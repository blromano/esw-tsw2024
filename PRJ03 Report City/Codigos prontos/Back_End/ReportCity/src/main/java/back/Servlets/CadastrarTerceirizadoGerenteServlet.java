/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import back.dao.TerceirizadoDAO ;
import back.entidades.Area;
import back.entidades.Terceirizado ;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
@WebServlet(name = "CadastrarTerceirizadoGerenteServlet", urlPatterns = {"/pCadastrarTerceirizadoGerente"})
public class CadastrarTerceirizadoGerenteServlet extends HttpServlet {

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
        
        TerceirizadoDAO dao = null ;
        Terceirizado ter = new Terceirizado() ;
        Area a = new Area() ;
        
        int aId = Integer.parseInt(request.getParameter("AID")) ;
        try{
            
            dao = new TerceirizadoDAO() ;
            
            a.setId(aId);
            ter.setArea(a);
            ter.setCelular(request.getParameter("celular"));
            ter.setCpf(request.getParameter("CPF"));
            ter.setEmail(request.getParameter("Email"));
            ter.setNome(request.getParameter("Nome"));
            ter.setSenha(request.getParameter("senha"));
            
            dao.salvar(ter);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            
            try{
                dao.fecharConexao();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        
        
        try (PrintWriter out = response.getWriter()) {
            
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
