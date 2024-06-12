/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * DepartmentDAO.java
 *
 */

package javasys.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javasys.employee.entity.Department;

public class DepartmentDAO {

	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            データベースの接続オブジェクト
	 */
	public DepartmentDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 部門を検索する。
	 *
	 * @param departmentId
	 *            部門番号
	 * @return 部門
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public Department findDepartmentById(int departmentId) throws SQLException {
		// TODO 1 department表からdepartment_id列を条件に検索するSQL文を代入してください。
		//        検索条件の値は、パラメータ「?」として指定します。
		String sql = "";

		PreparedStatement stmt = null;
		ResultSet res = null;
		Department department = null;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// TODO 2 メソッドの引数をパラメータとして設定してください。

			// SQL文の実行
			res = stmt.executeQuery();
			// 結果セットから情報を取り出す
			if (res.next()) {
				// TODO 3 Departmentオブジェクトを生成してください。

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
		// TODO 4 戻り値としてDepartmentオブジェクトを返却してください。
		return null;
	}
}
