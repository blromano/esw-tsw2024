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
    const motivo = document.getElementById('motivo').value.trim();
    const statusElement = document.getElementById('denuncia-status'); 

    // Validações
    if (!suspender && !banir) {
        alert("Por favor, selecione uma ação (Suspender ou Banir).");
        return;
    }

    if (motivo === "") {
        alert("Por favor, explique o motivo da ação.");
        return;
    }

    // Log para depuração
    console.log("Ação confirmada:");
    console.log({
        acao: suspender ? "Suspensão" : "Banimento",
        motivo: motivo,
    });

    // Atualiza o status para "Concluído"
    if (statusElement) {
        statusElement.textContent = "Concluído";
        statusElement.classList.remove("pendente");
        statusElement.classList.add("concluido");
        alert("Denúncia marcada como concluída!");
    } else {
        console.error("Elemento statusDenuncia não encontrado!");
    }

    fecharPopup();
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
     // Função para filtrar denúncias com base no texto digitado
     function filtrarDenuncias() {
        const termo = document.getElementById('barraPesquisa').value.toLowerCase();
        const lista = document.getElementById('listaDenuncias');
        const itens = lista.getElementsByClassName('denuncia-item');

        Array.from(itens).forEach(item => {
            const titulo = item.querySelector('.denuncia-titulo').textContent.toLowerCase();
            const descricao = item.querySelector('.denuncia-descricao').textContent.toLowerCase();

            if (titulo.includes(termo) || descricao.includes(termo)) {
                item.style.display = '';
            } else {
                item.style.display = 'none';
            }
        });
    }
    function confirmarAcao() {
        const suspender = document.getElementById('suspender').checked;
        const banir = document.getElementById('banir').checked;
        const motivo = document.getElementById('motivo').value.trim();
    
        if (!suspender && !banir) {
            alert("Por favor, selecione uma ação (Suspender ou Banir).");
            return;
        }
    
        if (motivo === "") {
            alert("Por favor, explique o motivo da ação.");
            return;
        }
    
        // Lógica para processar a suspensão ou banimento com o motivo
        console.log({
            acao: suspender ? "Suspensão" : "Banimento",
            motivo: motivo,
        });
    
        alert("Ação confirmada com sucesso!");
        fecharPopup();
    }
    