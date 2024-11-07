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