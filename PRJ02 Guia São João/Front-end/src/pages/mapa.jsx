import React from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/header';
import './mapa.css';

function Mapa() {

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
        </div>
    );
}

export default Mapa;