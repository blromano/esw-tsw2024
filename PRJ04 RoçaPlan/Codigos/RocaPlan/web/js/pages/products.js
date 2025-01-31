// Executado quando o DOM carregar
document.addEventListener("DOMContentLoaded", function () {
    listProducts();
});

function showOtherType(value) {
    if (value === "other") {
        document.getElementById('otherType').classList.remove('d-none');
        document.querySelector('[name="newTpr"]').setAttribute('required', 'true');
    } else {
        document.getElementById('otherType').classList.add('d-none');
        document.querySelector('[name="newTpr"]').removeAttribute('required');
    }
}

function listProducts() {
    let parametros = new URLSearchParams();
    parametros.append("acao", "listar");

    fetch("/RocaPlan/ProdutoServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        return response.json();
    }).then(data => {
        populateTable(data);
    }).catch(error => {
        errorRequestAlert(error);
    });
}

function openEditModal(idProduto) {
    let parametros = new URLSearchParams();
    parametros.append("acao", "prepararAlteracao");
    parametros.append("proId", idProduto);

    fetch("/RocaPlan/ProdutoServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        return response.json();
    }).then(data => {
        // Populando Campos
        $('#editModal input[name="proNome"]').val(data.proNome);
        $('#editModal #editTprId').val(data.tipoProduto.tprId);
        $('#editModal input[name="proQuantidade"]').val(data.proQuantidade);
        $('#editModal input[name="proValorUnitario"]').val(data.proValorUnitario);
        $('#editModal input[name="proId"]').val(data.proId);

        // Abrindo Modal
        var editModal = new bootstrap.Modal($('#editModal'));
        editModal.show();
    }).catch(error => {
        alert("Erro: " + error);
    });
}

function openDeleteAlert(idProduto) {
    Swal.fire({
        title: "Tem certeza que deseja deletar este produto?",
        icon: "warning",
        showCancelButton: true,
        cancelButtonText: "Não",
        cancelButtonColor: "#f07c69",
        confirmButtonText: "Sim",
        confirmButtonColor: "#84d474"
    }).then((result) => {
        if (result.isConfirmed) {
            let parametros = new URLSearchParams();
            parametros.append("acao", "excluir");
            parametros.append("proId", idProduto);

            fetch("/RocaPlan/ProdutoServlet", {
                method: "POST",
                body: parametros
            }).then(async response => {
                if (response.status === 200) {
                    successfulRequestAlert('excluído');
                } else {
                    const data = await response.json();
                    errorRequestAlert(data);
                }
            });
        }
    });
}

function saveProduct(e, isUpdate) {
    e.preventDefault();

    let form = new FormData(e.target);
    let parametros = new URLSearchParams();
    parametros.append("acao", isUpdate ? "alterar" : "inserir");

    for (const [key, value] of form) {
        parametros.append(key, value);
    }

    $(`${isUpdate ? "#editModal" : "#addModal"} .btn-close`).click();

    fetch("/RocaPlan/ProdutoServlet", {
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

function filterProducts(e) {
    e.preventDefault();

    let form = new FormData(e.target);
    let parametros = new URLSearchParams();
    parametros.append("acao", "filtrar");

    for (const [key, value] of form) {
        parametros.append(key, value);
    }

    fetch("/RocaPlan/ProdutoServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        return response.json();
    }).then(data => {
        populateTable(data);
    }).catch(error => {
        errorRequestAlert(error);
    });
}

function successfulRequestAlert(action) {
    Swal.fire({
        icon: "success",
        title: `Produto ${action} com sucesso!`,
        showConfirmButton: false,
        timer: 1500
    });

    listProducts();
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
    let tbody = $("#tbody-produtos");

    if (data.length > 0) {
        tbody.html("");
    } else {
        tbody.html('<tr><td colspan="7">Não há produtos cadastrados.</td></tr>');
    }

    data.forEach(produto => {
        tbody.append(
            `<tr>
                <td>${produto.proId}</td>
                <td>${produto.proNome}</td>
                <td>${produto.tipoProduto.tprNome}</td>
                <td>${produto.proQuantidade}</td>
                <td>R$ ${Number(produto.proValorUnitario).toFixed(2).replace(".", ",")}</td>
                <td data-bs-toggle="tooltip" data-bs-title="Editar">
                    <button class="btn btn-success btn-sm" onclick="openEditModal(${produto.proId})">
                        <i class="bx bx-edit"></i>
                    </button>
                </td>
                <td data-bs-toggle="tooltip" data-bs-title="Excluir">
                    <button class="btn btn-danger btn-sm" onclick="openDeleteAlert(${produto.proId})">
                        <i class="bx bx-trash"></i>
                    </button>
                </td>
            </tr>`
        );

        // Não tem aquele item no select de tipo ainda
        if ($(`#addTprId option[value=${produto.tipoProduto.tprId}]`).length === 0) {
            $('#addTprId, #editTprId, #filterTprId').append(
                `<option value="${produto.tipoProduto.tprId}">
                    ${produto.tipoProduto.tprNome}
                </option>`
            );
        }
    });
}

