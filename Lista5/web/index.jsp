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
        <link rel="stylesheet" type="text/css" href="estiloFTP.css">

        <title>Leitura arquivos</title>
    </head>
    <body>    
        <header class="buscarDiretorio">
            <h3>Leitura de diretórios e arquivos</h3>

            <form action="buscadiretorio" method="post">
                Digite o local onde estão armazenados os arquivos:<br/><br/>

                <input type="text" name="diretorio" value="" />
                <input type="submit" name="submit" value="Ler Diretorio" /><br/><br/><hr/>
            </form>
        </header>
       
        <div class="secao1">
            <h3>Informação obtida a partir do local informado!</h3>   
            <br /> 
           
            <table border="0">
                <tr>
                    <td><b>Nome</b></td>
                    <td><b>Data de modificação</b></td>
                    <td><b>Data de criação</b></td>
                    <td><b>Tamanho</b></td>
                </tr>
                <c:forEach var="diretorio" items="${diretorios}"> 
                    <tr>
                        <c:choose> 
                            <c:when test="${diretorio.ehDiretorio}">
                                <td class="coluna1"><img src="desenho.jpg"><a href="buscadiretorio?diretorio=${diretorio.caminho}"> ${diretorio.nome}</a></td>
                                <td><f:formatDate value="${diretorio.ultimaModificacao}" pattern="dd/MM/yyyy"/></td>
                                <td><f:formatDate value="${diretorio.dataCriacao}" pattern="dd/MM/yyyy"/></td> 
                                <td>${diretorio.tamanho}</td>

                            </c:when>
                            <c:otherwise>
                                <td class="coluna1"><a href="${diretorio.caminho}" type="text/html"> ${diretorio.nome}</a></td>    
                                <td><f:formatDate value="${diretorio.ultimaModificacao}" pattern="dd/MM/yyyy"/></td>
                                <td><f:formatDate value="${diretorio.dataCriacao}" pattern="dd/MM/yyyy"/></td> 
                                <td>${diretorio.tamanho}</td>

                            </c:otherwise> 
                        </c:choose> 
                    </tr>
                </c:forEach> 
            </table>
        </div>

    </body>
</html>
