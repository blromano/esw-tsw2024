$(document).ready(function() {
    // Modal de configurações (Engrenagem)
    const $settingsModal = $('#settings-modal');
    const $gearIcon = $('.gear-icon');
    const $settingsClose = $settingsModal.find('.close');
    const $logoutBtn = $('#logout-btn');

    // Modal dos gerentes
    const $managerModal = $('#manager-modal');
    const $managerClose = $managerModal.find('.close');
    const $arrowButtons = $('.arrow-btn');
    const $managerName = $('#manager-name');
    const $managerInfo = $('#manager-info');

    // Modal para adicionar novo gestor
    const $addManagerModal = $('#add-manager-modal');
    const $addBtn = $('#add-btn');
    const $addManagerClose = $addManagerModal.find('.close');
    const $createManagerBtn = $('#create-manager-btn');

    // Modal para deletar gestor
    const $deleteManagerModal = $('#delete-manager-modal');
    const $deleteBtn = $('#delete-btn');
    const $deleteManagerClose = $deleteManagerModal.find('.close');
    const $deleteManagerBtn = $('#delete-manager-btn');

    // Abre o modal de configurações ao clicar na engrenagem
    $gearIcon.on('click', function() {
        $settingsModal.removeClass('hidden');
    });

    // Fecha o modal de configurações ao clicar no "X"
    $settingsClose.on('click', function() {
        $settingsModal.addClass('hidden');
    });

    // Fecha o modal de configurações ao clicar fora dele
    $(window).on('click', function(event) {
        if ($(event.target).is($settingsModal)) {
            $settingsModal.addClass('hidden');
        }
    });

    // Realiza o logout ao clicar no botão de logout
    $logoutBtn.on('click', function() {
        alert("Logout realizado com sucesso!");
        window.location.href = 'index.html'; // Redireciona para a tela de login
    });

    // Abre o modal do gerente ao clicar na seta
    $arrowButtons.each(function(index) {
        $(this).on('click', function() {
            const managerNames = ['Erick Victor Teixeira', 'Gestor Nome 2', 'Gestor Nome 3'];
            const managerInfos = [
                'Informações detalhadas sobre Erick Victor Teixeira.',
                'Informações detalhadas sobre Gestor Nome 2.',
                'Informações detalhadas sobre Gestor Nome 3.'
            ];

            $managerName.text(managerNames[index]);
            $managerInfo.text(managerInfos[index]);

            $managerModal.removeClass('hidden');
        });
    });

    // Fecha o modal do gerente ao clicar no "X"
    $managerClose.on('click', function() {
        $managerModal.addClass('hidden');
    });

    // Fecha o modal do gerente ao clicar fora dele
    $(window).on('click', function(event) {
        if ($(event.target).is($managerModal)) {
            $managerModal.addClass('hidden');
        }
    });

    // Abre o modal para adicionar novo gestor ao clicar no botão "Novo Gestor"
    $addBtn.on('click', function() {
        $addManagerModal.removeClass('hidden');
    });

    // Fecha o modal de adicionar novo gestor ao clicar no "X"
    $addManagerClose.on('click', function() {
        $addManagerModal.addClass('hidden');
    });

    // Fecha o modal de adicionar novo gestor ao clicar fora dele
    $(window).on('click', function(event) {
        if ($(event.target).is($addManagerModal)) {
            $addManagerModal.addClass('hidden');
        }
    });

    

    // Abre o modal para deletar gestor ao clicar no botão "Deletar Gestor"
    $deleteBtn.on('click', function() {
        $deleteManagerModal.removeClass('hidden');
    });

    // Fecha o modal de deletar gestor ao clicar no "X"
    $deleteManagerClose.on('click', function() {
        $deleteManagerModal.addClass('hidden');
    });

    // Fecha o modal de deletar gestor ao clicar fora dele
    $(window).on('click', function(event) {
        if ($(event.target).is($deleteManagerModal)) {
            $deleteManagerModal.addClass('hidden');
        }
    });

    

    
});
