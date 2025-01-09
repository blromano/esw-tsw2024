<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Conecta+ | Pagina Inicial</title>
  <link rel="stylesheet" href="${cp}/css/pagina-inicial/style-paginaInicial.css">
  <script defer src="${cp}/js/pagina-inicial/pagina-inicial.js"></script>
  <link rel="icon" href="${cp}/img/icon-conecta.svg" type="favicon">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
  <script src="https://kit.fontawesome.com/0b8ee931c5.js" crossorigin="anonymous"></script>
  
</head>
<body>
  <!-- Navbar -->
  <header id="navbar">
    <div class="navbar-container">
      <div class="logo">
        <img src="${cp}/img/favicon_preta.svg" alt="Logo">
      </div>
      <nav class="menu">
        <ul>
          <li><a href="#como-funciona">Como funciona</a></li>
          <li><a href="#sobre">Sobre nós</a></li>
          <li><a href="#avaliacoes"> Avaliações</a></li>
          </a>
        </ul>
      </nav>
      <div class="login">
          <!-- Modificar quando a página de login estiver pronta -->
        <a href="${cp}/formularios/usuario/login.jsp"><i class="fa-solid fa-user" style="margin-right: 8px;"></i>Login</a>
      </div>
    </div>
  </header>

  <!-- Sessão 1  -->
  <section id="Apresentação" class="slide-imagens">
    <div class="carrosel-imagens">
      <img src="https://via.placeholder.com/800x400/ff7f7f/333333?text=Imagem+1" alt="Imagem 1" class="imagens">
      <img src="https://via.placeholder.com/800x400/7fbfff/333333?text=Imagem+2" alt="Imagem 2" class="imagens">
      <img src="https://via.placeholder.com/800x400/7fff7f/333333?text=Imagem+3" alt="Imagem 3" class="imagens">
    </div>
    <button class="button prev" onclick="moveSlide(-1)">&#10094;</button>
    <button class="button next" onclick="moveSlide(1)">&#10095;</button>
  </section>

  <!-- Sessão 2 -->
  <section id="avaliacoes">
    <h2>Avaliações dos Clientes</h2>
  <div class="reviews-container">
    <div class="review-card">
      <p><strong>Cliente 1</strong></p>
      <p>Profissional: <strong>João Silva</strong></p>
      <p>Ótimo serviço!</p>
      <div class="stars">
        ★★★★☆
      </div>
    </div>
    <div class="review-card">
      <p><strong>Cliente 2</strong></p>
      <p>Profissional: <strong>Maria Santos</strong></p>
      <p>Muito profissional.</p>
      <div class="stars">
        ★★★★☆
      </div>
    </div>
    <div class="review-card">
      <p><strong>Cliente 3</strong></p>
      <p>Profissional: <strong>Carlos Oliveira</strong></p>
      <p>Atendimento excelente.</p>
      <div class="stars">
        ★★★★★
      </div>
    </div>
  </div>
  </section>

  <!-- Sessão 3 -->
  <section id="sobre">
      <div class="cabecalho">
          <h1>Conecta LTDA</h1>
          <p>Conheça a nossa empresa e nosso propósito</p>
      </div>
      <div class="texto-apresentacao">
        <div class="sobre-nos">
          <h4>Sobre Nós</h4>
          <p>Bem-vindo à Conecta Ltda! Somos uma empresa especializada em elevar a presença online de profissionais autonomos, com a missão de levar mão de obra qualificada para você cliente, sem sair de casa. Fundada em 2024, nossa equipe foi formada por 5 alunos do Instituto Federal de Ciência e Tecnologia de São Paulo, campus São João da Boa Vista.</p>
          </br>
        </div>
      <div class="nossa-missao">
          <h4>Nossa Missão</h4>
          <p>Na Conecta Ltda, nossa missão é criar um ambiente de simples e fácil acesso para autônomos ofertarem seus serviços e serem avaliados por clientes.</p>
          </br>
      </div> 
      <div class="nossa-equipe">
          <h4>Nossa equipe</h4>
          <p>Nossa equipe é composta por 5 profissionais apaixonados, dedicados e com um espírito colaborativo e inovador para tornar simples e eficaz ofertar serviços online, gerando um aumento de renda e garantindo sempre a satisfação de nossos clientes.</p>
            <div class="fotos-equipe">
                <div class="circulo"></div>
                <div class="circulo"></div>
                <div class="circulo"></div>
                <div class="circulo"></div>
                <div class="circulo"></div>
            </div>
        </div>
    </div>
  </section>

   <!-- Seção Como Funciona -->
   <section id="como-funciona" class="funcionamento">
    <div class="container">
        <h1>Como Funciona?</h1>
        <p>Nosso processo é simples e eficiente. Veja como você pode contratar ou oferecer serviços na nossa plataforma.</p>
      <div class="steps">
        <div class="step"><i class="fas fa-search"></i>
          <h3>Encontre Profissionais</h3>
          <p>Utilize nossos filtros para localizar o profissional ideal para o serviço que você precisa.</p>
        </div>
        <div class="step">
          <i class="fas fa-calendar-check"></i>
          <h3>Agende o Serviço</h3>
          <p>Entre em contato com o profissional, verifique a disponibilidade e agende o serviço diretamente pela plataforma.</p>
        </div>
        <div class="step">
          <i class="fas fa-star"></i>
          <h3>Avalie o Serviço</h3>
          <p>Após a conclusão do serviço, avalie a qualidade e deixe seu feedback para futuros clientes.</p>
        </div>
      </div>
    </div>
  </section>

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
</body>
</html>

