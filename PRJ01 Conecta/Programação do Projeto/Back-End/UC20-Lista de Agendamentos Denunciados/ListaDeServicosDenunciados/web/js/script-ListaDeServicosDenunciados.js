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


