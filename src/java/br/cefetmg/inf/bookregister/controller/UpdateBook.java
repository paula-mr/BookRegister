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
public class UpdateBook {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            String idBook = request.getParameter("idbook");
            BookDAO bookDAO = new BookDAOImpl();
            Book book = bookDAO.searchById(Integer.parseInt(idBook));
            if(book != null){
                request.setAttribute("book", book);
                jsp = "/updatebook.jsp";
            } else {
               String erro = "Ocorreu erro ao alterar a categoria";
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
