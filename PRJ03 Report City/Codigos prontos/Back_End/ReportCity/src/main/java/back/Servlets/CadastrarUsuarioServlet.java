/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.CidadaoDAO ;
import back.entidades.Cidadao ;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
@WebServlet(name = "CadastrarUsuarioServlet", urlPatterns = {"/pCadastrarUsuario"})
public class CadastrarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        CidadaoDAO dao = null ;
        Cidadao cid = new Cidadao() ;
        String saida ;
        try {
            dao = new CidadaoDAO() ;
            
            cid.setBairro(request.getParameter("bairro"));
            cid.setCelular(request.getParameter("celular"));
            cid.setCep(request.getParameter("CEP"));
            cid.setCidade(request.getParameter("cidade"));
            cid.setComplemento(request.getParameter("complemento"));
            cid.setCpf(request.getParameter("CPF"));
            cid.setEmail(request.getParameter("email"));
            cid.setEstado(request.getParameter("estado"));
            cid.setNome(request.getParameter("nome"));
            cid.setNumero(request.getParameter("numero"));
            cid.setRua(request.getParameter("rua"));
            cid.setSenha(request.getParameter("senha"));
            
            dao.salvar(cid);
            saida = "sucesso" ;
        } catch (SQLException ex) {
            ex.printStackTrace();
            saida = "falha" ;
        } finally {
            
            try {
                dao.fecharConexao();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.print(saida);
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
