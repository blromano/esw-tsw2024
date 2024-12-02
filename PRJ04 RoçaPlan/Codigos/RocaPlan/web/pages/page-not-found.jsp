<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

        <title>RoçaPlan - Página Não Encontrada</title>

        <meta name="description" content="O Sistema de Gestão da Roça" />

        <!-- Favicon -->
        <link rel="icon" type="image/x-icon" href="${cp}/img/logo/favicon.ico" />

        <!-- Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link
            href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
            rel="stylesheet" />

        <link rel="stylesheet" href="${cp}/fonts/boxicons.css" />

        <!-- Core CSS -->
        <link rel="stylesheet" href="${cp}/css/libs/bootstrap/core.css" class="template-customizer-core-css" />
        <link rel="stylesheet" href="${cp}/css/theme-default.css" class="template-customizer-theme-css" />
        <link rel="stylesheet" href="${cp}/css/demo.css" />

        <!-- Vendors CSS -->
        <link rel="stylesheet" href="${cp}/css/libs/perfect-scrollbar/perfect-scrollbar.css" />

        <!-- Helpers -->
        <script src="${cp}/js/helpers.js"></script>

        <!-- Config  -->
        <script src="${cp}/js/config.js"></script>
    </head>

    <body>
        <!-- Content -->

        <!-- Error -->
        <div class="container-xxl container-p-y">
            <div class="misc-wrapper">
                <h1 class="mb-2 mx-2"
                    style="line-height: 6rem; font-size: 6rem">404</h1>
                <h4 class="mb-2 mx-2">Página Não Encontrada ⚠️</h4>
                <p class="mb-6 mx-2">Não encontramos a página que você procura.</p>
                <a href="${cp}/index.jsp" class="btn btn-primary">Voltar a Dashboard</a>
            </div>
        </div>
        <!-- /Error -->

        <!-- / Content -->

        <!-- Core JS -->
        <!-- build:js assets/vendor/js/core.js -->

        <script src="${cp}/js/libs/jquery/jquery.js"></script>
        <script src="${cp}/js/libs/popper/popper.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>

        <script async defer src="https://buttons.github.io/buttons.js"></script>
    </body>
</html>
