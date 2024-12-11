
$(document).ready(function () {
    
    console.log(dadosMoradorColetor);
    
    const redirecionarMapaLogin = $("#redirecionarMapaLogin");
    let url = redirecionarMapaLogin.attr("href");
    url = url.replace("login.jsp","mapa.jsp");
    
    if (dadosMoradorColetor !== null) {
        redirecionarMapaLogin.attr("href",url);
    }
});