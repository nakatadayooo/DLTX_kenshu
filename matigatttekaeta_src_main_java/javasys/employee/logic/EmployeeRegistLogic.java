/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * EmployeeRegistLogic.java
 *
 */

package javasys.employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.EmployeeDAO;
import javasys.employee.dao.SalaryDAO;
import javasys.employee.entity.Employee;
import javasys.employee.entity.Salary;


public class EmployeeRegistLogic {
	/**
	 * 従業員を登録する。
	 *
	 * @param employee
	 *            従業員
	 * @return 従業員
	 * @throws EmployeeBusinessException
	 *             業務エラーが発生した場合
	 * @throws EmployeeSystemException
	 *             システムエラーが発生した場合
	 */
	public Employee registEmployee(Employee employee)
			throws EmployeeBusinessException, EmployeeSystemException {
		Connection con = null;

		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// 自動コミットモードの解除
			con.setAutoCommit(false);

			// DAOを生成し、メソッドを呼び出す
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			SalaryDAO salaryDAO = new SalaryDAO(con);

			Employee findEmployee = employeeDAO.findEmployeeById(employee.getEmpId());

			// 検索結果がある場合、業務エラーを発生させる
			if (findEmployee != null) {
				// ロールバック
				con.rollback();
				throw new EmployeeBusinessException("従業員番号は既に登録されています。");
			}
			// 従業員を登録する
			employeeDAO.insertEmployee(employee);

			Salary salary = new Salary(employee.getEmpId(), 0, 0);
			salaryDAO.insertSalary(salary);

			// コミット
			con.commit();

		} catch (SQLException e) {
			try {
				// ロールバック
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			// データベースエラーの場合、システムエラーを発生させる
			throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new EmployeeSystemException("システムエラーが発生しました。管理者に連絡してください。");
			}
		}
		return employee;
	}
}
