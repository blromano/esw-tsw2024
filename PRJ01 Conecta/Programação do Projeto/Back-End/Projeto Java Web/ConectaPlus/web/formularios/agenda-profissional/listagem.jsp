<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conecta+ | Minha Agenda</title>
    <link rel="stylesheet" href="${cp}/css/agenda-profissional/agendaProfissional.css">
    <link rel="icon" href="../4.23-Agenda Profissional/img - Agenda Profissional/icon-conecta.svg" type="image/x-icon">
    <script defer src="${cp}/js/agenda-profissional/agendaProfissional.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>
    <!-- Menu Lateral -->
    <div id="sidebar" class="sidebar">
        <div class="sidebar-header">
            <button class="toggle-btn" onclick="toggleSidebar()">&#9776;</button>
        </div>
        <div class="menu">
            <a href="#">
                <i class="fas fa-search"></i>
                <span>Minha Agenda</span>
            </a>
            <a href="${cp}/formularios/agendamentos/listagem.jsp">
                <i class="fas fa-history"></i>
                <span>Histórico de Agendamentos</span>
            </a>
            <a href="${cp}/formularios/servicos/listagemS.jsp">
                <i class="fas fa-history"></i>
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

    <!-- Navbar topo -->
    <div class="main-content">
        <!-- Top bar -->
        <div class="top-bar">
            <div class="user-profile">
                <span>Bem-vindo, Usuário</span>
                <div class="dropdown">
                    <button class="dropbtn">Perfil ▼</button>
                    <div class="dropdown-content">
                        <a href="${cp}/formularios/gerenciar-perfil/gerenciar-perfil.jsp">Meu Perfil</a>
                        <a href="${cp}/index.jsp">Sair</a>
                    </div>
                </div>
            </div>
        </div>

       
        <!-- Minha Agenda -->
        
        <div class="minha-agenda">
            <div class="agenda">
                <jsp:useBean
                    id="servicos"
                    scope="page"
                    class="conecta.services.AgendaProfissionalService"/>
                    <h1>Agendamentos Pendentes</h1>
                    
                    <c:forEach items="${servicos.todos}" var="agendamentos">
                        
                        <div class="service" id="service-1">
                            <p>Agendado por: ${agendamentos.cliente.usuario.nome}</p>
                            <p>Data: ${agendamentos.age_data} </p>
                            <p>Horário: ${agendamentos.age_horario} </p>
                        </div>
                    
                    </c:forEach>
            </div>
            <div class="calendar-section">
                <h1>Google Calendar</h1>
                <iframe src="https://calendar.google.com/calendar/embed?src=your_calendar_id&ctz=America/Sao_Paulo" 
                        style="border: 0" width="600" height="400" frameborder="0" scrolling="no"></iframe>
            </div>
        </div>

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

