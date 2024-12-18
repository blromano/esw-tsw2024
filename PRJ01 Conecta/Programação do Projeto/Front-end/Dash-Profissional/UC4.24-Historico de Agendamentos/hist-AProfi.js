function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("closed");
}

function markAsCompleted(button) {
    button.classList.toggle('completed');
    if (button.classList.contains('completed')) {
        button.innerText = 'Serviço realizado';
    } else {
        button.innerText = 'Serviço realizado';
    }
}