/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import br.cefetmg.inf.bookregister.model.dao.BookDAO;
import br.cefetmg.inf.bookregister.model.dao.impl.BookDAOImpl;
import br.cefetmg.inf.bookregister.model.domain.Book;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pauli
 */
public class SaveInsertion {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            BookDAO bookDAO = new BookDAOImpl();
            Book book = new Book();
            String date = request.getParameter("date");
            book.setDate(sdf.parse(date));
            book.setAuthor(request.getParameter("author"));
            book.setEditor(request.getParameter("editor"));
            String ISBN = request.getParameter("ISBN");
            book.setISBN(Integer.parseInt(ISBN));
            String pgNbr = request.getParameter("pages");
            book.setPageNbr(Integer.parseInt(pgNbr));
            String volume = request.getParameter("volume");
            book.setVolume(Integer.parseInt(volume));
            book.setName(request.getParameter(jsp));
            
            int bookId = bookDAO.insert(book);

            if ((Integer)bookId != null) {
                jsp = ListBooks.execute(request);
            } else {
                String erro = "Nao foi possivel gravar esse registro!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
