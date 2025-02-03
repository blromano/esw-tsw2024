<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Alterar Serviço</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!-- Main content -->
        <div class="main-content">
            <h1>Alterar Serviço</h1>

            <form method="post" action="${cp}/processaServicos">
                <input name="acao" type="hidden" value="alterar"/>
                <input name="id" type="hidden" value="${requestScope.servicos.id_servicos}"/>

                <table>
                    <tr>
                        <td class="alinharDireita">Nome:</td>
                        <td>
                            <input name="nome" type="text" size="20" maxlength="30" value="${requestScope.servicos.ser_nome}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="alinharDireita">Área de Atuação:</td>
                        <td>
                            <input name="area" type="text" size="20" maxlength="50" value="${requestScope.servicos.ser_area}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="alinharDireita">Descrição:</td>
                        <td>
                            <input name="descricao" type="text" size="20" maxlength="100" value="${requestScope.servicos.ser_descricao}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="button-container">
                            <a href="${cp}/formularios/servicos/listagemS.jsp" class="button-secondary">Voltar</a>
                        </td>
                        <td class="alinharDireita">
                            <input type="submit" value="Alterar"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>

    </body>
</html>
