function verDetalhes(button) {
    
    document.getElementById('popup').style.display = 'flex';

    
    button.closest('.denuncia-item').classList.add('atual');
}

function fecharPopup() {
   
    document.getElementById('popup').style.display = 'none';
    
    
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
        
        
        const status = denunciaAtual.querySelector('.denuncia-status');
        status.textContent = 'Concluído';
        status.classList.add('concluido');
        status.classList.remove('pendente');
        
        
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