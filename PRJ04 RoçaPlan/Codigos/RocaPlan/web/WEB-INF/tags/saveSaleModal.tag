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
                <form onsubmit="saveSale(event, ${id == 'edit'})" id="saleForm">
                    <input type="hidden" name="usuId" value="1" />

                    <c:if test="${id eq 'edit'}">
                        <input type="hidden" name="venId" />
                    </c:if>

                    <div class="row g-4 align-items-center" id="row${id}Modal">
                        <div class="col-12 col-lg-6">
                            <label for="customer" class="form-label">Cliente</label>
                            <input type="text" class="form-control" list="${id}CustomerOptions"
                                   name="venNomeCliente" placeholder="Digite para buscar..." maxlength="60"
                                   required />

                            <jsp:useBean
                                id="servicos0"
                                scope="page"
                                class="rocaplan.servicos.ClienteServices"/>

                            <datalist id="${id}CustomerOptions">
                                <c:forEach items="${servicos0.todos}" var="cliente">
                                    <option value="${cliente}">${cliente}</option>
                                </c:forEach>
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

                        <div class="col-12" id="product0">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row g-4 align-items-center">
                                        <div class="col-8 col-md-10">
                                            <h6 class="card-title mb-0">1° Produto</h6>
                                        </div>

                                        <div class="col-4 col-md-2 text-end">
                                            <button class="btn btn-outline-danger btn-sm"
                                                    data-bs-toggle="tooltip"
                                                    data-bs-title="Excluir" onclick="deleteProduct('product0')">
                                                <i class="bx bx-trash"></i>
                                            </button>
                                        </div>

                                        <div class="col-12 col-md-8">
                                            <label for="proId0" class="form-label">
                                                Produto
                                            </label>

                                            <jsp:useBean
                                                id="servicos"
                                                scope="page"
                                                class="rocaplan.servicos.ProdutoServices"/>

                                            <select class="form-select" id="proId0" required>
                                                <option value="" selected disabled>Selecione...</option>

                                                <c:forEach items="${servicos.todos}" var="produto">
                                                    <option value="${produto.proId}" 
                                                            data-valor-unitario="${produto.proValorUnitario}">
                                                        ${produto.proNome}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="col-12 col-md-4">
                                            <label for="prvQuantidade0" class="form-label">Quantidade</label>
                                            <input type="number" class="form-control" id="prvQuantidade0" min="1"
                                                   required onkeyup="calculateTotalValue(0, this.value)" />
                                        </div>

                                        <div class="col-12 col-md-6 d-none" id="unitValueProduct0">
                                            <label for="proValorUnitario" class="form-label">Valor Unitário</label>
                                            <input type="text" class="form-control" id="proValorUnitario" readonly />
                                        </div>

                                        <div class="col-12 col-md-6 d-none" id="totalValueProduct0">
                                            <label for="venValorTotal" class="form-label">Valor Total</label>
                                            <input type="text" class="form-control" id="venValorTotal"
                                                   readonly />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-outline-primary m-0 me-1"
                        onclick="addProduct('row${id}Modal')">
                    <i class="tf-icons bx-18px bx bx-plus me-2"></i>
                    Produto
                </button>

                <button form="saleForm" type="submit" class="btn btn-primary m-0 ms-1">Salvar</button>
            </div>
        </div>
    </div>
</div>