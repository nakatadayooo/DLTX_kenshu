<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員検索結果</title>
</head>
<body>
<div style="text-align:center">
 <h2>従業員検索結果画面</h2>
従業員番号：<c:out value="${ requestScope.employee.empId }" /><br>
従業員名：<c:out value="${ requestScope.employee.empName }" /><br>
部門番号：<c:out value="${ requestScope.employee.departmentId }" /><br>
内線番号：<c:out value="${ requestScope.employee.phone }" /><br>
</div>
</body>
</html>