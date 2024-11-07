$('.btn').click(function() {
    // Remove active state from all buttons
    $('.btn').removeClass('bg-green-800 text-white').addClass('bg-gray-200 text-black');
    // Add active state to the clicked button
    $(this).removeClass('bg-gray-200 text-black').addClass('bg-green-800 text-white');
});

$('#graficoContent').show();
    //$('#terceirizadoContent').show();
            
            // Button click events to switch content
            $('#btnControlGrafico').click(function() {
                $('#graficoContent').show();
                $('#cidadaoContent, #terceirizadoContent, #taskContent').hide();
            });

            $('#btnControlCidadao').click(function() {
                $('#cidadaoContent').show();
                $('#graficoContent, #terceirizadoContent, #taskContent').hide();
            });

            $('#btnControlTerceirizado').click(function() {
                $('#terceirizadoContent').show();
                $('#graficoContent, #cidadaoContent, #taskContent').hide();
            });

            $('#btnControlTasks').click(function() {
                $('#taskContent').show();
                $('#graficoContent, #cidadaoContent, #terceirizadoContent').hide();
            });