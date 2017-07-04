<%-- 
    Document   : updateBook
    Created on : 03/07/2017, 21:38:22
    Author     : pauli
--%>

<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.inf.bookregister.model.domain.Book" %>
<%  Book book = (Book) request.getAttribute("book");
    Format formatter = new SimpleDateFormat("yyyy-MM-dd");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca - editar <%=book.getName()%> </title>
    </head>
    <body>
        <form name="register" method="post" action="/BookRegister/ServletWeb?page=insertBook">
            Nome: <input type="text" name="name" value="<%=book.getName()%>"> <br>
            Autor: <input type="text" name="author" value="<%=book.getAuthor()%>"> <br>
            ISBN: <input type="text" name="ISBN" value="<%=book.getISBN()%>"> <br>
            Volume: <input type="text" name="volume" value="<%=book.getVolume()%>"> <br>
            Data de publicação: <input type="text" name="date" value="<%=formatter.format(book.getDate())%>"> <br>
            Editora: <input type="text" name="editor" value="<%=book.getEditor()%>"> <br>
            Número de páginas: <input type="text" name="pages" value="<%=book.getPageNbr()%>"> <br>
            <input type='button' value='Gravar'>
        </form>
    </body>
</html>
