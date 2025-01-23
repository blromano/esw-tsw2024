package rocaplan.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.sql.SQLException;
import rocaplan.dao.UsuarioDAO;
import rocaplan.entidades.Usuario;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;
        //Jsonb jb = JsonBuilder.create();

        try {
            dao = new UsuarioDAO();

            if (acao.equals("inserir")) {
                String usuNome = request.getParameter("usuNome");
                String usuEmail = request.getParameter("usuEmail");
                String usuSenha = request.getParameter("usuSenha");

                Usuario u = new Usuario();
                u.setUsuNome(usuNome);
                u.setUsuEmail(usuEmail);
                u.setUsuSenha(usuSenha);

                dao.salvar(u);
                HttpSession sessao = request.getSession();
                sessao.setAttribute("usuarioLogado", u);

                disp = request.getRequestDispatcher(
                        "/pages/register.jsp");

            } else if (acao.equals("alterar")) {
                
                String usuEmail = request.getParameter("email");
                String usuSenha = request.getParameter("senha");
                
                Usuario u = new Usuario();

                u = dao.obterPorEmail(usuEmail);
                
                u.setUsuSenha(usuSenha);
                dao.atualizar(u);
                
                disp = request.getRequestDispatcher(
                        "/pages/forgot-password.jsp");
            } else if (acao.equals("excluir")) {

                //Não ha opção de excluir usuario.
            } else if (acao.equals("listar")) {

                //Não ha opção de listar usuario.
            } else if (acao.equals("obterPorEmail")) {

                String usuEmail = request.getParameter("email");
                String usuSenha = request.getParameter("senha");

                Usuario u = new Usuario();
                u = dao.obterPorEmail(usuEmail);
                if (u != null && u.getUsuSenha().equals(usuSenha)) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("usuarioLogado", u);
                    disp = request.getRequestDispatcher(
                            "/index.jsp");
                } else {
                    disp = request.getRequestDispatcher(
                            "/pages/page-not-found.jsp");
                }

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
