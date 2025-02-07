import React, { useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import './menuLateral.css';

function MenuLateral() {

    const navigate = useNavigate();

    const offcanvasRef = useRef(null); // Referência para o offcanvas

    useEffect(() => {
        offcanvasRef.current = new window.bootstrap.Offcanvas(document.getElementById('offcanvasDark'));
    }, []);

    function handleVisualizarEventos() {
        offcanvasRef.current.hide();
        console.log('Eventos');
        navigate('/eventos');
    }

    function handleVisualizarLocais() {
        offcanvasRef.current.hide();
        console.log('Locais');
    }

    function handleDarFeedback() {
        console.log('Feedback');
    }

    function handleGerenciarUsuarios() {
        navigate('/gerenciarUsuarios');
    }

    function handleGerenciarLocais() {
        navigate('/gerenciarLocais');
    }

    return(
        <div
            className="offcanvas offcanvas-start text-bg-dark"
            tabindex="-1"
            id="offcanvasDark"
        >
            <div className="offcanvas-header mx-2">
                <h5 className="offcanvas-title fs-4 fw-bold text-light my-1">Opções</h5>
                <button
                    type="button"
                    className="btn-close btn-close-white"
                    data-bs-dismiss="offcanvas"
                ></button>
            </div>
            <div
                className="offcanvas-body mx-2 d-flex flex-column justify-content-between"
            >
                <div>
                    <hr className="border border-light mt-0 mb-5" />
                    <a onClick={handleVisualizarEventos}><p className="fs-5 fw-normal">Visualizar eventos</p></a>
                    <a onClick={handleDarFeedback}><p className="fs-5 fw-normal">Dar feedback</p></a>
                    <hr className="border border-light mt-3 mb-3" />
                    <a onClick={handleGerenciarUsuarios}><p className="fs-5 fw-normal">Gerenciar usuários</p></a>
                    <a onClick={handleGerenciarLocais}><p className="fs-5 fw-normal">Gerenciar locais</p></a>
                </div>

                <div className="d-flex justify-content-center">
                    <img src="/facebook.svg" className="mx-3" alt="Ícone do Facebook" />
                    <img src="/instagram.svg" className="mx-3" alt="Ícone do Instagram" />
                    <img src="/whatsapp.svg" className="mx-3" alt="Ícone do Whatsapp" />
                </div>
            </div>
        </div>
    );
}

export default MenuLateral;