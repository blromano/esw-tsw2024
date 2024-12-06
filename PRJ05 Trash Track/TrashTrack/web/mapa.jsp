<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TrashTrack</title>
    <link rel="stylesheet" href="css/style-mapa.css">
    <link rel="stylesheet" href="js/script-mapa.js">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    
</head>
<body>

 <div id="interface">
    <div id="menu">
  <!--NavBar-->

  <nav class="container-fluid">
    <a href="index.jsp"><img src="img/seta.svg" alt="seta" id="seta"></a>
    <button type="button" class="btn-select-criar" id="btn-lista">Seleção de pontos</button>
    <button class="perfil "><img src="img/perfil.svg" alt="perfil"></button>
  </nav>

  <!--ModalPerfil-->

  <div id="modalPerfil">
    <div id="modalHeaderPerfil">
      <p>email@gmail.com</p>
      <button class="btn-close-perfil"><img src="img/x.png" alt="X"></button>
    </div>

    <div id="modalBodyPerfil">
      <img  class="foto" src="img/perfil.svg" alt="perfil">
      <h4 class="nome">Olá, Nome</h4>

      <div class="Ranking">
        <img class="trofeu" src="img/trofeu.png" alt="trofeu">
        <p>Ranking #005</p> 
      </div>

      <div id="cont">
        <p id="cont-lixos">Lixos Coletados</p>
        <h2>120</h2>
      </div>

      <a href="modal_editar_info.html" target="self">Editar Informações</a>
      <br>
      <h2 id="tipo-usu">Sou Coletor</h2>
      <label class="switch" id="alterarUsuarios" >
        <input type="checkbox" id="toggle">
        <span class="slider"></span>
    </label>
    </div>
  </div>

    <!--Modal Lista de pontos-->

  <div id="modalLista">
    <div id="modalHeaderLista">
      <h4 class="title">Pontos de Coleta</h4>
      <button class="btn-close-lista"><img src="img/x.png" alt="X"></button>
      <button class="btn-filtro"><img src="img/filtro.png" alt="filtro"></button>
    </div>
    <div id="modalBodyLista">

      <div id="lista">
        
      </div>

      <h4 class="title">Meus Pontos</h4>
      
      <div id="lista-meus" >
        
      </div>
    </div>
  </div>

  <!--ModalRanking-->

  <div id="modalRanking">
    <div id="modalHeaderRanking">
      <img class="icon" src="img/trofeu.png" alt="ranking">
      <h4 class="title">Ranking</h4>
      <button class="btn-close-ranking"><img src="img/x.png" alt="X"></button>
    </div>
    <div id="modalBodyRanking">
      <div id="Ranking">
        <div class="rank">
          <img src="img/medalha1.png" alt="ponto">
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
            <img src="img/medalha2.png" alt="ponto">    
            <p>Nome</p>
            <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <img  src="img/medalha3.png" alt="ponto">
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>4</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>5</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>6</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>7</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>  
        <div class="rank">
          <h4>8</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>9</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div>
        <div class="rank">
          <h4>10</h4>
          <p>Nome</p>
          <b class="pont">120pt</b>
        </div> 
      </div>   
    </div>
  </div>

  <!--Modal Criar Ponto de Coleta-->

  <div id="modalCriar">
    <div id="modalHeaderCriar">
      <h4 class="title">Criar ponto de Coleta</h4>
      <button class="btn-close-criar"><img src="img/x.png" alt="X"></button>
    </div>

    <div id="modalBodyCriar">

      <form id="formularioCriarPonto" action="">

        <input type="hidden" name="idMoradorColetor" value=""> <!-- COLOCAR VARIAVEL DE ID DO MORADOR DENTRO DO PARAMETRO 'value' -->

        <div class="checkbox-container">

          <div>
              <input type="radio" id="organico" value="OR" name="tipoLixo" class="checkers">
              <label for="organico">Organico</label>
          </div>
          <div>
              <input type="radio" id="eletronico" value="EL" name="tipoLixo" class="checkers">
              <label for="eletronico">Eletrônico</label>
          </div>
          <div>
              <input type="radio" id="reciclavel" value="RE" name="tipoLixo" class="checkers">
              <label for="reciclavel">Reciclável</label>
          </div>
          <div>
              <input type="radio" id="oleo" value="OL" name="tipoLixo" class="checkers">
              <label for="oleo">Óleo</label>
          </div>

          <h4 class="title">Endereço</h4>
          <br>

          <div>
            <label for="rua">Rua</label>
            <input id="rua" name="rua" type="text">
          </div>

          <div>
            <label for="numero">Número</label>
            <input id="numero" name="numero" type="text">
          </div>

          <div>
            <label for="bairro">Bairro</label>
            <input id="bairro" name="bairro" type="text">
          </div>

          <div>
            <label for="cidade">Cidade</label>
            <input id="cidade" name="cidade" type="text">
          </div>

          <div>
            <label for="complemento">Complemento</label>
            <input id="complemento" name="complemento" type="text">
          </div>

          <div class="container-footer">
            <input type="submit" class="container-button" value="Criar Ponto de Coleta"></button>
          </div>

        </div>

      </form>
    </div>
  </div>
 
  
  <!--Footer-->

  <nav class="footer" >
    <button type="button" class="btn-select-criar" id="btn-criar">Criar Ponto de Coleta</button>
    <button class="btn-ranking "><img src="img/ranking.png" alt="perfil"></button>

  </nav>

  </div>
  </div>
    
    <!-- Mapa da API --> 
  <div id="map"></div>

  <!-- JQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  
  <script src="js/script-mapa.js"></script>
  
  <!<!-- Import do mapa -- nele tem a API e os IDS do mapa -->
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCgZY0C6jCU1K1vRyv4MkZunP83_q3claI&map_ids=1c9b70d1e5ae023b&callback=initMap" async defer></script>
  
  
</body>

</html>