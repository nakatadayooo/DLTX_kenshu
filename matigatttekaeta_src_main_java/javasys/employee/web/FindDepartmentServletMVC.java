/**
 * All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited
 *
 * FindDepartmentServletMVC.java
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
import javasys.employee.entity.Department;
import javasys.employee.logic.DepartmentFindLogic;

// TODO 1 URLパターンを定義してください。

public class FindDepartmentServletMVC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 遷移先ページ名の設定
		String page = "/jsp/FindDepartmentResultView.jsp";
		try {
			// パラメータの取得
			request.setCharacterEncoding("UTF-8");
			// TODO 2 部門検索画面のテキストボックスに入力された部門番号を取得してください。
			String departmentId = null;

			// パラメータ未送信または未入力の場合
			// EmployeeBusinessExceptionをスローする
			if (departmentId == null || departmentId.equals("")) {
				throw new EmployeeBusinessException("部門番号が未入力です。");
			}

			// 業務Logic呼び出し
			// TODO 3 DepartmentFindLogicのfindDepartmentById()によりDepartmentオブジェクトを取得してください。


			// 処理結果の格納
			// TODO 4 Departmentオブジェクトをリクエストオブジェクトに格納してください。（キー："department"）

		} catch (EmployeeBusinessException e) {
			// 業務エラー発生時
			// エラーメッセージの格納
			// TODO 5 エラーメッセージをリクエストオブジェクトに格納してください。（キー："errorMessage"）

			// 遷移先ページ名の設定
			page = "/jsp/FindDepartmentView.jsp";
		// TODO 6 以下のcatchブロックをEmployeeSystemExceptionのcatchブロックに変更してください。
		} catch (Exception e) {
			// システムエラー発生時
			// エラーメッセージの格納
			// TODO 7 エラーメッセージをリクエストオブジェクトに格納してください。（キー："errorMessage"）

			// 遷移先ページ名の設定
			page = "/jsp/SystemErrorPage.jsp";
		}
		// 結果画面に転送
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
}
