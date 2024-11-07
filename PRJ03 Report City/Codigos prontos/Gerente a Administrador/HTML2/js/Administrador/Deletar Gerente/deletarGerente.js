function setupModalValidation(textareaId, selectId, buttonId, modalId) {
    // Função para verificar se os campos estão preenchidos corretamente
    function checkFields() {
        const isTextareaFilled = $(`#${textareaId}`).val().trim() !== '';
        const isOptionSelected = $(`#${selectId}`).val() && $(`#${selectId}`).val() !== '';

        // Ativa ou desativa o botão com base no estado dos campos
        $(`#${buttonId}`).prop('disabled', !(isTextareaFilled && isOptionSelected));

        // Adiciona ou remove a borda vermelha do textarea
        $(`#${textareaId}`).toggleClass('border-red-500', !isTextareaFilled);
    }

    // Chama a função de verificação de campos ao iniciar para garantir que o botão esteja desabilitado
    checkFields();

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
setupModalValidation('reason1', 'select-manager1', 'delete-manager1-btn', 'delete-manager-modal1');


$('#delete-btn').click(function() {
    $('#delete-manager-modal1').removeClass('hidden');
});

$('#fecharDeletar').click(function() {
    $('#delete-manager-modal1').addClass('hidden');
});