import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header.jsx';

function GerenciarLocais() {

    const navigate = useNavigate();

    function handleBuscarLocais() {
        console.log('Buscando locais')
    }


    return (
        <div className="container-fluid p-0 d-flex flex-column justify-content-center align-items-center">

            <Header paginaInicial={false} lista={true} />

            <div className="container mt-5">
                <h2 className="text-center mb-4 text-light">Gerenciar locais</h2>

                <div className="input-group mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Buscar locais..."
                    />
                    <span className="input-group-text"
                        ><img src="/search.svg" alt="Pesquisar" onClick={handleBuscarLocais}
                    /></span>
                </div>

                <table className="table table-striped ">
                    <thead className="table-dark">
                        <tr>
                            <th>Nome</th>
                            <th>Endereço</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Catedral</td>
                            <td>Praça da Catedral - Centro</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar local"
                                    data-bs-toggle="modal" data-bs-target="#editarLocal"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir local"
                                    data-bs-toggle="modal" data-bs-target="#excluirLocal"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Teatro Municipal</td>
                            <td>Praça da Catedral, 22 - Centro</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar local"
                                    data-bs-toggle="modal" data-bs-target="#editarLocal"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir local"
                                    data-bs-toggle="modal" data-bs-target="#excluirLocal"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Cachoeira do Mirante</td>
                            <td>Estrada da Serra da Paulista, 3897 - Sítio Santana</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar local"
                                    data-bs-toggle="modal" data-bs-target="#editarLocal"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir local"
                                    data-bs-toggle="modal" data-bs-target="#excluirLocal"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Igreja São Sebastião</td>
                            <td>Rua Maria Inês da S Oliveira, 50 - Vila Valentim</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar local"
                                    data-bs-toggle="modal" data-bs-target="#editarLocal"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir local"
                                    data-bs-toggle="modal" data-bs-target="#excluirLocal"
                                />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div class="modal fade" id="editarLocal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="editarLocalLabel">Editar local</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                <div className="card-body p-md-5 mx-md-4">
                                    <form className="my-0">
                                        <div className="mt-0 mb-0">
                                            <label htmlFor="inputName">Nome</label>
                                            <input
                                                type="text"
                                                className="form-control"
                                                id="inputName"
                                            />
                                            <label htmlFor="inputEndereco">Endereço</label>
                                            <input
                                                type="text"
                                                className="form-control"
                                                id="inputEndereco"
                                            />
                                            <label htmlFor="inputEndereco">Descrição</label>
                                            <input
                                                type="text"
                                                className="form-control"
                                                id="inputDescricao"
                                            />
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="excluirLocal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="editarLocalLabel">Excluir local</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir esse local?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-dark" data-bs-dismiss="modal">Confirmar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default GerenciarLocais;