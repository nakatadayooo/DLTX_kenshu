<!-- All Rights Reserved, Copyright(c) Fujitsu Learning Media Limited -->
<%-- pageディレクティブの設定 --%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" import="java.util.Enumeration"%>

<%-- taglibディレクティブで、使用するタグライブラリを宣言 --%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Output Check</title>
</head>
<body>
<div style="text-align:left">
 <h3>HttpServletRequestに格納されているキー</h3>
 <%
  Enumeration<String> names = request.getAttributeNames();
  while( names.hasMoreElements() ) {
   String name = (String) names.nextElement();
   out.println("キー：" + name + ",");
   out.println("値：" + request.getAttribute(name) + "<br>");
  }
 %>
</div>
</body>
</html>