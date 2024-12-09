/* 
const dadosMoradorColetor = JSON.parse(sessionStorage.getItem("dadosMoradorColetor"));
const idMoradorColetor = dadosMoradorColetor.id;

//Funcao de iniciar o mapa - FAVOR NAO MEXER QUE EH ELA QUE INICIA O MAPA
async function initMap() {
  console.log(dadosMoradorColetor);
  const { Map } = await google.maps.importLibrary("maps");
  const { AdvancedMarkerElement, PinElement } = await google.maps.importLibrary("marker");

  map = new Map(document.getElementById("map"), {
    center: { lat: -21.97777788538838, lng: -46.78949514952139 }, //Coordenadas para iniciar em São Joao.
    zoom: 15, //zoom do mapa
    zoomControl: false, //tirei os botoes de zoom
    streetViewControl: false, //tirei o streetview , o bonequinho que vc pode ver a rua dps a gnt conversa disso se coloca ou nao
    mapTypeControl: false, //eh feio e tirei :D
    mapId: "d5458e9d958b668e", //favor nao mexer nisso que se n para de funfar
    fullscreenControl: false //se quiserem colocar fullscreen só deixar isso true
  });

    listarPontosNoMapa();

}


Abrir Perfil*/

const btnOpen = document.querySelector('button.perfil');
const btnCLose = document.querySelector('button.btn-close-perfil');
const modal = document.querySelector('#modalPerfil');

[btnOpen].forEach((ev) =>{
ev.addEventListener('click', function() {
  var modal = document.querySelector('#modalPerfil');
  if (modal.style.display === "block") {
      modal.style.display = "none";
  } else {
      modal.style.display = "block";
  }});
});

document.querySelector('button.btn-close-perfil').addEventListener('click', function() {
  document.querySelector('#modalPerfil').style.display = "none";
});

/* Mudar a interface do tipo de usuario */

let tipoUsuario = "coletor";
const toggle = document.getElementById("toggle");
const texto = document.getElementById("tipo-usu");
const contador = document.getElementById("cont");
const lixos = document.getElementById('cont-lixos');
const btn_coleta = document.querySelectorAll(".btn-coleta");  
const btn_criar = document.getElementById("btn-criar");
const meusPontos =document.getElementById("lista-meus")

toggle.addEventListener('click', function() {
  if (toggle.classList.contains('active')) {
      toggle.classList.remove('active');
      toggle.textContent = 'Ativar';
      texto.textContent = 'Sou Coletor';
      texto.style.color = '#3ACC97';
      contador.style.borderColor = '#3ACC97';
      lixos.textContent = 'Lixos Coletados';

      // Muda botão de coleta
      btn_coleta.forEach(button => {
        button.style.visibility  = 'visible';  
      });

      // Oculta botão de criar
      btn_criar.style.visibility = 'visible';  
      btn_criar.style.visibility = 'hidden'; 

      // Oculta meus Pontos
      meusPontos.style.visibility = 'visible';  
      meusPontos.style.visibility = 'hidden';  


      tipoUsuario = "coletor";
      //Lixo coletado no modo coletor
      $("#modalPerfilLixosColetados").html(dadosMoradorColetor.quantidadeLixoColetado);
      
  } else {
      toggle.classList.add('active');
      toggle.textContent = 'Desativar';
      texto.textContent = 'Sou Morador';
      texto.style.color = '#3AB6CC';
      contador.style.borderColor = '#3AB6CC';
      lixos.textContent = 'Lixos Reciclados';
      
      btn_coleta.forEach(button => {
        button.style.visibility  = 'hidden';  
      });

      btn_criar.style.visibility = 'hidden';  
      btn_criar.style.visibility = 'visible';  

      meusPontos.style.visibility = 'hidden';  
      meusPontos.style.visibility = 'visible';  

      tipoUsuario = "morador";
      //Lixo reciclado no modo morador
      $("#modalPerfilLixosColetados").html(dadosMoradorColetor.quantidadeLixoReciclado);
  }

  listarPontos(event);

});

/* Modal de editar Informações*/
let eyeicon = document.getElementById('eyeicon');
let password = document.getElementById('password');
let eyeicon2 = document.getElementById('eyeicon2');
let password2 = document.getElementById('password2');

// botao mostrar senha 

mostrarsenha = function(){
  if(password.type === "password"){
    password.type = "text";
    eyeicon.src = "img/eye-open.png";
  }
  else{
    password.type = "password";
    eyeicon.src = "img/eye-close.png";
  }
};

