// Executado quando o DOM carregar
document.addEventListener("DOMContentLoaded", function(e) {
    let parametros = new URLSearchParams();
    parametros.append( "acao", "listar" );
    
    fetch("/RocaPlan/ProdutoServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        // faz o parse do json em objeto e retorna
        return response.json();
    }).then(data => {
        let tbody = $("#tbody-produtos");
        
        if(data.length > 0) {
            tbody.html("");
        }        
        
        data.forEach( produto => {
            tbody.append(
               `<tr>
                    <td>${produto.proId}</td>
                    <td>${produto.proNome}</td>
                    <td>${produto.tipoProduto.tprNome}</td>
                    <td>${produto.proQuantidade}</td>
                    <td>${produto.proValorUnitario}</td>
                    <td data-bs-toggle="tooltip" data-bs-title="Editar">
                        <button class="btn btn-success btn-sm" onclick="openEditModal(${produto.proId})">
                            <i class="bx bx-edit"></i>
                        </button>
                    </td>
                    <td data-bs-toggle="tooltip" data-bs-title="Excluir">
                        <button class="btn btn-danger btn-sm" data-bs-toggle="modal"
                                data-bs-target="#deleteModal">
                            <i class="bx bx-trash"></i>
                        </button>
                    </td>
                </tr>`
            );
        });
    }).catch( error => {
        alert( "Erro: " + error );
    });
});

function openEditModal(idProduto) {
    let parametros = new URLSearchParams();
    parametros.append( "acao", "prepararAlteracao" );
    parametros.append( "id", idProduto );
    
    fetch("/RocaPlan/ProdutoServlet", {
        method: "POST",
        body: parametros
    }).then(response => {
        // faz o parse do json em objeto e retorna
        return response.json();
    }).then(data => {
        // Populando Campos
        document.querySelector('#editModal input[name="nome"]').value = data.proNome;
        document.querySelector('#editModal #type').value = data.tipoProduto.tprId;
        document.querySelector('#editModal input[name="quantidade"]').value = data.proQuantidade;
        document.querySelector('#editModal input[name="valorUnitario"]').value = data.proValorUnitario;
        document.querySelector('#editModal input[name="id"]').value = data.proId;
        
        // Abrindo Modal
        document.querySelector('#editModal').classList.add('show');
        document.querySelector('#editModal').style.display = 'block';
    }).catch( error => {
        alert( "Erro: " + error );
    });
}

function showOtherType(value, id) {
    if (value == 5) {
        document.getElementById(id).classList.remove('d-none');

        if (id == 'other-type') {
            document.getElementById('btn-filter-clear').classList.replace('col-md-2', 'col-md-6');
            document.getElementById('btn-filter').classList.replace('col-md-2', 'col-md-6');
        }
    } else {
        document.getElementById(id).classList.add('d-none');

        if (id == 'other-type') {
            document.getElementById('btn-filter-clear').classList.replace('col-md-6', 'col-md-2');
            document.getElementById('btn-filter').classList.replace('col-md-6', 'col-md-2');
        }
    }
}

