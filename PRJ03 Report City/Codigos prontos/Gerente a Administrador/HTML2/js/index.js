$(document).ready(function() {
    const $emailInput = $('#email');
    const $passwordInput = $('#password');
    const $loginBtn = $('#login-btn');
    const $gerenteOption = $('#gerente-option');
    const $admOption = $('#adm-option');
    const $gerenteLabel = $('#gerente-label');
    const $admLabel = $('#adm-label');

    function validateForm() {
        if ($emailInput.val().trim() && $passwordInput.val().trim()) {
            $loginBtn.addClass('bg-green-800 text-white cursor-pointer');
            $loginBtn.removeClass('cursor-not-allowed');
            $loginBtn.prop('disabled', false);
        } else {
            $loginBtn.addClass('cursor-not-allowed');
            $loginBtn.removeClass('bg-green-800 text-white cursor-pointer');
            $loginBtn.prop('disabled', true);
        }
    }

    function updateRoleSelection() {
        if ($gerenteOption.is(':checked')) {
            $gerenteLabel.addClass('bg-green-700 text-white');
            $admLabel.removeClass('bg-green-700 text-white').addClass('bg-gray-200 text-blue-900');
        } else if ($admOption.is(':checked')) {
            $admLabel.addClass('bg-green-700 text-white');
            $gerenteLabel.removeClass('bg-green-700 text-white').addClass('bg-gray-200 text-blue-900');
        }
    }

    $gerenteOption.on('change', updateRoleSelection);
    $admOption.on('change', updateRoleSelection);

    $loginBtn.click(function() {
        if (!$loginBtn.prop('disabled')) {
            if ($admOption.is(':checked')) {
                window.location.href = 'adm_lobby copy.html';
            } else if ($gerenteOption.is(':checked')) {
                window.location.href = 'grt_lobby copy.html';
            }
        }
    });

    $emailInput.on('input', validateForm);
    $passwordInput.on('input', validateForm);

    // Atualiza a seleção de papel quando a página carrega
    updateRoleSelection();

    // Desabilita o botão de login inicialmente
    $loginBtn.prop('disabled', true);
    validateForm(); // Certifica-se de que o botão de login esteja na condição correta ao carregar a página
});
