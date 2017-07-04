/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pauli
 */
public class ServletWeb extends HttpServlet {
    private String jsp = "";
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    
        request.setCharacterEncoding("UTF-8");
        String page = request.getParameter("page");
        
        if (page.equals("ListBooks"))
            jsp = ListBooks.execute(request);
        else if (page.equals("UpdateBook"))
            jsp = UpdateBook.execute(request);
        else if (page.equals("DeleteBook"))
            jsp = DeleteBook.execute(request);
        else if (page.equals("SaveUpdate"))
            jsp = SaveUpdate.execute(request);
        else if (page.equals("InsertBook"))
            jsp = InsertBook.execute(request);
        else if (page.equals("SaveInsertion"))
            jsp = SaveInsertion.execute(request);

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}
