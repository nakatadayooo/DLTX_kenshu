/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * LoginServletMVC.java
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
import jakarta.servlet.http.HttpSession;

import javasys.employee.common.EmployeeBusinessException;
import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;
import javasys.employee.logic.LoginLogic;

@WebServlet(urlPatterns = { "/loginMVC" })
public class LoginServletMVC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 遷移先ページ名の設定
		String page = "/WEB-INF/jsp/EmployeeMenu.jsp";
		try {
			// パラメータの取得
			request.setCharacterEncoding("UTF-8");
			String empId = request.getParameter("empId");
			String password = request.getParameter("password");

			// パラメータ未送信または未入力の場合
			// EmployeeBusinessExceptionをスローする
			String errorMessage = "";
			if (empId == null || empId.equals("")) {
				errorMessage += "従業員番号が未入力です。<br>";
			}
			if (password == null || password.equals("")) {
				errorMessage += "パスワードが未入力です。<br>";
			}
			if (!errorMessage.equals("")) {
				throw new EmployeeBusinessException(errorMessage);
			}

			// 業務Logic呼び出し
			LoginLogic logic = new LoginLogic();
			Employee employee = logic.login(Integer.parseInt(empId),password);

			// セッションの生成
			HttpSession session = request.getSession(true);
			// ログイン情報の格納
			session.setAttribute("loginEmployee", employee);
		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの格納
			request.setAttribute("errorMessage", e.getMessage());
			// 遷移先ページ名の設定
			page = "/jsp/LoginPage.jsp";
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
