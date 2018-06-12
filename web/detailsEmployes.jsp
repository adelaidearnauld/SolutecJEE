<%-- 
    Document   : detailsEmployes
    Created on : 1 juin 2018, 13:33:30
    Author     : esic
--%>

<%@page import="com.solutec.EmployeBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type"><title></title>

    </head>
   <%
    EmployeBean User2 = (EmployeBean) session.getAttribute("cleEmp");
    %>
    <body>
        <span style="font-weight: bold;"></span><big><big><span style="font-weight: bold;">Détails du membre <%out.println(User2.getPrenom());%> <%out.println(User2.getNom());%></span><br style="font-weight: bold;">
        </big></big><br>
    <span style="font-weight: bold; color: red;"></span><br>
    
    
    <form action="Controleur"> 
        <label for="nom">Nom : </label><input value=<%out.println(User2.getNom());%> id="nom" name="nom" onblur="leaveField(this);"> <label for="prenom">Prénom
            : </label><input value=<%out.println(User2.getPrenom());%> id="prenom" name="prenom" onblur="leaveField(this); leavePrenom();">
        <br>
        <br>
        <span style="font-weight: bold;">Numéro de téléphone</span><br>
        <label for="teldom">Domicile : </label><input value=<%out.println(User2.getTeldom());%> name="teldom" id="teldom" onblur="leaveField(this); checkTel(this);"><br>
        <label for="telport">Portable : </label><input value=<%out.println(User2.getTelport());%> name="telpor" id="telpor" onblur="leaveField(this); checkTel(this);"><br>
        <label for="telpro">Professionnel : </label><input value=<%out.println(User2.getTelpro());%> name="telpro" id="telpro" onblur="leaveField(this); checkTel(this);"><br>
        <br>
        <label for="adresse">Adresse : </label><input value=<%out.println(User2.getAdresse());%> name="adresse" id="adresse" onblur="leaveField(this);"><br>
        <label for="cp">Code postal : </label><input value=<%out.println(User2.getCodepostal());%> name="cp" id="cp" onblur="leaveField(this); checkCP();">
        <label for="ville">Ville : </label><input value=<%out.println(User2.getVille());%> name="ville" id="ville" onblur="leaveField(this);"><br>
        <label for="email">E-mail : </label><input id="mail" name="email" value=<%out.println(User2.getEmail());%> onblur="leaveField(this); checkMail();"><br>
        <br>
        
        <input name="bouton" value="Voir liste" type="submit"><br>
        <input name="bouton" value="Modifier" type="submit"><br>

    </form>
</body></html>