confirmarsenha = function(){
  if(password2.type === "password"){
    password2.type = "text";
    eyeicon2.src = "img/eye-open.png";
  }
  else{
    password2.type = "password";
    eyeicon2.src = "img/eye-close.png";
  }
};

/* Abrir Modal de editar informações */
const btnOpenInfo = document.querySelector('button.btn-info');
const btnCLoseInfo = document.querySelector('button.btn-close-info');
const modalInfo = document.querySelector('#ModalInfo');
const fade = document.querySelector('#fade');
const btnSaveInfo = document.querySelector('button.editar');

[btnOpenInfo].forEach((ev) =>{
  ev.addEventListener('click', function() {
    var modalInfo = document.querySelector('#ModalInfo');
    if (modalInfo.style.display === "block") {
      modalInfo.style.display = "none";
    } else {
      modalInfo.style.display = "block";
    }});
    ev.addEventListener('click', function() {
      var fade = document.querySelector('#fade');
      if (fade.style.display === "block") {
        fade.style.display = "none";
      } else {
        fade.style.display = "block";
      }});
});

document.querySelector('button.btn-close-info').addEventListener('click', function() {
  document.querySelector('#ModalInfo').style.display = "none";
  document.querySelector('#fade').style.display = "none";
});

document.querySelector('button#editar').addEventListener('click', function() {
  document.querySelector('#ModalInfo').style.display = "none";
  document.querySelector('#fade').style.display = "none";
});



/* Abrir Modal de confirmar coleta */

const btnColetar = document.querySelector('button.btn-coleta');
const btnCLoseColeta = document.querySelector('button.btn-close-coleta');
const modalColeta = document.querySelector('#modalColeta');
const fadeColeta = document.querySelector('#fadeColeta');

// botões sim e não
const btnColetado = document.querySelector('button#btnColetado');
const btnNaoColetado = document.querySelector('button#btnNaoColetado');

[btnColetar].forEach((ev) =>{
  ev.addEventListener('click', function() {
    var modalColeta = document.querySelector('#modalColeta');
    if (modalColeta.style.display === "block") {
      modalColeta.style.display = "none";
    } else {
      modalColeta.style.display = "block";
    }});
    ev.addEventListener('click', function() {
      var fade = document.querySelector('#fadeColeta');
      if (fade.style.display === "block") {
        fade.style.display = "none";
      } else {
        fade.style.display = "block";
      }});
});

document.querySelector('button.btn-close-coleta').addEventListener('click', function() {
document.querySelector('#modalColeta').style.display = "none";
document.querySelector('#fadeColeta').style.display = "none";
});

document.querySelector('button#btnColetado').addEventListener('click', function() {
document.querySelector('#modalColeta').style.display = "none";
document.querySelector('#fadeColeta').style.display = "none";
});

document.querySelector('button#btnNaoColetado').addEventListener('click', function() {
  document.querySelector('#modalColeta').style.display = "none";
  document.querySelector('#fadeColeta').style.display = "none";
});



 /*Abrir Lista de pontos */

const btnOpenLista = document.querySelector('button#btn-lista');
const btnCLoseLista = document.querySelector('button.btn-close-lista');
const modalLista = document.querySelector('#modalLista');

[btnOpenLista].forEach((ev) =>{
ev.addEventListener('click', function() {
  var modalLista = document.querySelector('#modalLista');
  if (modalLista.style.display === "block") {
      modalLista.style.display = "none";
  } else {
      modalLista.style.display = "block";
  }});
});

document.querySelector('button.btn-close-lista').addEventListener('click', function() {
  document.querySelector('#modalLista').style.display = "none";
});

/* Abrir Filtros*/ 
const btnFiltros = document.querySelector('button.btn-filtro');
const modalFiltro = document.querySelector('#modalFiltro');
[btnFiltros].forEach((ev) =>{
  ev.addEventListener('click', function() {
    var modalFiltro = document.querySelector('#modalFiltro');
    if (modalFiltro.style.display === "block") {
      modalFiltro.style.display = "none";
    } else {
      modalFiltro.style.display = "block";
    }});
});
document.getElementById('filtrar').addEventListener('click', function() {
  document.querySelector('#modalFiltro').style.display = "none";
});

/* Abrir Raking */

const btnOpenRanking = document.querySelector('button.btn-ranking');
const btnCLoseRanking = document.querySelector('button.btn-close-ranking');
const modalRanking = document.querySelector('#modalRanking');

