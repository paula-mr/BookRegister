/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import br.cefetmg.inf.bookregister.model.dao.BookDAO;
import br.cefetmg.inf.bookregister.model.dao.impl.BookDAOImpl;
import br.cefetmg.inf.bookregister.model.domain.Book;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pauli
 */
public class ListBooks {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            BookDAO bookDAO = new BookDAOImpl();
            List<Book> listBook = bookDAO.listAll();
            if (listBook != null) {
                request.setAttribute("listBooks", listBook);
                jsp = "listBooks.jsp";
            } else {
                String erro = "Nao existem livros!";
                request.setAttribute("erro", erro);
                jsp = "erro.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
