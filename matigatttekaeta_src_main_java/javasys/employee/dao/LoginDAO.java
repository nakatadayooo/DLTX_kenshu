/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * LoginDAO.java
 *
 */

package javasys.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            データベースの接続オブジェクト
	 */
	public LoginDAO(Connection con) {
		this.con = con;
	}

	/**
	 * ログイン情報を検索する。
	 *
	 * @param empId
	 *            従業員番号
	 * @param password
	 *            パスワード
	 * @return 検索結果
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public boolean findEmployee(int empId, String password) throws SQLException {
		String sql = "SELECT employee_id FROM login WHERE employee_id = ? and password = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setInt(1, empId);
			stmt.setString(2, password);
			// SQL文の実行
			res = stmt.executeQuery();
			// 結果セットの確認
			if (res.next()) {
				result = true;
			}
		} finally {
			// クローズ処理
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}
}
