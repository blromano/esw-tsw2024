<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib tagdir="/WEB-INF/tags" prefix="components" %>
<!DOCTYPE html>

<html lang="pt-BR" class="light-style layout-menu-fixed layout-compact">
    <head>
        <components:header title="Produtos" cp="${cp}" />
        <script src="${cp}/js/pages/products.js"></script>
    </head>    

    <body>
        <!-- Layout wrapper -->
        <div class="layout-wrapper layout-content-navbar">
            <div class="layout-container">
                <components:sidebar cp="${cp}" activeItemIndex="3" />

                <!-- Layout container -->
                <div class="layout-page">
                    <components:navbar cp="${cp}" />

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
                                            <form class="row g-4 align-items-end" onsubmit="filterProducts(event)"
                                                  onreset="listProducts()">
                                                <div class="col-12 col-md-4">
                                                    <label for="proNome" class="form-label">
                                                        Nome
                                                    </label>

                                                    <input type="text" class="form-control"
                                                           id="proNome" name="proNome" maxlength="40" />
                                                </div>

                                                <div class="col-12 col-md-2">
                                                    <label for="filterTprId" class="form-label">
                                                        Tipo
                                                    </label>

                                                    <jsp:useBean
                                                        id="servicos"
                                                        scope="page"
                                                        class="rocaplan.servicos.TipoProdutoServices"/>

                                                    <select class="form-select" id="filterTprId" name="tprId">
                                                        <option value="" selected>Selecione...</option>
                                                        <c:forEach items="${servicos.todos}" var="tipoProduto">
                                                            <option value="${tipoProduto.tprId}">
                                                                ${tipoProduto.tprNome}
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                                <div class="col-12 col-md-2">
                                                    <label for="proValorUnitario" class="form-label">
                                                        Valor Unitário
                                                    </label>

                                                    <input type="number" class="form-control" id="proValorUnitario"
                                                           name="proValorUnitario" step="0.01" min="0" />
                                                </div>

                                                <div class="col-6 col-md-2" id="btn-filter-clear">
                                                    <input type="reset" class="btn btn-outline-primary w-100" 
                                                           value="Limpar" />
                                                </div>

                                                <div class="col-6 col-md-2" id="btn-filter">
                                                    <input type="submit" class="btn btn-primary w-100" 
                                                           value="Filtrar" />
                                                </div>
                                            </form>
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

                                        <tfoot id="tfoot-produtos"></tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modals -->
        <components:saveProductModal title="Adicionar Produto" id="add" />

        <components:saveProductModal title="Editar Produto" id="edit" />

        <!-- Core JS -->
        <!-- build:js assets/vendor/js/core.js -->

        <script src="${cp}/js/libs/jquery/jquery.min.js"></script>
        <script src="${cp}/js/libs/bootstrap/bootstrap.bundle.min.js"></script>
        <script src="${cp}/js/libs/sweetalert/sweetalert2@11.js"></script>
        <script src="${cp}/js/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
        <script src="${cp}/js/menu.js"></script>

        <!-- endbuild -->

        <!-- Main JS -->
        <script src="${cp}/js/main.js"></script>
    </body>
</html>
