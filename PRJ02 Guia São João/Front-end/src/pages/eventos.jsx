import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header';
import './eventos.css';

function Eventos() {

    const navigate = useNavigate();

    function handleBusca() {

    }

    return (
        <div>

            <Header paginaInicial={false} lista={true} />

            <main className="d-flex justify-content-center align-items-center vh-100">
                <div className="w-75 h-75">
                    <div className="input-group mb-3">
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Buscar locais..."
                        />
                        <span className="input-group-text"
                            ><img src="/search.svg" alt="Pesquisar" onClick={handleBusca}
                        /></span>
                    </div>
                    <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3700.1525787880173!2d-46.81527092392906!3d-21.96710640496662!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94c9cca77098ac5f%3A0x1c68374dfb5e08c0!2sInstituto%20Federal%20de%20Educa%C3%A7%C3%A3o%2C%20Ci%C3%AAncia%20e%20Tecnologia%20de%20S%C3%A3o%20Paulo%2C%20C%C3%A2mpus%20S%C3%A3o%20Jo%C3%A3o%20da%20Boa%20Vista!5e0!3m2!1sen!2sbr!4v1724884430854!5m2!1sen!2sbr"
                    width="100%"
                    height="600"
                    style={{border: 0}}
                    allowfullscreen=""
                    loading="lazy"
                    >
                    </iframe>
                </div>
            </main>

            <main className="container-fluid px-0 text-light">
                <div className="container">
                    <section className="mb-5">
                        <h2 className="text-center mb-4">Próximos eventos</h2>
                        <div className="row justify-content-center py-3">
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Festa Junina do Bairro</h3>
                                    <div className="card-body">
                                        <img src="../../public/1.jpg" className="img-fluid"/>
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 24/06/2024</li>
                                            <li className="list-group-item">Local: Praça Central</li>
                                            <li className="list-group-item">Descrição: Uma tradicional festa junina com comidas típicas, quadrilha e música ao vivo.</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Arraial Beneficente</h3>
                                    <div className="card-body">
                                        <img src="../../public/2.jpg" className="img-fluid"/>
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 30/06/2024</li>
                                            <li className="list-group-item">Local: Igreja São João</li>
                                            <li className="list-group-item">Descrição: Evento beneficente com barracas de jogos, comidas e apresentações culturais.</li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div className="col-md-4 mb-3">
                                <div className="card text-dark">
                                    <h3 className="card-header">Show de Forró</h3>
                                    <div className="card-body">
                                        <img src="../../public/3.jpg" className="img-fluid"/>
                                        <ul className="list-group list-group-flush">
                                            <li className="list-group-item">Data: 05/07/2024</li>
                                            <li className="list-group-item">Local: Parque Municipal</li>
                                            <li className="list-group-item">Descrição: Grande show de forró com bandas locais e muita animação para dançar a noite inteira.</li>
                                        </ul>
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

export default Eventos;