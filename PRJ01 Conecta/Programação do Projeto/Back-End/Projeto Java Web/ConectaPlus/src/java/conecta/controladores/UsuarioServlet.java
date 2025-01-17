package conecta.controladores;

//import conecta.dao.UsuarioDAO;
//import conecta.entidades.Usuario;
//import jakarta.servlet.RequestDispatcher;
import conecta.dao.UsuarioDAO;
import conecta.entidades.Usuario;
import java.io.IOException;
//import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/tratarUsuario"})
public class UsuarioServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
     
        /*
        *Inicio tentativa de sistema de login
        
        
        String acao = request.getParameter( "acao" );
        
        UsuarioDAO daoU = null;
        RequestDispatcher disp = null;
        
        if( acao.equals("autenticar")){
            
            String email = request.getParameter("emailCad");
            String senha = request.getParameter("senhaCad");
            
            Usuario u = new Usuario();
            
            u.setEmail(email);
            u.setSenha(senha);
            
            daoU.autenticar(u);
            
            
            
        
            disp = request.getRequestDispatcher("index.jsp");
            
        }
        
        */
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String acao = request.getParameter("acao");

        UsuarioDAO daoU = null;
        try {
            daoU = new UsuarioDAO(); // Inicialização do DAO
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher disp = null;

        try {
            if (acao.equals("autenticar")) {
                // Obtendo os parâmetros do formulário
                String email = request.getParameter("email");
                String senha = request.getParameter("password");

                // Criando o objeto usuário
                Usuario u = new Usuario();
                u.setEmail(email);
                u.setSenha(senha);
                boolean autenticado = false;

                // Autenticando o usuário
                
                if (autenticado) {
                    // Autenticação bem-sucedida
                    request.setAttribute("mensagem", "Login realizado com sucesso!");
                    disp = request.getRequestDispatcher("index.jsp"); // Página inicial do usuário
                } else {
                    // Falha na autenticação
                    request.setAttribute("mensagem", "E-mail ou senha inválidos!");
                    disp = request.getRequestDispatcher("login.jsp"); // Página de login
                }
            } else {
                // Ação não reconhecida
                request.setAttribute("mensagem", "Ação inválida!");
                disp = request.getRequestDispatcher("erro.jsp");
            }
        } catch (Exception e) {
            // Tratamento de exceções
            request.setAttribute("mensagem", "Erro ao processar a solicitação: " + e.getMessage());
            disp = request.getRequestDispatcher("erro.jsp");
        }

        // Encaminhando a requisição
        if (disp != null) {
            disp.forward(request, response);
        }
        
        
        
        
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
