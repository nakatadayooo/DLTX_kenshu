/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * Department.java
 *
 */
package javasys.employee.entity;

import java.io.Serializable;

public class Department implements Serializable{

	/** 部門番号 */
	private int departmentId;

	/** 部門名 */
	private String departmentName;

	/**
	 * コンストラクタ（引数なし）
	 */
	public Department() {
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 *
	 * @param departmentId
	 *            部門番号
	 * @param departmentName
	 *            部門名
	 */
	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
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
}
