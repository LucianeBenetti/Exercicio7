<%-- 
    Document   : Pedido
    Created on : 24/04/2019, 08:34:11
    Author     : 80130917
--%>

<%@page import="Classes.Cardapio"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <title>Cadastro de Pedidos</title>
    </head>
    <body>
        <%
            Object pedidoCliente = request.getAttribute("pedido");

            if (pedidoCliente != null) {
                ArrayList<Cardapio> pedido = (ArrayList<Cardapio>) pedidoCliente;
        %>   
        <section class="secao2">
            <h3>Pedido Efetuado</h3>   

            <table border="0">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th>Preço (R$) </th>
                        <th>Calorias</th>

                    </tr>
                </thead>

                <%
                    for (int i = 0; i < pedido.size(); i++) {
                        Cardapio opcoesCardapio = pedido.get(i);
                %>
                <tr>
                    <td><% out.print(opcoesCardapio.getNome()); %></td>
                    <td><% out.print(opcoesCardapio.getQuantidade()); %></td>
                    <td><% out.print(opcoesCardapio.getPreco());%></td>
                    <td><% out.print(opcoesCardapio.getCalorias()); %></td>
                </tr>
                <%   }%>
                <br />          

            </table>
            <br>
            <br>
           
            </form>
        </section>
                
 
         <section class="secao3">
            <h3>Digite seus dados para processar o pedido</h3>
            <form name="pedido" action="Pedido.jsp" method="POST">
               
                <br>
                <br>
                <input type="submit" name="enviar" value="Gerar XML">
            </form>
        </section>
     
        <%}%>
    </body>
</html>
