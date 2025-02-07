import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header.jsx';

function GerenciarUsuarios() {

    const navigate = useNavigate();

    function handleLogin() {

        // autenticar e ver se é admin ou não

        navigate('/mapa');
    }

    function handleCadastro() {
        navigate('/cadastro');
    }

    function handleEsqueciMinhaSenha() {
        navigate('/esqueciMinhaSenha')
    }

    function handleBuscarUsuarios() {
        console.log('Buscando usuários')
    }


    return (
        <div className="container-fluid p-0 d-flex flex-column justify-content-center align-items-center">

            <Header paginaInicial={false} lista={true} />

            <div className="container mt-5">
                <h2 className="text-center mb-4 text-light">Gerenciar usuários</h2>

                <div className="input-group mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Buscar usuários..."
                    />
                    <span className="input-group-text"
                        ><img src="/search.svg" alt="Pesquisar" onClick={handleBuscarUsuarios}
                    /></span>
                </div>

                <table className="table table-striped ">
                    <thead className="table-dark">
                        <tr>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Webert Assis</td>
                            <td>webertassis@gmail.com</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar usuário"
                                    data-bs-toggle="modal" data-bs-target="#editarUsuario"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir usuário"
                                    data-bs-toggle="modal" data-bs-target="#excluirUsuario"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Mateus Rosa</td>
                            <td>mateusrosa@gmail.com</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar usuário"
                                    data-bs-toggle="modal" data-bs-target="#editarUsuario"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir usuário"
                                    data-bs-toggle="modal" data-bs-target="#excluirUsuario"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Matheus Viana</td>
                            <td>matheusviana@gmail.com</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar usuário"
                                    data-bs-toggle="modal" data-bs-target="#editarUsuario"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir usuário"
                                    data-bs-toggle="modal" data-bs-target="#excluirUsuario"
                                />
                            </td>
                        </tr>
                        <tr>
                            <td>Marco Antônio</td>
                            <td>marcoantonio@gmail.com</td>
                            <td>
                                <img
                                    src="/edit-icon.svg"
                                    className="img-fluid"
                                    alt="Editar usuário"
                                    data-bs-toggle="modal" data-bs-target="#editarUsuario"
                                />
                            </td>
                            <td>
                                <img
                                    src="/delete-icon.svg"
                                    className="img-fluid"
                                    alt="Excluir usuário"
                                    data-bs-toggle="modal" data-bs-target="#excluirUsuario"
                                />
                            </td>
                        </tr>
                    </tbody>
                </table>

                <div class="modal fade" id="editarUsuario" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="editarUsuarioLabel">Editar usuário</h1>
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
                                            <label htmlFor="inputEmail">Email</label>
                                            <input
                                                type="email"
                                                className="form-control"
                                                id="inputEmail"
                                            />
                                            <label htmlFor="inputTelefone">Telefone</label>
                                            <input
                                                type="number"
                                                className="form-control"
                                                id="inputTelefone"
                                            />
                                            <label htmlFor="inputEndereco">Endereço</label>
                                            <input
                                                type="text"
                                                className="form-control"
                                                id="inputEndereco"
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

                <div class="modal fade" id="excluirUsuario" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
                    <div class="modal-dialog modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="editarUsuarioLabel">Excluir usuário</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">
                                Deseja realmente excluir esse usuário?
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

export default GerenciarUsuarios;