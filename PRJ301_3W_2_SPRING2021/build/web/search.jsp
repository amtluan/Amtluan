<%-- 
    Document   : search
    Created on : Apr 13, 2021, 6:27:53 PM
    Author     : PC
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEARCH Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO)session.getAttribute("LOGIN_USER");
            String search = request.getParameter("search");
            if(search ==null)
            {
                search="";
            }
            if(loginUser ==null || !"AD".equals(loginUser.getRoleID()))
            {
                response.sendRedirect("login.html");
                return;
            }
            {
                %>
                <h1>Welcome: <%= loginUser.getFullname()%></h1>
                
                <form
                    action="MainController">
                    <input type="submit" name="action" value="Logout"/>
                </form>
                <form
                    action="MainController">
                    Search <input type ="text" name="search"/>
                    <input type="submit" name="action" value="Search"/>
                </form>
                <%
                List<UserDTO> list = (List<UserDTO>)request.getAttribute("LIST_USER");
                if(list!=null)
                {
                    %>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>User ID</th>
                                <th>Full Name</th>
                                <th>Role ID</th>
                                <th>Password</th>
                                <th>Delete</th>
                                <th>Update</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                            int count = 1;
                            for(UserDTO user : list )
                            {
                                %>
                        <form action="MainController"
                             <tr>
                                <td><%= count++ %></td>
                                <td><%= user.getUserID()%></td>
                                <td>
                                     <input type="text" name="fullname" value="<%= user.getFullname()%>"/>
                                </td>
                                <td>
                                    <input type="text" name="roleID" value="<%= user.getRoleID()%>"/>
                                </td>
                                <td><%= user.getPassword()%></td>
                                <td>
                                    <a href="MainController?search=<%= search %>&action=Delete&userID=<%= user.getUserID() %>">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="userID" value="<%= user.getUserID() %>"/>
                                    <input type="hidden" name="search" value="<%= search%>"/>
                                    <input type="submit" name="action" value="Update"/>
                                </td>
                            </tr>
                        </form>
                            <%
                            }
                            
                            %>
                           
                        </tbody>
                    </table>

                
                <%
                }
                %>
        <%
            }
        %>
       
    </body>
</html>
