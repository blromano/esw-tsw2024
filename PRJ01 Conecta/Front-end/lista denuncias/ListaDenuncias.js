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
function filtrarDenuncias() {
    // Obtém o valor da barra de pesquisa e converte para minúsculas
    const termoPesquisa = document.getElementById('barraPesquisa').value.toLowerCase();

    // Seleciona todos os itens de denúncia
    const denuncias = document.querySelectorAll('.denuncia-item');
    
    // Se a barra de pesquisa estiver vazia, exibe todas as denúncias
    if (termoPesquisa === "") {
        denuncias.forEach(denuncia => {
            denuncia.style.display = ''; // Exibe todas as denúncias
        });
        return;
    }

    // Caso contrário, realiza a pesquisa
    denuncias.forEach(denuncia => {
        // Obtém o título e a descrição da denúncia e converte para minúsculas
        const titulo = denuncia.querySelector('.denuncia-titulo').innerText.toLowerCase();
        const descricao = denuncia.querySelector('.denuncia-descricao').innerText.toLowerCase();

        // Verifica se o título ou a descrição contêm o termo de pesquisa
        if (titulo.includes(termoPesquisa) || descricao.includes(termoPesquisa)) {
            // Exibe a denúncia se houver correspondência
            denuncia.style.display = '';
        } else {
            // Oculta a denúncia se não houver correspondência
            denuncia.style.display = 'none';
        }
    });
}
function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("closed");

    // Alterar o símbolo do botão com base no estado da sidebar
    const toggleBtn = document.querySelector(".toggle-btn");
    toggleBtn.textContent = sidebar.classList.contains("closed") ? "➔" : "➖";
}

