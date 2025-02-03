<%@tag description="Save Sale Modal" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true"%>
<%@attribute name="title" required="true"%>

<%-- any content can be specified here e.g.: --%>
<div class="modal fade" id="${id}Modal" tabindex="-1" aria-hidden="true"
     data-bs-backdrop="static">
    <div
        class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg"
        role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">${title}</h5>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="modal"
                    aria-label="Close"></button>
            </div>

            <div class="modal-body">
                <form class="row g-4 align-items-center" id="rowAddModal" onsubmit="saveSale(event, ${id == 'edit'})">
                    <input type="hidden" name="usuId" value="1" />

                    <c:if test="${id eq 'edit'}">
                        <input type="hidden" name="venId" />
                    </c:if>

                    <div class="col-12 col-lg-6">
                        <label for="customer" class="form-label">Cliente</label>
                        <input type="text" class="form-control" list="customerOptions"
                               name="venNomeCliente" placeholder="Digite para buscar..." maxlength="60"
                               required />

                        <datalist id="customerOptions">
                            <option value="José Pereira"></option>
                            <option value="Ana Paula Santana"></option>
                            <option value="Carlos Matias"></option>
                            <option value="Sandra Maria Agostine"></option>
                        </datalist>
                    </div>

                    <div class="col-12 col-sm-6 col-lg-3">
                        <label for="venData" class="form-label">Data</label>
                        <input type="date" class="form-control" name="venData" required />
                    </div>

                    <div class="col-12 col-sm-6 col-lg-3">
                        <label for="venSituacaoPagamento" class="form-label">
                            Situação de Pagamento
                        </label>
                        <select name="venSituacaoPagamento" class="form-select" required>
                            <option selected disabled>Selecione...</option>
                            <option value="true">Pago</option>
                            <option value="false">Não Pago</option>
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
                                        <label for="${id}ProId" class="form-label">
                                            Produto
                                        </label>

                                        <jsp:useBean
                                            id="servicos"
                                            scope="page"
                                            class="rocaplan.servicos.ProdutoServices"/>

                                        <select class="form-select" id="proId" name="proId" required>
                                            <option selected disabled>Selecione...</option>

                                            <c:forEach items="${servicos.todos}" var="produto">
                                                <option value="${produto.proId}" 
                                                    data-valorUnitario="${produto.proValorUnitario}">
                                                    ${produto.proNome}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="col-12 col-md-4">
                                        <label for="amount" class="form-label">Quantidade</label>
                                        <input type="number" class="form-control" name="prvQuantidade" min="1"
                                               required onkeyup="calculateTotalValue(0, this.value)" />
                                    </div>

                                    <div class="col-12 col-md-6 d-none" id="unitValueProduct0">
                                        <label for="unit_value" class="form-label">Valor Unitário</label>
                                        <input type="text" class="form-control" name="proValorUnitario" readonly />
                                    </div>

                                    <div class="col-12 col-md-6 d-none" id="totalValueProduct0">
                                        <label for="total_value" class="form-label">Valor Total</label>
                                        <input type="text" class="form-control" name="venValorTotal"
                                               readonly />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
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