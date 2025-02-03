<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <components:header title="Vendas" cp="${cp}" />
        <script src="${cp}/js/pages/sales.js"></script>
    </head> 

    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <components:sidebar cp="${cp}" activeItemIndex="4" />

                <!-- Layout container -->
                <div class="layout-page">
                    <components:navbar cp="${cp}" />

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
        <components:saveSaleModal title="Adicionar Venda" id="add" />

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

        <components:saveSaleModal title="Editar Venda" id="edit" />

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

        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>
    </body>
</html>
