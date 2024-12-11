<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="cad-prof.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.min.js"></script>
    <link rel="icon" href="../selec-TipoCadastro/img - Fazer Cadastros/icon-conecta.svg" type="image/x-icon">
    <title>Conecta+ | Cadastre-se como profissional aqui!</title>
</head>
<body>
    <script>
        $(document).ready(function(){
            $('#cpf').mask('000.000.000-00');
            $('#celular').mask('(00) 00000-0000');
            $('#telComercial').mask('(00) 00000-0000');
            $('#dataNasc').mask('00/00/0000');
        });
    </script>

    <div class="container">
        <div class="form-image">
            <img src="/Paginas Primarias/UC4.18 - Fazer Cadastro Profissional/img/arte-cadastro.svg" alt="">
        </div>
        <div class="form">
            <form method="POST" action="${cp}/tratarProfissional">
                
                <input name="acao" type="hidden" value="inserir"/>
                
                <div class="form-header">
                    <div class="title">
                        <h1>Cadastre-se como Profissional</h1>
                    </div>
                </div>

                <!-- Área rolável -->
                <div class="scrollable-form">
                    <div class="input-group">
                        <div class="input-box">
                            <label for="firstname">Nome Completo</label>
                            <input id="name" type="text" name="name" placeholder="Digite seu nome completo" required>
                        </div>

                        <div class="input-box">
                            <label for="dataNasc">Data de Nascimento</label>
                            <input id="dataNasc" type="text" name="dataNasc" placeholder="00/00/0000" required>
                        </div>
                        <div class="input-box">
                            <label for="celular">Celular</label>
                            <input id="celular" type="text" name="celular" placeholder="(xx) xxxxx-xxxx" required>
                        </div>

                        <div class="input-box">
                            <label for="telComercial">Telefone Comercial</label>
                            <input id="telComercial" type="text" name="telComercial" placeholder="(xx) xxxxx-xxxx" required>
                        </div>

                        <div class="input-box">
                            <label for="email">E-mail</label>
                            <input id="email" type="email" name="email" placeholder="Digite seu e-mail" required>
                        </div>

                        <div class="input-box">
                            <label for="Estado">Estado (UF)</label> 
                            <input id="Estado" type="text" name="Estado" placeholder="Ex: SP" required>
                        </div>

                        <div class="input-box">
                            <label for="Cidade">Cidade</label>
                            <input id="Cidade" type="text" name="cidade" placeholder="Ex: Osasco" required>
                        </div>

                        <div class="input-box">
                            <label for="Endereço">Endereço</label>
                            <input id="Endereço" type="text" name="endereço" placeholder="Digita seu endereço" required>
                        </div>

                        <div class="input-box">
                            <label for="endComercial">Endereço Comercial</label>
                            <input id="endComercial" type="text" name="endComercial" placeholder="Digita seu endereço" required>
                        </div>

                        <div class="input-box">
                            <label for="cpf">CPF (Cadastro de Pessoa Física)</label>
                            <input id="cpf" type="text" name="cpf" placeholder="000.000.000-00" required>
                        </div>

                        <div class="input-box">
                            <label for="password">Senha</label>
                            <input id="password" type="password" name="password" placeholder="Digite sua senha" required>
                        </div>

                        <div class="input-box">
                            <label for="confirmPassword">Confirme sua Senha</label>
                            <input id="confirmPassword" type="password" name="confirmPassword" placeholder="Digite sua senha novamente" required>
                        </div>
                        
                        <div class="input-box">
                            <label for="fotoPerfil">Envie uma foto de perfil</label>
                            <div class="input-box">
                            <input type="file" id="fileInput" accept="image/*">
                                <img id="preview" src="" alt="Pré-visualização da imagem" placeholder="envia sua imagem">
                                </div>
                        </div>

                    </div>
                </div>

                <div class="continue-button">
                    <input type="submit" value="Cadastrar-me"/>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
