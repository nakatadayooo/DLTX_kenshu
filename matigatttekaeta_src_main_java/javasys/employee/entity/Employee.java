/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * Employee.java
 *
 */
package javasys.employee.entity;

import java.io.Serializable;

public class Employee implements Serializable{

	/** 従業員番号 */
	private int empId;

	/** 従業員名 */
	private String empName;

	/** 部門番号 */
	private int departmentId;

	/** 部門名 */
	private String departmentName;

	/** 内線番号 */
	private String phone;

	/**
	 * コンストラクタ（引数なし）
	 */
	public Employee() {
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 *
	 * @param empId
	 *            従業員番号
	 * @param empName
	 *            従業員名
	 * @param departmentId
	 *            部門番号
	 * @param phone
	 *            内線番号
	 */
	public Employee(int empId, String empName, int departmentId, String phone) {
		this.empId = empId;
		this.empName = empName;
		this.departmentId = departmentId;
		this.phone = phone;
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 *
	 * @param empId
	 *            従業員番号
	 * @param empName
	 *            従業員名
	 * @param departmentId
	 *            部門番号
	 * @param departmentName
	 *            部門名
	 * @param phone
	 *            内線番号
	 */
	public Employee(int empId, String empName, int departmentId, String departmentName , String phone) {
		this.empId = empId;
		this.empName = empName;
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.phone = phone;
	}

	/**
	 * 従業員番号を取得する。
	 *
	 * @return 従業員番号
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * 従業員番号を設定する。
	 *
	 * @param empId
	 *            従業員番号
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * 従業員名を取得する。
	 *
	 * @return 従業員名
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * 従業員名を設定する。
	 *
	 * @param empName
	 *            従業員名
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * 部門番号を取得する。
	 *
	 * @return 部門番号
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * 部門番号を設定する。
	 *
	 * @param departmentId
	 *            部門番号
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * 部門名を取得する。
	 *
	 * @return 部門名
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * 部門名を設定する。
	 *
	 * @param departmentName
	 *            部門名
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * 内線番号を取得する。
	 *
	 * @return 内線番号
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 内線番号を設定する。
	 *
	 * @param phone
	 *            内線番号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
