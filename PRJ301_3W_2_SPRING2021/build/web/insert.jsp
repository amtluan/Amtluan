<%-- 
    Document   : insert
    Created on : Apr 16, 2021, 10:49:34 AM
    Author     : ACER
--%>

<%@page import="sample.dto.UserErrorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new user</title>
    </head>
    <body>

        <form
            action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/></br>
            ${requestScope.ERROR_USER.userIDEorror}</br>
            Full Name<input type="text" name="fullname" required=""/></br>
            ${requestScope.ERROR_USER.FullNameError}</br>
            Role ID<input type="text" name="roleID" required=""/></br>
            ${requestScope.ERROR_USER.RoleIDError}</br>
            Password<input type="password" name="password" required=""/></br>
            ${requestScope.ERROR_USER.passwordError}</br>
            Confirm<input type="password" name="confirm" required=""/></br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset"  value="Reset"/></br>
        </form>
    </body>
</html>
