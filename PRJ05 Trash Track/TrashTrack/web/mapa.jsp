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
    <button type="button" class="btn-select-lista" id="btn-lista">Seleção de pontos</button>
    <button class="perfil "><img src="img/perfil.svg" alt="perfil"></button>
  </nav>

  <!--ModalPerfil-->

  <div id="modalPerfil">
      <div id="modalHeaderPerfil">
      <p id="modalPerfilEmail">email@gmail.com</p>
      <button class="btn-close-perfil"><img src="img/x.png" alt="X"></button>
    </div>

    <div id="modalBodyPerfil">
      <img  class="foto" src="img/perfil.svg" alt="perfil">
      <h4 class="nome" id="modalPerfilNome">Olá, Nome</h4>

      <div class="Ranking">
        <img class="trofeu" src="img/trofeu.png" alt="trofeu">
        <p>Ranking #005</p> 
      </div>

      <div id="cont">
        <p id="cont-lixos">Lixos Coletados</p>
        <h2 id="modalPerfilLixosColetados">120</h2>
      </div>

      <button class="btn-info">Editar Informações</button>
      <br>
      <h2 id="tipo-usu">Sou Coletor</h2>
      <label class="switch" id="alterarUsuarios" >
        <input type="checkbox" id="toggle">
        <span class="slider"></span>
    </label>
    </div>
  </div>
  
  <!-- Modal editar Informações do Usuario -->

  <div id="fade"></div>
  <div id="ModalInfo">
  
    <div>
      <h3 class="title">Editar Informações</h3>
      <button class="btn-close-info"><img src="img/x.png" alt="X"></button>
    </div>

    <div class="modalBodyInfo">

      <form id="formularioEditarInformacoes">

        <label for="nome_completo"> Nome Completo</label>
        <br>
        <input type="text" id="nomeEditarInformacoes" name="nomeEditarInformacoes" >

        <br>

        <label for="email" class="form-label" > Email</label>
        <br>
        <input type="email" id="emailEditarInformacoes" name="emailEditarInformacoes" >


        <div class="form-group">

          <label for="password">Senha Antiga</label>
          <input type="password" id="password" placeholder="" class="senha" name="senhaAntigaEditarInformacoes">
          <img src="img/eye-close.png" alt="" id="eyeicon" class="botao-senha" onclick="mostrarsenha()">

        </div>
            
        <div class="form-group">

          <label for="password2" class="cinza">Nova Senha</label>
          <input type="password" id="password2" placeholder="" class="senha" name="senhaNovaEditarInformacoes">
          <img src="img/eye-close.png" alt="" class="botao-senha" id="eyeicon2" onclick="confirmarsenha()">

        </div>

        <div class="container-footer">
            <button class="container-button" id="editar" type="submit">Salvar</button>
        </div>

      </form>

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
        <!-- PELO AMOR DE DEUS SAMUEL EH AQ Q EH PRA VC FAZER AS COISA  -->
      <div id="lista">
          <div class="ponto">
          <img  src="img/pontoOrganico.png" alt="ponto">
          <div class="ende">R. David de Carvalho, 1055 - Vila Valentin</div>
          <button class="btn-coleta"><img id="coleta" src="img/coletar.png" alt="coleta"></button>
          <button class="btn-denuncia"><img id="denuncia" src="img/denuncia.png" alt="denuncia"></button>
        </div>
      </div>

      <div id="lista-meus" >
        <h4 class="title">Meus Pontos</h4>
        
      </div>
    </div>
  </div>
    
   <!-- Modal filtro da lista de ponto -->

  <div id="modalFiltro" >
  
    <div id="modalHeaderFiltro">
      <h4 class="title">Filtros</h4>      
    </div>
    
    <div id="modalBodyFiltro" >
      
      <ul class="filtros">
        <li><label><input type="checkbox"> Organico</label></li>
        <li><label><input type="checkbox">Eletrônico </label></li>
        <li><label><input type="checkbox"> Reciclável</label></li>
        <li><label><input type="checkbox"> Óleo</label></li>  
      </ul> 
    </div>

    <div class="container-footer" >
      <button class="container-button" id="filtrar">Filtrar</button>
    </div>

  </div>

  <!-- Modal Coleta de Ponto (Ativado pelo Botão de Coletar da Lista) -->
  
  <!-- Nunca aparece nao sei pq  -->
  <div id="fadeColeta"></div>
    <div id="modalColeta">
        <div>
          <h4 class="title">Marcar como Coletado?</h4>
          <button class="btn-close-coleta"><img src="img/x.png" alt="X"></button>
        </div>

        <div class="container-footer">
          <button type="button" class="container-button" id="btnColetado">Sim</button>  <!-- Ponto foi coletado -->
          <button type="button" class="container-button" id="btnNaoColetado">Não</button> <!-- Ponto não foi coletado -->
        </div>
            
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
            <input type="submit" class="container-button" value="Criar Ponto de Coleta">
          </div>

        </div>

      </form>
    </div>
  </div>
  
  <!--Modal Editar Ponto de Coleta-->

  <div id="modalEditar">
    <div id="modalHeaderCriar">
      <h4 class="title">Editar ponto de Coleta</h4>
      <button class="btn-close-editar"><img src="img/x.png" alt="X"></button>
    </div>

    <div id="modalBodyCriar">

      <form id="formularioEditarPonto" action="">

        <input type="hidden" name="idMoradorColetor" value=""> <!-- COLOCAR VARIAVEL DE ID DO MORADOR DENTRO DO PARAMETRO 'value' -->

        <div class="checkbox-container">

          <div>
              <input type="radio" id="organicoEditar" value="OR" name="tipoLixo" class="checkers">
              <label for="organico">Organico</label>
          </div>
          <div>
              <input type="radio" id="eletronicoEditar" value="EL" name="tipoLixo" class="checkers">
              <label for="eletronico">Eletrônico</label>
          </div>
          <div>
              <input type="radio" id="reciclavelEditar" value="RE" name="tipoLixo" class="checkers">
              <label for="reciclavel">Reciclável</label>
          </div>
          <div>
              <input type="radio" id="oleoEditar" value="OL" name="tipoLixo" class="checkers">
              <label for="oleo">Óleo</label>
          </div>

          <h4 class="title">Endereço</h4>
          <br>

          <div>
            <label for="rua">Rua</label>
            <input id="ruaEditar" name="ruaEditar" type="text">
          </div>

          <div>
            <label for="numero">Número</label>
            <input id="numeroEditar" name="numeroEditar" type="text">
          </div>

          <div>
            <label for="bairroEditar">Bairro</label>
            <input id="bairroEditar" name="bairroEditar" type="text">
          </div>

          <div>
            <label for="cidade">Cidade</label>
            <input id="cidadeEditar" name="cidadeEditar" type="text">
          </div>

          <div>
            <label for="complemento">Complemento</label>
            <input id="complementoEditar" name="complementoEditar" type="text">
          </div>

          <div class="container-footer">
            <input type="submit" class="container-button" value="Salvar Edicao">
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