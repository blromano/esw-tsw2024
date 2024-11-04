function verDetalhes(button) {
    // Exibe o pop-up
    document.getElementById('popup').style.display = 'flex';

    // Define o item de denúncia atual para modificar o status posteriormente
    button.closest('.denuncia-item').classList.add('atual');
}

function fecharPopup() {
    // Fecha o pop-up
    document.getElementById('popup').style.display = 'none';
    
    // Limpa a classe 'atual' da denúncia para não afetar outras interações
    const atual = document.querySelector('.denuncia-item.atual');
    if (atual) {
        atual.classList.remove('atual');
    }
}

function confirmarAcao() {
    const suspender = document.getElementById('suspender').checked;
    const banir = document.getElementById('banir').checked;
    
    if (suspender || banir) {
        const denunciaAtual = document.querySelector('.denuncia-item.atual');
        
        // Atualiza o status para "Concluído" e altera a cor do status
        const status = denunciaAtual.querySelector('.denuncia-status');
        status.textContent = 'Concluído';
        status.classList.add('concluido');
        status.classList.remove('pendente');
        
        // Fecha o pop-up
        fecharPopup();
    } else {
        alert("Selecione uma ação (Suspender ou Banir) para confirmar.");
    }
}
document.addEventListener('DOMContentLoaded', function () {
    const suspenderCheckbox = document.getElementById('suspender');
    const banirCheckbox = document.getElementById('banir');

    // Quando 'Suspender' é marcado, desmarque 'Banir'
    suspenderCheckbox.addEventListener('change', function () {
        if (suspenderCheckbox.checked) {
            banirCheckbox.checked = false;
        }
    });

    // Quando 'Banir' é marcado, desmarque 'Suspender'
    banirCheckbox.addEventListener('change', function () {
        if (banirCheckbox.checked) {
            suspenderCheckbox.checked = false;
        }
    });
});