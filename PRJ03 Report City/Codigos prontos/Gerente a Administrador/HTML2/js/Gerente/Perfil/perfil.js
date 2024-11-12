$('#editarPerfil-btn').click(function() {
    $('#editarPerfilModal').removeClass('hidden');
});

$('#perfilFechar').click(function() {
    $('#editarPerfilModal').addClass('hidden');
});

function setupModalValidation(textarea2Id1, textarea2Id2, textarea2Id3, button2Id, modal2Id) {
    // Função para verificar se os campos estão preenchidos corretamente
    function checkFields() {
        const isTextareaFilled1 = $(`#${textarea2Id1}`).val().trim() !== '';
        const isTextareaFilled2 = $(`#${textarea2Id2}`).val().trim() !== '';
        const isTextareaFilled3 = $(`#${textarea2Id3}`).val().trim() !== '';
        

        // Ativa ou desativa o botão com base no estado dos campos
        $(`#${button2Id}`).prop('disabled', !(isTextareaFilled1 && isTextareaFilled2 && isTextareaFilled3));

        // Adiciona ou remove a borda vermelha do textarea
        $(`#${textarea2Id1}`).toggleClass('border-red-500', !isTextareaFilled1);
        $(`#${textarea2Id2}`).toggleClass('border-red-500', !isTextareaFilled2);
        $(`#${textarea2Id3}`).toggleClass('border-red-500', !isTextareaFilled3);
    }

    // Eventos para verificar o preenchimento e seleção
    $(`#${textarea2Id1}`).on('input', checkFields);
    $(`#${textarea2Id2}`).on('input', checkFields);
    $(`#${textarea2Id3}`).on('input', checkFields);
    

    // Função do botão para registrar a tarefa e fechar o modal
    $(`#${button2Id}`).click(function() {
        alert('Perfil Salvo!');
        $(`#${modal2Id}`).addClass('hidden');
    });
}

// Configuração de cada modal individualmente
setupModalValidation('perfilNome', 'perfilEmail', 'perfilSetor', 'salvarPerfil-btn', 'editarPerfilModal');