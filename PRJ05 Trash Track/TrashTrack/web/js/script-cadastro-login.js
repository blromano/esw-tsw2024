

    let eyeicon = document.getElementById('eyeicon');
    let password = document.getElementById('password');
    let eyeicon2 = document.getElementById('eyeicon2');
    let password2 = document.getElementById('password2');

    /* botao mostrar senha */
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
    
    $(document).ready(function () {
        
        $("#btnCadastro").on("submit", function ( e ) {
            
            e.preventDefault();
        
            let nome = $('input[name="nome"]').val();
            let email = $('input[name="email"]').val();
            let dataNascimento = $('input[name="dataNascimento"]').val();
            let cpf = $('input[name="cpf"]').val();
            let senha = $('input[name="senha"]').val();
            let confirmar = $('input[name="confirmarSenha"]').val();
            
            $.ajax("processaMoradorColetor", {
                method: "POST",
                data: {
                    acao: "inserir",
                    nome: nome,
                    email: email,
                    dataNascimento: dataNascimento,
                    cpf: cpf,
                    senha: senha,
                    confirmarSenha: confirmar
                },
                dataType: "text"
            }).done( ( data ) =>  {
                window.location.replace("login.jsp");
            }).fail ( ( jqXHR, textStatus, errorThrown ) => {
                console.log("Erro na requisição");
                console.log("Código de status: " + jqXHR.status);
                console.log("Erro: " + errorThrown); 
            });
        });
        
        $("#btnLogin").on("submit", function ( e ) {
            
            e.preventDefault();
            
            
            let email = $('input[name="email"]').val();
            let senha = $('input[name="senha"]').val();
            
            $.ajax("processaMoradorColetor", {
                method: "POST",
                data: {
                    acao: "login",
                    email: email,
                    senha: senha
                },
                dataType: "json"
            }).done( ( data ) => {
                if ( data ) {
                    sessionStorage.setItem("dadosMoradorColetor",JSON.stringify(data));
                    window.location.replace("mapa.jsp");
                } else {
                    alert("Erro ao Logar");
                }
            }).fail( ( jqXHR, textStatus, errorThrown ) => {
                console.log("Erro na requisição");
                console.log("Código de status: " + jqXHR.status);
                console.log("Erro: " + errorThrown); 
                console.log(jqXHR.responseText);
            });
        });
    });