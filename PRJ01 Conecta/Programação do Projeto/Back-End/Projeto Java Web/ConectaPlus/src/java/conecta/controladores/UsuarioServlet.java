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
     
        
        String acao = request.getParameter( "acao" );
        
        UsuarioDAO dao = null;
        RequestDispatcher disp = null;
        
        try{
 
            dao = new UsuarioDAO();
            
            if( acao.equals("autenticar")){

                String email = request.getParameter("emailCad");
                String senha = request.getParameter("senhaCad");

                Usuario u = new Usuario();
                u.setEmail(email);
                u.setSenha(senha);
                
                boolean autenticacao = dao.autenticar(u);
                
                if (autenticacao){
                    
                    disp = request.getRequestDispatcher("/index.jsp");
                    
                } else {
                    
                    disp = request.getRequestDispatcher(
                            "/formularios/usuario/login.jsp");
                    
                }

            }

        }catch ( SQLException exc ){
            exc.printStackTrace();
        }finally{ 

            if( dao != null ){
                try{
                    dao.fecharConexao();
                }catch (SQLException exc){
                    exc.printStackTrace();
                }
            }
        }
        
        if ( disp != null ){
            disp.forward( request, response );
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
