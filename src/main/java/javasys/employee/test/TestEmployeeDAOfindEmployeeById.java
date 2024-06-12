/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * TestEmployeeDAOfindEmployeeById.java
 *
 */

package javasys.employee.test;
import java.sql.Connection;
import java.sql.SQLException;
import javasys.employee.dao.ConnectionManager;
import javasys.employee.dao.EmployeeDAO;
import javasys.employee.entity.Employee;

public class TestEmployeeDAOfindEmployeeById {
	public static void main(String args[]) {
		Connection con = null;
		Employee employee = null;
		try {
			// データベースの接続を取得する
			con = ConnectionManager.getConnection();

			// DAOを生成し、メソッドを呼び出す
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			employee = employeeDAO.findEmployeeById(922101);

			// 検索結果がない場合
			if (employee == null) {
				System.out.println("nullが返却されました。");
			}else {
				System.out.println("Employeeオブジェクトが返却されました。");
				System.out.println("従業員番号："+employee.getEmpId());
				System.out.println("従業員名："+employee.getEmpName());
				System.out.println("部門番号："+employee.getDepartmentId());
				System.out.println("内線番号"+employee.getPhone());
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