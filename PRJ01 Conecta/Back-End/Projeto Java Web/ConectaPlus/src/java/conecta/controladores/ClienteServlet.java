package conecta.controladores;

import conecta.dao.ClienteDAO;
import conecta.dao.UsuarioDAO;
import conecta.entidades.Cliente;
import conecta.entidades.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;


@WebServlet(name = "Cliente", urlPatterns = {"/tratarCliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        ClienteDAO dao = null;
        UsuarioDAO daoU = null;
        RequestDispatcher disp = null;
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try{
            
            dao = new ClienteDAO();
            daoU = new UsuarioDAO();
            
            if( acao.equals("inserir" )){
                
                String nome = request.getParameter("name");
                String dataNasc = request.getParameter("dataNasc");
                String contato = request.getParameter("celular");
                String email = request.getParameter("email");
                String estado = request.getParameter("Estado");
                String cidade = request.getParameter("cidade");
                String cpf = request.getParameter("cpf");
                String senha = request.getParameter("password");
                
                Cliente c = new Cliente();
                c.setCpf(cpf);
                
                Usuario u = new Usuario();
                u.setCidade(cidade);
                u.setNome(nome);
                u.setSenha(senha);
                u.setEmail(email);
                u.setDataNasc(dataNasc);
                u.setContato(contato);
                u.setEstado(estado);
                
                dao.salvar(c);
                daoU.salvar(u);
                
                //Colocar o endereço da página de login
                //disp = request.getRequestDispatcher("")
                
                
            }
            
            
        } catch (SQLException exc ){ 
            exc.printStackTrace();
        }finally {
            
            if( dao != null ){
                try{
                    dao.fecharConexao();
                    daoU.fecharConexao();
                } catch ( SQLException exc ){
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
