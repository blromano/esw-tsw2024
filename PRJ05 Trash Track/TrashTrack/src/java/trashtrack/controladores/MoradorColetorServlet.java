/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trashtrack.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import trashtrack.dao.MoradoresColetoresDAO;
import trashtrack.entidades.MoradorColetor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.Date;

@WebServlet(name = "MoradorColetorServlet", urlPatterns = {"/processaMoradorColetor"})
public class MoradorColetorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        MoradoresColetoresDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
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
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson("InvalidoEmail"));
                } else if (!senha.equals(confirmarSenha)) {
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson("InvalidoSenha"));
                } else if (!isCPFValido(cpf)) {
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson("InvalidoCPF"));
                } else if (email.isBlank() || senha.isBlank() || confirmarSenha.isBlank() 
                           || nome.isBlank() || cpf.isBlank() || dataNascimento.isBlank()){
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson("InvalidoVazio"));
                }  else {
                    // Criando o objeto MoradorColetor
                    LocalDate dataNascimentoLocal = LocalDate.parse(dataNascimento, dtf);
                    MoradorColetor mc = new MoradorColetor();
                    mc.setEmail(email);
                    mc.setSenha(senha); // Armazenando a senha diretamente (não seguro para produção)
                    mc.setNome(nome);
                    mc.setCpf(cpf);
                    mc.setDataNascimento(Date.valueOf(dataNascimentoLocal));
                    mc.setQuantidadeLixoColetado(0);
                    mc.setQuantidadeLixoReciclado(0);
                    mc.setPontuacao(0);
                    mc.setAtivo(true);

                    // Persistindo no banco
                    dao.salvar(mc);

                    // Redireciona para a página de sucesso
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson(mc));
                }
            } else if (acao.equals("login")) {
                // Login de usuário
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                
                // Verificação de credenciais no banco de dados
                List<MoradorColetor> lista = dao.listarTodos();
                MoradorColetor mc = null;
                
                for (MoradorColetor moradorColetorLista : lista) {
                    
                    if ( moradorColetorLista.getEmail().equals(email) ) {
                        
                        if ( moradorColetorLista.getSenha().equals(senha) ) {
                            mc = moradorColetorLista;
                            break;
                        }
                    }
                    
                }
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson(mc));
            } else if ( acao.equals("atualizar") ) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String senhaAntiga = request.getParameter("senhaAntiga");
                String senhaNova = request.getParameter("senhaNova");
                
                if ( nome.isBlank() || email.isBlank() || senhaAntiga.isBlank() || senhaNova.isBlank() ) {
                    response.setContentType("application/json");
                    PrintWriter pw = response.getWriter();
                    pw.print(jb.toJson("InvalidoVazio"));
                } else {
                    
                    MoradorColetor mc = dao.obterPorId(id);
                    
                    if ( mc != null ) {
                        if ( mc.getSenha().equals(senhaAntiga) ) {

                            mc.setId(id);
                            mc.setEmail(email);
                            mc.setSenha(senhaNova);
                            mc.setNome(nome);

                            dao.atualizar(mc);

                            mc = dao.obterPorId(id);

                            response.setContentType("application/json");
                            PrintWriter pw = response.getWriter();
                            pw.print(jb.toJson(mc));
                        } else {
                            response.setContentType("application/json");
                            PrintWriter pw = response.getWriter();
                            pw.print(jb.toJson("InvalidoSenha"));
                        } 
                    }
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
