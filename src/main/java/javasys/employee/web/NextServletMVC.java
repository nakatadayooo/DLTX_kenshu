/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * NextServletMVC.java
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

import javasys.employee.common.EmployeeSystemException;
import javasys.employee.entity.Employee;

@WebServlet(urlPatterns = { "/next" })
public class NextServletMVC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 遷移先ページ名の設定
		String page = "/WEB-INF/jsp/NextPage.jsp";
		try {
			// セッションチェック
			HttpSession session = request.getSession(false);
			if (session == null) { // セッションが存在しない
				throw new EmployeeSystemException("セッションが無効です。");
			} else {
				Employee loginEmployee = (Employee) session.getAttribute("loginEmployee");
				if (loginEmployee == null) { // ログイン情報が存在しない
					throw new EmployeeSystemException("ログイン情報が存在しません。");
				}
			}
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
