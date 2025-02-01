<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Controle do Administrador</title>
    <link rel="stylesheet" href="${cp}/css/style-ListaDeServicosDenunciados.css">
    <script src="${cp}/js/script-ListaDeServicosDenunciados.js"></script>
</head>
<body>
    <div class="wrapper">
        <!-- Menu Lateral -->
        <nav class="sidebar">
            <div class="sidebar-item" onclick="mostrarSessao('denuncias')">Lista de Denúncias</div>
            <div class="sidebar-item" onclick="mostrarSessao('usuarios')">Lista de Usuários</div>
        </nav>

        <!-- Área de Conteúdo -->
        <div class="content">
            <!-- Top-bar -->
            <div class="top-bar">
                <div class="user-profile">
                    <span>Administrador</span> | <a href="#">Sair</a>
                </div>
            </div>

            <!-- Lista de Denúncias -->
            <div id="denuncias" class="section active">
                <div class="section-title">Lista de Denúncias</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Status</th>
                            <th>Motivo</th>
                            <th>Descrição</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        
                        <jsp:useBean
                            id="servicos"
                            scope="page"
                            class="lista.services.DenunciaServices"/>
                        
                        <c:forEach items="${servicos.todos}" var="denuncias">
                            <tr>
                                
                                <td>${denuncias.id}</td>
                                <td>${denuncias.status}</td>
                                <td>${denuncias.motivo}</td>
                                <td>${denuncias.descricao}</td>
                                <td>
                                    <a href="${cp}/${prefixo}Alteracao&id=${denuncias.id}">
                                        Alterar 
                                    </a>
                                    
                                    <a href="${cp}/${prefixo}Exclusao&id=${denuncias.id}">
                                        Excluir 
                                    </a>
 
                                </td>
                                
                            </tr>
                            
                        </c:forEach>
                        
                        
                    </tbody>
                    
                    
                </table>
            </div>

            <!-- Lista de Usuários -->
            <div id="usuarios" class="section">
                <div class="section-title">Lista de Usuários</div>
                <table class="table">
                    <thead>
                        <tr>
                            <th>Status</th>
                            <th>Usuário</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><div class="status resolvido-amarelo"></div></td>
                            <td>Usuário Suspenso 1</td>
                        </tr>
                        <tr>
                            <td><div class="status resolvido"></div></td>
                            <td>Usuário Banido 1</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Popup -->
    <div id="popup" class="popup">
        <div class="popup-content">
            <div id="popup-title"></div>
            <input type="text" id="searchUser" placeholder="Buscar Usuário">
            <button>Confirmar</button>
            <button>Fechar</button>
        </div>
    </div>
</body>
</html>
