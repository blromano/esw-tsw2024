<%-- 
    Document   : cadastro
    Created on : 6 de dez. de 2024, 10:03:45
    Author     : majus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TrashTrack</title>

    <!-- Link do CSS Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style-cadastro-login.css">
</head>
<body>
    <div class="container-fluid vh-100">
        <div class="row" style="height: 100%;">
            <!-- Coluna esquerda -->
            <div class="col-md-6 background-site d-flex align-items-center justify-content-center">
                <div>
                    <img src="img/register-icon.png" alt="IconeFolha">
                </div>
            </div>
            <!-- Coluna direita -->
            <div class="col-md-6 d-flex flex-column">

                <!-- Botão de voltar -->
                <div class="mb-3" style="position: absolute; margin-top: 5%; margin-left: 5%;">
                    <a href="index.jsp"> &lt; Home</a>
                </div>

                <!-- parte inteira do registro -->
                <div class="d-flex justify-content-center align-items-center flex-grow-1">

                    <div class="login-container text-left">

                        <!-- Exibição de mensagens de erro -->
                        
                        <div class="alert alert-danger" role="alert" id="caixaErro">
                                <p id="mensagemErro"></p>
                            </div>
                        
                        <form method="post" id="btnCadastro">
                            <h2>Cadastro</h2>
                            <p class="cinza">Se torne um membro e aproveite dos benefícios!</p>

                            <!-- Nome -->
                            <div class="form-group">
                                <label for="nome" class="cinza">Nome Completo</label>
                                <input type="text" name="nome" class="form-control botao-forms" required>
                            </div>

                            <!-- Email -->
                            <div class="form-group">
                                <label for="email" class="cinza">Email</label>
                                <input type="email" name="email" class="form-control botao-forms" required>
                            </div>

                            <!-- Data de nascimento -->
                            <div class="form-group">
                                <label for="data-nsc" class="cinza">Data de Nascimento</label>
                                <input type="date" name="dataNascimento" class="form-control botao-forms text-center" required>
                            </div>

                            <!-- CPF -->
                            <div class="form-group">
                                <label for="cpf" class="cinza">CPF</label>
                                <input type="text" name="cpf" class="form-control botao-forms text-center" 
                                placeholder="000.000.000-00" autocomplete="off" 
                                maxlength="14" required>
                            </div>                                            

                            <!-- Senha -->
                            <div class="form-group">
                                <label for="password" class="cinza">Senha</label>
                                <div class="d-flex align-items-center botao-forms form-control botao-senha">
                                    <input type="password" name="senha" id="password" required>
                                    <img src="img/eye-close.png" id="eyeicon" name="eyeicon" onclick="mostrarsenha()">
                                </div>
                            </div>

                            <!-- Confirmar senha -->
                            <div class="form-group">
                                <label for="password2" class="cinza">Confirmar Senha</label>
                                <div class="d-flex align-items-center botao-forms form-control botao-senha">
                                    <input type="password" name="confirmarSenha" id="password2" required>
                                    <img src="img/eye-close.png" alt="" id="eyeicon2" name="eyeicon2" onclick="confirmarsenha()">
                                </div>
                            </div>

                            <!-- Botão enviar cadastro -->
                            <button type="submit" class="btn btn-primary" style="margin-top: 20px;">Cadastrar</button>
                        </form> 
                    </div>
                </div>    
            </div>
        </div>
    </div>

    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Script do JavaScript do Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>

    <!-- scripts -->
    <script src="js/script-cadastro-login.js"></script>
</body>
</html>


