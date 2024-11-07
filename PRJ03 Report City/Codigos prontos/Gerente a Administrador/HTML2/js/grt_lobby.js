$(document).ready(function() {
    // Configuração do gráfico
    const ctx = $('#serviceChart')[0].getContext('2d');
    const serviceChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Chamados Realizados', 'Chamados Respondidos', 'Chamados Não Respondidos'],
            datasets: [{
                label: 'Número de Chamados',
                data: [12, 8, 4], // Valores de exemplo
                backgroundColor: ['#37623A', '#3A6642', '#14273D'],
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

    // Abrir modal de Terceirizados ao clicar no botão correspondente
    $('.segment-control').on('click', function() {
        $('#terceirizadosModal').removeClass('hidden');
    });

    // Abrir modal de Configurações (Engrenagem)
    $('.settings-icon').on('click', function() {
        $('#settingsModal').removeClass('hidden');
    });

    // Funções para abrir e fechar os modais dos cidadãos
    $('[data-citizen]').on('click', function() {
        const citizen = $(this).data('citizen');
        $(`#${citizen}Modal`).removeClass('hidden');
    });

    // Funções para fechar os modais
    $('[data-close]').on('click', function() {
        const modalId = $(this).data('close');
        $(`#${modalId}Modal`).addClass('hidden');
    });

    // Funções para abrir e fechar os modais de detalhes dos terceirizados
    $('[data-details]').on('click', function() {
        const detailsId = $(this).data('details');
        $(`#${detailsId}Modal`).removeClass('hidden');
    });

    // Funções para abrir e fechar os modais de chat
    $('[data-chat]').on('click', function() {
        const chatService = $(this).data('chat');
        $(`#${chatService}Modal`).removeClass('hidden');
    });

    $('[data-close-chat]').on('click', function() {
        const chatService = $(this).data('close-chat');
        $(`#${chatService}Modal`).addClass('hidden');
    });

    // Abrir modal para cadastrar terceirizado
    $('.cadastrar-btn').on('click', function() {
        $('#cadastrarTerceirizadoModal').removeClass('hidden');
    });

    // Fechar modal de cadastrar terceirizado
    $('[data-close="cadastrarTerceirizado"]').on('click', function() {
        $('#cadastrarTerceirizadoModal').addClass('hidden');
    });

    // Abrir modal de desabilitar usuário
    $('.disable-btn').on('click', function() {
        $('#disableUserModal').removeClass('hidden');
    });

    // Função para fechar o modal de desabilitar usuário
    function closeDisableUserModal() {
        $('#disableUserModal').addClass('hidden');
    }

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
});
