<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-wide customizer-hide">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

        <title>RoçaPlan - Recuperar Senha</title>

        <meta name="description" content="O Sistema de Gestão da Roça" />

        <!-- Favicon -->
        <link rel="icon" type="image/x-icon"
              href="${cp}/img/logo/favicon.ico" />

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

        <!-- Page -->
        <link rel="stylesheet" href="${cp}/css/pages/page-auth.css" />

        <!-- Helpers -->
        <script src="${cp}/js/helpers.js"></script>

        <!-- Config  -->
        <script src="${cp}/js/config.js"></script>
    </head>

    <body>
        <!-- Content -->

        <div class="container-xxl">
            <div class="authentication-wrapper authentication-basic container-p-y">
                <div class="authentication-inner">
                    <!-- Forgot Password -->
                    <div class="card px-sm-6 px-0">
                        <div class="card-body">
                            <!-- Logo -->
                            <div class="app-brand justify-content-center mb-6">
                                <a href="${cp}/pages/login.jsp" class="app-brand-link gap-2">
                                    <span class="app-brand-logo demo">
                                        <img src="${cp}/img/logo/logo.svg" alt="Logo" />
                                    </span>
                                    <span class="app-brand-text demo text-heading fw-bold">RoçaPlan</span>
                                </a>
                            </div>
                            <!-- /Logo -->
                            <h4 class="mb-1">Esqueceu sua senha? 🔒</h4>
                            <p class="mb-6">
                                Digite seu e-mail e lhe enviaremos instruções
                                para redefinir sua senha.
                            </p>

                            <form id="formAuthentication" class="mb-6" action="${cp}/index.jsp">
                                <div class="mb-6">
                                    <label for="email" class="form-label">E-mail</label>
                                    <input
                                        type="email"
                                        class="form-control"
                                        id="email"
                                        name="email"
                                        placeholder="Digite seu e-mail..."
                                        maxlength="60"
                                        required
                                        autofocus />
                                </div>

                                <button class="btn btn-primary d-grid w-100">
                                    Enviar Instruções
                                </button>
                            </form>
                            <div class="text-center">
                                <a href="${cp}/pages/login.jsp"
                                   class="d-flex justify-content-center">
                                    <i class="bx bx-chevron-left scaleX-n1-rtl me-1"></i>
                                    Voltar ao Login
                                </a>
                            </div>
                        </div>
                    </div>
                    <!-- /Forgot Password -->
                </div>
            </div>
        </div>

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
    </body>
</html>
