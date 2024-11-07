// Primeira Tarefa
$('#tarefa01').click(function() {
    $('#modalTarefa01').removeClass('hidden');
});

$('#mTarefa01').click(function() {
    $('#modalTarefa01').addClass('hidden');
});

$('#abrirCidadosPorTarefa01').click(function() {
    $('#modalTarefa01').addClass('hidden');
    $('#gabriellyModal').removeClass('hidden');
});

$('#cidadaoTarefa1').click(function() {
    $('#gabriellyModal').addClass('hidden');
    $('#modalTarefa01').removeClass('hidden');
});

// Segunda Tarefa
$('#tarefa02').click(function() {
    $('#modalTarefa02').removeClass('hidden');
});

$('#mTarefa02').click(function() {
    $('#modalTarefa02').addClass('hidden');
});

$('#abrirCidadosPorTarefa02').click(function() {
    $('#modalTarefa02').addClass('hidden');
    $('#outroModal').removeClass('hidden');
});

$('#cidadaoTarefa2').click(function() {
    $('#outroModal').addClass('hidden');
    $('#modalTarefa02').removeClass('hidden');
});

// Terceira Tarefa
$('#tarefa03').click(function() {
    $('#modalTarefa03').removeClass('hidden');
});

$('#mTarefa03').click(function() {
    $('#modalTarefa03').addClass('hidden');
});

$('#abrirCidadosPorTarefa03').click(function() {
    $('#modalTarefa03').addClass('hidden');
    $('#mais_umModal').removeClass('hidden');
});

$('#cidadaoTarefa3').click(function() {
    $('#mais_umModal').addClass('hidden');
    $('#modalTarefa03').removeClass('hidden');
});