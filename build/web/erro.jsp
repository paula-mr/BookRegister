<%-- 
    Document   : erro
    Created on : 03/07/2017, 21:37:01
    Author     : pauli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  String erro = (String) request.getAttribute("erro"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Erro</h1>
        <p><%=erro %></p>
    </body>
</html>
