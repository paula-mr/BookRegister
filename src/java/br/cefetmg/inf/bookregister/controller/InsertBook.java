/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.bookregister.controller;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author pauli
 */
public class InsertBook {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            jsp = "insertBook.jsp";

        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
