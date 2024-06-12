/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * EmployeeFindAllLogic.java
 *
 */
package javasys.employee.logic;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.EmployeeDAO;
import javasys.employee.entity.Employee;

public class EmployeeFindAllLogic {
	/**
	 * 従業員リストを検索する。
	 *
	 * @return 従業員リスト
	 * @throws EmployeeBusinessException
	 *             業務エラーが発生した場合
	 * @throws EmployeeSystemException
	 *             システムエラーが発生した場合
	 */
	public ArrayList<Employee> findAllEmployee()
			throws EmployeeBusinessException, EmployeeSystemException {
		Connection con = null;
		ArrayList<Employee> employeeList = null;
		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();
			// DAOを生成し、メソッドを呼び出す
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			employeeList = employeeDAO.findAllEmployee();

			// 検索結果がない場合、業務エラーを発生させる
			if (employeeList.isEmpty()) {
				throw new EmployeeBusinessException("従業員リストが存在しません。");
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
		return employeeList;
	}
}