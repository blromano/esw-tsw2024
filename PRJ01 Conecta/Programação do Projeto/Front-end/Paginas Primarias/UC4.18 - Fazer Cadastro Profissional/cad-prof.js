// Função para exibir a imagem selecionada
document.getElementById('fileInput').addEventListener('change', function(event) {
    const file = event.target.files[0]; // Obtém o arquivo selecionado
    const reader = new FileReader(); // Cria um leitor de arquivos
    
    // Quando o arquivo for carregado, exibimos a imagem
    reader.onload = function(e) {
        const preview = document.getElementById('preview');
        preview.src = e.target.result; // Define o src da imagem para a imagem carregada
        preview.style.display = 'block'; // Exibe a imagem
    };
    
    // Lê o arquivo como URL de dados
    if (file) {
        reader.readAsDataURL(file);
    }
});