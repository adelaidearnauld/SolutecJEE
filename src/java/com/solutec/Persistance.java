package com.solutec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Persistance {

    Connection conn2;
    Statement stmt2;
    PreparedStatement pstmt2;
    ResultSet rs2;
    EmployeBean eb;
    

    public ResultSet getConnection(String requete) throws SQLException 
    {

        conn2 = DriverManager.getConnection(EmployesConstantes.url2, EmployesConstantes.user2, EmployesConstantes.mdp2);
        stmt2 = conn2.createStatement();
        rs2 = stmt2.executeQuery(requete);
        return rs2;
    }
    
    ArrayList<EmployeBean> listeEmployes = null;

    public ArrayList getEmployes(ResultSet rs2) 
    {
        listeEmployes = new ArrayList<EmployeBean>();

        try {
            while (rs2.next()) {
                eb = new EmployeBean();
                eb.setId(rs2.getString("ID"));
                eb.setNom(rs2.getString("NOM"));
                eb.setPrenom(rs2.getString("PRENOM"));
                eb.setTeldom(rs2.getString("TELDOM"));
                eb.setTelport(rs2.getString("TELPORT"));
                eb.setTelpro(rs2.getString("TELPRO"));
                eb.setAdresse(rs2.getString("ADRESSE"));
                eb.setCodepostal(rs2.getString("CODEPOSTAL"));
                eb.setVille(rs2.getString("VILLE"));
                eb.setEmail(rs2.getString("EMAIL"));

                listeEmployes.add(eb);
            }
        } catch (SQLException e) {
        }
        return listeEmployes;
    }

    public void supprimer(String requete, String cleId)

    {
        try {
            conn2 = DriverManager.getConnection(EmployesConstantes.url2, EmployesConstantes.user2, EmployesConstantes.mdp2);
            pstmt2 = conn2.prepareStatement(EmployesConstantes.REQ3);
            pstmt2.setString(1, cleId);
            //rs2 = pstmt2.executeQuery(EmployesConstantes.REQ3);
            pstmt2.executeQuery(requete);
            
        } catch (SQLException e) {}
        

    }
    
    public ResultSet getDetails(String requete, String cleId)

    {
        try {
            conn2 = DriverManager.getConnection(EmployesConstantes.url2, EmployesConstantes.user2, EmployesConstantes.mdp2);
            pstmt2 = conn2.prepareStatement(EmployesConstantes.REQ4);
            pstmt2.setString(1, cleId);
            rs2= pstmt2.executeQuery();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs2;
    }
    
    //creation bean pour le bouton Détails
    
    public EmployeBean getEmploye(ResultSet rs2) 
    {
        
        try {
            while (rs2.next()) {
                eb = new EmployeBean();
                eb.setId(rs2.getString("ID"));
                eb.setNom(rs2.getString("NOM"));
                eb.setPrenom(rs2.getString("PRENOM"));
                eb.setTeldom(rs2.getString("TELDOM"));
                eb.setTelport(rs2.getString("TELPORT"));
                eb.setTelpro(rs2.getString("TELPRO"));
                eb.setAdresse(rs2.getString("ADRESSE"));
                eb.setCodepostal(rs2.getString("CODEPOSTAL"));
                eb.setVille(rs2.getString("VILLE"));
                eb.setEmail(rs2.getString("EMAIL"));

                
            }
        } catch (SQLException e) {
        }
        return eb;
    }
    
    public void modifier( String requete, String cleEmail, String clePrenom, String cleAdresse, String cleNom, String cleId) throws SQLException 
    {
         try {
            conn2 = DriverManager.getConnection(EmployesConstantes.url2, EmployesConstantes.user2, EmployesConstantes.mdp2);
            pstmt2 = conn2.prepareStatement(EmployesConstantes.REQ5);
            pstmt2.setString(5, cleId);
            pstmt2.setString(1, cleNom);
            pstmt2.setString(2, clePrenom);
            pstmt2.setString(3, cleAdresse);
            pstmt2.setString(4, cleEmail);
            int i = pstmt2.executeUpdate();
            System.out.println("");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
