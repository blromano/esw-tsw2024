<%@tag description="Save Product Modal" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="id" required="true"%>
<%@attribute name="title" required="true"%>

<%-- any content can be specified here e.g.: --%>
<div class="modal fade" id="${id}Modal" tabindex="-1" aria-hidden="true" data-bs-backdrop="static">
    <div
        class="modal-dialog modal-dialog-centered modal-lg"
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
                <form class="row g-4 align-items-center" onsubmit="saveProduct(event, ${id == 'edit'})">
                    <input type="hidden" name="usuId" value="1" />

                    <c:if test="${id eq 'edit'}">
                        <input type="hidden" name="proId" />
                    </c:if>

                    <div class="col-12 col-md-6 col-lg-4">
                        <label for="proNome" class="form-label">Nome</label>
                        <input type="text" class="form-control" name="proNome" maxlength="40" required />
                    </div>

                    <div class="col-12 col-md-6 col-lg-4">
                        <label for="${id}TprId" class="form-label">
                            Tipo
                        </label>

                        <jsp:useBean
                            id="servicos"
                            scope="page"
                            class="rocaplan.servicos.TipoProdutoServices"/>

                        <select class="form-select" id="${id}TprId" name="tprId" onchange="showOtherType(this.value)" required>
                            <option selected disabled>Selecione...</option>

                            <c:forEach items="${servicos.todos}" var="tipoProduto">
                                <option value="${tipoProduto.tprId}">
                                    ${tipoProduto.tprNome}
                                </option>
                            </c:forEach>

                            <option value="other">Outro</option>
                        </select>
                    </div>

                    <div class="col-12 col-md-6 col-lg-4 d-none" id="otherType">
                        <label for="newTpr" class="form-label">Outro Tipo</label>
                        <input type="text" class="form-control" name="newTpr" maxlength="10" />
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
</div>