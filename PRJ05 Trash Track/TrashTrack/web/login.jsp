<%-- 
    Document   : login
    Created on : 6 de dez. de 2024, 11:19:53
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
    <style>

    </style>
</head>
<body>

    <div class="container-fluid vh-100">
        <div class="row" style="height: 100%;">

            <!-- Coluna esquerda -->
            <div class="col-md-6 background-site d-flex align-items-center justify-content-center">
                <div>
                    <img src="img/reciclagem.png" alt="">
                </div>
            </div>


            <!-- Coluna direita -->
            <div class="col-md-6 d-flex flex-column">

                <!-- Botão de voltar -->
                <div class="mb-3" style="position: absolute; margin-top: 5%; margin-left: 5%;">
                    <a href="index.jsp" class=""> &lt; Home</a>
                </div>

            
                <!-- parte inteira do login -->
                <div class="d-flex justify-content-center align-items-center flex-grow-1">

                    <div class="login-container text-left">
                        <form method="post" id="btnLogin">
                            <input name="acao" type="hidden" value="login"/>
                                <h2>Login</h2>
                                <p class="cinza">Se você ja é um membro do TrashTrack você ja pode realizar seu login.</p>

                                <!-- login  -->
                                <div class="form-group">
                                    <label for="email" class="cinza">Email</label>
                                    <input type="text" id="email" name="email" class="form-control botao-forms" placeholder="" value="${param.email}">
                                </div>

                                <!-- senha -->
                                <div class="form-group">
                                    <label for="password" class="cinza">Senha</label>
                                    <input type="password" id="password" name="senha" class="form-control botao-forms" placeholder="">
                                </div>
                                
                                <div class="form-check">
                                <input class="form-check-input" type="checkbox" value="" id="lembrar-usuario">
                                <label class="form-check-label cinza" for="lembrar-usuario">
                                Lembrar de mim
                                </label>
                                </div>

                                <br>

                                <button type="submit" class="btn btn-primary" style="margin-bottom: 20px;">Entrar</button>
                                <p>Não tem uma conta ? <a href="cadastro.jsp"> Registre-se aqui</a></p>
                                <a href="recuperar-senha.html">Recuperar Senha </a>

                        
                            </form>         
                        </div>
                    </div>
                </div>
            </div>
        </div>
    

    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- Script do JavaScript do Bootstrap (opcional, mas recomendado) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
    
    <!-- Script Cadastro/Login-->
    <script src="js/script-cadastro-login.js"></script>
</body>
</html>

