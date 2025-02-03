document.addEventListener("DOMContentLoaded", function () {
    let today = new Date();

    const todayFormatted = today.toLocaleDateString("ko-KR")
            .replace(/\./g, '')
            .replace(/\s+/g, '-')
            .replace(/(\d+)-(\d+)/, '$1-0$2')
            .replace(/(\d{4})-(\d{2})-(\d{1})$/, '$1-$2-0$3');

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
    console.log($('#proId option:selected').data("valorUnitario"));
    let totalValue = 3 * amount;
    $(`#unitValueProduct${numProduct}`).removeClass('d-none');
    $(`#totalValueProduct${numProduct}`).removeClass('d-none');
    $(`#totalValueProduct${numProduct} input`).prop('value', `R$${totalValue.toFixed(2)}`);
}

