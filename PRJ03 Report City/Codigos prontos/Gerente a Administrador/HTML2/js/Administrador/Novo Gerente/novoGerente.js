function setupModalValidation(textarea2Id1, textarea2Id2, textarea2Id3, textarea2Id4, textarea2Id5, button2Id, modal2Id) {
    // Função para verificar se os campos estão preenchidos corretamente
    function checkFields() {
        const isTextareaFilled1 = $(`#${textarea2Id1}`).val().trim() !== '';
        const isTextareaFilled2 = $(`#${textarea2Id2}`).val().trim() !== '';
        const isTextareaFilled3 = $(`#${textarea2Id3}`).val().trim() !== '';
        const isTextareaFilled4 = $(`#${textarea2Id4}`).val().trim() !== '';
        const isTextareaFilled5 = $(`#${textarea2Id5}`).val().trim() !== '';

        // Ativa ou desativa o botão com base no estado dos campos
        $(`#${button2Id}`).prop('disabled', !(isTextareaFilled1 && isTextareaFilled2 && isTextareaFilled3 && isTextareaFilled4 && isTextareaFilled5));

        // Adiciona ou remove a borda vermelha do textarea
        $(`#${textarea2Id1}`).toggleClass('border-red-500', !isTextareaFilled1);
        $(`#${textarea2Id2}`).toggleClass('border-red-500', !isTextareaFilled2);
        $(`#${textarea2Id3}`).toggleClass('border-red-500', !isTextareaFilled3);
        $(`#${textarea2Id4}`).toggleClass('border-red-500', !isTextareaFilled4);
        $(`#${textarea2Id5}`).toggleClass('border-red-500', !isTextareaFilled5);
    }

    // Chamando checkFields sempre que o modal é mostrado
    const modal = $(`#${modal2Id}`);
    modal.on('transitionend', function() {
        if (!modal.hasClass('hidden')) {
            checkFields();
        }
    });

    // Eventos para verificar o preenchimento e seleção
    $(`#${textarea2Id1}`).on('input', checkFields);
    $(`#${textarea2Id2}`).on('input', checkFields);
    $(`#${textarea2Id3}`).on('input', checkFields);
    $(`#${textarea2Id4}`).on('input', checkFields);
    $(`#${textarea2Id5}`).on('input', checkFields);

    // Função do botão para registrar a tarefa e fechar o modal
    $(`#${button2Id}`).click(function() {
        checkFields(); // Garantir que os campos são validados ao clicar
        if (!$(this).prop('disabled')) {
            alert('Gerente Criado!');
            modal.addClass('hidden');
        }
    });
}

// Configuração de cada modal individualmente
setupModalValidation('name', 'cpf', 'email', 'password', 'department', 'submitGestor', 'add-manager-modal');
