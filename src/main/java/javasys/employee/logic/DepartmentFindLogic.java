/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * DepartmentFindLogic.java
 *
 */

package javasys.employee.logic;

import java.sql.Connection;
import java.sql.SQLException;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.DepartmentDAO;
import javasys.employee.entity.Department;

public class DepartmentFindLogic {

	/**
	 * 部門を検索する。
	 *
	 * @param departmentId
	 *            部門番号
	 * @return 部門
	 * @throws EmployeeBusinessException
	 *             業務エラーが発生した場合
	 * @throws EmployeeSystemException
	 *             システムエラーが発生した場合
	 */
	public Department findDepartmentById(int departmentId)
			// TODO 1 throws宣言を追加してください。
	{
		Connection con = null;
		Department department = null;
		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// DAOを生成し、メソッドを呼び出す
			DepartmentDAO departmentDAO = new DepartmentDAO(con);
			department = departmentDAO.findDepartmentById(departmentId);

			// 検索結果がない場合、業務エラーを発生させる
			if (department == null) {
				// TODO 2 EmployeeBusinessException例外をスローしてください。
				//        エラーメッセージは、「"部門番号："+ departmentId + "は、存在しません。"」としてください。


			}
		} catch (SQLException e) {
			// データベースエラーの場合、システムエラーを発生させる
			// TODO 3 EmployeeSystemException例外をスローしてください。
			//	    エラーメッセージは、「"システムエラーが発生しました。管理者に連絡してください。"」としてください。

		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// データベースエラーの場合、システムエラーを発生させる
				// TODO 4 EmployeeSystemException例外をスローしてください。
				//	    エラーメッセージは、「"システムエラーが発生しました。管理者に連絡してください。"」としてください。

			}
		}
		// TODO 5 戻り値としてDepartmentオブジェクトを返却してください。
		return null;
	}
}
