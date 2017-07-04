<%-- 
    Document   : listBooks
    Created on : 03/07/2017, 21:38:13
    Author     : pauli
--%>
<%@page import="br.cefetmg.inf.bookregister.model.domain.Book" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Livro</title>
    </head>
    <body>
        <h1>Livros Cadastrados</h1>
        
            <%
                List<Book> list = (List<Book>) request.getAttribute("listBooks");
                if(!list.isEmpty()){
            %>
            <table style="border-collapse: collapse;">
                <tr>
                    <th style="border: 1px solid black">Nome</th>
                    <th style="border: 1px solid black">Editar</th>
                    <th style="border: 1px solid black">Excluir</th>
                </tr>
            <%      for (Book book: list) {
            %>                 
            <tr>
               <td style="border: 1px solid black">
                   <%= book.getName() %>
               </td>
               <td style="border: 1px solid black">
                   <a href="/BookRegister/ServletWeb?page=updateBook&isbn=<%=book.getId()%>"><button>Editar</button></a>
               </td>
               <td style="border: 1px solid black">
                   <a href="/BookRegister/ServletWeb?page=deleteBook&isbn=<%=book.getId()%>"><button>Excluir</button></a>
               </td>
            </tr>
            <%      }
            %>
            </table>
            <%
                }else{
            %>
            <p>Sem Livros</p>
            <%
              }  
            %>
    </body>
</html>
