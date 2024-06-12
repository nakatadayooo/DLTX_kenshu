<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン後の機能画面</title>
</head>
<body>
<div style="text-align:center">
<h2>ログイン後の機能画面</h2>
</div>
<hr>
ログイン従業員名：<c:out value="${ sessionScope.loginEmployee.empName }" /><br>
</body>
</html>