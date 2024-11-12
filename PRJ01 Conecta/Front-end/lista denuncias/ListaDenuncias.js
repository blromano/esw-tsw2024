function verDetalhes(button) {
    // Abre o popup e adiciona a classe 'atual' ao item de denúncia correspondente
    document.getElementById('popup').style.display = 'flex';
    button.closest('.denuncia-item').classList.add('atual');
}

function fecharPopup() {
    // Fecha o popup e remove a classe 'atual' de qualquer item que a tenha
    document.getElementById('popup').style.display = 'none';
    const atual = document.querySelector('.denuncia-item.atual');
    if (atual) {
        atual.classList.remove('atual');
    }
}

function confirmarAcao() {
    const suspender = document.getElementById('suspender').checked;
    const banir = document.getElementById('banir').checked;
    const motivo = document.getElementById('motivo').value.trim();

    // Validações
    if (!suspender && !banir) {
        alert("Por favor, selecione uma ação (Suspender ou Banir).");
        return;
    }

    if (motivo === "") {
        alert("Por favor, explique o motivo da ação.");
        return;
    }

    // Encontra o item de denúncia ativo
    const denunciaAtual = document.querySelector('.denuncia-item.atual');
    if (denunciaAtual) {
        // Atualiza o status para "Concluído"
        const statusElement = denunciaAtual.querySelector('.denuncia-status');
        if (statusElement) {
            statusElement.textContent = "Concluído";
            statusElement.classList.add("concluido");
        }
    } else {
        console.error("Nenhum item de denúncia ativo encontrado!");
    }

    alert("Denúncia marcada como concluída!");
    fecharPopup();
}
document.addEventListener('DOMContentLoaded', function () {
    const suspenderCheckbox = document.getElementById('suspender');
    const banirCheckbox = document.getElementById('banir');

    // Quando 'Suspender' é marcado, desmarca 'Banir'
    suspenderCheckbox.addEventListener('change', function () {
        if (suspenderCheckbox.checked) {
            banirCheckbox.checked = false;
        }
    });

    // Quando 'Banir' é marcado, desmarca 'Suspender'
    banirCheckbox.addEventListener('change', function () {
        if (banirCheckbox.checked) {
            suspenderCheckbox.checked = false;
        }
    });
});
