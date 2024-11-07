const $form = $('#cadastrarTerceirizadoForm');
const $inputs = $form.find('input');
const $cpfInput = $('#terceirizadoCPF');
const $emailInput = $('#terceirizadoEmail');
const $submitButton = $('#create-manager-btn');

// Função para verificar se o CPF é válido
function validarCPF(cpf) {
    cpf = cpf.replace(/[^\d]+/g, ''); // Remove caracteres não numéricos
    if (cpf.length !== 11 || /^(\d)\1+$/.test(cpf)) return false;
    
    let soma = 0, resto;
    for (let i = 1; i <= 9; i++) soma += parseInt(cpf.substring(i - 1, i)) * (11 - i);
    resto = (soma * 10) % 11;
    if ((resto === 10) || (resto === 11)) resto = 0;
    if (resto !== parseInt(cpf.substring(9, 10))) return false;
    
    soma = 0;
    for (let i = 1; i <= 10; i++) soma += parseInt(cpf.substring(i - 1, i)) * (12 - i);
    resto = (soma * 10) % 11;
    if ((resto === 10) || (resto === 11)) resto = 0;
    return resto === parseInt(cpf.substring(10, 11));
}

// Função para verificar se o e-mail é válido
function validarEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}

// Função para verificar se todos os campos estão preenchidos e válidos
function verificarCampos() {
    let todosValidos = true;

    $inputs.each(function() {
        const $input = $(this);
        const valor = $input.val().trim();

        // Resetando a classe de borda ao iniciar a verificação
        $input.removeClass('border-red-500 border-blue-900');

        if (valor === '') {
            $input.addClass('border-red-500'); // Borda vermelha para campo vazio
            todosValidos = false;
        } else {
            if ($input.attr('id') === 'terceirizadoCPF') {
                if (!validarCPF(valor)) {
                    $input.addClass('border-red-500'); // Borda vermelha para CPF inválido
                    todosValidos = false;
                } else {
                    $input.addClass('border-blue-900'); // Borda azul para CPF válido
                }
            } else if ($input.attr('id') === 'terceirizadoEmail') {
                if (!validarEmail(valor)) {
                    $input.addClass('border-red-500'); // Borda vermelha para e-mail inválido
                    todosValidos = false;
                } else {
                    $input.addClass('border-blue-900'); // Borda azul para e-mail válido
                }
            } else {
                $input.addClass('border-blue-900'); // Borda azul para campo válido
            }
        }
    });

    $submitButton.prop('disabled', !todosValidos);
}

// Verificação inicial e a cada mudança de valor nos campos
$inputs.on('input', verificarCampos);

// Chama a função de verificação na inicialização
verificarCampos();

// Primeiro Terceirizado

$('#desativarTerceiro01').click(function() {
    $('#desativarTer01').removeClass('hidden');
});

$('#desativar01').click(function() {
    $('#desativarTer01').addClass('hidden');
});

$('#desabilitar01').click(function() {
    const reason = $('#razaoDesativar01').val();
    if (reason.trim() !== '') {
        alert('Terceirizado Desabilitado!');
        $('#desativarTer01').addClass('hidden');
        
    } else {
        alert('Por favor, insira um motivo.');
    }
});

// Segundo Terceirizado

$('#desativarTerceiro02').click(function() {
    $('#desativarTer02').removeClass('hidden');
});

$('#desativar02').click(function() {
    $('#desativarTer02').addClass('hidden');
});

$('#desabilitar02').click(function() {
    const reason = $('#razaoDesativar02').val();
    if (reason.trim() !== '') {
        alert('Terceirizado Desabilitado!');
        $('#desativarTer02').addClass('hidden');
        
    } else {
        alert('Por favor, insira um motivo.');
    }
});

// Terceiro Terceirizado

$('#desativarTerceiro03').click(function() {
    $('#desativarTer03').removeClass('hidden');
});

$('#desativar03').click(function() {
    $('#desativarTer03').addClass('hidden');
});

$('#desabilitar03').click(function() {
    const reason = $('#razaoDesativar03').val();
    if (reason.trim() !== '') {
        alert('Terceirizado Desabilitado!');
        $('#desativarTer03').addClass('hidden');
        
    } else {
        alert('Por favor, insira um motivo.');
    }
});

// Quarto Terceirizado

$('#desativarTerceiro04').click(function() {
    $('#desativarTer04').removeClass('hidden');
});

$('#desativar04').click(function() {
    $('#desativarTer04').addClass('hidden');
});

$('#desabilitar04').click(function() {
    const reason = $('#razaoDesativar04').val();
    if (reason.trim() !== '') {
        alert('Terceirizado Desabilitado!');
        $('#desativarTer04').addClass('hidden');
        
    } else {
        alert('Por favor, insira um motivo.');
    }
});