[btnOpenRanking].forEach((ev) =>{
ev.addEventListener('click', function() {
  var modalRanking = document.querySelector('#modalRanking');
  if (modalRanking.style.display === "block") {
      modalRanking.style.display = "none";
  } else {
      modalRanking.style.display = "block";
  }});
});

document.querySelector('button.btn-close-ranking').addEventListener('click', function() {
  document.querySelector('#modalRanking').style.display = "none";
});

/* Abrir Criar Ponto*/

const btnOpenCriar = document.querySelector('button#btn-criar');
const btnCLoseCriar = document.querySelector('button.btn-close-criar');
const modalCriar = document.querySelector('#modalCriar');

[btnOpenCriar].forEach((ev) =>{
ev.addEventListener('click', function() {
  var modalCriar = document.querySelector('#modalCriar');
  if (modalCriar.style.display === "block") {
      modalCriar.style.display = "none";
  } else {
      modalCriar.style.display = "block";
  }});
});

document.querySelector('button.btn-close-criar').addEventListener('click', function() {
  document.querySelector('#modalCriar').style.display = "none";
});

$(document).ready( function() {

  listarPontos(event); // Listando pela primeira vez
  
  // Inicializar as informações do perfil do usuário
  $("#modalPerfilNome").html("Olá, " + dadosMoradorColetor.nome); 
  $("#modalPerfilEmail").html(dadosMoradorColetor.email);
  $("#modalPerfilLixosColetados").html(dadosMoradorColetor.quantidadeLixoColetado);
  
  // Inicializar as informações do perfil do usuário na seção editar
  $("#nomeEditarInformacoes").val(dadosMoradorColetor.nome);
  $("#emailEditarInformacoes").val(dadosMoradorColetor.email);

  /* CRIANDO PONTO DE COLETA */
  $('#formularioCriarPonto').on("submit", function(event) {

    event.preventDefault();
    let tipoDeLixo = $('input[name="tipoLixo"]:checked').val();
    let rua = $('input[name="rua"]').val();
    let numero = $('input[name="numero"]').val();
    let bairro = $('input[name="bairro"]').val();
    let cidade = $('input[name="cidade"]').val();
    let complemento = $('input[name="complemento"]').val();
    let longitude;
    let latitude;

    let enderecoCompleto = rua + ' ' + numero + ', ' + bairro + ', ' + cidade;
    
    const geocoder = new google.maps.Geocoder();

    geocoder.geocode( { address: enderecoCompleto }, function (results, status) {

      if (status === 'OK') {

        let location = results[0].geometry.location;
        longitude = location.lng();
        latitude = location.lat();

        if ( tipoDeLixo && rua && numero && bairro && cidade && complemento ) {

          if ( !complemento ) {
            complemento = " ";
          }
    
          console.log(latitude);
          console.log(longitude);
    
          $.ajax("processaPontoDeColeta", {
    
            data: {
              acao: "inserir",
              idMoradorColetor: idMoradorColetor,
              tipoDeLixo: tipoDeLixo,
              rua: rua,
              numero: numero,
              bairro: bairro,
              cidade: cidade,
              complemento: complemento,
              longitude: longitude,
              latitude: latitude
            },
      
            dataType: "json"
      
          }).done((data) => {
    
            listarPontosNoMapa(event);
            listarPontos(event);
    
          }).fail((jqXHR, textStatus, errorThrown) => {
    
            console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
    
          });
    
        } else {
    
          alert("Não deixe nenhum campo em branco");
    
        }
    
        $('#modalCriar').css( "display", "none" );

      } else {
        alert('Endereco não encontrado: ' + status);
      }

    });

  });

  /* EXCLUINDO PONTO DE COLETA */
  $('.btn-denuncia').on('click', function(event) {

    event.preventDefault();

    const $divPonto = $(this).closest('.ponto');
    const idPonto = $divPonto.data("idPonto");

    /* DISPARAR MODAL CONFIRMANDO - SE NEGAR, APENAS DE 'return;' - SE ACEITAR, APENAS CONTINUAR */

    $.ajax("processaPontoDeColeta", {

      data: {
        acao: "deletar",
        idPonto: idPonto
      },

      dataType: "json"

    }).done((data) => {

      listarPontosNoMapa(event);
      listarPontos(event);

    }).fail((jqXHR, textStatus, errorThrown) => {

      console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);

    });

  });

});

/* Função para Listar os pontos */

