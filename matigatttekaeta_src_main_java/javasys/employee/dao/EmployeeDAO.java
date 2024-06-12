/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * EmployeeDAO.java
 *
 */

package javasys.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javasys.employee.entity.Employee;

public class EmployeeDAO {

	/** データベースの接続 */
	private Connection con;

	/**
	 * コンストラクタ
	 *
	 * @param con
	 *            データベースの接続オブジェクト
	 */
	public EmployeeDAO(Connection con) {
		this.con = con;
	}

	/**
	 * 従業員を検索する。
	 *
	 * @param empId
	 *            従業員番号
	 * @return 従業員
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public Employee findEmployeeById(int empId) throws SQLException {
		String sql = "SELECT employee_id,employee_name,department_id,phone "
				+ "FROM employee WHERE employee_id = ?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Employee employee = null;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setInt(1, empId);
			// SQL文の実行
			res = stmt.executeQuery();
			// 結果セットから情報を取り出す
			if (res.next()) {
				// Employeeオブジェクトの生成
				employee = new Employee(res.getInt("employee_id"), res.getString("employee_name"),
						res.getInt("department_id"), res.getString("phone"));
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

		return employee;
	}
	/**
	 * 従業員を登録する。
	 *
	 * @param employee
	 *            従業員
	 * @return boolean
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public boolean insertEmployee(Employee employee) throws SQLException {
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		PreparedStatement stmt = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setInt(1, employee.getEmpId());
			stmt.setString(2, employee.getEmpName());
			stmt.setInt(3, employee.getDepartmentId());
			stmt.setString(4, employee.getPhone());
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

	/**
	 * 従業員を削除する。
	 *
	 * @param employee
	 *            従業員
	 * @return 削除結果
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public boolean deleteEmployee(Employee employee) throws SQLException {
		String sql = "DELETE FROM employee WHERE employee_id = ?";
		PreparedStatement stmt = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setInt(1, employee.getEmpId());
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

	/**
	 * 従業員を更新する。
	 *
	 * @param employee
	 *            従業員
	 * @return 更新結果
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public boolean updateEmployee(Employee employee) throws SQLException {
		String sql = "UPDATE employee SET employee_name=? department_id=?, phone=? "
				+ "WHERE employee_id=? ";
		PreparedStatement stmt = null;
		boolean result = false;

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// パラメータの設定
			stmt.setString(1, employee.getEmpName());
			stmt.setInt(2, employee.getDepartmentId());
			stmt.setString(3, employee.getPhone());
			stmt.setInt(4, employee.getEmpId());
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

	/**
	 * 従業員を全件検索する。
	 *
	 * @return 従業員リスト
	 * @throws SQLException
	 *             データベースエラーが発生した場合
	 */
	public ArrayList<Employee> findAllEmployee() throws SQLException {
		String sql = "SELECT employee_id,employee_name,department_id,phone FROM employee";
		PreparedStatement stmt = null;
		ResultSet res = null;
		ArrayList<Employee> employeeList = new ArrayList<>();

		try {
			// PreparedStatementの作成
			stmt = con.prepareStatement(sql);
			// SQL文の実行
			res = stmt.executeQuery();

			// 結果セットから情報を取り出す
			Employee employee = null;
			while (res.next()) {
				employee = new Employee(res.getInt("employee_id"), res.getString("employee_name"),
						res.getInt("department_id"), res.getString("phone"));
				employeeList.add(employee);
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
		return employeeList;
	}
}
