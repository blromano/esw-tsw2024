<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conecta+ | Cadastre-se em nossa plataforma</title>
    <link rel="stylesheet" href="${cp}/css/tipo-cadastro/style-selecCad.css">
    <link rel="icon" href="${cp}/img/icon-conecta.svg" type="image/x-icon">

</head>
<body>
    <div class="container">
        <a href="${cp}/formularios/cliente/cad-Cliente.jsp">
            <div class="option-box cliente" id="FormularioCliente">
                <h2>Quero Buscar Serviços</h2> 
            </div>
        </a>
        
        <a href="${cp}/formularios/profissional/cad-Profissional.jsp">
            <div class="option-box profissional" id="FormularioProfissional">
                <h2>Quero Ofertar Serviços</h2>
            </div>
        </a>
    </div>
</body>
</html>
