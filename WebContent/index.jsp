<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>JSP Redirect Example</title>
</head>
<body>
    <%
        String redirectURL = "IndexServlet?accion=home";
        response.sendRedirect(redirectURL);
    %>
</body>
</html>