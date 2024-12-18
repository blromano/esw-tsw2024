window.addEventListener('scroll', () => {
  const navbar = document.getElementById('navbar');
  const carouselSection = document.querySelector('.slide-imagens');
  const scrollPosition = window.scrollY;

  if (scrollPosition > carouselSection.offsetHeight - navbar.offsetHeight) {
    navbar.style.backgroundColor = '#ffc800';
  } else {
    navbar.style.backgroundColor = 'transparent';
  }
});

//Sessão do slide de imagens

let currentSlide = 0;
const slideInterval = 3000; // Tempo em milissegundos para avançar a cada 3 segundos

function showSlide(slideIndex) {
    const slides = document.querySelector('.carrosel-imagens');
    const totalSlides = document.querySelectorAll('.imagens').length;

    if (slideIndex >= totalSlides) {
        currentSlide = 0; // Volta ao primeiro slide
    } else if (slideIndex < 0) {
        currentSlide = totalSlides - 1; // Volta ao último slide
    } else {
        currentSlide = slideIndex;
    }

    slides.style.transform = 'translateX(' + (-currentSlide * 100) + '%)';
}

function moveSlide(direction) {
    showSlide(currentSlide + direction);
}

// Inicializa o carrossel mostrando o primeiro slide
showSlide(currentSlide);

// Função para avançar automaticamente os slides
setInterval(() => {
  moveSlide(1); // Avança para o próximo slide
}, slideInterval);

