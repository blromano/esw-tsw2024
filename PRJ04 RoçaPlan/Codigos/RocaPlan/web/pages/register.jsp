<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-wide customizer-hide">
    <head>
        <components:header title="Cadastro" cp="${cp}" />
        <link rel="stylesheet" href="${cp}/css/pages/page-auth.css" />
    </head> 

    <body>
        <!-- Content -->

        <div class="container-xxl">
            <div class="authentication-wrapper authentication-basic container-p-y">
                <div class="authentication-inner">
                    <!-- Register Card -->
                    <div class="card px-sm-6 px-0">
                        <div class="card-body">
                            <!-- Logo -->
                            <div class="app-brand justify-content-center mb-6">
                                <a href="${cp}/index.jsp" class="app-brand-link gap-2">
                                    <span class="app-brand-logo demo">
                                        <img src="${cp}/img/logo/logo.svg" alt="Logo" />
                                    </span>
                                    <span
                                        class="app-brand-text demo text-heading fw-bold">RoçaPlan</span>
                                </a>
                            </div>
                            <!-- /Logo -->
                            <h4 class="mb-1">Cultive seu sucesso 🚀</h4>
                            <p class="mb-6">
                                Simplifique a administração da sua roça com
                                facilidade e eficiência!
                            </p>

                            <form id="formAuthentication" class="mb-6" action="${cp}/login.jsp">
                                <div class="mb-6">
                                    <label for="name" class="form-label">Nome Completo</label>
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="name"
                                        name="name"
                                        maxlength="60"
                                        placeholder="Digite seu nome completo..."
                                        required
                                        autofocus />
                                </div>

                                <div class="mb-6">
                                    <label for="email" class="form-label">E-mail</label>
                                    <input type="email" class="form-control" id="email"
                                           name="email" placeholder="Digite seu e-mail..." required />
                                </div>

                                <div class="mb-6 form-password-toggle">
                                    <label class="form-label" for="password">
                                        Senha
                                        <i class="bx bx-info-circle fs-6" data-bs-toggle="tooltip"
                                           data-bs-placement="right"
                                           data-bs-title="A senha deve conter no mínimo 8 caracteres, entre eles um caractere especial, uma letra maiúscula e um número."></i>
                                    </label>

                                    <div class="input-group input-group-merge">
                                        <input
                                            type="password"
                                            id="password"
                                            class="form-control"
                                            name="password"
                                            placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
                                            aria-describedby="password"
                                            required
                                            minlength="8" />

                                        <span class="input-group-text cursor-pointer">
                                            <i class="bx bx-hide"></i>
                                        </span>
                                    </div>
                                </div>

                                <div class="mb-6 form-password-toggle">
                                    <label class="form-label" for="password">
                                        Confirmar Senha
                                    </label>

                                    <div class="input-group input-group-merge">
                                        <input
                                            type="password"
                                            id="confirm-password"
                                            class="form-control"
                                            name="confirm-password"
                                            placeholder="&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;&#xb7;"
                                            aria-describedby="password"
                                            required
                                            minlength="8" />

                                        <span class="input-group-text cursor-pointer">
                                            <i class="bx bx-hide"></i>
                                        </span>
                                    </div>
                                </div>

                                <button class="btn btn-primary d-grid w-100">Cadastrar</button>
                            </form>

                            <p class="text-center">
                                <span>Já possui uma conta?</span>
                                <a href="${cp}/pages/login.jsp">
                                    <span>Faça o login</span>
                                </a>
                            </p>
                        </div>
                    </div>
                    <!-- Register Card -->
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
