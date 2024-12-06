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
                // Recebendo os parâmetros do formulário
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
                    disp = request.getRequestDispatcher("login.html");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erro ao processar a requisição: " + e.getMessage());
            disp = request.getRequestDispatcher("cadastro.jsp");
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
