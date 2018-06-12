/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutec;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import javax.jms.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.solutec.EmployesConstantes;
import com.solutec.Persistance;
import java.util.ArrayList;
import com.solutec.EmployeBean;
import com.solutec.UtilBean;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esic
 */
public class Controleur extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//
//            String nom = request.getParameter("nom");
//            out.println("Votre nom est: " + nom);
//        }
        // CODE CONTROLEUR.JSP

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ResultSet rs2;
        Persistance p;

        String btn;
        String cleId;
        String cleIdModif;
        String cleEmp;
        String cleEmpsession;
        String cleNom;
        String clePrenom;
        String cleAdresse;
        String cleEmail;

        UtilBean user1;

        HttpSession session;

        session = request.getSession();

        conn = DriverManager.getConnection(EmployesConstantes.url, EmployesConstantes.user, EmployesConstantes.mdp);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(EmployesConstantes.REQ);

        String loginSaisi = request.getParameter("login");
        String mdpSaisi = request.getParameter("mdp");

        user1 = new UtilBean();
        while (rs.next()) {
            user1.setLogin(rs.getString("Login"));
            user1.setMdp(rs.getString("Mdp"));
        }

        //Gestion des erreurs et de la compatibilité des infos avec la BDD
        int i = 0;
        if (loginSaisi != null && mdpSaisi != null) {
            if (loginSaisi.equals(user1.getLogin()) && mdpSaisi.equals(user1.getMdp())) {
                //i=0;
                //request.setAttribute("cleErr", i);
                p = new Persistance();
                rs2 = (ResultSet) p.getConnection(EmployesConstantes.REQ2);
                session.setAttribute("cleListe", p.getEmployes(rs2));
                request.getRequestDispatcher(EmployesConstantes.PAGE_BIENVENUE).forward(request, response);
            } else if (loginSaisi.equals("") || mdpSaisi.equals("")) {
                i = 1;
                session.setAttribute("cleErr", i);
                request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);
            } else {
                i = 2;
                session.setAttribute("cleErr", i);
                request.getRequestDispatcher(EmployesConstantes.PAGE_INDEX).forward(request, response);

            }
        }

        btn = request.getParameter("bouton");
        cleId = request.getParameter("idClient");
        if (cleId != null) {
            session.setAttribute("Id", cleId);
        }

        if (btn != null) {

            if (btn.equals(EmployesConstantes.ACTION_SUPPRIMER)) {
                p = new Persistance();
                p.supprimer(EmployesConstantes.REQ3, cleId);
                rs2 = (ResultSet) p.getConnection(EmployesConstantes.REQ2);
                session.setAttribute("cleListe", p.getEmployes(rs2));
                request.getRequestDispatcher(EmployesConstantes.PAGE_BIENVENUE).forward(request, response);
            }

            if (btn.equals(EmployesConstantes.ACTION_DETAILS)) {
                p = new Persistance();
                rs2 = (ResultSet) p.getDetails(EmployesConstantes.REQ4, cleId);
                session.setAttribute("cleEmp", p.getEmploye(rs2));
                request.getRequestDispatcher(EmployesConstantes.PAGE_DETAIL_EMPLOYE).forward(request, response);
            }

            if (btn.equals(EmployesConstantes.ACTION_VOIR_LISTE)) {
                p = new Persistance();
                rs2 = (ResultSet) p.getConnection(EmployesConstantes.REQ2);
                session.setAttribute("cleListe", p.getEmployes(rs2));
                request.getRequestDispatcher(EmployesConstantes.PAGE_BIENVENUE).forward(request, response);
            }

            if (btn.equals(EmployesConstantes.ACTION_MODIFIER)) {
                p = new Persistance();
                cleIdModif = (String) session.getAttribute("Id");
                cleNom = request.getParameter("nom");
                clePrenom = request.getParameter("prenom");
                cleAdresse = request.getParameter("adresse");
                cleEmail = request.getParameter("email");
                p.modifier(EmployesConstantes.REQ5, cleEmail, clePrenom, cleAdresse, cleNom, cleIdModif);

                rs2 = (ResultSet) p.getDetails(EmployesConstantes.REQ4, cleIdModif);
                session.setAttribute("cleEmp", p.getEmploye(rs2));
                request.getRequestDispatcher(EmployesConstantes.PAGE_DETAIL_EMPLOYE).forward(request, response);

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
