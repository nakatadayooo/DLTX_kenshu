/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FindAllEmployeeServletMVC.java
 *
 */
package javasys.employee.web;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;
import javasys.employee.logic.EmployeeFindAllLogic;

@WebServlet(urlPatterns = { "/findAllEmployeeMVC" })
public class FindAllEmployeeServletMVC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 遷移先ページ名の設定
		String page = "/jsp/FindAllEmployeeResultView.jsp";
		try {
			// 業務Logic呼び出し
			EmployeeFindAllLogic logic = new EmployeeFindAllLogic();
			ArrayList<Employee> employeeList = logic.findAllEmployee();

			// 処理結果の格納
			request.setAttribute("employeeList", employeeList);
		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
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
