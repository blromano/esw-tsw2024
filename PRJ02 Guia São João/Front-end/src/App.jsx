import React, { Suspense } from 'react';
import { Routes, Route } from 'react-router-dom';
const PaginaInicial = React.lazy(() => import('./pages/paginaInicial'));
const Login = React.lazy(() => import('./pages/login'));
const Cadastro = React.lazy(() => import('./pages/cadastro'));
const Mapa = React.lazy(() => import('./pages/mapa'));
const Eventos = React.lazy(() => import('./pages/eventos'));
const EsqueciMinhaSenha = React.lazy(() => import('./pages/esqueciMinhaSenha'));
const GerenciarUsuarios = React.lazy(() => import('./pages/gerenciarUsuarios'));
const GerenciarLocais = React.lazy(() => import('./pages/gerenciarLocais'));


function App() {

  return (
    <Suspense fallback='Carregando...'>
      <Routes>
          <Route path="/" element={<PaginaInicial />} />
          <Route path="/login" element={<Login />} />
          <Route path="/cadastro" element={<Cadastro />} />
          <Route path="/mapa" element={<Mapa />} />
          <Route path="/eventos" element={<Eventos />} />
          <Route path="/esqueciMinhaSenha" element={<EsqueciMinhaSenha />} />
          <Route path="/gerenciarUsuarios" element={<GerenciarUsuarios />} />
          <Route path="/gerenciarLocais" element={<GerenciarLocais />} />
      </Routes>
    </Suspense>  
  )
}

export default App;
