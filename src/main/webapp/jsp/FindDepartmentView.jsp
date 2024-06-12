<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部門検索</title>
</head>
<body>
<div style="text-align:center">
 <h2>部門検索画面</h2>
 部門番号を入力して、検索ボタンをクリックしてください。
 <div style="text-align:center; color:red; font-weight:bold;">
 <%-- TODO 1 サーブレットが格納したエラーメッセージを出力してください --%>

 </div>

 <div style="text-align:center">
  <form action="/javasys_samples/findDepartmentMVC" method="post">
    部門番号：<input type="text" name="departmentId"  maxlength="6" value="<c:out value="${ param.departmentId }"/>"><br>
    <input type="submit" value="検索">
  </form>
 </div>
</div>
</body>
</html>