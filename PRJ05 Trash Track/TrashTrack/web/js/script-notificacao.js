const dadosMoradorColetor = JSON.parse(sessionStorage.getItem("dadosMoradorColetor"));

function abrirNotificacao() {
    $('#notificacao-pop-up-dropdown').css('display', 'block');
}

function fecharNotificacao() {
    $('#notificacao-pop-up-dropdown').css('display', 'none');
}

$(document).ready(function () {
    const notificacoes = $('#notificacoes');
    const cadastroLogin = $('#cadastroLogin');
    const login = $('#login');
    const usuarioLogadoItem = $('#usuarioLogado');
    const usuarioLogadoTexto = $('#usuarioLogadoTexto');

    if (dadosMoradorColetor !== null) {
        notificacoes.show();
        usuarioLogadoItem.show();
        cadastroLogin.hide();
        login.hide();
        usuarioLogadoTexto.html("Bem vindo, " + dadosMoradorColetor.nome);
    } else {
        notificacoes.hide();
        usuarioLogadoItem.hide();
        cadastroLogin.show();
        login.show();
    }
    
    notificacoes.on( "click", function (event) {
       
        event.preventDefault();
        
        $.ajax("processaNotificacao", {
            data:{
                acao:"listar",
                id: dadosMoradorColetor.id
            },
            dataType: "json"
        }).done( ( data ) => {
            
            let $listaNotificacoes = $("#listaNotificacoes");
            $listaNotificacoes.html("");
            
            if ( Object.keys(data).length === 0 ){
                console.log(data);
                $listaNotificacoes.append(`<li>Sem novas notificações</li>`);
            } else {
                data.forEach(notificacao => {
                    console.log(data);
                    $listaNotificacoes.append(`<li>${notificacao.descricao}</li>`);
                });
            }
        }).fail((jqXHR, textStatus, errorThrown) => {
            console.log("Erro na requisição");
            console.log("Código de status: " + jqXHR.status);
            console.log("Erro: " + errorThrown); 
            console.log(jqXHR.responseText);
        });
        
    });
});
