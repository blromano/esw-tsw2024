import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header.jsx';
import './login.css';

function Login() {

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


    return (
        <div className="container-fluid p-0 d-flex flex-column justify-content-center align-items-center">

            <Header paginaInicial={false} lista={false} />

            <section className="h-100">
            <div className="container py-5 h-100">
                    <div className="row d-flex justify-content-center align-items-center h-100">
                        <div className="col-xl-11">
                            <div className="card rounded-3">
                                <div className="row g-0">
                                    <div className="col-lg-6">
                                        <div className="card-body p-md-5 mx-md-4">
                                            <form className="my-5">
                                                <h1 className="fs-1 fw-normal text-center">Login</h1>
                                                <div className="mt-4 mb-2">
                                                    <label for="inputEmail">Email</label>
                                                    <input
                                                    type="email"
                                                    className="form-control"
                                                    id="inputEmail"
                                                    />
                                                    <label for="inputPassword">Senha</label>
                                                    <input
                                                    type="password"
                                                    className="form-control"
                                                    id="inputPassword"
                                                    />
                                                </div>

                                                <div className="mb-3 d-flex justify-content-between">
                                                    <div className="form-check">
                                                        <input
                                                            className="form-check-input"
                                                            type="checkbox"
                                                            id="disabledFieldsetCheck"
                                                        />
                                                        <label
                                                            className="form-check-label"
                                                            htmlFor="disabledFieldsetCheck"
                                                        >
                                                            Lembrar senha
                                                        </label>
                                                    </div>
                                                    <div>
                                                        <a><p className="text-dark" onClick={handleEsqueciMinhaSenha}>Esqueci minha senha</p></a>
                                                    </div>
                                                </div>

                                                <button
                                                    type="button"
                                                    className="btn btn-light w-100 mb-3"
                                                    onClick={handleLogin}
                                                >
                                                    Login
                                                </button>
                                                <p className="text-center">
                                                    Ainda não tem uma conta? <a className="link-underline-opacity-0 link-underline-opacity-75-hover" onClick={handleCadastro}>
                                                        Cadastre-se
                                                    </a>
                                                </p>
                                            </form>
                                        </div>
                                    </div>
                                    <div className="col-lg-6 d-flex align-items-center gradient-custom-2 justify-content-center rounded bg-light">
                                        <div className="px-3 py-4 p-md-5 mx-md-4">
                                            <img src="/login-icon.svg" alt="login icon" />
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

export default Login;