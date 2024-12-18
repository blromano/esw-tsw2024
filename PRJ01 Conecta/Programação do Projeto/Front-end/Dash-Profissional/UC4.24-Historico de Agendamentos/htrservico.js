// Array que contém os serviços
const services = [
    {
        type: 'Eletricista',
        professional: 'João Silva',
        time: '14:00',
        date: '14/10/2024',
        rating: 5,
        status: 'Finalizado'
    },
    {
        type: 'Encanador',
        professional: 'Lucas Mendes',
        time: '10:00',
        date: '15/10/2024',
        rating: null,
        status: 'Agendado'
    }
  ];
  
  // Função para renderizar os serviços
  function renderServices() {
    const serviceContainer = document.getElementById('services');
    serviceContainer.innerHTML = '';
  
    // Ordena os serviços para que os agendados apareçam primeiro
    services.sort((a, b) => {
        if (a.status === 'Agendado' && b.status !== 'Agendado') return -1;
        if (b.status === 'Agendado' && a.status !== 'Agendado') return 1;
        return 0;
    });
  
    // Cria a exibição de cada serviço
    services.forEach((service, index) => {
        const ticket = document.createElement('div');
        ticket.className = 'ticket';
  
        let actions = '';
        let ratingInfo = service.status !== 'Cancelado' ? `<p>Avaliação: ${service.rating ? service.rating + ' estrelas' : 'N/A'}</p>` : '';
  
        // Define ações com base no status do serviço
        if (service.status === 'Finalizado') {
            actions = `
                <button class="fav-button" data-index="${index}">&#9733; Favoritar</button>
                <button class="rate-button" data-index="${index}">Avaliar Serviço</button>
                <button class="report-button" data-index="${index}">Fazer Denúncia</button>
            `;
        } else if (service.status === 'Agendado') {
            actions = `<button class="cancel-button" data-index="${index}">Cancelar Agendamento</button>`;
        }
  
        // Adiciona as informações do serviço e as ações ao ticket
        ticket.innerHTML = `
            <h2>${service.type}</h2>
            <p>Nome do profissional: ${service.professional}</p>
            <p>Horário: ${service.time}</p>
            <p>Data: ${service.date}</p>
            ${ratingInfo}
            <p>Status: ${service.status}</p>
            ${actions}
        `;
  
        serviceContainer.appendChild(ticket);
    });
  
    // Adiciona os ouvintes de eventos para os botões
    addEventListeners();
  }
  
  // Função para adicionar ouvintes de eventos a todos os botões
  function addEventListeners() {
    document.querySelectorAll('.fav-button').forEach(button => {
        button.addEventListener('click', event => {
            const index = event.target.getAttribute('data-index');
            showFavoritePopup(index);
        });
    });
  
    document.querySelectorAll('.cancel-button').forEach(button => {
        button.addEventListener('click', event => {
            const index = event.target.getAttribute('data-index');
            showCancelPopup(index);
        });
    });
  
    document.querySelectorAll('.report-button').forEach(button => {
        button.addEventListener('click', event => {
            const index = event.target.getAttribute('data-index');
            showReportPopup(index);
        });
    });
  
    document.querySelectorAll('.rate-button').forEach(button => {
        button.addEventListener('click', event => {
            const index = event.target.getAttribute('data-index');
            showRatingPopup(index);
        });
    });
  }
  
  // Função para mostrar o popup de favoritar
  function showFavoritePopup(index) {
    const popup = document.createElement('div');
    popup.className = 'popup';
    popup.innerHTML = `
        <div class="popup-content">
            <p>Deseja Favoritar Profissional?</p>
            <button class="cancel-fav-button">Cancelar</button>
            <button class="confirm-fav-button" data-index="${index}">Confirmar</button>
        </div>
    `;
    document.body.appendChild(popup);
  
    // Eventos para cancelar ou confirmar favoritar
    document.querySelector('.cancel-fav-button').addEventListener('click', () => {
        document.body.removeChild(popup);
    });
  
    document.querySelector('.confirm-fav-button').addEventListener('click', event => {
        const button = document.querySelector(`.fav-button[data-index="${index}"]`);
        button.classList.toggle('favorited');
        button.textContent = button.classList.contains('favorited') ? '★ Favoritado' : '☆ Favoritar';
        document.body.removeChild(popup);
    });
  }
  
  // Função para mostrar o popup de cancelamento
  function showCancelPopup(index) {
    const popup = document.createElement('div');
    popup.className = 'popup';
    popup.innerHTML = `
        <div class="popup-content">
            <p>Deseja cancelar o agendamento?</p>
            <button class="back-button">Voltar</button>
            <button class="confirm-button" data-index="${index}">Confirmar</button>
        </div>
    `;
    document.body.appendChild(popup);
  
    // Eventos para voltar ou confirmar cancelamento
    document.querySelector('.back-button').addEventListener('click', () => {
        document.body.removeChild(popup);
    });
  
    document.querySelector('.confirm-button').addEventListener('click', event => {
        services[index].status = 'Cancelado'; // Atualiza o status do serviço
        document.body.removeChild(popup);
        renderServices(); // Re-renderiza os serviços
    });
  }
  
  // Função para mostrar o popup de denúncia
  function showReportPopup(index) {
    const popup = document.createElement('div');
    popup.className = 'popup';
    popup.innerHTML = `
        <div class="popup-content">
            <h3>Qual sua denúncia?</h3>
            <p>Por favor, nos conte em detalhe seu problema:</p>
            <textarea id="report-text" rows="4" cols="50"></textarea><br>
            <button class="cancel-report-button">Cancelar</button>
            <button class="confirm-report-button" data-index="${index}">Denunciar</button>
        </div>
    `;
    document.body.appendChild(popup);
  
    // Eventos para cancelar ou confirmar denúncia
    document.querySelector('.cancel-report-button').addEventListener('click', () => {
        document.body.removeChild(popup);
    });
  
    document.querySelector('.confirm-report-button').addEventListener('click', () => {
        const reportText = document.getElementById('report-text').value;
        if (reportText) {
            console.log(`Denúncia enviada para o serviço ${index}: ${reportText}`);
            document.body.removeChild(popup);
        } else {
            alert('Por favor, preencha o motivo da denúncia.');
        }
    });
  }
  
  // Função para mostrar o popup de avaliação
  function showRatingPopup(index) {
    const popup = document.createElement('div');
    popup.className = 'popup';
    popup.innerHTML = `
        <div class="popup-content">
            <p>Avalie o profissional.</p>
            <div>
                <span class="rating-bubble" data-rating="1">1</span>
                <span class="rating-bubble" data-rating="2">2</span>
                <span class="rating-bubble" data-rating="3">3</span>
                <span class="rating-bubble" data-rating="4">4</span>
                <span class="rating-bubble" data-rating="5">5</span>
            </div>
            <p>Observação:</p>
            <textarea id="observation-text" rows="4" cols="50"></textarea><br>
            <button class="cancel-fav-button">Cancelar</button>
            <button class="confirm-rating-button" data-index="${index}">Avaliar</button>
        </div>
    `;
    document.body.appendChild(popup);
  
    let selectedRating = null;
  
    // Adiciona evento de clique para as bolinhas de avaliação
    document.querySelectorAll('.rating-bubble').forEach(bubble => {
        bubble.addEventListener('click', () => {
            selectedRating = bubble.getAttribute('data-rating');
            document.querySelectorAll('.rating-bubble').forEach(b => b.classList.remove('selected'));
            bubble.classList.add('selected');
        });
    });
  
    // Eventos para cancelar ou confirmar avaliação
    document.querySelector('.cancel-fav-button').addEventListener('click', () => {
        document.body.removeChild(popup);
    });
  
    document.querySelector('.confirm-rating-button').addEventListener('click', () => {
        const observationText = document.getElementById('observation-text').value;
        if (selectedRating) {
            services[index].rating = selectedRating; // Atualiza a avaliação do serviço
            console.log(`Avaliação enviada para o serviço ${index}: ${selectedRating} estrelas. Observação: ${observationText}`);
            document.body.removeChild(popup);
            renderServices(); // Re-renderiza os serviços
        } else {
            alert('Por favor, selecione uma avaliação.');
        }
    });
  }
  
  // Inicializa a renderização dos serviços
  renderServices();
  