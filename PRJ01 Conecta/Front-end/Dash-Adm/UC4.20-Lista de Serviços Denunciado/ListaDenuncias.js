// Função para alternar entre as seções
function mostrarSessao(sessao) {
    const sections = document.querySelectorAll('.section');
    sections.forEach(section => {
        section.classList.remove('active');
    });
    
    const targetSection = document.getElementById(sessao);
    if (targetSection) {
        targetSection.classList.add('active');
    }
}

// Função para alterar o status de uma denúncia
function alterarStatus() {
    const status = document.querySelector('.status');
    const currentStatus = status.classList.contains('pendente') ? 'pendente' : 
                          status.classList.contains('resolvido-amarelo') ? 'resolvido-amarelo' : 'resolvido';

    let newStatus;
    if (currentStatus === 'pendente') {
        newStatus = 'resolvido-amarelo';
    } else if (currentStatus === 'resolvido-amarelo') {
        newStatus = 'resolvido';
    } else {
        newStatus = 'pendente';
    }

    status.classList.remove('pendente', 'resolvido', 'resolvido-amarelo');
    status.classList.add(newStatus);

    alert('Status alterado para ' + newStatus);
}

// Função para mostrar o popup de suspensão ou banimento
function mostrarPopup(tipo) {
    const popup = document.getElementById('popup');
    const popupTitle = document.getElementById('popup-title');
    
    if (tipo === 'suspender') {
        popupTitle.innerHTML = 'Suspender Usuário';
    } else if (tipo === 'banir') {
        popupTitle.innerHTML = 'Banir Usuário';
    }

    popup.style.display = 'block';
}

// Função para fechar o popup
function fecharPopup() {
    const popup = document.getElementById('popup');
    popup.style.display = 'none';
}

// Função para confirmar a ação de suspensão ou banimento
function confirmarAction() {
    const userSearch = document.getElementById('searchUser').value;
    if (userSearch) {
        alert('Ação confirmada para o usuário: ' + userSearch);
    } else {
        alert('Nenhum usuário encontrado.');
    }

    fecharPopup();
}

// Função para simular o logout
function sair() {
    alert("Você saiu da sua conta.");
    // Aqui você pode adicionar lógica para redirecionar para uma página de login, se necessário.
}
