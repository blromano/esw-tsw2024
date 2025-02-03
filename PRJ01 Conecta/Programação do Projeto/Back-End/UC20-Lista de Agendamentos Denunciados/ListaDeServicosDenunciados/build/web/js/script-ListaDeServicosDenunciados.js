function toggleSidebar() {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.toggle("closed");
}

document.addEventListener('DOMContentLoaded', function () {
    const sidebar = document.getElementById("sidebar");
    sidebar.classList.add("closed");  // Adiciona a classe 'closed' logo ao carregar
});

