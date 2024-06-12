/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * EmployeeFindLogic.java
 *
 */

package javasys.employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.EmployeeDAO;
import javasys.employee.entity.Employee;

public class EmployeeFindLogic {

	/**
	 * 従業員を検索する。
	 *
	 * @param empId
	 *            従業員番号
	 * @return 従業員
	 * @throws EmployeeBusinessException
	 *             業務エラーが発生した場合
	 * @throws EmployeeSystemException
	 *             システムエラーが発生した場合
	 */
	public Employee findEmployeeById(int empId)
			throws EmployeeBusinessException, EmployeeSystemException {
		Connection con = null;
		Employee employee = null;
		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// DAOを生成し、メソッドを呼び出す
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			employee = employeeDAO.findEmployeeById(empId);

			// 検索結果がない場合、業務エラーを発生させる
			if (employee == null) {
				throw new EmployeeBusinessException("従業員番号："
										+ empId + "は、存在しません。");
			}
		} catch (SQLException e) {
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
