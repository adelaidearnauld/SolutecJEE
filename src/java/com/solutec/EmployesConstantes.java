/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solutec;

/**
 *
 * @author esic
 */
public class EmployesConstantes 
{
    //Connection 1
    public static final String url = "jdbc:derby://localhost:1527/BaseTP";
    public static final String user = "jee";
    public static final String mdp = "jee";
    
    //Connection 2
    public static final String url2 = "jdbc:derby://localhost:1527/solutec";
    public static final String user2 = "test";
    public static final String mdp2 = "test";
    
    //Requêtes SQL    
    public static final String REQ ="SELECT * FROM IDENTIFIANTS"; 
    public static final String REQ2 ="SELECT * FROM EMPLOYES";
    public static final String REQ3 ="DELETE FROM EMPLOYES WHERE ID=?";
    public static final String REQ4 ="SELECT * FROM EMPLOYES WHERE ID=?";
    public static final String REQ5 ="UPDATE EMPLOYES SET NOM=?, PRENOM=?, ADRESSE=?, EMAIL=? WHERE ID=?";
    
    //Pages
    public static final String PAGE_INDEX = "index.jsp";
    public static final String PAGE_CONTROLEUR = "Controleur";
    public static final String PAGE_BIENVENUE = "bienvenue.jsp";
    public static final String PAGE_DETAIL_EMPLOYE = "detailsEmployes.jsp";
    
    //Messages d'erreur
    public static final String ERREUR_SAISIE_VIDE = "Vous devez renseigner les deux champs";
    public static final String ERREUR_LOGIN_MDP = "Informations de connexion non valides. Réessayer svp";
    
    //Actions
    public static final String ACTION_SUPPRIMER = "Supprimer";
    public static final String ACTION_DETAILS = "Details";
    public static final String ACTION_MODIFIER = "Modifier";
    public static final String ACTION_VOIR_LISTE = "Voir liste";
   
}
