/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * EmployeeBusinessException.java
 *
 */
package javasys.employee.common;

public class EmployeeBusinessException extends Exception {

	/**
	 * コンストラクタ
	 *
	 * @param message
	 *            エラーメッセージ
	 */
	public EmployeeBusinessException(String message) {
		super(message);
	}
}
