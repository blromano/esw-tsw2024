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

        <title>RoçaPlan - Vendas</title>

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

                        <li class="menu-item">
                            <a href="${cp}/pages/products.jsp" class="menu-link">
                                <i class="menu-icon tf-icons bx bx-box"></i>
                                <div class="text-truncate">Produtos</div>
                            </a>
                        </li>

                        <li class="menu-item active">
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
                                    <h3 class="m-0">Vendas</h3>
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
                                                <div class="col-12 col-sm-6 col-md-6">
                                                    <label for="customer" class="form-label">
                                                        Cliente
                                                    </label>

                                                    <input type="text" class="form-control"
                                                           id="customer" maxlength="60" />
                                                </div>

                                                <div class="col-12 col-sm-6 col-md-3">
                                                    <label for="date" class="form-label">
                                                        Data
                                                    </label>

                                                    <input type="date" class="form-control"
                                                           id="date" />
                                                </div>

                                                <div class="col-12 col-sm-6 col-md-3">
                                                    <label for="payment-status" class="form-label">
                                                        Situação de Pagamento
                                                    </label>

                                                    <select class="form-select" id="payment-status">
                                                        <option selected disabled>Selecione...</option>
                                                        <option value="paid">Pago</option>
                                                        <option value="not-paid">Não Pago</option>
                                                    </select>
                                                </div>

                                                <div class="col-6">
                                                    <button type="button" class="btn btn-outline-primary w-100">
                                                        Limpar
                                                    </button>
                                                </div>

                                                <div class="col-6">
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
                                                <th>Cliente</th>
                                                <th>Data</th>
                                                <th>Situação de Pagamento</th>
                                                <th>Valor</th>
                                                <th colspan="3" width="20%">Ações</th>
                                            </tr>
                                        </thead>

                                        <tbody>
                                            <tr>
                                                <td>1</td>
                                                <td>José Teixeira</td>
                                                <td>28/08/2024</td>
                                                <td>Pago</td>
                                                <td>R$40,00</td>
                                                <td data-bs-toggle="tooltip" data-bs-title="Detalhar">
                                                    <button class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                                            data-bs-target="#detailsModal">
                                                        <i class="bx bx-expand"></i>
                                                    </button>
                                                </td>
                                                <td data-bs-toggle="tooltip" data-bs-title="Editar">
                                                    <button class="btn btn-success btn-sm" data-bs-toggle="modal"
                                                            data-bs-target="#editModal">
                                                        <i class="bx bx-edit"></i>
                                                    </button>
                                                </td>
                                                <td data-bs-toggle="tooltip" data-bs-title="Excluir">
                                                    <button class="btn btn-danger btn-sm" data-bs-toggle="modal"
                                                            data-bs-target="#deleteModal">
                                                        <i class="bx bx-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>2</td>
                                                <td>Carlos Teixeira Santos</td>
                                                <td>27/08/2024</td>
                                                <td>Não Pago</td>
                                                <td>R$60,00</td>
                                                <td>
                                                    <button class="btn btn-primary btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Detalhar">
                                                        <i class="bx bx-expand"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-success btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Editar">
                                                        <i class="bx bx-edit"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Excluir">
                                                        <i class="bx bx-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>3</td>
                                                <td>Mário Celso Pereira</td>
                                                <td>26/08/2024</td>
                                                <td>Não Pago</td>
                                                <td>R$70,00</td>
                                                <td>
                                                    <button class="btn btn-primary btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Detalhar">
                                                        <i class="bx bx-expand"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-success btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Editar">
                                                        <i class="bx bx-edit"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Excluir">
                                                        <i class="bx bx-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>4</td>
                                                <td>Carolina Muriel Santana</td>
                                                <td>25/08/2024</td>
                                                <td>Pago</td>
                                                <td>R$55,00</td>
                                                <td>
                                                    <button class="btn btn-primary btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Detalhar">
                                                        <i class="bx bx-expand"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-success btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Editar">
                                                        <i class="bx bx-edit"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Excluir">
                                                        <i class="bx bx-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>5</td>
                                                <td>Ana Paula Costa</td>
                                                <td>24/08/2024</td>
                                                <td>Pago</td>
                                                <td>R$30,00</td>
                                                <td>
                                                    <button class="btn btn-primary btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Detalhar">
                                                        <i class="bx bx-expand"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-success btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Editar">
                                                        <i class="bx bx-edit"></i>
                                                    </button>
                                                </td>
                                                <td>
                                                    <button class="btn btn-danger btn-sm" data-bs-toggle="tooltip"
                                                            data-bs-title="Excluir">
                                                        <i class="bx bx-trash"></i>
                                                    </button>
                                                </td>
                                            </tr>
                                        </tbody>

                                        <tfoot>
                                            <tr>
                                                <td colspan="5">
                                                    <small>Mostrando de 1 a 5 de 15 entradas</small>
                                                </td>
                                                <td colspan="4">
                                                    <ul class="pagination m-0">
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
                class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg"
                role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Adicionar Venda</h5>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <div class="row g-4 align-items-center" id="rowAddModal">
                            <div class="col-12 col-lg-6">
                                <label for="customer" class="form-label">Cliente</label>
                                <input type="text" class="form-control" list="customerOptions"
                                       name="customer" placeholder="Digite para buscar..." maxlength="60"
                                       required />

                                <datalist id="customerOptions">
                                    <option value="José Pereira"></option>
                                    <option value="Ana Paula Santana"></option>
                                    <option value="Carlos Matias"></option>
                                    <option value="Sandra Maria Agostine"></option>
                                </datalist>
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <label for="date" class="form-label">Data</label>
                                <input type="date" class="form-control" name="date" required />
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <label for="payment_status" class="form-label">
                                    Situação de Pagamento
                                </label>
                                <select name="payment_status" class="form-select" required>
                                    <option selected disabled>Selecione...</option>
                                    <option value="paid">Pago</option>
                                    <option value="not_paid">Não Pago</option>
                                </select>
                            </div>

                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row g-4 align-items-center">
                                            <div class="col-12">
                                                <h6 class="card-title mb-0">1° Produto</h6>
                                            </div>

                                            <div class="col-12 col-md-8">
                                                <label for="product" class="form-label">
                                                    Produto
                                                </label>
                                                <select name="product" class="form-select" required>
                                                    <option selected disabled>Selecione...</option>
                                                    <option value="1">Alface</option>
                                                    <option value="2">Almeirão</option>
                                                    <option value="3">Feijão</option>
                                                    <option value="4">Laranja</option>
                                                    <option value="5">Limão</option>
                                                    <option value="6">Mamão</option>
                                                </select>
                                            </div>

                                            <div class="col-12 col-md-4">
                                                <label for="amount" class="form-label">Quantidade</label>
                                                <input type="number" class="form-control" name="amount" min="1"
                                                       required onkeyup="calculateTotalValue(0, this.value)" />
                                            </div>

                                            <div class="col-12 col-md-6 d-none" id="unitValueProduct0">
                                                <label for="unit_value" class="form-label">Valor Unitário</label>
                                                <input type="text" class="form-control" name="unit_value"
                                                       value="R$3.00" readonly />
                                            </div>

                                            <div class="col-12 col-md-6 d-none" id="totalValueProduct0">
                                                <label for="total_value" class="form-label">Valor Total</label>
                                                <input type="text" class="form-control" name="total_value"
                                                       readonly />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-outline-primary m-0 me-1"
                                onclick="addProduct('rowAddModal')">
                            <i class="tf-icons bx-18px bx bx-plus me-2"></i>
                            Produto
                        </button>

                        <button type="button" class="btn btn-primary m-0 ms-1"
                                data-bs-dismiss="modal">
                            Salvar
                        </button>
                    </div>
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
                        <h4 class="mt-5 mb-0">Tem certeza que deseja deletar esta venda?</h4>
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

        <div class="modal fade" id="editModal" tabindex="-1" aria-hidden="true"
             data-bs-backdrop="static">
            <div
                class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg"
                role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Editar Venda</h5>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>

                    <div class="modal-body">
                        <div class="row g-4 align-items-center" id="rowEditModal">
                            <div class="col-12 col-lg-6">
                                <label for="customer" class="form-label">Cliente</label>
                                <input type="text" class="form-control" list="customerOptions"
                                       name="customer" placeholder="Digite para buscar..." maxlength="60"
                                       required value="José Teixeira" />

                                <datalist id="customerOptions">
                                    <option value="José Pereira"></option>
                                    <option value="Ana Paula Santana"></option>
                                    <option value="Carlos Matias"></option>
                                    <option value="Sandra Maria Agostine"></option>
                                </datalist>
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <label for="date" class="form-label">Data</label>
                                <input type="date" class="form-control" name="date" required
                                       value="2024-08-28" />
                            </div>

                            <div class="col-12 col-sm-6 col-lg-3">
                                <label for="payment_status" class="form-label">
                                    Situação de Pagamento
                                </label>
                                <select name="payment_status" class="form-select" required>
                                    <option disabled>Selecione...</option>
                                    <option value="paid" selected>Pago</option>
                                    <option value="not_paid">Não Pago</option>
                                </select>
                            </div>

                            <div class="col-12">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="row g-4 align-items-center">
                                            <div class="col-12">
                                                <h6 class="card-title mb-0">1° Produto</h6>
                                            </div>

                                            <div class="col-12 col-md-8">
                                                <label for="product" class="form-label">
                                                    Produto
                                                </label>
                                                <select name="product" class="form-select" required>
                                                    <option disabled>Selecione...</option>
                                                    <option selected value="1">Alface</option>
                                                    <option value="2">Almeirão</option>
                                                    <option value="3">Feijão</option>
                                                    <option value="4">Laranja</option>
                                                    <option value="5">Limão</option>
                                                    <option value="6">Mamão</option>
                                                </select>
                                            </div>

                                            <div class="col-12 col-md-4">
                                                <label for="amount" class="form-label">Quantidade</label>
                                                <input type="number" class="form-control" name="amount" min="1"
                                                       required onkeyup="calculateTotalValue(0, this.value)" value="20" />
                                            </div>

                                            <div class="col-12 col-md-6" id="unitValueProduct0">
                                                <label for="unit_value" class="form-label">Valor Unitário</label>
                                                <input type="text" class="form-control" name="unit_value"
                                                       value="R$2.00" readonly />
                                            </div>

                                            <div class="col-12 col-md-6" id="totalValueProduct0">
                                                <label for="total_value" class="form-label">Valor Total</label>
                                                <input type="text" class="form-control" name="total_value"
                                                       readonly value="R$40.00" />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-outline-primary m-0 me-1"
                                onclick="addProduct('rowEditModal')">
                            <i class="tf-icons bx-18px bx bx-plus me-2"></i>
                            Produto
                        </button>

                        <button type="button" class="btn btn-primary m-0 ms-1"
                                data-bs-dismiss="modal">
                            Salvar
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="detailsModal" tabindex="-1" aria-hidden="true"
             data-bs-backdrop="static">
            <div
                class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg"
                role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Detalhar Venda</h5>
                        <button
                            type="button"
                            class="btn-close"
                            data-bs-dismiss="modal"
                            aria-label="Close"></button>
                    </div>

                    <div class="modal-body table-responsive">
                        <h6>Detalhamento dos produtos comprados</h6>

                        <table
                            class="table table-sm table-primary table-hover table-striped">
                            <thead class="table-success">
                                <tr>
                                    <th>#</th>
                                    <th>Nome</th>
                                    <th>Quantidade</th>
                                    <th>Valor Unitário</th>
                                    <th>Valor Total</th>
                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Alface</td>
                                    <td>20</td>
                                    <td>R$2,00</td>
                                    <td>R$40,00</td>
                                </tr>
                            </tbody>

                            <tfoot>
                                <tr>
                                    <td colspan="4" class="text-end">
                                        <strong>TOTAL:</strong>
                                    </td>
                                    <td>R$40,00</td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>

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

        <script>
            $(document).ready(function () {
                let today = new Date();

                const todayFormatted = today.toLocaleDateString("ko-KR").replace(/\./g, '').replace(/\s+/g, '-').replace(/(\d+)-(\d+)/, '$1-0$2').replace(/(\d{4})-(\d{2})-(\d{1})$/, '$1-$2-0$3');

                $('#addModal input[type="date"]').prop('value', todayFormatted);
            });

            function addProduct(rowId) {
                let numProducts = $(`#${rowId}`).children().length - 2;

                let newCardProduct = `
                    <div class="col-12" id="product${numProducts}">
                        <div class="card">
                            <div class="card-body">
                                <div class="row g-4 align-items-center">
                                    <div class="col-8 col-md-10">
                                        <h6 class="card-title mb-0">${numProducts}° Produto</h6>
                                    </div>

                                    <div class="col-4 col-md-2 text-end">
                                        <button class="btn btn-outline-danger btn-sm"
                                            data-bs-toggle="tooltip"
                                            data-bs-title="Excluir" onclick="deleteProduct('product${numProducts}')">
                                            <i class="bx bx-trash"></i>
                                        </button>
                                    </div>

                                    <div class="col-12 col-md-8">
                                        <label for="product${numProducts}" class="form-label">
                                            Produto
                                        </label>
                                        <select name="product${numProducts}" class="form-select" required>
                                            <option selected disabled>Selecione...</option>
                                            <option value="1">Alface</option>
                                            <option value="2">Almeirão</option>
                                            <option value="3">Feijão</option>
                                            <option value="4">Laranja</option>
                                            <option value="5">Limão</option>
                                            <option value="6">Mamão</option>
                                        </select>
                                    </div>

                                    <div class="col-12 col-md-4">
                                        <label for="amount" class="form-label">Quantidade</label>
                                        <input type="number" class="form-control" name="amount" min="1"
                                                required onkeyup="calculateTotalValue(${numProducts}, this.value)" />
                                    </div>

                                    <div class="col-12 col-md-6 d-none" id="unitValueProduct${numProducts}">
                                        <label for="unit_value" class="form-label">Valor Unitário</label>
                                        <input type="text" class="form-control" name="unit_value"
                                                value="R$3.00" readonly />
                                    </div>

                                    <div class="col-12 col-md-6 d-none" id="totalValueProduct${numProducts}">
                                        <label for="total_value" class="form-label">Valor Total</label>
                                        <input type="text" class="form-control" name="total_value"
                                                readonly />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>`;

                $(`#${rowId}`).append(newCardProduct);
            }

            function deleteProduct(id) {
                $(`#${id}`).remove();
            }

            function calculateTotalValue(numProduct, amount) {
                let totalValue = 3 * amount;
                $(`#unitValueProduct${numProduct}`).removeClass('d-none');
                $(`#totalValueProduct${numProduct}`).removeClass('d-none');
                $(`#totalValueProduct${numProduct} input`).prop('value', `R$${totalValue.toFixed(2)}`);
            }
        </script>
    </body>
</html>
