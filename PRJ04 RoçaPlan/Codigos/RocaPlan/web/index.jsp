<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width,initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

        <title>RoçaPlan</title>

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
        <link rel="stylesheet" href="${cp}/css/libs/apex-charts/apex-charts.css" />

        <!-- Helpers -->
        <script src="${cp}/js/helpers.js"></script>

        <!-- Config  -->
        <script src="${cp}/js/config.js"></script>
    </head>

    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <!-- Menu -->

                <aside id="layout-menu"
                       class="layout-menu menu-vertical menu bg-menu-theme">
                    <div class="app-brand demo">
                        <a href="${cp}/index.jsp" class="app-brand-link">
                            <span class="app-brand-logo demo">
                                <img src="${cp}/img/logo/logo.svg" alt="Logo RoçaPlan" />
                            </span>
                            <span class="app-brand-text demo menu-text fw-bold ms-2">RoçaPlan</span>
                        </a>

                        <a href="javascript:void(0);"
                           class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
                            <i
                                class="bx bx-chevron-left bx-sm d-flex align-items-center justify-content-center"></i>
                        </a>
                    </div>

                    <div class="menu-inner-shadow"></div>

                    <ul class="menu-inner py-1">
                        <li class="menu-item active">
                            <a href="${cp}/pages/index.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-home-smile"></i>
                                <div class="text-truncate">Dashboard</div>
                            </a>
                        </li>

                        <li class="menu-item">
                            <a href="${cp}/pages/expenses.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-cart-download"></i>
                                <div class="text-truncate">Despesas</div>
                            </a>
                        </li>

                        <li class="menu-item">
                            <a href="${cp}/pages/products.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-box"></i>
                                <div class="text-truncate">Produtos</div>
                            </a>
                        </li>

                        <li class="menu-item">
                            <a href="${cp}/pages/sales.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-money-withdraw"></i>
                                <div class="text-truncate">Vendas</div>
                            </a>
                        </li>

                        <li class="menu-item mt-auto">
                            <a href="${cp}/pages/login.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-power-off"></i>
                                <div class="text-truncate">Sair</div>
                            </a>
                        </li>
                    </ul>
                </aside>
                <!-- / Menu -->

                <!-- Layout container -->
                <div class="layout-page">
                    <!-- Navbar -->
                    <nav
                        class="layout-navbar container-xxl navbar navbar-expand-xl navbar-detached align-items-center bg-navbar-theme"
                        id="layout-navbar">
                        <div
                            class="layout-menu-toggle navbar-nav align-items-xl-center me-4 me-xl-0 d-xl-none">
                            <a class="nav-item nav-link px-0 me-xl-6"
                               href="javascript:void(0)">
                                <i class="bx bx-menu bx-md"></i>
                            </a>
                        </div>

                        <div class="d-flex align-items-center ms-auto">
                            <div class="flex-shrink-0 me-2">
                                <img src="${cp}/img/avatars/1.png" alt="User Image"
                                     class="w-px-30 h-auto rounded-circle" />
                            </div>
                            <h6 class="mb-0">Francisco Silva</h6>
                        </div>
                    </nav>
                    <!-- / Navbar -->

                    <!-- Content wrapper -->
                    <div class="content-wrapper">
                        <!-- Content -->

                        <div class="container-xxl flex-grow-1 container-p-y">
                            <div class="row g-4 align-items-stretch">
                                <div class="col-8 col-md-10">
                                    <h3 class="m-0">Dashboard</h3>
                                </div>

                                <div class="col-4 col-md-2">
                                    <button class="btn btn-outline-primary w-100"
                                            data-bs-toggle="collapse"
                                            data-bs-target="#collapseFilters" aria-expanded="false">
                                        <i class="tf-icons bx-18px bx bx-filter-alt me-2"></i>
                                        Filtros
                                    </button>
                                </div>

                                <div class="col-12">
                                    <div class="collapse" id="collapseFilters">
                                        <div class="card card-body">
                                            <div class="row g-4 align-items-end">
                                                <div class="col-12 col-sm-6 col-md-4">
                                                    <label for="initial-date" class="form-label">
                                                        Período Inicial
                                                    </label>

                                                    <input type="date" class="form-control"
                                                           id="initial-date" />
                                                </div>

                                                <div class="col-12 col-sm-6 col-md-4">
                                                    <label for="initial-date" class="form-label">
                                                        Período Final
                                                    </label>

                                                    <input type="date" class="form-control"
                                                           id="final-date" />
                                                </div>

                                                <div class="col-6 col-md-2">
                                                    <button type="button"
                                                            class="btn btn-outline-primary w-100">
                                                        Limpar
                                                    </button>
                                                </div>

                                                <div class="col-6 col-md-2">
                                                    <button type="button" class="btn btn-primary w-100">
                                                        Filtrar
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6 col-lg-7">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Vendas X Despesas</h5>
                                            <div id="salesXExpenses"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6 col-lg-5">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Produtos Vendidos</h5>
                                            <div id="productsSold"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Detalhamento das Despesas</h5>
                                            <div id="expenseDetails"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-md-6">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Produtos em Estoque</h5>
                                            <div id="productsInStock"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-lg-6">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Economia com Despesas (R$)</h5>
                                            <div id="expenseSavings"></div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 col-lg-6">
                                    <div class="card h-100">
                                        <div class="card-body">
                                            <h5 class="card-title">Lucro com Produtos (R$)</h5>
                                            <div id="profitProducts"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- / Content -->
                    </div>
                    <!-- Content wrapper -->
                </div>
                <!-- / Layout page -->
            </div>

            <!-- Overlay -->
            <div class="layout-overlay layout-menu-toggle"></div>
        </div>
        <!-- / Layout wrapper -->

        <!-- Core JS -->
        <!-- build:js assets/vendor/js/core.js -->

        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Vendors JS -->
        <script src="${cp}/js/libs/apex-charts/apexcharts.js"></script>

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>

        <!-- Page JS -->
        <script src="${cp}/js/dashboards-analytics.js"></script>

        <!-- Place this tag before closing body tag for github widget button. -->
        <script async defer src="https://buttons.github.io/buttons.js"></script>

        <script>
            let date = new Date();

            const firstDate = new Date(date.getFullYear(), date.getMonth(), 1);
            const lastDate = new Date(date.getFullYear(), date.getMonth() + 1, 0);

            const firstDay = firstDate.toLocaleDateString("ko-KR").replace(/\./g, '').replace(/\s+/g, '-').replace(/(\d+)-(\d+)/, '$1-0$2').replace(/(\d{4})-(\d{2})-(\d{1})$/, '$1-$2-0$3');

            const lastDay = lastDate.toLocaleDateString("ko-KR").replace(/\./g, '').replace(/\s+/g, '-').replace(/(\d+)-(\d+)/, '$1-0$2').replace(/(\d{4})-(\d{2})-(\d{1})$/, '$1-$2-0$3');

            $('#initial-date').prop('value', firstDay);
            $('#final-date').prop('value', lastDay);
        </script>
    </body>
</html>
