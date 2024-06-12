/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FindEmployeeServlet.java
 *
 */
package javasys.employee.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;
import javasys.employee.logic.EmployeeFindLogic;

@WebServlet(urlPatterns = { "/findEmployee" })
public class FindEmployeeServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// パラメータの取得
			request.setCharacterEncoding("UTF-8");
			String empId = request.getParameter("empId");

			// パラメータ未送信または未入力の場合
			// EmployeeBusinessExceptionをスローする
			if (empId == null || empId.equals("")) {
				throw new EmployeeBusinessException("従業員番号が未入力です。");
			}

			// 業務Logic呼び出し
			EmployeeFindLogic logic = new EmployeeFindLogic();
			Employee employee = logic.findEmployeeById(Integer.parseInt(empId));

			// 結果画面の返却
			// コンテンツタイプの設定
	        response.setContentType("text/html; charset=UTF-8");
	        // 出力ストリームの取得
	        PrintWriter pw = response.getWriter();
	        // HTMLタグ出力
	        pw.println("<html><head></head><body><div style=\"text-align:center;\">");
	        pw.println("<h2>従業員検索結果</h2>");
	        pw.println("従業員番号：" + employee.getEmpId() + "<br>");
	        pw.println("従業員名：" + employee.getEmpName() + "<br>");
	        pw.println("部門番号：" + employee.getDepartmentId() + "<br>");
	        pw.println("内線番号：" + employee.getPhone() + "<br>");
	        pw.println("</div></body></html>");
		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// 業務エラー画面を返却する
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter pw = response.getWriter();
	        // HTMLタグ出力
	        pw.println("<html><head></head><body><div style=\"text-align:center;\">");
	        pw.println("<h2>業務エラー画面</h2>");
	        pw.println("エラーメッセージ<br>");
	        pw.println(e.getMessage());
	        pw.println("</div></body></html>");
		} catch (EmployeeSystemException e) {
			// システムエラー発生時
			// システムエラー画面を返却する
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter pw = response.getWriter();
	        // HTMLタグ出力
	        pw.println("<html><head></head><body><div style=\"text-align:center;\">");
	        pw.println("<h2>システムエラー画面</h2>");
	        pw.println("エラーメッセージ<br>");
	        pw.println(e.getMessage());
	        pw.println("</div></body></html>");
		}
	}
}
