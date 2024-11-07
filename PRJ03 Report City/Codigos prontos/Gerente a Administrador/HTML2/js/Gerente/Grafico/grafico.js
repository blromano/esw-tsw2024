// Configuração do gráfico
const ctx = $('#serviceChart')[0].getContext('2d');
const serviceChart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Chamados Realizados', 'Chamados Respondidos', 'Chamados Não Respondidos'],
        datasets: [{
            label: 'Número de Chamados',
            data: [52, 34, 18], // Valores de exemplo inicial
            backgroundColor: ['#65c368', '#3A6642', '#14273D'],
        }]
    },
    options: {
        responsive: true,
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

// Valores dos chamados para cada opção
const dataSets = {
    'geral': [52, 34, 18],
    'buraco': [12, 8, 4],
    'rede': [14, 9, 5],
    'encanamento': [16, 10, 6],
    'postes': [10, 7, 3]
};

// Estado ínicial do botão gráfico
$('#btnControlGrafico').removeClass('bg-gray-200 text-black').addClass('bg-green-800 text-white');