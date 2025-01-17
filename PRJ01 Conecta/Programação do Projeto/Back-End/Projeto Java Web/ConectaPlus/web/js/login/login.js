<script>
    document.getElementById("btnLogin").addEventListener("click", async function (event) {
     // Impede o envio padrão do formulário

        // Obtendo os valores dos campos
        const email = document.getElementById("email").value;
        const senha = document.getElementById("password").value;

        if (!email || !senha) {
            alert("Por favor, preencha todos os campos.");
            return;
        }

        try {
            // Enviando os dados ao back-end
            const response = await fetch("UsuarioServlet", {
                method: "POST",
                headers: {
                    "Content-Type": "application/x-www-form-urlencoded",
                },
                body: new URLSearchParams({
                    acao: "autenticar",
                    email: email,
                    password: senha,
                }),
            });

            if (response.ok) {
                const result = await response.json(); // Supondo que o servlet retorne JSON
                if (result.autenticado) {
                    // Login bem-sucedido
                    alert("Login realizado com sucesso!");
                    window.location.href = "index.jsp"; // Redireciona para a página inicial
                } else {
                    // Falha no login
                    alert("E-mail ou senha inválidos!");
                }
            } else {
                alert("Erro ao processar a solicitação. Tente novamente.");
            }
        } catch (error) {
            console.error("Erro na requisição:", error);
            alert("Erro inesperado. Por favor, tente novamente.");
        }
    });
</script>


