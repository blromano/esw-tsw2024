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

    <!-- DIV GERAL -->
    <div class="default-size" > <!-- Colocar a mesma margem que vai ter no header -->
        
        <!-- LINHA 1 - Título -->
        <div class="row align-items-center my-5" >

            <div class="col-md-12 text-center align-items-center justify-content-center">
                <h2 class="h2-informativa">Como Reciclar?!</h2>
            </div>

        </div>

        <!-- LINHA 2 - Info -->
        <div class="row align-items-center my-5">

            <div class="col-md-6 ">
                <h3 class="h3-informativa">O que é reciclagem?</h3>
                
                <p class="p-informativa">Reciclagem é o processo em que há a transformação do resíduo sólido que não seria aproveitado, com mudanças em seus estados físico,
                     físico-químico ou biológico, de modo a atribuir características ao resíduo para que ocorra produção de novos materiais.
                </p>

                <h3 class="h3-informativa">Como fazer?</h3>
                
                <p class="p-informativa">A forma mais simples de fazer a reciclagem de lixo doméstico consiste em separar seus resíduos em duas categorias:
                     recicláveis e não recicláveis. Para isto, basta depositar os lixos em duas sacolas diferentes. É uma ótima ideia que não requer muito esforço.
                </p>
            </div>

            <div class="col-md-6 text-center">
                <img class="img-fluid" style="max-height: 400px;" src="img/informativa-1.png" alt="">
            </div>

        </div>

        <!-- LINHA 3 - Info -->        
        <div class="row align-items-center my-5">

            <div class="col-md-6 text-left">
                <img class="img-fluid" style="max-height: 400px;" src="img/informativa-2.png" alt="">
            </div>

            <div class="col-md-6 text-right">
                <h3 class="h3-informativa">O Lixo Reciclável</h3>
                
                <p class="p-informativa">O lixo reciclável engloba papéis (papelão, jornal, etc.), plásticos, 
                    metais e vidros. Cartelas de comprimidos e bandejas de isopor também devem ser descartadas com o lixo seco, 
                    pois podem se transformar em matéria-prima para blocos da construção civil.
                </p>

                <p class="p-informativa"><span style="font-weight: bold;">É importante lembrar que as embalagens plásticas devem ser deixadas secas, as caixas de papelão dobradas</span> 
                    (para economizar espaço) e os vidros embalados em jornal ou papelão, pois caso estejam quebrados não machucarem quem os manusear. 
                    Os papéis podem ser dobrados, porém, não devem estar amassados.
                </p>
            
            </div>

        </div>

        <!-- LINHA 4 - Info -->        
        <div class="align-items-center my-5">
            <h2 class="h2-informativa">Mas e o Lixo<br /> Orgânico?</h2>

            <p class="p-informativa">O lixo úmido ou lixo orgânico, é composto de materiais orgânicos (cascas de frutas e legumes, folhas e restos de comida) e não recicláveis 
                (papel higiênico utilizado, materiais de higiene pessoal, plásticos e papéis engordurados, bitucas de cigarro, chiclete, etc.). 
                Ele representa aproximadamente 50% de todo o lixo produzido diariamente por cada brasileiro.
            </p>
        </div>

        <!-- LINHA 5 - Info -->   
        <div class="row my-5">

            <div class="col-md-7">
                <h3 class="h3-informativa">O Lixo Reciclável</h3>

                    <p class="p-informativa" style="font-weight: 600;">Você sabia que pode contribuir ainda mais com o meio ambiente ao reciclar seu lixo orgânico?</p>

                    <p class="p-informativa">Sim, os materiais orgânicos que você joga fora em casa (cascas de frutas e de ovos, iogurte e sementes, por exemplo), 
                        podem ser utilizados na criação de adubo natural para suas plantas.
                    </p>

                    <p class="p-informativa">Este processo é chamado de compostagem, e pode ser definido como a reciclagem de matéria orgânica. 
                        Seu objetivo é diminuir o impacto nos aterros sanitários, onde toda a matéria vira gás metano, 
                        prejudicial quando depositado no solo ou liberado na atmosfera
                    </p>

                    <p class="p-informativa">Para mais informações sobre como produzir sua composteira,
                         <a class="a-informativa" href="https://capital.sp.gov.br/web/meio_ambiente/w/umapaz/formacao_em_educacao_ambiental/conteudo/350267">Clique Aqui!</a>
                    </p>
            
            </div>

            <div class="col-md-4 d-flex align-items-center justify-content-center">
                <img class="img-fluid" style="max-height: 400px;" src="img/informativa-3.png" alt="">
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

</body>
</html>