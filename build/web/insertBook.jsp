<%-- 
    Document   : insertBook
    Created on : 02/07/2017, 16:49:55
    Author     : paula
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Biblioteca</title>
    </head>
    <body>
    <div>
        <form name="register" method="post" action="/BookRegister/ServletWeb?page=insertBook">
            Nome: <input type="text" name="name"> <br>
            Autor: <input type="text" name="author"> <br>
            ISBN: <input type="text" name="ISBN"> <br>
            Volume: <input type="text" name="volume"> <br>
            Data de publicação: <input type="text" name="date"> <br>
            Editora: <input type="text" name="editor"> <br>
            Número de páginas: <input type="text" name="pages"> <br>
            <input type='button' value='Gravar'>
        </form>
    </div>
    </body>
</html>
