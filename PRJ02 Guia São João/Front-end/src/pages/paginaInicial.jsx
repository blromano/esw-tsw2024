import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header.jsx';
import './paginaInicial.css';

function PaginaInicial() {

    const navigate = useNavigate();

    return (
        <div>
            <Header paginaInicial={true} lista={false} />

            <div className="container-fluid p-0 position-relative">
                <img
                    src="/bg-pattern.svg"
                    className="img-fluid w-100"
                    alt="Imagem de fundo"
                />
                <div
                    className="position-absolute top-50 start-50 translate-middle text-center p-4 slogan-container"
                >
                    <h1 className="slogan display-4 text-light fw-bold mb-3">
                    São João como você nunca viu.
                    </h1>
                    <h2 className="text-light fw-normal">Explore e surpreenda-se.</h2>
                </div>
            </div>

            <div className="container-fluid py-5 custom-section">
            <div className="row align-items-center justify-content-center">
                <div className="col-md-5 text-center">
                    <img
                        src="/map-icon.svg"
                        className="img-fluid me-5"
                        alt="Importância do Guia São João"
                    />
                    </div>
                    <div className="col-md-4">
                        <h3 className="fw-bold mb-4">Descubra São João com seu guia!</h3>
                        <p className="fs-5 fw-normal">
                            Este portal é a sua chave para explorar tudo o que a cidade tem a
                            oferecer. Desde eventos locais vibrantes até informações úteis sobre
                            serviços essenciais como hospitais, escolas e centros de reciclagem,
                            o Guia São João foi projetado para conectar você com a comunidade.
                            Navegue por um mapa interativo que destaca as áreas de Zona Azul e
                            fique por dentro das novidades e atividades que tornam nossa cidade
                            especial. Junte-se a nós e aproveite ao máximo o que São João da Boa
                            Vista tem a oferecer!
                        </p>
                    </div>
                </div>
            </div>

            <main className="container-fluid px-0 py-5 text-light">
                <div className="container py-5">
                    <section className="mb-5">
                        <h2 className="text-center mb-4">Próximos eventos</h2>
                        <div className="row justify-content-center py-3">
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Festa Junina do Bairro</h3>
                                    <div className="card-body">
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 24/06/2024</li>
                                            <li className="list-group-item">Local: Praça Central</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Arraial Beneficente</h3>
                                    <div className="card-body">
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 30/06/2024</li>
                                            <li className="list-group-item">Local: Igreja São João</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Show de Forró</h3>
                                    <div className="card-body">
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 05/07/2024</li>
                                            <li className="list-group-item">Local: Parque Municipal</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>

                    <section className="mt-5">
                        <h2 className="text-center mb-4">Feedback dos usuários</h2>
                        <div className="row justify-content-center py-3">
                            <div className="col-md-4 mb-3">
                                <div className="card h-100 text-dark">
                                    <div className="card-body">
                                        <blockquote className="blockquote mb-0">
                                            <p>
                                            Ótimo site! Fácil de usar e cheio de informações úteis.
                                            </p>
                                            <footer className="blockquote-footer text-end">
                                            João Silva
                                            </footer>
                                        </blockquote>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card h-100 text-dark">
                                    <div className="card-body">
                                        <blockquote className="blockquote mb-0">
                                            <p>
                                            Amei a seção de eventos! Consegui encontrar várias festas
                                            na minha região.
                                            </p>
                                            <footer className="blockquote-footer text-end">
                                            Maria Oliveira
                                            </footer>
                                        </blockquote>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card h-100 text-dark">
                                    <div className="card-body">
                                        <blockquote className="blockquote mb-0">
                                            <p>Interface limpa e funcional. Parabéns pelo trabalho!</p>
                                            <footer className="blockquote-footer text-end">
                                            Pedro Souza
                                            </footer>
                                        </blockquote>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
            </main>
        </div>
    );
}

export default PaginaInicial;