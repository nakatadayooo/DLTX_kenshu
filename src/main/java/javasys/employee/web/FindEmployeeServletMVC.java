/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FindEmployeeServletMVC.java
 *
 */
package javasys.employee.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;
import javasys.employee.logic.EmployeeFindLogic;

@WebServlet(urlPatterns = { "/findEmployeeMVC" })
public class FindEmployeeServletMVC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 遷移先ページ名の設定
		String page = "/jsp/FindEmployeeResultView.jsp";
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

			// 処理結果の格納
			request.setAttribute("employee", employee);
		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "/jsp/FindEmployeeView.jsp";
		} catch (EmployeeSystemException e) {
			// システムエラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "/jsp/SystemErrorPage.jsp";
		}
		// 結果画面に転送
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
