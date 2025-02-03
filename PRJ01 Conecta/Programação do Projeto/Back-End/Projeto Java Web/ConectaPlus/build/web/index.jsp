<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conecta+ | Pagina Inicial</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <link rel="icon" href="${cp}/img/icon-conecta.svg" type="favicon">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/0b8ee931c5.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${cp}/css/pagina-inicial/pag-inicial.css">
    <script src="${cp}/js/pagina-inicial/paginainicial.js" defer></script>
</head>
<body>
    
    <header>
        <div class="interface">
            <div class="logo">
                <a href="#">
                    <img src="${cp}/img/images/favicon.svg" alt="Logo Conecta">
                </a>
            </div><!--logo-->

            <nav class="menu-desktop">
                <ul>
                    <li><a href="#">Início</a></li>
                    <li><a href="#section1">Como funciona</a></li>
                    <li><a href="#section2">Nossa Empresa</a></li>
                    <li><a href="#section3">Fale Conosco</a></li>
                </ul>
            </nav>

            <div class="btn-contato">
                <a href="${cp}/formularios/usuario/login.jsp">
                    <button>Login</button>
                </a>
            </div>

            <div class="btn-abrir-menu" id="btn-menu">
                <i class="bi bi-list"></i>
            </div>

            <div class="menu-mobile" id="menu-mobile">
                <div class="btn-fechar">
                    <i class="bi bi-x-lg"></i>
                </div>

            <nav>
                <ul>
                    <li><a href="#">Início</a></li>
                    <li><a href="#section1">Como funciona</a></li>
                    <li><a href="#section2">Nossa Empresa</a></li>
                    <li><a href="#section3">Fale Conosco</a></li>
                </ul>
            </nav>

            </div>
            <div class="overlay-menu" id="overlay-menu"></div>
        </div>
    </header>

    <main>
        <section class="topo-do-site">
            <div class="interface">
                <div class="flex">
                    <div class="txt-topo-site">
                        <h1>Encontre o profissional ideal para resolver seu problema com serviços de qualidade!<span>.</span></h1>
                        <p>Na Conecta+, conectamos você a profissionais autônomos qualificados, prontos para atender às suas necessidades com excelência. Busque, escolha e agende de forma rápida e fácil. O serviço certo está a apenas um clique de distância!"</p>

                        <div class="btn-contato">
                            <a href="${cp}/formularios/profissional/cad-Profissional.jsp">
                                <button>Trabalhe Conosco</button>
                            </a>
                        </div>
                    </div><!--txt-topo-site-->

                    <div class="img-topo-site">
                        <img src="${cp}/img/images/imagem-homepage.png" alt="Foto 1">
                    </div><!--img-topo-site-->
                </div><!--flex-->
            </div><!--interface-->
        </section><!--topo-do-site-->

        <section class="especiliadades" id="section1">
            <div class="interface">
                <h2 class="titulo">COMO <span>FUNCIONA.</span></h2>
                <div class="flex">
                    <div class="especialidades-box">
                        <i class="fas fa-search"></i>
                        <h3>Encontre Profissionais</h3>
                        <p>Utilize nossos filtros para localizar o profissional ideal para o serviço que você precisa.</p>
                    </div><!--especialidades-box-->

                    <div class="especialidades-box">
                        <i class="fas fa-calendar-check"></i>
                        <h3>Agende o Serviço</h3>
                        <p>Entre em contato com o profissional, verifique a disponibilidade e agende o serviço diretamente pela plataforma.</p>
                    </div><!--especialidades-box-->

                    <div class="especialidades-box">
                        <i class="fas fa-star"></i>
                        <h3>Avalie o Serviço</h3>
                        <p>Após a conclusão do serviço, avalie a qualidade e deixe seu feedback para futuros clientes.</p>
                    </div><!--especialidades-box-->
                </div><!--flex-->
            </div><!--interface-->
        </section><!--especiliadades-->

        <section class="sobre" id="section2">
            <div class="interface">
                <div class="flex">
                    <div class="img-sobre">
                        <img src="${cp}/img/images/empresa.png" alt="">
                    </div><!--img-sobre-->

                    <div class="txt-sobre">
                        <h2>MUITO PRAZER, <span>SOMOS A CONECTA+.</span></h2>
                        <p>Bem-vindo à Conecta Ltda! Somos uma empresa especializada em elevar a presença online de profissionais autonomos, com a missão de levar mão de obra qualificada para você cliente, sem sair de casa. Fundada em 2024, nossa equipe foi formada por 5 alunos do Instituto Federal de Ciência e Tecnologia de São Paulo, campus São João da Boa Vista.</p>
                        <p>Na Conecta Ltda, nossa missão é criar um ambiente de simples e fácil acesso para autônomos ofertarem seus serviços e serem avaliados por clientes.</p>
                        <div class="btn-social">
                            <a href="#"><button><i class="bi bi-instagram"></i></button></a>
                            <a href="#"><button><i class="bi bi-youtube"></i></button></a>
                            <a href="#"><button><i class="bi bi-linkedin"></i></button></a>
                        </div><!--btn-social-->
                    </div><!--txt-sobre-->
                </div><!--flex-->
            </div><!--interface-->
        </section><!--sobre-->


        <section class="formulario" id="section3">
            <div class="interface">
                <h2 class="titulo">FALE <span>CONOSCO.</span></h2>

                <form action="">
                    <input type="text" name="" id="" placeholder="Seu nome completo:" required>
                    <input type="text" name="" id="" placeholder="Seu e-mail:" required>
                    <input type="text" name="" id="" placeholder="Seu celular:">
                    <textarea name="" id="" placeholder="Sua mensagem" required></textarea>
                    <div class="btn-enviar"><input type="submit" value="ENVIAR"></div>
                </form>
            </div><!--interface-->
        </section><!--formulario-->

    </main>

    <footer>
        <div class="interface">
            <div class="line-footer">
                <div class="flex">
                    <div class="logo-footer">
                        <img src="${cp}/img/images/favicon.svg" alt="Logotipo Agência BRN">
                    </div><!--logo-footer-->
                    <div class="btn-social">
                        <a href="#"><button><i class="bi bi-instagram"></i></button></a>
                        <a href="#"><button><i class="bi bi-youtube"></i></button></a>
                        <a href="#"><button><i class="bi bi-linkedin"></i></button></a>
                    </div><!--btn-social-->
                </div>
            </div><!--line-footer-->

            <div class="line-footer borda">
                <p><i class="bi bi-envelope-fill"></i> <a href="mailto:rhconecta@gmail.com">rhconecta@gmail.com</a></p>
            </div><!--line-footer-->
        </div><!--interface-->
    </footer>

</body>
</html>