<%-- 
    Document   : ViewCart
    Created on : Apr 19, 2021, 12:50:19 PM
    Author     : ACER
--%>

<%@page import="sample.dto.TeaDTO"%>
<%@page import="sample.dto.cartDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View shopping Cart</title>
    </head>
    <body>
        <h1>You selected:</h1>
        <%
            cartDTO cart = (cartDTO) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total=0;
                    for (TeaDTO tea : cart.getCart().values()) {
                        total +=tea.getQuantity() * tea.getPrice();
                %>
            <form action ="MainController">
                <tr>
                    <td><%=count++%></td>
                    <td><%=tea.getId()%>
                        <input type="hidden" name="id" value="<%=tea.getId()%>"/>
                    
                    </td>
                    <td><%=tea.getName()%></td>
                    <td>
                        <input type="number" name="quantity" value="<%=tea.getQuantity()%>"/>
                    </td>
                    <td><%=tea.getPrice()%></td>
                    <td><%=tea.getQuantity() * tea.getPrice()%></td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
        </form>
                <%
                }
                %>
            </tbody>
        </table>
            <h1>Total:<%= total %></h1>

        <%
            }
        %>
        <a href="shopping.jsp">Add more</a>
    </body>
</html>
