import React from "react";
import { useNavigate } from "react-router-dom";
import './cadastro.css';
import Header from "../components/header";

function Cadastro() {

    const navigate = useNavigate();

    function handleCadastro() {

        // verificar e salvar no banco

        navigate('/login');
    }

    function handleLogin() {
        navigate('/login');
    }

    return (
        <div className="container-fluid p-0 d-flex flex-column justify-content-center align-items-center">

            <Header paginaInicial={false} lista={false} />

            <section className="h-100">
                <div className="container py-5 h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                    <div className="col-xl-11">
                        <div className="card rounded-3">
                        <div className="row g-0">
                            <div
                            className="col-lg-6 d-flex align-items-center gradient-custom-2 justify-content-center rounded bg-light"
                            >
                            <div className="px-3 py-4 p-md-5 mx-md-4">
                                <img src="/signup-icon.svg" alt="Ícone de cadastro" />
                            </div>
                            </div>
                            <div className="col-lg-6">
                            <div className="card-body p-md-5 mx-md-4">
                                <form className="my-5">
                                <h1 className="fs-1 fw-normal text-center">Bem vindo(a)!</h1>
                                <div className="mt-4 mb-2">
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
                                    <label htmlFor="inputPassword">Senha</label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="inputPassword"
                                    />
                                    <label htmlFor="inputConfirmPassword"
                                    >Confirmar senha</label>
                                    <input
                                        type="password"
                                        className="form-control"
                                        id="inputConfirmPassword"
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

                                <button
                                    type="button"
                                    className="btn btn-light w-100 mb-3"
                                    onClick={handleCadastro}
                                >
                                    Cadastrar
                                </button>
                                <p className="text-center">
                                    Já tem uma conta? <a className="link-underline-opacity-0 link-underline-opacity-75-hover" onClick={handleLogin}>Faça login</a>
                                </p>
                                </form>
                            </div>
                            </div>
                        </div>
                        </div>
                    </div>
                    </div>
                </div>
                </section>
        </div>
    );
}

export default Cadastro;