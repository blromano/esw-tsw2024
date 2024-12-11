package conecta.controladores;

import conecta.dao.ProfissionalDAO;
import conecta.dao.UsuarioDAO;
import conecta.entidades.Profissional;
import conecta.entidades.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.sql.SQLException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "ProfissionalServlet", urlPatterns = {"/tratarProfissional"})
public class ProfissionalServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        
        ProfissionalDAO dao = null;
        UsuarioDAO daoU = null;
        RequestDispatcher disp = null;
        
        try{
            
            dao = new ProfissionalDAO();
            daoU = new UsuarioDAO();
            
            if ( acao.equals("inserir")){
                
                String nome = request.getParameter("name");
                String dataNasc = request.getParameter("dataNasc");
                String contato = request.getParameter("celular");
                String telCom = request.getParameter("telComercial");
                String email = request.getParameter("email");
                String estado = request.getParameter("Estado");
                String cidade = request.getParameter("cidade");
                String endereco = request.getParameter("endereço");
                String endCom = request.getParameter("endComercial");
                String cpfCnpj = request.getParameter("cpf");
                String senha = request.getParameter("password");
                
                Profissional p = new Profissional();
                p.setCpfCnpj(cpfCnpj);
                p.setEndCom(endCom);
                p.setTelCom(telCom);
                
                Usuario u = new Usuario();
                u.setNome(nome);
                u.setEmail(email);
                u.setDataNasc(dataNasc);
                u.setContato(contato);
                u.setCidade(cidade);
                u.setEstado(estado);
                u.setEndereco(endereco);
                u.setSenha(senha);
                
                dao.salvar(p);
                daoU.salvar(u);
                
            }
            
        } catch ( SQLException exc ){
            exc.printStackTrace();
        }finally{
            
            if( dao != null ){
                try{
                    dao.fecharConexao();
                    daoU.fecharConexao();
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
