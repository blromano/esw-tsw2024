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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDate;



@WebServlet(name = "Cliente", urlPatterns = {"/tratarCliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        ClienteDAO dao = null;
        UsuarioDAO daoU = null;
        RequestDispatcher disp = null;
        
        try{
            
            dao = new ClienteDAO();
            daoU = new UsuarioDAO();
            
            if( acao.equals("inserir" )){
                
                String nome = request.getParameter("name");
                String dataNascimento = request.getParameter("dataNasc");
                String contato = request.getParameter("celular");
                String endereco = request.getParameter("endereço");
                String email = request.getParameter("email");
                String estado = request.getParameter("Estado");
                String cidade = request.getParameter("cidade");
                String cpf = request.getParameter("cpf");
                String senha = request.getParameter("password");
                
                try{
                 
                    Date dataNasc = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
                    Cliente c = new Cliente();
                    c.setCpf(cpf);
                
                    Usuario u = new Usuario();
                    u.setCidade(cidade);
                    u.setNome(nome);
                    u.setSenha(senha);
                    u.setEmail(email);
                    u.setDataNasc(dataNasc);
                    u.setContato(contato);
                    u.setEndereco(endereco);
                    u.setEstado(estado);
                
                    dao.salvar(c);
                    daoU.salvar(u);
                    
                } catch ( ParseException pe ){
                    
                    System.out.println("Erro de conversao de data");
                    
                }           
                
                disp = request.getRequestDispatcher(
                        "/formularios/usuario/login.jsp");
                
                
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
