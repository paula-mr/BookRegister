/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import br.cefetmg.inf.bookregister.model.dao.BookDAO;
import br.cefetmg.inf.bookregister.model.dao.impl.BookDAOImpl;
import br.cefetmg.inf.bookregister.model.domain.Book;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pauli
 */
public class SaveUpdate {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            int idBook = Integer.parseInt(request.getParameter("idbook"));
            Book book = new Book();
            book.setId(idBook);
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

            BookDAO bookDAO = new BookDAOImpl();
            boolean updated = bookDAO.update(book);

            if (updated == true) {
                jsp = ListBooks.execute(request);
            } else {
                String erro = "Nao foi possivel gravar a alteracao desse registro";
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
