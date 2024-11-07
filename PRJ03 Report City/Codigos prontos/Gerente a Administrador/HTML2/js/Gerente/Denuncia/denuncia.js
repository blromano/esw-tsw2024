$('#denuncia1').click(function() {
    $('#denunciaModal1').show();
});

$('#denunciaM1').click(function() {
    $('#denunciaModal1').hide();
});

// Primeira Denuncia
$('.registrarTask-btn').on('click', function() {
    $('#CadastrarTask1').removeClass('hidden');
});

$('[data-close="CadastrarTask1"]').on('click', function() {
    $('#CadastrarTask1').addClass('hidden');
});

$('#CancelarcadastrarTask-btn').click(function() {
    $('#CadastrarTask1').addClass('hidden');
});

// Segunda Denuncia
$('.registrarTask2-btn').on('click', function() {
    $('#CadastrarTask2').removeClass('hidden');
});

$('[data-close="CadastrarTask2"]').on('click', function() {
    $('#CadastrarTask2').addClass('hidden');
});

$('#CancelarcadastrarTask2-btn').click(function() {
    $('#CadastrarTask2').addClass('hidden');
});

// Terceira Denuncia
$('.registrarTask3-btn').on('click', function() {
    $('#CadastrarTask3').removeClass('hidden');
});

$('[data-close="CadastrarTask3"]').on('click', function() {
    $('#CadastrarTask3').addClass('hidden');
});

$('#CancelarcadastrarTask3-btn').click(function() {
    $('#CadastrarTask3').addClass('hidden');
});



/*$('#ConfirmarcadastrarTask-btn').click(function() {
    alert('Tarefa Registrada!');
    $('#CadastrarTask1').hide();
});*/

// Função para verificar o campo em tempo real
/*$('#taskName1').on('input', function() {
    if ($(this).val().trim() === '') {
        $(this).addClass('border-red-500'); // Adiciona borda vermelha se estiver vazio
        $('#ConfirmarcadastrarTask-btn').prop('disabled', true); // Desativa o botão
    } else {
        $(this).removeClass('border-red-500'); // Remove borda vermelha se preenchido
        $('#ConfirmarcadastrarTask-btn').prop('disabled', false); // Ativa o botão
    }
});

// Função do botão para enviar a tarefa
$('#ConfirmarcadastrarTask-btn').click(function() {
    alert('Tarefa Registrada!');
    $('#CadastrarTask1').hide();
});

$('#taskName2').on('input', function() {
    if ($(this).val().trim() === '') {
        $(this).addClass('border-red-500'); // Adiciona borda vermelha se estiver vazio
        $('#ConfirmarcadastrarTask2-btn').prop('disabled', true); // Desativa o botão
    } else {
        $(this).removeClass('border-red-500'); // Remove borda vermelha se preenchido
        $('#ConfirmarcadastrarTask2-btn').prop('disabled', false); // Ativa o botão
    }
});

$('#ConfirmarcadastrarTask2-btn').click(function() {
    alert('Tarefa Registrada!');
    $('#CadastrarTask2').hide();
});

$('#taskName3').on('input', function() {
    if ($(this).val().trim() === '') {
        $(this).addClass('border-red-500'); // Adiciona borda vermelha se estiver vazio
        $('#ConfirmarcadastrarTask3-btn').prop('disabled', true); // Desativa o botão
    } else {
        $(this).removeClass('border-red-500'); // Remove borda vermelha se preenchido
        $('#ConfirmarcadastrarTask3-btn').prop('disabled', false); // Ativa o botão
    }
});

$('#ConfirmarcadastrarTask3-btn').click(function() {
    alert('Tarefa Registrada!');
    $('#CadastrarTask3').hide();
});*/

// Função para configurar validação de modal
function setupModalValidation(textareaId, selectId, buttonId, modalId) {
    // Função para verificar se os campos estão preenchidos corretamente
    function checkFields() {
        const isTextareaFilled = $(`#${textareaId}`).val().trim() !== '';
        const isOptionSelected = $(`#${selectId}`).val() && $(`#${selectId}`).val() !== ''; // Verifica se uma opção válida foi selecionada

        // Ativa ou desativa o botão com base no estado dos campos
        $(`#${buttonId}`).prop('disabled', !(isTextareaFilled && isOptionSelected));

        // Adiciona ou remove a borda vermelha do textarea
        $(`#${textareaId}`).toggleClass('border-red-500', !isTextareaFilled);
    }

    // Eventos para verificar o preenchimento e seleção
    $(`#${textareaId}`).on('input', checkFields);
    $(`#${selectId}`).on('change', checkFields);

    // Função do botão para registrar a tarefa e fechar o modal
    $(`#${buttonId}`).click(function() {
        alert('Tarefa Registrada!');
        $(`#${modalId}`).addClass('hidden');
    });
}

// Configuração de cada modal individualmente
setupModalValidation('taskName1', 'serviceSelect1', 'ConfirmarcadastrarTask-btn', 'CadastrarTask1');
setupModalValidation('taskName2', 'serviceSelect2', 'ConfirmarcadastrarTask2-btn', 'CadastrarTask2');
setupModalValidation('taskName3', 'serviceSelect3', 'ConfirmarcadastrarTask3-btn', 'CadastrarTask3');



