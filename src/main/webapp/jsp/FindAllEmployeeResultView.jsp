<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員一覧</title>
</head>
<body>
<div style="text-align:center">
 <h2>従業員一覧画面</h2>
  <div style="text-align:center; color:red; font-weight:bold;">
 <%-- エラーメッセージがある場合、出力 --%>
   <c:out value="${requestScope.errorMessage}" />
  </div>
 </div>
<c:if test="${requestScope.employeeList != null}">
 <table border="1" style="margin: 0 auto">
  <tr>
   <th>従業員番号</th>
   <th>従業員名</th>
   <th>部門番号</th>
   <th>内線番号</th>
  </tr>
  <c:forEach var="employee" items="${ requestScope.employeeList }">
  <tr>
   <td><c:out value="${ employee.empId }" /></td>
   <td><c:out value="${ employee.empName }" /></td>
   <td><c:out value="${ employee.departmentId }" /></td>
   <td><c:out value="${ employee.phone }" default="内線番号なし"/></td>
  </tr>
  </c:forEach>
 </table>
</c:if>
</body>
</html>