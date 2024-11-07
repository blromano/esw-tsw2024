$('#gerente1').click(function() {
    $('#manager-modal1').removeClass('hidden');
});

$('#gerente1x').click(function() {
    $('#manager-modal1').addClass('hidden');
});

$('#gerente2').click(function() {
    $('#manager-modal2').removeClass('hidden');
});

$('#gerente2x').click(function() {
    $('#manager-modal2').addClass('hidden');
});

$('#gerente3').click(function() {
    $('#manager-modal3').removeClass('hidden');
});

$('#gerente3x').click(function() {
    $('#manager-modal3').addClass('hidden');
});

$('#perfilFechar').click(function() {
    $('#manager-modal3').addClass('hidden');
});

$('#editar1').click(function() {
    $('#editarGestor1').removeClass('hidden');
});

$('#editarGerente1').click(function() {
    $('#editarGestor1').addClass('hidden');
});

$('#editar2').click(function() {
    $('#editarGestor2').removeClass('hidden');
});

$('#editarGerente2').click(function() {
    $('#editarGestor2').addClass('hidden');
});

$('#editar3').click(function() {
    $('#editarGestor3').removeClass('hidden');
});

$('#editarGerente3').click(function() {
    $('#editarGestor3').addClass('hidden');
});

function setupModalValidation(textarea2Id1, textarea2Id2, textarea2Id3, textarea2Id4, button2Id, modal2Id) {
    // Função para verificar se os campos estão preenchidos corretamente
    function checkFields() {
        const isTextareaFilled1 = $(`#${textarea2Id1}`).val().trim() !== '';
        const isTextareaFilled2 = $(`#${textarea2Id2}`).val().trim() !== '';
        const isTextareaFilled3 = $(`#${textarea2Id3}`).val().trim() !== '';
        const isTextareaFilled4 = $(`#${textarea2Id4}`).val().trim() !== '';
        

        // Ativa ou desativa o botão com base no estado dos campos
        $(`#${button2Id}`).prop('disabled', !(isTextareaFilled1 && isTextareaFilled2 && isTextareaFilled3 && isTextareaFilled4));

        // Adiciona ou remove a borda vermelha do textarea
        $(`#${textarea2Id1}`).toggleClass('border-red-500', !isTextareaFilled1);
        $(`#${textarea2Id2}`).toggleClass('border-red-500', !isTextareaFilled2);
        $(`#${textarea2Id3}`).toggleClass('border-red-500', !isTextareaFilled3);
        $(`#${textarea2Id4}`).toggleClass('border-red-500', !isTextareaFilled4);
    }

    // Eventos para verificar o preenchimento e seleção
    $(`#${textarea2Id1}`).on('input', checkFields);
    $(`#${textarea2Id2}`).on('input', checkFields);
    $(`#${textarea2Id3}`).on('input', checkFields);
    $(`#${textarea2Id4}`).on('input', checkFields);
    

    // Função do botão para registrar a tarefa e fechar o modal
    $(`#${button2Id}`).click(function() {
        alert('Perfil Editado!');
        $(`#${modal2Id}`).addClass('hidden');
    });
}

// Configuração de cada modal individualmente
setupModalValidation('g1t1', 'g1t2', 'g1t3', 'g1t4', 'salvar1', 'editarGestor1');
setupModalValidation('g2t1', 'g2t2', 'g2t3', 'g2t4', 'salvar2', 'editarGestor2');
setupModalValidation('g3t1', 'g3t2', 'g3t3', 'g3t4', 'salvar3', 'editarGestor3');