<%-- 
    Document   : shopping
    Created on : Apr 19, 2021, 11:14:24 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TAM Tea</title>
    </head>
    <body>
        <h1>Select your Favorite Tea: </h1>
        <form action="MainController">
            <select name="cmbTea">
                <option value="T01-Peach Tea-15">Peach Tea</option>
                <option value="T02-Pink Tea-50">Pink Tea</option>
                <option value="T03-Black Tea-50">Black Pink Tea</option>
                <option value="T04-Classic Tea-10">Classic Tea</option>
            </select>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            String message = (String)session.getAttribute("MESSAGE");
            if(message==null)
            {
                message="";
            }
        %>
        <h1> <%= message %></h1>
    </body>
</html>
