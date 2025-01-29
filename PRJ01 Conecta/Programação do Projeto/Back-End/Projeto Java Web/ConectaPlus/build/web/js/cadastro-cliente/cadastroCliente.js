function onChangeEmail(){
    
    const email = form.email().value;
    form.emailObrigatorio().style.display = email ? "none" : "block";
    
    form.emailInvalido().style.display = validarEmail(email) ? "none" : "block";
    
    botaoDesabilitado();
    
}

function onChangeSenha(){
    
    const senha = form.senha().value;
    
    form.senhaObrigatoria().style.display = senha ? "none" : "block";
    
    form.senhaInvalida().style.display = validarSenha(senha) ? "none" : "block";    
    
    validarSenhaCoincidente();
    
    botaoDesabilitado();
    
}

function onChangeConfirmarSenha(){
    
    validarSenhaCoincidente();
    botaoDesabilitado();
    
}

function validarSenhaCoincidente(){
    
    const senha = form.senha().value;
    const confirmarSenha = form.confirmarSenha().value;
    
    form.confirmarSenhaErro().style.display = 
            senha === confirmarSenha ? "none" : "block";
    
    
}

function botaoDesabilitado(){
    
    form.botaoSubmissao().disabled = ! validarForm();
    
}

function validarForm(){
    
    const email = form.email().value;
    if ( !email || !validarEmail(email)){
        return false;
    }
    
    const senha = form.senha().value;
    if ( !senha || !validarSenha(senha)) {
        return false;
    }
    
    const confirmarSenha = form.confirmarSenha().value;
    if ( senha !== confirmarSenha ) {
        return false;
    }
    
    return true;
    
}

function validarEmail(email) {
    return /\S+@\S+\.\S+/.test(email);
}

function validarSenha(senha) {
    
    const validacao = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%&*])[A-Za-z\d!@#$%&*]{8,}$/;
    
    /*
     * ^(?=.*[a-z]) - Pelo menos uma letra minuscula.
     * (?=.*[A-Z]) - Pelo menos uma letra maiúscula.
     * (?=.*\d) - Pelo menos um numero.
     * (?=.*[!@#$%&*]) - Pelo menos um caractere especial
     * [A-Za-z\d!@#$%&*]{8,}$  - Minimo 8 caracteres e pode conter
     *                          letras, numeros 
     *                          e caracteres especiais listados
     * 
    */
    return validacao.test(senha);
    
}



const form = {
    
    email: () => document.getElementById('email'),
    emailInvalido: () => document.getElementById('email-invalido'),
    emailObrigatorio: () => document.getElementById('email-obrigatorio'),
    
    senha: () => document.getElementById('password'),
    senhaInvalida: () => document.getElementById('senha-necessaria'),
    senhaObrigatoria: () => document.getElementById('senha-obrigatoria'),
    
    confirmarSenha: () => document.getElementById('confirmPassword'),
    confirmarSenhaErro: () => document.getElementById('senha-coincide'),
    
    
    botaoSubmissao: () => document.getElementById('botao-submissao')
    
};


