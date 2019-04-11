<%-- 
    Document   : index
    Created on : 10/04/2019, 08:49:30
    Author     : 80130917
--%>

<%@page import="Servlet.BuscaDiretorio"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estiloProjeto.css">
        <title>Leitura arquivos</title>
    </head>
    <body>
        <div class="secao1">
            <h1>Leitura de diretórios e arquivos</h1>

            <form action="buscadiretorio" method="post">
                Digite o local onde estão armazenados os arquivos:<br/><br/>

                <input type="text" name="diretorio" value="" />
                <input type="submit" name="submit" value="Ler Diretorio" /><br/><br/><hr/>
            </form>
        </div>

        <div class="secao2">
            <h1>Informação obtida a partir do local informado!</h1>   
            <br /> 

            <c:forEach var="diretorio" items="${diretorios}"> 
                <br /> 
                ${diretorio.nome} ${diretorio.tamanho} ${diretorio.ultimaModificacao} 
                <br /> 
                <img src="desenho.jpg">  ${diretorio.nome} ${diretorio.tamanho} ${diretorio.ultimaModificacao}  

            </c:forEach> 

        </div>
    </body>
</html>
