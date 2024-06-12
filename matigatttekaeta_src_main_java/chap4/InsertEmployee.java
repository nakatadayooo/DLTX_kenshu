/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * InsertEmployee.java
 *
 */

package chap4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
	public static void main(String args[]) {
		Connection con = null;
		PreparedStatement empStmt = null;
		PreparedStatement salStmt = null;

		String url = "jdbc:mysql://localhost:3306/flm";
		String userName = "mysql";
		String password = "mysql";

		String empSql = "INSERT INTO employee VALUES( ?, ?, ?, ? )";
		String salSql = "INSERT INTO salary VALUES( ?, ?, ? )";

		try {
			// データベースに接続
			con = DriverManager.getConnection(url, userName, password);
			// 自動コミットモードの解除
			con.setAutoCommit(false);

			// PreparedStatementの作成
			empStmt = con.prepareStatement(empSql);
			salStmt = con.prepareStatement(salSql);

			// パラメータの設定
			empStmt.setInt(1,922999);
			empStmt.setString(2,"佐々木　良夫");
			empStmt.setInt(3,40);
			empStmt.setString(4,"7718-1199");

			salStmt.setInt(1,922999);
			salStmt.setInt(2,300000);
			salStmt.setInt(3,12000);

			// SQL文の実行
			empStmt.executeUpdate();
			salStmt.executeUpdate();

			// コミット
			con.commit();
			System.out.println("従業員を登録しました。");
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("従業員の登録に失敗しました。");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// PreparedStatementのクローズ
				if (empStmt != null) {
					empStmt.close();
				}
				if (salStmt != null) {
					salStmt.close();
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