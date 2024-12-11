function showSection(section) {
    const sections = document.querySelectorAll('.content-section');
    const menuItems = document.querySelectorAll('.menu-item');

    // Esconde todas as seções
    sections.forEach(sec => sec.classList.remove('active'));

    // Remove a classe 'active' dos itens de menu
    menuItems.forEach(item => item.classList.remove('active'));

    // Mostra a seção selecionada
    document.getElementById(section).classList.add('active');

    // Marca o item de menu como ativo
    const activeMenuItem = document.querySelector(`.menu-item:nth-child(${section === 'dados' ? 1 : section === 'avaliacoes' ? 2 : 3})`);
    if (activeMenuItem) {
        activeMenuItem.classList.add('active');
    }
}

function editarInformacoes() {
    alert('Abrir formulário para editar informações do usuário');
}

function alterarSenha() {
    alert('Abrir formulário para alterar a senha');
}

function goBack() {
    window.history.back();  // Simula a ação de voltar para a página anterior
}
