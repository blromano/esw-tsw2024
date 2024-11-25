

    let eyeicon = document.getElementById('eyeicon')
    let password = document.getElementById('password')
    let eyeicon2 = document.getElementById('eyeicon2')
    let password2 = document.getElementById('password2')

    /* botao mostrar senha */
    mostrarsenha = function(){

        if(password.type == "password"){
            password.type = "text"
            eyeicon.src = "img/eye-open.png"
        }
        else{
            password.type = "password"
            eyeicon.src = "img/eye-close.png"
        }
    }

    confirmarsenha = function(){

        if(password2.type == "password"){
            password2.type = "text"
            eyeicon2.src = "img/eye-open.png"
        }
        else{
            password2.type = "password"
            eyeicon2.src = "img/eye-close.png"
        }
    }
