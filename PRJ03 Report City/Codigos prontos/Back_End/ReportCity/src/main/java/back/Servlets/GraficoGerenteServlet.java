/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.DenunciaDAO;
import back.dao.StatusDAO;
import back.entidades.Status;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicho
 */
@WebServlet(name = "GraficoGerenteServlet", urlPatterns = {"/pGraficoGerente"})
public class GraficoGerenteServlet extends HttpServlet {

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
        
        String retorno = "{" ;
        String tipos =  null ;
        try {
            
            retorno = retorno.concat(contarStatus()) ;
            tipos = contarTipos() ;
            
            if (tipos != null) {
                retorno = retorno.concat(", ") ;
                retorno = retorno.concat(tipos) ;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        retorno = retorno.concat("}") ;
        try (PrintWriter out = response.getWriter()) {
            out.write(retorno);
        }
        
    }

    private String contarStatus() throws SQLException{
        String retorno = null;
        StatusDAO sta = null ;
        DenunciaDAO den = null ;
        
        
        List<Status> status = null;
        List<Integer> valores = new ArrayList<>() ;
        
        sta = new StatusDAO() ;
        den = new DenunciaDAO() ;
        
        status = sta.selecionarTodos() ;
            
        for (Status s : status) {
            valores.add(den.countDenunciasPorStatus(s)) ;
        }
        
        for (int i = 0 ; i < status.size(); i++) {
            retorno = retorno.concat(status.get(i).getStatus() + ": " + valores.get(i));
            if (i < status.size()-1){
                retorno = retorno.concat(", ") ;
            }
        }
        
        sta.fecharConexao();
        den.fecharConexao();
        
        return retorno ;
    }
    
    private String contarTipos () throws SQLException {
        String retorno = null ;
        DenunciaDAO den = new DenunciaDAO() ;
        
        List<String> tipos = den.todosTipos() ;
        
        for (String s : tipos) {
            retorno = retorno.concat( s +": " + den.contarPorTipo(s)) ;
            if (tipos.indexOf(s) < tipos.size() -1) {
                retorno = retorno.concat(", ") ;
            }
        }
        
        den.fecharConexao();
        
        return retorno ;
        
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
