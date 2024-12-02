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
import back.entidades.Terceirizado ;
import back.dao.TerceirizadoDAO ;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
@WebServlet(name = "EntradaServicoTerceirizado", urlPatterns = {"/pEntradaTerceirizado"})
public class EntradaServicoTerceirizado extends HttpServlet {

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
        
        String email = request.getParameter("email") ;
        String senha = request.getParameter("senha") ;
        
        Terceirizado ter = ProcurarAdministrador(email, senha);
        
        try (PrintWriter out = response.getWriter()){
            out.print(ter.toString());
        }
        
    }
    
    private Terceirizado ProcurarAdministrador(String email, String senha) {
        TerceirizadoDAO adDao = null ;
        Terceirizado Ter = new Terceirizado() ;
        try{
            
            adDao = new TerceirizadoDAO();
            Ter = adDao.procurarPorEmailESenha(email, senha) ;
             
        } catch(SQLException ex) {
            
            ex.printStackTrace();
            Ter = null ;
            
        } finally {
            
            try{
                adDao.fecharConexao();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
            
            
        }
        
        return Ter ;
        
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
