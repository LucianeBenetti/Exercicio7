<%-- 
    Document   : Pedido
    Created on : 24/04/2019, 08:34:11
    Author     : 80130917
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Pedidos</title>
    </head>
    <body>
        <%
            Object pedidoCliente = request.getAttribute("pedido");

            if (pedidoCliente != null) {
              //  ArrayList<String> nome = (ArrayList<String>) nomeTorta;
                out.print(pedidoCliente);
            }
        %>
    </body>
</html>
