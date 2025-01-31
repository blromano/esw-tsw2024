<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-wide customizer-hide">    
    <head>
        <components:header title="Recuperar Senha" cp="${cp}" />
        <link rel="stylesheet" href="${cp}/css/pages/page-auth.css" />
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

        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>
    </body>
</html>
