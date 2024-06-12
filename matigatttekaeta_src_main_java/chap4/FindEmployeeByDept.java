/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FindEmployeeByDept.java
 *
 */

package chap4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindEmployeeByDept {
	public static void main(String args[]) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet res = null;

		String url = "jdbc:mysql://localhost:3306/flm";
		String userName = "mysql";
		String password = "mysql";
		String sql = "SELECT employee_id, employee_name, department_id, phone "
						+ "FROM employee WHERE department_id = ?";

		try {
			// データベースに接続
			con = DriverManager.getConnection(url, userName, password);

			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);

			// パラメータの設定
			stmt.setInt(1,20);
			// SQL文の実行
			res = stmt.executeQuery();

			System.out.println("Result------------------------");

			// 結果セットから情報を取り出す
			while (res.next()) {
				System.out.print(res.getInt("employee_id") + ",");
				System.out.print(res.getString("employee_name") + ",");
				System.out.print(res.getInt("department_id") + ",");
				System.out.print(res.getString("phone"));
				System.out.println();
			}
			System.out.println("-------------------------------End");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 結果セットのクローズ
				if (res != null) {
					res.close();
				}
				// ステートメントのクローズ
				if (stmt != null) {
					stmt.close();
				}
				// 接続のクローズ
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}