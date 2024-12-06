/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trashtrack.controladores;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trashtrack.dao.MoradoresColetoresDAO;
import trashtrack.entidades.MoradorColetor;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "MoradorColetorServlet", urlPatterns = {"/processaMoradorColetor"})
public class MoradorColetorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        MoradoresColetoresDAO dao = null;
        RequestDispatcher disp = null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            dao = new MoradoresColetoresDAO();

            if (acao.equals("inserir")) {
                // Cadastro de usuário
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                String confirmarSenha = request.getParameter("confirmarSenha");
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                String dataNascimento = request.getParameter("dataNascimento");

                // Validações
                if (!isEmailValido(email)) {
                    request.setAttribute("errorMessage", "E-mail inválido.");
                    disp = request.getRequestDispatcher("cadastro.jsp");
                } else if (!senha.equals(confirmarSenha)) {
                    request.setAttribute("errorMessage", "As senhas não coincidem.");
                    disp = request.getRequestDispatcher("cadastro.jsp");
                } else if (!isCPFValido(cpf)) {
                    request.setAttribute("errorMessage", "CPF inválido.");
                    disp = request.getRequestDispatcher("cadastro.jsp");
                } else if (existeEmailOuCPF(dao, email, cpf)) { // Verifica se já existe o e-mail ou CPF
                    request.setAttribute("errorMessage", "E-mail ou CPF já estão associados a uma conta.");
                    disp = request.getRequestDispatcher("cadastro.jsp");
                } else {
                    // Criando o objeto MoradorColetor
                    LocalDate dataNascimentoLocal = LocalDate.parse(dataNascimento, dtf);
                    MoradorColetor mc = new MoradorColetor();
                    mc.setEmail(email);
                    mc.setSenha(senha); // Armazenando a senha diretamente (não seguro para produção)
                    mc.setNome(nome);
                    mc.setCpf(cpf);
                    mc.setDataNascimento(java.sql.Date.valueOf(dataNascimentoLocal));
                    mc.setQuantidadeLixoColetado(0);
                    mc.setQuantidadeLixoReciclado(0);
                    mc.setPontuacao(0);
                    mc.setAtivo(true);

                    // Persistindo no banco
                    dao.salvar(mc);

                    // Redireciona para a página de sucesso
                    request.setAttribute("successMessage", "Cadastro realizado com sucesso!");
                    disp = request.getRequestDispatcher("login.jsp");
                }
            } else if (acao.equals("login")) {
                // Login de usuário
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                
                // Verificação de credenciais no banco de dados
                MoradorColetor mc = dao.buscarPorEmail(email);

                if (mc != null && mc.getSenha().equals(senha)) {
                    request.getSession().setAttribute("usuarioLogado", mc);
                    disp = request.getRequestDispatcher("mapa.html");
                } else {
                    // Credenciais inválidas
                    request.setAttribute("errorMessage", "E-mail ou senha incorretos.");
                    disp = request.getRequestDispatcher("login.jsp");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao processar a requisição: " + e.getMessage());
            disp = request.getRequestDispatcher("erro.jsp");
        } finally {
            // Fechando a conexão com o DAO
            if (dao != null) {
                try {
                    dao.closeConnection();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Encaminhando a requisição
        if (disp != null) {
            disp.forward(request, response);
        }
    }

    // Método para validar o formato do e-mail
    private boolean isEmailValido(String email) {
        String regex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        return email != null && email.matches(regex);
    }

    // Método para validar o formato do CPF
    private boolean isCPFValido(String cpf) {
        return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    // Método para verificar duplicidade de e-mail ou CPF
    private boolean existeEmailOuCPF(MoradoresColetoresDAO dao, String email, String cpf) throws SQLException {
        String sql = "SELECT COUNT(*) FROM moradores_coletores WHERE MOC_EMAIL = ? OR MOC_CPF = ?";
        try (var connection = dao.getConnection();
             var stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, cpf);
            try (var rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Retorna true se encontrar duplicidade
                }
            }
        }
        return false;  // Retorna false se não encontrar duplicidade
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para processar ações relacionadas ao MoradorColetor";
    }
}
