<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員管理メニュー</title>
</head>
<body>
<div style="text-align:center">
<h2>従業員管理メニュー画面</h2>
<form action="/javasys_employee/employeeFC" method="post">
 <button type="submit" name="buttonId" value="e100" disabled="disabled">従業員検索</button><br>
 <button type="submit" name="buttonId" value="e200" disabled="disabled">従業員登録</button><br>
 <button type="submit" name="buttonId" value="e300" disabled="disabled">従業員変更</button><br>
 <button type="submit" name="buttonId" value="e400" disabled="disabled">従業員削除</button><br>
 <button type="submit" name="buttonId" value="e500" disabled="disabled">従業員一覧</button><br>
</form>
<h2>第9章解説用</h2>
<form action="/javasys_samples/next" method="post">
<input type="submit" value="ログイン後の機能呼び出し">
</form>
</div>
<hr>
ログイン従業員名：<c:out value="${ sessionScope.loginEmployee.empName }" /></body>
</html>