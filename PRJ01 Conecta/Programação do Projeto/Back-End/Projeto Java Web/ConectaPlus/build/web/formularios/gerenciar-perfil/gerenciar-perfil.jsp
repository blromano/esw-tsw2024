<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conecta+ | Minha Agenda</title>
    <link rel="stylesheet" href="${cp}/css/gerenciar-perfil/gerenciar-perfil.css">
    <link rel="icon" href="../4.23-Agenda Profissional/img - Agenda Profissional/icon-conecta.svg" type="image/x-icon">
    <script defer src="${cp}/js/agenda-profissional/agendaProfissional.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

</head>
<body>
    <!-- Navbar topo -->
    <div class="main-content">
        <!-- Top bar -->
        <div class="top-bar">
            <div class="user-profile">
                <span>Bem-vindo, Usuário</span>
                <div class="dropdown">
                    <button class="dropbtn">Perfil ▼</button>
                    <div class="dropdown-content">
                        <a href="/${cp}#">Meu Perfil</a>
                        <a href="${cp}/index.jsp">Sair</a>
                    </div>
                </div>
            </div>
        </div>


        <div class="profile-container">
            <div class="profile-card">
                <div class="profile-header">
                    <a href="${cp}/formularios/agenda-profissional/listagem.jsp" class="back-icon"><i class="fas fa-arrow-left"></i></a>
                    <h4 class="profile-title"><i class="fas fa-user-circle"></i> Meu Perfil</h4>
                </div>
                <div class="profile-body">
                    <div class="profile-item">
                        <div class="profile-label">Nome</div>
                        <div class="profile-data">Teste</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Email</div>
                        <div class="profile-data">teste@example.com</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Celular</div>
                        <div class="profile-data">(9) 98919-2662</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Endereço</div>
                        <div class="profile-data">Endereço</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Endereço Comercial</div>
                        <div class="profile-data">Endereço</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Telefone Comercial</div>
                        <div class="profile-data">(19) 98919-2662</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Data de Nascimento</div>
                        <div class="profile-data">01/01/1990</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">CPF</div>
                        <div class="profile-data">123.456.789-00</div>
                    </div>
                    <div class="profile-item">
                        <div class="profile-label">Senha</div>
                        <div class="profile-data">********</div>
                    </div>
                </div>
                <div class="profile-footer">
                    <a class="btn profile-edit-btn" href="#">Editar Informações</a>
                    <a class="btn profile-password-btn" href="#">Alterar Senha</a>
                </div>
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