$(document).ready(function() {
    // Função para desabilitar usuário
    function disableUser() {
        const reason = $('#disableReason').val();
        if (reason.trim() !== '') {
            alert('Usuário Desabilitado');
            closeDisableUserModal();
            $('.modal').addClass('hidden');  // Fechar todos os modais
        } else {
            alert('Por favor, insira um motivo.');
        }
    }

    // Função para o logout
    function logout() {
        alert('Logout realizado com sucesso!');
        window.location.href = 'index.html'; // Redireciona para a página de login
    }

    // Função para cadastrar terceirizado
    function registerTerceirizado() {
        alert('Terceirizado Registrado!');
        $('#cadastrarTerceirizadoModal').addClass('hidden'); // Fechar o modal após o cadastro
    }

    // Tornando as funções globais para que o HTML possa acessá-las
    window.closeDisableUserModal = closeDisableUserModal;
    window.disableUser = disableUser;
    window.logout = logout;
    window.registerTerceirizado = registerTerceirizado;

    // Configuração dos botões para chamar as funções globais
    $('#logout-btn').on('click', logout);
    $('#create-manager-btn').on('click', registerTerceirizado);
    $('#disable-manager-btn').on('click', disableUser);

    $('#serviceSelect').change(function() {
        const selectedValue = $(this).val();
        const newData = dataSets[selectedValue];

        // Atualiza os dados do gráfico
        serviceChart.data.datasets[0].data = newData;
        serviceChart.update();
    });

});