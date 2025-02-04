let countProducts = 0;
let defaultCardProduct = '';

document.addEventListener("DOMContentLoaded", function () {
    let today = new Date();

    const todayFormatted = today.toLocaleDateString("ko-KR")
            .replace(/\./g, '')
            .replace(/\s+/g, '-')
            .replace(/(\d+)-(\d+)/, '$1-0$2')
            .replace(/(\d{4})-(\d{2})-(\d{1})$/, '$1-$2-0$3');

    $('#addModal input[type="date"]').prop('value', todayFormatted);
    defaultCardProduct = `<div class="col-12" id="product0">${$('#addModal #product0').html()}</div>`;

    listSales();
});

function addProduct(rowId) {
    countProducts++;

    let divProduct = defaultCardProduct;
    divProduct = divProduct.replaceAll('product0', `product${countProducts}`);
    divProduct = divProduct.replaceAll('proId0', `proId${countProducts}`);
    divProduct = divProduct.replaceAll('prvQuantidade0', `prvQuantidade${countProducts}`);
    divProduct = divProduct.replace('1°', `${countProducts + 1}`);
    divProduct = divProduct.replace('(0,', `(${countProducts},`);
    divProduct = divProduct.replace('unitValueProduct0', `unitValueProduct${countProducts}`);
    divProduct = divProduct.replace('totalValueProduct0', `totalValueProduct${countProducts}`);

    $(`#${rowId}`).append(divProduct);
}

function deleteProduct(id) {
    $(`#${id}`).remove();
}

function calculateTotalValue(numProduct, amount) {
    const valorUnitario = $(`#proId${numProduct} option:selected`).data("valor-unitario");

    if (valorUnitario) {
        const totalValue = valorUnitario * amount;

        $(`#unitValueProduct${numProduct}`).removeClass('d-none');
        $(`#unitValueProduct${numProduct} input`).prop('value', `R$${valorUnitario.toFixed(2)}`);
        $(`#totalValueProduct${numProduct}`).removeClass('d-none');
        $(`#totalValueProduct${numProduct} input`).prop('value', `R$${totalValue.toFixed(2)}`);
    }
}

function listSales(page = 1) {
    let parametros = new URLSearchParams();
    parametros.append("acao", "listar");

    if (page < 1) {
        page = 1;
    }

    parametros.append("pagina", page);

    fetch("/RocaPlan/VendaServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        return response.json();
    }).then(data => {
        populateTable(data.vendas);

        let tfoot = $('#tfoot-vendas');

        if (data.totalVendas <= 0) {
            tfoot.html("");
            tfoot.hide();
        } else {
            tfoot.show();

            let numberPages = Math.round(data.totalVendas / 5);

            let text = `<tr>
                        <td colspan="4">
                            <small>Mostrando de ${data.vendas.length} de ${data.totalVendas} entradas</small>
                        </td>
                        <td colspan="4">
                            <ul class="pagination m-0 justify-content-end">
                                <li class="page-item">
                                    <a class="page-link" onclick="listSales(${page - 1})" data-bs-toggle="tooltip"
                                       data-bs-title="Anterior">
                                        <i class="bx bx-chevron-left"></i>
                                    </a>
                                </li>`;

            for (let i = 1; i <= numberPages; i++) {
                text += `<li class="page-item ${i === page ? 'active' : ''}">
                            <a class="page-link" onclick(listSales(${i}))>${i}</a>
                        </li>`;
            }

            const lastPage = page + 1;

            text += `<li class="page-item">
                        <a class="page-link" onclick="listSales(${lastPage > numberPages ? 1 : lastPage})" 
                            data-bs-toggle="tooltip" data-bs-title="Próximo">
                            <i class="bx bx-chevron-right"></i>
                        </a>
                    </li></ul></td></tr>`;

            tfoot.html(text);
        }
    }).catch(error => {
        errorRequestAlert(error);
    });
}

function saveSale(e, isUpdate) {
    e.preventDefault();

    let form = new FormData(e.target);
    let parametros = new URLSearchParams();
    parametros.append("acao", isUpdate ? "alterar" : "inserir");

    for (const [key, value] of form) {
        parametros.append(key, value);
    }

    let produtos = [];
    for (let i = 0; i <= countProducts; i++) {
        const proId = $(`#${isUpdate ? 'edit' : 'add' }Modal #proId${i}`).val();
        const prvQuantidade = $(`#${isUpdate ? 'edit' : 'add' }Modal #prvQuantidade${i}`).val();

        produtos.push({
            proId: proId,
            prvQuantidade: prvQuantidade
        });
    }

    parametros.append("produtos", JSON.stringify(produtos));

    $(`${isUpdate ? "#editModal" : "#addModal"} .btn-close`).click();

    fetch("/RocaPlan/VendaServlet", {
        method: "POST",
        body: parametros
    }).then(async response => {
        if (response.status === 200) {
            successfulRequestAlert('salvo');
        } else {
            const data = await response.json();
            errorRequestAlert(data);
        }

        e.target.reset();
    });
}

function successfulRequestAlert(action) {
    Swal.fire({
        icon: "success",
        title: `Venda ${action} com sucesso!`,
        showConfirmButton: false,
        timer: 1500
    });

    listSales();
}

function errorRequestAlert(data) {
    Swal.fire({
        icon: "error",
        title: "Erro(s)",
        html: `<ul class="list-group list-group-flush">${data}</ul>`,
        confirmButtonText: "Fechar",
        confirmButtonColor: "#f07c69"
    });
}

function populateTable(data) {
    let tbody = $("#tbody-vendas");

    if (data.length > 0) {
        tbody.html("");
    } else {
        tbody.html('<tr><td colspan="8">Não há vendas cadastradas.</td></tr>');
    }

    data.forEach(venda => {
        tbody.append(
                `<tr>
                <td>${venda.venId}</td>
                <td>${venda.venNomeCliente}</td>
                <td>${venda.venData}</td>
                <td>${venda.venSituacaoPagamento ? "Pago" : "Não Pago"}</td>
                <td>R$ ${Number(venda.venValorTotal).toFixed(2).replace(".", ",")}</td>
                <td data-bs-toggle="tooltip" data-bs-title="Detalhar">
                    <button class="btn btn-primary btn-sm" onclick="openDetailModal(${venda.venId})">
                        <i class="bx bx-expand"></i>
                    </button>
                </td>
                <td data-bs-toggle="tooltip" data-bs-title="Editar">
                    <button class="btn btn-success btn-sm" onclick="openEditModal(${venda.venId})">
                        <i class="bx bx-edit"></i>
                    </button>
                </td>
                <td data-bs-toggle="tooltip" data-bs-title="Excluir">
                    <button class="btn btn-danger btn-sm" onclick="openDeleteAlert(${venda.venId})">
                        <i class="bx bx-trash"></i>
                    </button>
                </td>
            </tr>`
                );
    });
}