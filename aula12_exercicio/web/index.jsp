<%-- 
    Document   : index
    Created on : 9 de mai. de 2022, 20:13:16
    Author     : Fatec
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Associates" %>
<% 
Exception requestEx = null;
ArrayList<Associates> List = new ArrayList<>();
int count = 0;
try{
    //count = Associates.getCount();
    List = Associates.getList();
}catch(Exception ex){
    requestEx = ex;
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Índice - Associados</title>
    </head>
    <body>
        <style>
            .conteiner{
                display: flex;
            }
        </style>
        
        <h1>JDBC</h1>
        <div class="conteiner">
            <div>
        <h2>Clientes</h2>
        <%if(requestEx!=null){%>
        <h2 style="color:red"><%= requestEx.getMessage() %></h2>
        <%}%>
        <table border="1">
            <tr><th>id</th><th>name</th></tr>
            <%for(Associates a: Associates.getList()){%>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getName() %></td>
            </tr>
            <%}%>
        </table>
        </div>
        <div>
        <h2>funcionarios</h2>
        <%if(requestEx!=null){%>
        <h2 style="color:red"><%= requestEx.getMessage() %></h2>
        <%}%>
        <table border="1">
            <tr><th>id</th><th>name</th></tr>
            <%for(Associates a: Associates.getList_funcionarios()){%>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getName() %></td>
            </tr>
            <%}%>
        </table>
        </div>
        </div>
    </body>
</html>