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

        <title>RoçaPlan - Produtos</title>

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
        <script src="${cp}/js/pages/products.js"></script>
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
                            <span
                                class="app-brand-text demo menu-text fw-bold ms-2">RoçaPlan</span>
                        </a>

                        <a href="javascript:void(0);"
                           class="layout-menu-toggle menu-link text-large ms-auto d-block d-xl-none">
                            <i
                                class="bx bx-chevron-left bx-sm d-flex align-items-center justify-content-center"></i>
                        </a>
                    </div>

                    <div class="menu-inner-shadow"></div>

                    <ul class="menu-inner py-1">
                        <li class="menu-item">
                            <a href="${cp}/index.jsp" class="menu-link">
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

                        <li class="menu-item active">
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
                            <div class="row g-4 align-items-center">
                                <div class="col-4 col-md-8">
                                    <h3 class="m-0">Produtos</h3>
                                </div>

                                <div class="col-4 col-md-2">
                                    <button class="btn btn-outline-primary w-100"
                                            data-bs-toggle="collapse"
                                            data-bs-target="#collapseFilters" aria-expanded="false">
                                        <i class="tf-icons bx-18px bx bx-filter-alt me-2"></i>
                                        Filtros
                                    </button>
                                </div>

                                <div class="col-4 col-md-2">
                                    <button class="btn btn-outline-success w-100" data-bs-toggle="modal"
                                            data-bs-target="#addModal">
                                        <i class="tf-icons bx-18px bx bx-plus me-2"></i>
                                        Adicionar
                                    </button>
                                </div>

                                <div class="col-12">
                                    <div class="collapse" id="collapseFilters">
                                        <div class="card card-body">
                                            <div class="row g-4 align-items-end">
                                                <div class="col-12 col-md-4">
                                                    <label for="name" class="form-label">
                                                        Nome
                                                    </label>

                                                    <input type="text" class="form-control"
                                                           id="name" maxlength="40" />
                                                </div>

                                                <div class="col-12 col-md-2">
                                                    <label for="type" class="form-label">
                                                        Tipo
                                                    </label>

                                                    <select class="form-select" id="type"
                                                            onchange="showOtherType(this.value, 'other-type')">
                                                        <option selected disabled>Selecione...</option>
                                                        <option value="1">Fruta</option>
                                                        <option value="2">Grãos</option>
                                                        <option value="3">Legume</option>
                                                        <option value="4">Verdura</option>
                                                        <option value="5">Outro</option>
                                                    </select>
                                                </div>

                                                <div class="col-12 col-md-4 d-none" id="other-type">
                                                    <label for="other" class="form-label">
                                                        Outro Tipo
                                                    </label>

                                                    <input type="text" class="form-control"
                                                           id="other" maxlength="60" />
                                                </div>

                                                <div class="col-12 col-md-2">
                                                    <label for="value" class="form-label">
                                                        Valor Unitário
                                                    </label>

                                                    <input type="number" class="form-control"
                                                           id="value" step="0.01" min="0" />
                                                </div>

                                                <div class="col-6 col-md-2" id="btn-filter-clear">
                                                    <button type="button" class="btn btn-outline-primary w-100">
                                                        Limpar
                                                    </button>
                                                </div>

                                                <div class="col-6 col-md-2" id="btn-filter">
                                                    <button type="button" class="btn btn-primary w-100">
                                                        Filtrar
                                                    </button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-12 table-responsive">
                                    <table
                                        class="table table-sm table-primary table-hover table-striped">
                                        <thead class="table-success">
                                            <tr>
                                                <th>#</th>
                                                <th>Nome</th>
                                                <th>Tipo</th>
                                                <th>Quantidade</th>
                                                <th>Valor Unitário</th>
                                                <th colspan="2" width="15%">Ações</th>
                                            </tr>
                                        </thead>

                                        <tbody id="tbody-produtos">
                                            <tr>
                                                <td colspan="7">Não há produtos cadastrados.</td>
                                            </tr>
                                        </tbody>

                                        <tfoot>
                                            <tr>
                                                <td colspan="4">
                                                    <small>Mostrando de 1 a 5 de 15 entradas</small>
                                                </td>
                                                <td colspan="3">
                                                    <ul class="pagination m-0 justify-content-end">
                                                        <li class="page-item">
                                                            <a class="page-link" href="#" data-bs-toggle="tooltip"
                                                               data-bs-title="Anterior">
                                                                <i class="bx bx-chevron-left"></i>
                                                            </a>
                                                        </li>
                                                        <li class="page-item active">
                                                            <a class="page-link" href="#">1</a>
                                                        </li>
                                                        <li class="page-item"><a class="page-link" href="#">2</a></li>
                                                        <li class="page-item"><a class="page-link" href="#">3</a></li>
                                                        <li class="page-item">
                                                            <a class="page-link" href="#" data-bs-toggle="tooltip"
                                                               data-bs-title="Próximo">
                                                                <i class="bx bx-chevron-right"></i>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modals -->
        <div class="modal fade" id="addModal" tabindex="-1" aria-hidden="true"
             data-bs-backdrop="static">
            <div
                class="modal-dialog modal-dialog-centered modal-lg"
                role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Adicionar Produto</h5>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <form class="row g-4 align-items-center" onsubmit="addProduct(event)">
                            <div class="col-12 col-md-6 col-lg-4">
                                <label for="proNome" class="form-label">Nome</label>
                                <input type="text" class="form-control" name="proNome" maxlength="40"
                                       required />
                            </div>

                            <div class="col-12 col-md-6 col-lg-4">
                                <label for="type" class="form-label">
                                    Tipo
                                </label>
                                <select class="form-select" id="type" name="fkTprId"
                                        onchange="showOtherType(this.value, 'add-other-type')" required>
                                    <option selected disabled>Selecione...</option>
                                    <option value="1">Fruta</option>
                                    <option value="2">Grãos</option>
                                    <option value="3">Legume</option>
                                    <option value="4">Verdura</option>
                                    <option value="5">Outro</option>
                                </select>
                            </div>

                            <div class="col-12 col-md-6 col-lg-4 d-none" id="add-other-type">
                                <label for="newTpr" class="form-label">Outro Tipo</label>
                                <input type="text" class="form-control" name="newTpr" maxlength="10" required />
                            </div>

                            <div class="col-12 col-md-6 col-lg-4">
                                <label for="proQuantidade" class="form-label">Quantidade</label>
                                <input type="number" class="form-control" name="proQuantidade" min="0" required />
                            </div>

                            <div class="col-12 col-md-6 col-lg-4">
                                <label for="proValorUnitario" class="form-label">Valor Unitário</label>
                                <input type="number" class="form-control" name="proValorUnitario" step="0.01"
                                       min="0" required />
                            </div>
                            
                            <div class="col-12 text-end">
                                <input type="submit" class="btn btn-primary m-0 ms-1" value="Salvar" />
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="deleteModal" tabindex="-1"
                 aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-sm"
                     role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"></button>
                        </div>

                        <div class="modal-body text-center">
                            <i class="bx bx-large bx-info-circle text-danger"></i>
                            <h4 class="mt-5 mb-0">Tem certeza que deseja deletar este produto?</h4>
                        </div>

                        <div class="modal-footer justify-content-between">
                            <button type="button"
                                    class="btn btn-primary flex-grow-1 me-1" data-bs-dismiss="modal">
                                Sim
                            </button>

                            <button type="button" class="btn btn-outline-danger flex-grow-1 ms-1"
                                    data-bs-dismiss="modal">
                                Não
                            </button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="editModal" tabindex="-1" data-bs-backdrop="static">
                <div
                    class="modal-dialog modal-dialog-centered modal-lg"
                    role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Editar Produto</h5>
                            <button
                                type="button"
                                class="btn-close"
                                data-bs-dismiss="modal"
                                aria-label="Close"></button>
                        </div>

                        <div class="modal-body">
                            <div class="row g-4 align-items-center">
                                <input type="hidden" name="id" />

                                <div class="col-12 col-md-6 col-lg-4">
                                    <label for="name" class="form-label">Nome</label>
                                    <input type="text" class="form-control" name="nome" maxlength="40" required />
                                </div>

                                <div class="col-12 col-md-6 col-lg-4">
                                    <label for="type" class="form-label">
                                        Tipo
                                    </label>
                                    <select class="form-select" id="type" name="type"
                                            onchange="showOtherType(this.value, 'edit-other-type')">
                                        <option disabled>Selecione...</option>
                                        <option value="1">Fruta</option>
                                        <option value="2">Grãos</option>
                                        <option value="3">Legume</option>
                                        <option value="4">Verdura</option>
                                        <option value="5">Outro</option>
                                    </select>
                                </div>

                                <div class="col-12 col-md-6 col-lg-4 d-none" id="edit-other-type">
                                    <label for="other-type" class="form-label">Outro Tipo</label>
                                    <input type="text" class="form-control" name="other-type" maxlength="60"
                                           required />
                                </div>

                                <div class="col-12 col-md-6 col-lg-4">
                                    <label for="amount" class="form-label">Quantidade</label>
                                    <input type="number" class="form-control" name="quantidade" min="0"
                                           required />
                                </div>

                                <div class="col-12 col-md-6 col-lg-4">
                                    <label for="value" class="form-label">Valor Unitário</label>
                                    <input type="number" class="form-control" name="valorUnitario" step="0.01"
                                           min="0" required />
                                </div>
                            </div>
                        </div>

                        <div class="modal-footer justify-content-end">
                            <button type="button" class="btn btn-primary m-0 ms-1"
                                    data-bs-dismiss="modal">
                                Salvar
                            </button>
                        </div>
                    </div>
                </div>
            </div>

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
