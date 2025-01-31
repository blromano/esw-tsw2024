<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <components:header title="Página Não Encontrada" cp="${cp}" />
        <link rel="stylesheet" href="${cp}/css/pages/page-misc.css">
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

        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>

        <script async defer src="https://buttons.github.io/buttons.js"></script>
    </body>
</html>
