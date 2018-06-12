<%-- 
    Document   : bienvenue
    Created on : 31 mai 2018, 10:50:29
    Author     : esic
--%>

<%@page import="com.solutec.EmployeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controleur">
    
            <table border =5>

                <tr>
                    <td><b>Detail</b></td>
                    <td><b>Prenom</b></td>
                    <td><b>Nom</b></td>
                    <td><b>Teldom</b></td>
                    <td><b>Telport</b></td>
                    <td><b>Telpro</b></td>
                    <td><b>Adresse</b></td>
                    <td><b>Code Postal</b></td>
                    <td><b>Ville</b></td>
                    <td><b>Email</b></td>
                </tr>

                <%
                    ArrayList<EmployeBean> listeUser2 = (ArrayList<EmployeBean>) session.getAttribute("cleListe");
                    int i;
                    for (i = 0; i < listeUser2.size(); i++) { %>
                <tr> 
                    <td>  <INPUT TYPE="radio" NAME='idClient' VALUE="<%out.println(listeUser2.get(i).getId());%>" CHECKED ></td>

                    <td>  <%out.println(listeUser2.get(i).getNom());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getPrenom());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getTeldom());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getTelport());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getTelpro());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getAdresse());%></td>
                    <td>  <%out.println(listeUser2.get(i).getCodepostal());%> </td>
                    <td>  <%out.println(listeUser2.get(i).getVille());%></td>
                    <td>  <%out.println(listeUser2.get(i).getEmail());%></td>
                </tr>    

                <% }%>
            </table> 
            <input type='submit' name="bouton" value="Details"  />
            <input type='submit' name="bouton" value="Supprimer"/>
            <!--<input type='submit' name="bouton" value="Quitter" onclick = "twFermer()"/>-->
            

        </form>


    </body>
</html>
