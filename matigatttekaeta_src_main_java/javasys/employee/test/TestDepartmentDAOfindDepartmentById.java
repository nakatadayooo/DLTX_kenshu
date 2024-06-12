/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * TestDepartmentDAOfindDepartmentById.java
 *
 */

package javasys.employee.test;
import java.sql.Connection;
import java.sql.SQLException;

import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.DepartmentDAO;
import javasys.employee.entity.Department;

public class TestDepartmentDAOfindDepartmentById {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		Connection con = null;
		Department department = null;
		try {
			// ConnectionManagerのgetConnection()メソッドでデータベースの接続を取得する
			con = ConnectionManager.getConnection();

			// TODO 1 DepartmentDAOを生成してください。
			//       ConnectionManagerのgetConnection()メソッドで取得したConnectionオブジェクトを引数に指定します。


			// TODO 2 DepartmentDAOのfindDepartmentById()メソッドを呼び出して
			//        Departmentオブジェクトを取得してください。
			//        引数には、「10」を指定します。


			// 検索結果がない場合
			if (department == null) {
				System.out.println("nullが返却されました。");
			}else {
				System.out.println("Departmentオブジェクトが返却されました。");
				System.out.println("部門番号："+department.getDepartmentId());
				System.out.println("部門名："+department.getDepartmentName());
			}
		} catch (SQLException e) {
			// データベースエラーの場合
			System.out.println("SQLExceptionがスローされました。");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}