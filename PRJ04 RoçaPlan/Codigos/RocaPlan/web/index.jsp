<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <components:header title="Home" cp="${cp}" />
        <link rel="stylesheet" href="${cp}/css/libs/apex-charts/apex-charts.css" />
    </head>

    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <components:sidebar cp="${cp}" activeItemIndex="1" />

                <!-- Layout container -->
                <div class="layout-page">
                    <components:navbar cp="${cp}" />

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
