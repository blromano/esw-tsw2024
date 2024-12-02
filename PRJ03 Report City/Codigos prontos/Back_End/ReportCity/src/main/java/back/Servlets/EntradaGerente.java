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
import java.sql.SQLException;
import back.entidades.Gerente;
import back.dao.GerenteDAO;

/**
 *
 * @author nicho
 */
@WebServlet(name = "EntradaGerente", urlPatterns = {"/pEntradaGerente"})
public class EntradaGerente extends HttpServlet {

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
        
        Gerente cid = ProcurarGerente(email, senha);
        
        try (PrintWriter out = response.getWriter()){
            out.print(cid.toString());
        }
        
    }
    
    private Gerente ProcurarGerente(String email, String senha) {
        GerenteDAO gerDao = null ;
        Gerente ger = new Gerente() ;
        try{
            
            gerDao = new GerenteDAO();
            ger = gerDao.procurarPorEmailESenha(email, senha) ;
             
        } catch(SQLException ex) {
            
            ex.printStackTrace();
            ger = null ;
            
        } finally {
            
            try{
                gerDao.fecharConexao();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
            
            
        }
        
        return ger ;
        
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
