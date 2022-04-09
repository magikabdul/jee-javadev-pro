<%--
  Created by IntelliJ IDEA.
  User: landr
  Date: 09.04.2022
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private static final String NAME_PARAM = "name";
%>

<%
    String name =  request.getParameter(NAME_PARAM);
    if (name == null) {
        name = "";
    }
    out.println(prepareResponse(name));
%>

<%!
    private String prepareResponse(String name) {
        return "<html><head><title>JEE</title></head><body><p>Hello " + name + "</p></body></html>";
    }
%>
</body>
</html>
