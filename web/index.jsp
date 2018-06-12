<%-- 
    Document   : index
    Created on : 31 mai 2018, 09:48:46
    Author     : esic
--%>

<%@page import="com.solutec.EmployesConstantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="Controleur">
            <label>Login: <input type="text" name="login"/></label>
            <label> MDP <input type="text" name="mdp"/></label>
            <input type="submit" value="Ok"/>
        </form>
        <span style="color:red">
        <%
        Integer i = (Integer) request.getAttribute("cleErr");
        if (i != null)
        {
            if (i.equals(1))
            {
                out.println(EmployesConstantes.ERREUR_SAISIE_VIDE);
            }
            
            if (i.equals(2))
            {
                out.println(EmployesConstantes.ERREUR_LOGIN_MDP);
            }
        }
        %>
        </span>
           
        
    </body>
</html>
