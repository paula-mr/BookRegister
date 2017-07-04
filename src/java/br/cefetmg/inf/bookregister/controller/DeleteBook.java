/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import br.cefetmg.inf.bookregister.model.dao.BookDAO;
import br.cefetmg.inf.bookregister.model.dao.impl.BookDAOImpl;
import br.cefetmg.inf.bookregister.model.domain.Book;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pauli
 */
public class DeleteBook {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            int idBook = Integer.parseInt(request.getParameter("idbook"));
            BookDAO bookDAO = new BookDAOImpl();
            Book book = bookDAO.searchById(idBook);
            boolean delete = bookDAO.delete(book);
            if (delete != false) {
                jsp = ListBooks.execute(request);
            } else {
                String erro = "Ocorreu erro ao Excluir Categoria!";
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
