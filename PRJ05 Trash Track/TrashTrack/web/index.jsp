<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TrashTrack</title>

  <!-- Link do CSS Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style-index.css">
  <link rel="stylesheet" href="css/style-sobre-informativa.css">
</head>

<body>
    <!-- NAV BAR -->
    <nav class="navbar navbar-expand-lg navbar-light py-3" style="margin-left: 12rem; margin-right: 12rem;">
      <div class="container-fluid">
          <a class="navbar-brand" href="index.jsp">
              <img src="img/Logo.png" alt="TrashTrack Logo" width="160" height="45" class="d-inline-block">
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                  </li>
              </ul>
              <div class="d-flex align-items-center gap-3">
                  <ul class="navbar-nav mb-2 mb-lg-0">
                      <li class="nav-item" id="notificacoes">
                          <img src="img/Sino.png" alt="Notification logo" width="20" height="20" class="logo" onclick="abrirNotificacao()">
                            <!-- Dropdown Notificação -->
                            <div class="notificacao-pop-up-dropdown" id="notificacao-pop-up-dropdown">
  
                              <div class="notificacao-pop-up-dropdown-header">
                                <h5>Notificações</h5>
                                <img src="img/x.png" alt="Botao Fechar" width="20" height="20" id="botaoNotificacao" onclick="fecharNotificacao()">
                              </div>
  
                              <ul class="notificacao-pop-up-dropdown-list" id="listaNotificacoes"></ul>
  
                            </div>
                      </li>
                      <li class="nav-item" id="cadastroLogin">
                          <a class="nav-link" aria-current="page" href="cadastro.jsp">Cadastro</a>
                      </li>
                      <li class="nav-item" id="login">
                          <a href="login.jsp"> <button class="btn btn-outline-success" type="submit">Entrar</button> </a>
                      </li>
                      <li class="nav-item" id="usuarioLogado">
                          <a class="nav-link active" aria-current="page" href="mapa.jsp"><p id="usuarioLogadoTexto"></p></a>
                      </li>
                  </ul>
              </div>
          </div>
      </div>
  </nav>

    <!--Linha 1-->
    <!--Linha 1 -Titulo-->
    <div class="default-size"> <!--Div Geral-->
            <div class="row align-items-center my-5 justify-content-center">
                <div class="Titulo col-md-6 text-left">
                    <h2>Faça a</br> diferença:</br> Recicle!</h2>
                    <p>Faça parte desse projeto!</p>
                    <!--Botão - Insira seu email-->
                    <div class="row align-items-center my-5">
                        <div class="col-md-6"> 
                            <form class="form-inline" action="${cp}/login.jsp">
                                <span style="font-size: 15px;">Email</span>
                                <input type="hidden" name="acao" value="paginaLogin">
                                <div class="input-group" style="display: flex; align-items: center"> 
                                    <input type="email" name="email" class="form-control" placeholder="Insira seu Email..." style="height: 38px; border-radius: 0.25rem"/>
                                    <div class="input-group-append">
                                        <button type="submit" class="btn btn-outline-success" style="height: 38px; border-radius: 0.25rem">
                                            Login
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            <!--Imagem Linha 1-->
                <div class="col-md-6 text-end">
                    <img style="max-height: 370px;" src="img/imgPgnInfo.png" alt="imagemresponsiva" class="img-fluid">
                </div>
            </div>

            <!--LINHA 2-->
            <!--Imagem Linha 2-->
            <div class="row align-items-center my-5 justify-content-center">
                <div class="col-md-3 text-left">
                  <a href="sobre.jsp"> <img style="width: 250px ;" src="img/NossaHistoria.png" alt="imagemresponsiva" class="img-fluid"> </a>
                </div>
            <!--Linha 2 - Sobre o Projeto-->
                <div class="Titulo col-md-6 text-right">
                    <h2><scan style="font-weight: bolder; font-size: 40px;">Sobre o Projeto</scan></h2>
                    <p>Um projeto de aplicativo de reciclagem pode ser uma excelente ferramenta para incentivar práticas sustentáveis e facilitar o processo de descarte correto de resíduos. O conceito central é criar uma plataforma intuitiva e acessível, onde os usuários possam aprender sobre reciclagem, identificar materiais recicláveis, localizar pontos de coleta e até mesmo rastrear seu impacto ambiental.</p>
                </div>
            </div>

            <!--LINHA 3-->
            <!--Imagem Esquerda Linha 3-->
                <div class="row align-items-center d-flex justify-content-center my-5">
                    <div class="col-md-6 text-center">
                        <a href="informativa.jsp"> <img style="width: 350px ;" src="img/ApendaComoReciclar.png" alt="imagemresponsiva" class="img-fluid"> </a>
                    </div>
            <!--Imagem Direita Linha 3-->
                    <div class="Titulo col-md-6 text-center">
                        <a id="redirecionarMapaLogin" href="login.jsp"> <img style="width: 350px ;" src="img/MapaComPontosDeColeta.png" alt="imagemresponsiva" class="img-fluid"> </a>
                    </div>
                </div>

            <!--Linha 4 - FAQ-->
            <div class="FAQ">
                <h2>FAQ</h2>
                <h3>Perguntas Frequentes</h3>
                <p>Bem-vindo à nossa seção de Perguntas Frequentes! Aqui, você encontrará respostas para as dúvidas mais comuns sobre nossos serviços. Se você não encontrar o que procura ou precisar de mais informações, sinta-se à vontade para entrar em contato conosco diretamente. Estamos aqui para ajudar!</p>
            </div>

            <!--Linha 5 - Pergutas FAQ-->
            <div class="accordion" id="accordionExample">
                <!--Pergunta 1-->
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Como fazemos para realizar o Cadastro de um novo ponto de coleta?
                    </button>
                  </h2>
                  <div id="collapseOne" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                        Selecionando a aba de "Criar Pontos de Coleta" você pode criar um novo ponto de coleta! Lá você deve informar o tipo de lixo cadastrado e pronto! Seu lixo estará disponivel para qualquer coletor!
                    </div>
                  </div>
                </div>

                <!--Pergunta 2-->
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                      Como fazemos para retirar editar ponto de coleta?
                    </button>
                  </h2>
                  <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                      Na aba de "Seleção de Pontos" você pode conferir os Pontos de Coleta cadastrados por todos os usuário. Nesta mesma aba, em sua parte inferior você encontra os pontos cadastrados por você!</br>
                      Clicando nele irá aparecer a opção de edição! Basta selecionar essa opção e realizar as mudanças necessárias!
                    </div>
                  </div>
                </div>

                <!--Pergunta 3-->
                <div class="accordion-item">
                  <h2 class="accordion-header">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Como Funciona o Ranking?
                    </button>
                  </h2>
                  <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                    <div class="accordion-body">
                      <scan style="font-weight: bolder;">No caso de Usuário:</scan> Quanto mais pontos de coletas cadastrados, mais pontos o usuário recebe! (Lembrando que para seu ponto de coleta receber sua designda pontuação, ele deve ser um ponto verdadeiro e validado.)</br>
                      <scan style="font-weight: bolder;">No caso de Coletor:</scan> Quanto mais pontos de coletas acumulados, mais pontos o catador recebe! (Lembrando que para coleta receber sua designda pontuação posição ele deve ser uma coleta verdadeira e validada.)
                    </div>
                  </div>
                </div>

                <!--Pergunta 4-->
                <div class="accordion-item">
                    <h2 class="accordion-header">
                      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Como fazer para recuperar a senha?
                      </button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" data-bs-parent="#accordionExample">
                      <div class="accordion-body">
                        <scan style="font-weight: bolder;">Caso você não se lembre de sua senha, não se preocupe!</scan>Contamos com um sistema de recuperação de senha!</br>
                        Na página de login, abaixo do campo para inserir a senha, você encontrará a frase "Esqueci minha senha". Ao clicar nela, você será direcionado para outra página na qual deve informar o e-mail cadastrado.</br>
                        Em seguida, acesse o e-mail informado, onde você encontrará uma mensagem que enviamos com um link. Este link o levará a outra página onde você poderá alterar sua senha. Pronto! Sua senha foi modificada. (Lembre-se de utilizar uma senha segura e diferente da anterior.)</br>
                    </div>
                  </div>
              </div> </br></br>
              <div class="duvidas">
                <button type="button" class="btn btn-primary btn-salvar" data-bs-toggle="modal" data-bs-target="#exampleModal">Enviar Dúvida</button>
              </div>
              
      </div>
    </div>

    <!-- Modal Enviar Duvidas -->

    <div class="d-flex justify-content-center align-items-center" style="height: 100%;">

      </div>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
  
                  <!-- header modal -->
                  <div class="modal-header">
                      <h1 class="modal-title fs-5" id="exampleModalLabel">Enviar Duvida</h1>
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
  
                  <!-- corpo modal -->
                  <div class="modal-body">
                        
                          <!-- forms -->
                      <form action="">
  
                          <!-- Email -->
                          <div class="">
  
                              <label for="email" class="form-label" >Email</label>
                              <input type="email" id="email" class="form-control shadow-sm">
  
                          </div>
  
                          <!-- Dúvida -->
                          <div >
  
                              <label for="password" class="form-label">Dúvida</label>
                              <input type="text" id="duvida" placeholder="Informe sua Dúvida" class="form-control shadow-sm">
                              
  
                          </div>
  
                      </form>
 
                      <!-- footer modal-->
                      <div class="modal-footer">
                          <button type="button" class="btn btn-primary btn-salvar-modal">Enviar</button>
                      </div>
                  </div>
              </div>
          </div>
      </div>


    <!-- Footer -->
    <footer class="fixed-bottom" style="position: relative; background-color: #3ACC97; height: 5rem;"></footer>
    
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Script do JavaScript do Bootstrap (opcional, mas recomendado) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <script src="js/script-notificacao.js"></script>
    
    <script src="js/script-redirecionamento.js"></script>
    
</body>
</html>
