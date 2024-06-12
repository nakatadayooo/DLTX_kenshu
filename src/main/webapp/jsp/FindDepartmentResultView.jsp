<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部門検索結果</title>
</head>
<body>
<div style="text-align:center">
 <h2>部門検索結果画面</h2>
部門番号：<c:out value="${ requestScope.department.departmentId }" /><br>
部門名：<c:out value="${ requestScope.department.departmentName }" /><br>
</div>
</body>
</html>