/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * Salary.java
 *
 */
package javasys.employee.entity;

import java.io.Serializable;

public class Salary implements Serializable{

	/** 従業員番号 */
	private int empId;

	/** 基本給 */
	private int monthBase;

	/** 時間外単価 */
	private int orvertimeUnit;

	/**
	 * コンストラクタ（引数なし）
	 */
	public Salary() {
	}

	/**
	 * コンストラクタ:引数で指定した値を設定する。
	 *
	 * @param empId
	 *            従業員番号
	 * @param monthBase
	 *            基本給
	 * @param orvertimeUnit
	 *            時間外単価
	 */
	public Salary(int empId, int monthBase, int orvertimeUnit) {
		this.empId = empId;
		this.monthBase = monthBase;
		this.orvertimeUnit = orvertimeUnit;
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
	 * 基本給を取得する。
	 *
	 * @return 基本給
	 */
	public int getMonthBase() {
		return monthBase;
	}

	/**
	 * 基本給を設定する。
	 *
	 * @param monthBase
	 *            従業員番号
	 */
	public void setMonthBase(int monthBase) {
		this.monthBase = monthBase;
	}

	/**
	 * 時間外単価を取得する。
	 *
	 * @return 時間外単価
	 */
	public int getOrvertimeUnit() {
		return orvertimeUnit;
	}

	/**
	 * 時間外単価を設定する。
	 *
	 * @param OrvertimeUnit
	 *            時間外単価
	 */
	public void setOrvertimeUnit(int orvertimeUnit) {
		this.orvertimeUnit = orvertimeUnit;
	}
}
