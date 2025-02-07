import React from 'react';
import { useNavigate } from 'react-router-dom';
import './header.css';
import MenuLateral from './menuLateral';

function Header( { paginaInicial, lista } ) {

    const navigate = useNavigate();

    function handlePaginaInicial() {
        console.log('Deu bom');
        navigate('/');
    }

    function handleLogin() {
        console.log('Deu bom');
        navigate('/login');
    }

    function handleCadastro() {
        console.log('Deu bom');
        navigate('/cadastro');
    }

    return (
        <header className="container-fluid p-0">
            <nav className="navbar p-3">
                <div className={`container ${lista ? 'd-flex align-itens-center' : ''} `}>

                    <div className={ lista ? 'd-flex' : 'd-none' }>
                        <img className="btn py-0 my-0 mx-0" src="/sidebar-icon.svg" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDark" alt="Ícone de lista"/>
                    </div>

                    <div className={ lista ? 'custom' : '' }>
                        <a className="d-flex align-items-center" onClick={handlePaginaInicial}>
                            <img src="/pin.svg" alt="Logo" width="30" height="35" />
                            <span className="ms-3 fw-bold text-light">Guia São João</span>
                        </a>
                    </div>

                    <div>
                        { paginaInicial && <button className="btn btn-light mx-1" type="button" onClick={handleCadastro}>Cadastro</button>}
                        { paginaInicial && <button className="btn btn-light mx-2" type="button" onClick={handleLogin}>Login</button>}
                    </div>
                </div>
            </nav>
            <MenuLateral />
        </header>   
    );
}

export default Header;