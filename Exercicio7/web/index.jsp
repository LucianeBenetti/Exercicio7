<%-- 
    Document   : index
    Created on : 17/04/2019, 08:15:57
    Author     : 80130917
--%>
<%@page import="java.lang.Double"%>
<%@page import="Classes.Cardapio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlet.XML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estil.css">
        <title>Cardapio</title>
    </head>
    <body>

        <header class="buscarMenu">
            <h4>Clique no link abaixo e acesse nosso cardápio especial de tortas e sobremesas: </h4>
            <form action="xml" method="POST"> 
                <input type="submit" name="conhecerCardapio" value="Conhecer Cardápio">
            </form>
        </header>       

        <%
            Object cardapio = request.getAttribute("conteudoCardapio");
            if (cardapio != null) {
                ArrayList<Cardapio> menu = (ArrayList<Cardapio>) cardapio;
        %>
        <section class="secao1">
            <h3>Conheça nosso Menu de Tortas e Sobremesas</h3>   
            <table border="0">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descricao</th>
                        <th>Calorias</th>
                        <th>Preço</th>
                    </tr>
                </thead>

                <%
                    for (int i = 0; i < menu.size(); i++) {
                        Cardapio opcoesCardapio = menu.get(i);
                %>
                <tr>
                    <td class="nome"><% out.print(opcoesCardapio.getNome()); %></td>
                    <td><% out.print(opcoesCardapio.getDescricao()); %></td>
                    <td><% out.print(opcoesCardapio.getCalorias()); %></td>
                    <td>R$ <% out.print(opcoesCardapio.getPreco()); %></td>
                </tr>
                <%   }  %>
                <br />          

            </table>
        </section>

        <section class="secao2">
            <h3>Escolha a quantidade e faça seu Pedido</h3>
            <form name="pedido" action="Pedido.jsp" method="POST">
                <table>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Quantidade</th>
                            <th>Preço por Unidade</th>
                            <th>Calorias por Unidade</th>
                    <br>
                    </tr>
                    </thead>
                    <tbody>
                        <%
                            for (int i = 0; i < menu.size(); i++) {
                                Cardapio opcoesCardapio = menu.get(i);
                        %>
                        <tr class="item">

                            <td class="nomePedido"><% out.print(opcoesCardapio.getNome());%></td>
                            <td class="qtdade"> 
                                <a class="btn-decrementa">-</a>
                                <input max="100" class="quantidade" value="0" type="number" readonly="" name="valores">  
                                <a class="btn-incrementa">+</a>
                            </td>
                            <td class="preco-item"><%out.print(opcoesCardapio.getPreco()); %></td>
                            <td class="calorias-item"><%out.print(opcoesCardapio.getCalorias()); %></td>
                        </tr>  
                        <%}%>   
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="total" colspan="2">Total (preço total em R$)</td>
                            <td name="total" id="total">0</td>
                            <td name="totalCalorias" id="totalCalorias">0</td>
                        </tr>
                    </tfoot>
                </table>
                <br>
                <br>
                <input type="submit" value="Enviar Pedido">
            </form>
        </section>
        <script type="text/javascript" src="calcularCampos.js"></script>
        <%}%>
    </body>
</html>
