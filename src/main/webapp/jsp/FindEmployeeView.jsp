<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員検索</title>
</head>
<body>
<div style="text-align:center">
 <h2>従業員検索画面</h2>
 従業員番号を入力して、検索ボタンをクリックしてください。
 <div style="text-align:center; color:red; font-weight:bold;">
 <%-- エラーメッセージがある場合、出力 --%>
   <c:out value="${requestScope.errorMessage}" />
 </div>

 <div style="text-align:center">
  <form action="/javasys_samples/findEmployeeMVC" method="post">
    従業員番号：<input type="number" name="empId"  maxlength="6" value="<c:out value="${ param.empId }"/>"><br>
    <input type="submit" value="検索">
  </form>
 </div>
</div>
</body>
</html>