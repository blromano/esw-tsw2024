<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conecta+ | Denuncias Recebidas</title>
    <link rel="stylesheet" href="${cp}/css/style-ListaDeServicosDenunciados.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> 
    <script src="${cp}/js/script-ListaDeServicosDenunciados.js"></script>
</head>
<body>
    <!-- Menu Lateral -->
        <div id="sidebar" class="sidebar">
            <div class="sidebar-header">
                <button class="toggle-btn" onclick="toggleSidebar()">&#9776;</button>
            </div>
            <div class="menu">
                </a>
                <a href="#">
                    <i class="fas fa-history"></i>
                    <span>Lista de Denuncias</span>
                </a>
                <a href="#">
                    <i class="fas fa-list"></i>
                    <span>Lista de Usuarios</span>
                </a>
            </div>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <!-- Top bar -->
            <div class="top-bar">
                <div class="user-profile">
                    <span>Bem-vindo, Administrador</span>
                    <div class="dropdown">
                        <button class="dropbtn">Perfil ▼</button>
                        <div class="dropdown-content">
                            <a href="#">Meu Perfil</a>
                            <a href="${cp}/index.jsp">Sair</a>
                        </div>
                    </div>
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

           
        </div>
    </div>
    <footer>
                <div class="footer-content">
                    <div class="footer-left">
                        <p>&copy; 2024 Conecta LTDA - Todos os direitos reservados.</p>
                    </div>
                    <div class="footer-center">
                        <div class="social-icons">
                            <a href="https://www.instagram.com" target="_blank" class="social-circle"><i class="fab fa-instagram"></i></a>
                            <a href="https://www.linkedin.com" target="_blank" class="social-circle"><i class="fab fa-linkedin"></i></a>
                            <a href="https://wa.me" target="_blank" class="social-circle"><i class="fab fa-whatsapp"></i></a>
                        </div>
                    </div>
                    <div class="footer-right">
                        <div class="footer-links">
                            <a href="#">Política de Privacidade</a> |
                            <a href="#">Termos de Uso</a>
                        </div>
                    </div>
                </div>
            </footer>  
    </body>
</html>