async function listarPontosNoMapa ( event ) {
    
    const { AdvancedMarkerElement, PinElement } = await google.maps.importLibrary("marker");
    
    $.ajax("processaPontoDeColeta", {
      data: {
        acao: "listarPontosMapa"
      },
      dataType: "json"
    })
    .done((data) => {

      data.forEach(pontoDeColeta => {

        new AdvancedMarkerElement({
          map: map,
          position: { lat: pontoDeColeta.coordenada.latitude, lng: pontoDeColeta.coordenada.longitude },
          //Title eh oq acontece no hover do marker (ponto) deixei o tipo de lixo só por enquanto.
          title: `${pontoDeColeta.tipoDeLixo}` 
        });

        console.log( pontoDeColeta );
      });
    })
    .fail((jqXHR, textStatus, errorThrown) => {
      console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
    }); 
}

function listarPontos(event) {

  $.ajax("processaPontoDeColeta", {

    data: {
        acao: "listar",
        idMoradorColetor: idMoradorColetor
    },
    dataType: "json"

  }).done((data) => {

    let $listaDePontos = $("#lista");
    $listaDePontos.html("");

    data.forEach(pontoDeColeta => {

      if (tipoUsuario == "coletor") {

        $listaDePontos.append (
          `<div class="ponto" data-idPonto="${pontoDeColeta.id}">
            <img  src="img/pontoOrganico.png" alt="ponto"> 
            <div class="ende">${pontoDeColeta.rua}, ${pontoDeColeta.numero} - ${pontoDeColeta.bairro}</div>
            <button class="btn-denuncia"><img id="denuncia" src="img/denuncia.png" alt="denuncia"></button>
          </div>`
        );

      } else {

        $listaDePontos.append (
          `<div class="ponto" data-idPonto="${pontoDeColeta.id}">
            <div class="ende">${pontoDeColeta.rua}, ${pontoDeColeta.numero} - ${pontoDeColeta.bairro}</div>
            <button class="btn-denuncia"><img id="denuncia" src="img/denuncia.png" alt="denuncia"></button>
          </div>`
        );

      }
    });

  }).fail((jqXHR, textStatus, errorThrown) => {
    console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
  });

  $.ajax("processaPontoDeColeta", {

    data: {
        acao: "listarPontosProprios",
        idMoradorColetor: idMoradorColetor
    },
    dataType: "json"

  }).done((data) => {

    let $listaDePontosProprios = $("#lista-meus");
    $listaDePontosProprios.html("");

    data.forEach(pontoDeColeta => {

      if (tipoUsuario == "coletor") {

        $listaDePontosProprios.append (
          `<div class="ponto">
            <img id="ponto" src="img/pontoOleo.png" alt="ponto">
            <div class="ende">${pontoDeColeta.rua}, ${pontoDeColeta.numero} - ${pontoDeColeta.bairro}</div>
            <button class="btn-editar"><img src="img/editar.png" alt="denuncia"></button>
            <button class="btn-excluir"><img src="img/excluir.png" alt="denuncia"></button>
          </div>`
        );

      } else {

        $listaDePontosProprios.append (
          `<div class="ponto">
            <div class="ende">${pontoDeColeta.rua}, ${pontoDeColeta.numero} - ${pontoDeColeta.bairro}</div>
            <button class="btn-editar"><img src="img/editar.png" alt="denuncia"></button>
            <button class="btn-excluir"><img src="img/excluir.png" alt="denuncia"></button>
          </div>`
        );

      }

    });

  }).fail((jqXHR, textStatus, errorThrown) => {
      console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);
  });
  
  $("#formularioEditarInformacoes").on("submit", function (event) {
      
     event.preventDefault();
     
     let id = dadosMoradorColetor.id;
     let nome = $('input[name="nomeEditarInformacoes"]').val();
     let email = $('input[name="emailEditarInformacoes"]').val();
     let senhaAntiga = $('input[name="senhaAntigaEditarInformacoes"]').val();
     let senhaNova = $('input[name="senhaNovaEditarInformacoes"]').val();
     
     $.ajax("processaMoradorColetor", {
         method: "POST",
         data:{
             acao: "atualizar",
             id : id,
             nome: nome,
             email: email,
             senhaAntiga: senhaAntiga,
             senhaNova: senhaNova
         },
         dataType: "text"
     }).done( (data) => {
         if ( data === "OK" ) {
             window.location.replace("index.jsp");
         } else {
             alert("Erro ao Atualizar Informações");
         }
     }).fail( ( jqXHR, textStatus, errorThrown ) => {
         console.log("Erro na requisição");
         console.log("Código de status: " + jqXHR.status);
         console.log("Erro: " + errorThrown); 
         console.log(jqXHR.responseText);
     });
     
  });
}

