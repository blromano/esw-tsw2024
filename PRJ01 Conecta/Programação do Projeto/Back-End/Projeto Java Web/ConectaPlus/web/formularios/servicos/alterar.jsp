<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Conecta+ | Lista de Serviços</title>
        <link rel="stylesheet" href="${cp}/css/servicos/style-alterar.css">
        <link rel="icon" href="../4.23-Agenda Profissional/img - Agenda Profissional/icon-conecta.svg" type="image/x-icon">
        <script defer src="${cp}/js/servicos-js/lista-servicos.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
   </head>
    <body>
         <!-- Menu Lateral -->
        <div id="sidebar" class="sidebar">
            <div class="sidebar-header">
                <button class="toggle-btn" onclick="toggleSidebar()">&#9776;</button>
            </div>
            <div class="menu">
                <a href="/Dash-Profissional/UC4.23-Agenda Profissional/agendaProfissional.html">
                    <i class="fas fa-search"></i>
                    <span>Minha Agenda</span>
                </a>
                <a href="${cp}/formularios/agendamentos/listagem.jsp">
                    <i class="fas fa-history"></i>
                    <span>Histórico de Agendamentos</span>
                </a>
                <a href="#">
                    <i class="fas fa-list"></i>
                    <span>Lista de Serviços</span>
                </a>
                <a href="#">
                    <i class="fas fa-star"></i>
                    <span>Gerenciar Imagens</span>
                </a>
                <a href="#">
                    <i class="fas fa-trophy"></i>
                    <span>Ranking de Profissionais</span>
                </a>
            </div>
        </div>

        <!-- Main Content -->
        <div class="main-content">
            <!-- Top bar -->
            <div class="top-bar">
                <div class="user-profile">
                    <span>Bem-vindo, Usuário</span>
                    <div class="dropdown">
                        <button class="dropbtn">Perfil ▼</button>
                        <div class="dropdown-content">
                            <a href="/Dash-Profissional/UC4.13-Gerenciar Perfil/meuPerfil.html">Meu Perfil</a>
                            <a href="${cp}/index.jsp">Sair</a>
                        </div>
                    </div>
                </div>
            </div>
        <!-- Main content -->
        <div class="main-content">
            <h2 style="text-align:initial; margin-top: 10px; padding-bottom: 10px">Alterar Serviço</h2>

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
           <!-- Rodapé -->
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
        </div>
    </body>
</html>
