function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("closed");
}

// Função para abrir o modal de cadastro de serviço
function toggleForm() {
    const modal = document.getElementById('service-modal');
    modal.style.display = 'block';
}

// Função para fechar o modal de cadastro de serviço
function closeForm() {
    const modal = document.getElementById('service-modal');
    modal.style.display = 'none';
}

// Função para cadastrar um serviço
document.getElementById('serviceForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const serviceName = document.getElementById('service-name').value;
    const serviceDescription = document.getElementById('service-description').value;
    
    const serviceItem = document.createElement('li');
    serviceItem.innerHTML = `
        <span><strong>${serviceName}</strong>: ${serviceDescription}</span>
        <div class="service-actions">
            <i class="fas fa-eye" data-title="Visualizar" onclick="confirmAction('visualizar', '${serviceName}', '${serviceDescription}')"></i>
            <i class="fas fa-edit" data-title="Editar" onclick="confirmAction('editar', '${serviceName}', '${serviceDescription}')"></i>
            <i class="fas fa-trash" data-title="Excluir" onclick="confirmAction('excluir', '${serviceName}', '${serviceDescription}')"></i>
        </div>
    `;
    
    document.getElementById('service-list').appendChild(serviceItem);
    
    // Limpar o formulário
    document.getElementById('service-name').value = '';
    document.getElementById('service-description').value = '';
    closeForm(); // Fechar o modal
});

// Função para confirmar ação (Visualizar, Editar, Excluir)
function confirmAction(action, name, description) {
    let message = '';
    let confirmed = false;

    switch (action) {
        case 'visualizar':
            message = `Você deseja visualizar o serviço "${name}"?`;
            confirmed = confirm(message);
            if (confirmed) viewService(name, description);
            break;
        case 'editar':
            message = `Você deseja editar o serviço "${name}"?`;
            confirmed = confirm(message);
            if (confirmed) editService(name, description);
            break;
        case 'excluir':
            message = `Você deseja excluir o serviço "${name}"?`;
            confirmed = confirm(message);
            if (confirmed) deleteService(name);
            break;
    }
}

// Função para visualizar o serviço
function viewService(name, description) {
    alert(`Visualizar Serviço:\nNome: ${name}\nDescrição: ${description}`);
}

// Função para editar o serviço
function editService(name, description) {
    const newName = prompt('Novo Nome do Serviço:', name);
    const newDescription = prompt('Nova Descrição:', description);
    
    if (newName && newDescription) {
        const serviceItems = document.querySelectorAll('#service-list li');
        serviceItems.forEach(item => {
            if (item.querySelector('span').textContent.includes(name)) {
                item.querySelector('span').innerHTML = `<strong>${newName}</strong>: ${newDescription}`;
            }
        });
    }
}

// Função para excluir o serviço
function deleteService(name) {
    const serviceItems = document.querySelectorAll('#service-list li');
    serviceItems.forEach(item => {
        if (item.querySelector('span').textContent.includes(name)) {
            item.remove();
        }
    });
}
