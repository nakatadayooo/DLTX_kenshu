<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>システムエラー画面</title>
</head>
<body>
<div style="text-align:center">
 <h2>システムエラー画面</h2>
 エラーメッセージ<br>
 <c:out value="${requestScope.errorMessage}" />
</div>
</body>
</html>