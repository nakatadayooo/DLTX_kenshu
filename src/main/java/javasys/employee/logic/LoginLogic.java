/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * LoginLogic.java
 *
 */

package javasys.employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.EmployeeDAO;
import javasys.employee.dao.LoginDAO;
import javasys.employee.entity.Employee;

public class LoginLogic {

	/**
	 * ログイン情報を検索する。
	 *
	 * @param empId
	 *            従業員番号
	 * @param password
	 *            パスワード
	 * @return 従業員
	 * @throws EmployeeBusinessException
	 *             業務エラーが発生した場合
	 * @throws EmployeeSystemException
	 *             システムエラーが発生した場合
	 */
	public Employee login(int empId, String password)
			throws EmployeeBusinessException, EmployeeSystemException {
		Connection con = null;
		Employee employee = null;
		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// DAOを生成し、メソッドを呼び出す
			LoginDAO loginDAO = new LoginDAO(con);
			boolean result = loginDAO.findEmployee(empId, password);
			// 戻り値がfalseの場合、業務エラーを発生させる
			if (result == false) {
				throw new EmployeeBusinessException("ログインに失敗しました。");
			}

			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			employee = employeeDAO.findEmployeeById(empId);
			// 戻り値がnullの場合、業務エラーを発生させる
			if (employee == null) {
				throw new EmployeeBusinessException("ログインに失敗しました。");
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