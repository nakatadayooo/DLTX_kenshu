/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * SalaryDAO.java
 *
 */

package javasys.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javasys.employee.entity.Salary;

public class SalaryDAO {

	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            データベースの接続オブジェクト
	 */
	public SalaryDAO(Connection con) {
		this.con = con;
	}
	/**
	 * 従業員を登録する。
	 *
	 * @param salary
	 *            給与
	 * @return 登録結果
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public boolean insertSalary(Salary salary) throws SQLException {
		String sql = "INSERT INTO salary" + " VALUES(?,?,?)";
		PreparedStatement stmt = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setInt(1, salary.getEmpId());
			stmt.setInt(2, salary.getMonthBase());
			stmt.setInt(3, salary.getOrvertimeUnit());
			// SQL文の実行
			int count = stmt.executeUpdate();
			if (count == 1) {
				result = true;
			}
		} finally {
			// クローズ処理
			if (stmt != null) {
				stmt.close();
			}
		}
		return result;
	}

}
