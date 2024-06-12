/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * TestEmployeeFindLogicfindEmployeeById.java
 *
 */

package javasys.employee.test;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;
import javasys.employee.logic.EmployeeFindLogic;

public class TestEmployeeFindLogicfindEmployeeById {
	public static void main(String args[]) {
		try {
			// 業務Logic呼び出し
			EmployeeFindLogic logic = new EmployeeFindLogic();
			Employee employee = logic.findEmployeeById(922101);

			// 処理結果の表示
			System.out.println("Employeeオブジェクトが返却されました。");
			System.out.println("従業員番号："+employee.getEmpId());
			System.out.println("従業員名："+employee.getEmpName());
			System.out.println("部門番号："+employee.getDepartmentId());
			System.out.println("内線番号"+employee.getPhone());
		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの表示
			System.out.println("業務エラーメッセージ：" +  e.getMessage());
			e.printStackTrace();
		} catch (EmployeeSystemException e) {
			// システムエラー発生時
			// エラーメッセージの表示
			System.out.println("システムエラーメッセージ：" +  e.getMessage());
			e.printStackTrace();
		}
	}
}