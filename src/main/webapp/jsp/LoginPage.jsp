<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false"%>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<div style="text-align:center">
 <h2>ログイン画面</h2>
 <div style="color:red; font-weight:bold;">
 <%-- エラーメッセージがある場合、出力 --%>
   <c:out value="${requestScope.errorMessage}" escapeXml="false"/>
 </div>
 <div>
  <form action="/javasys_samples/loginMVC" method="post">
    従業員番号：<input type="number" name="empId" value="<c:out value="${ param.empId }" />"><br>
    パスワード：<input type="password" name="password" value="<c:out value="${ param.password }" />"><br>
    <input type="submit" value="ログイン">
  </form>
 </div>
</div>
</body>
</html>