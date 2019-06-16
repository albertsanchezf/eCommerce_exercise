<%-- 
    Document   : category
    Created on : Mar 12, 2019, 10:59:34 AM
    Author     : AlbertSanchez
--%>

<%@page import="cart.ShoppingCart"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.List"%>
<%@page import="model.CategoryModel"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>

<!-- Get type of category from URL-->
<% int categoryId = Integer.parseInt(request.getParameterValues("categoryid")[0]); %>

<!-- Get categories, items list and shopping cart -->
<%   
    CategoryModel cm = (CategoryModel) getServletContext().getAttribute("categoryModel");
    String categoryName = cm.getNamefromId(categoryId);
    List<Category> categories = cm.retrieveAll();
    
    List<Product> itemsList = (List<Product>)request.getAttribute("items");
    
    ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute("shoppingCart");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Categories Page</title>
    </head>
    <body>
        <h1>Products of <%=categoryName%> </h1>
        <img src="./img/cart.gif" alt="Cart"> <%=shoppingCart.getNumberOfItems() %> items
        <% if (shoppingCart.getNumberOfItems() != 0) { %>
        <a href="viewcart.do"> View Cart</a><br><br>
        <a href="checkout.do">Proceed to checkout</a>
        <%}%>
        <br><br>
        <table border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
            <tr>
                <td valign="center" align="middle">
                    <table width="150px" border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                        <% 
                            for(Category category : categories) 
                            {
                        %>
                        <tr>
                            <td valign="center" align="middle">
                                <a href="category.do?categoryid=<%=category.getId()%>"><%=category.getName() %></a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </td>
                <td valign="center" align="middle">
                    <table border="1" bordercolordark="#000000" bordercolorlight="#FFFFFF" cellpadding="3" cellspacing="0">
                        <tr>
                            <td width="150px" valign="center" align="middle">
                                <b>Product</b>
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <b>Name</b>
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <b>Price</b>
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <b>Add to chart</b>
                            </td>
                        </tr>
                        <% 
                            for(Product product : itemsList) 
                            {
                        %>
                        <tr>
                            <td width="150px" valign="center" align="middle">
                                <img src="./img/products/<%=product.getName()%>.png">
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <b><%=product.getName()%></b><br>
                                <%=product.getDescription()%>
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <%=product.getPrice()%>€
                            </td>
                            <td width="150px" valign="center" align="middle">
                                <form action="neworder.do" method="POST">
                                    <input type="text" name="categoryid"
                                           value="<%=categoryId%>"
                                           hidden="true">
                                    <input type="text" name="itemid" 
                                           value="<%=product.getId()%>" 
                                           hidden="true">
                                    <input type="submit" value="Add to chart">
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
