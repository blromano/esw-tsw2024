/* Abrir Perfil*/

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


/* Mudar tipo de usuario */

const toggle = document.getElementById("toggle");
const texto = document.getElementById("tipo-usu");
const contador = document.getElementById("cont");
const lixos = document.getElementById('cont-lixos')

toggle.addEventListener('click', function() {
  if (toggle.classList.contains('active')) {
      toggle.classList.remove('active');
      toggle.textContent = 'Ativar';
      texto.textContent = 'Sou Coletor';
      texto.style.color = '#3ACC97';
      contador.style.borderColor = '#3ACC97';
      lixos.textContent = 'Lixos Coletados';
  } else {
      toggle.classList.add('active');
      toggle.textContent = 'Desativar';
      texto.textContent = 'Sou Morador';
      texto.style.color = '#3AB6CC';
      contador.style.borderColor = '#3AB6CC';
      lixos.textContent = 'Lixos Reciclados';
  }
});

/* Abrir Lista de pontos */

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

  /* CRIANDO PONTO DE COLETA */
  $('#formularioCriarPonto').on("submit", function(event) {

    event.preventDefault();

    let idMoradorColetor = $('input[name="idMoradorColetor"]').val();
    let tipoDeLixo = $('input[name="tipoLixo"]:checked').val();
    let rua = $('input[name="rua"]').val();
    let numero = $('input[name="numero"]').val();
    let bairro = $('input[name="bairro"]').val();
    let cidade = $('input[name="cidade"]').val();
    let complemento = $('input[name="complemento"]').val();
    
    /* INSERIR COORDENADAS */
    /*
      let longitude = ...
      let latitude = ...

      OBTER UTILIZANDO: https://developers.google.com/maps/documentation/javascript/geocoding?hl=pt-br (ESPERANDO API DO SAMUEL)
    */

    if ( idMoradorColetor && tipoDeLixo && rua && numero && bairro && cidade && complemento ){

      if ( !complemento ) {
        complemento = " ";
      }

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

        /* reexibir pontos de coleta no mapa */

      }).fail((jqXHR, textStatus, errorThrown) => {

        console.log("Erro: " + errorThrown + "\nStatus: " + textStatus);

      });

    } else {

      alert("Não deixe nenhum campo em branco");

    }

    $('#modalCriar').css( "display", "none" );

  })

  /* EXCLUINDO PONTO DE COLETA */

})
