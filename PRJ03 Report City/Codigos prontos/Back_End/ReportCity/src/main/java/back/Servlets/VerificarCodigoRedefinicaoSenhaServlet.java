/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.entidades.Terceirizado;
import back.dao.TerceirizadoDAO;
import back.entidades.Cidadao;
import back.dao.CidadaoDAO;
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
@WebServlet(name = "VerificarCodigoRedefinicaoSenhaServlet", urlPatterns = {"/pVerificarCodigoRedefinicaoSenha"})
public class VerificarCodigoRedefinicaoSenhaServlet extends HttpServlet {

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
        
        String senha = request.getParameter("codigoRecuperacao") ;
        String tipo = request.getParameter("tipo") ;
        
        TerceirizadoDAO daoT = null ;
        Terceirizado ter = null;
        CidadaoDAO daoC = null ;
        Cidadao cid = null ;
        
        try{
            if (tipo.equals("cidadao")) {
                daoC = new CidadaoDAO() ;
                
                cid = daoC.selecionarPorCodigoRecuperacao(senha) ;
            
            } else if (tipo.equals("terceirizado")) {
                daoT = new TerceirizadoDAO() ;
                
                ter = daoT.procurarPorCodigoRecuperacao(senha) ;
            }
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        } finally {
            try{
                if (daoC == null) {
                    daoT.fecharConexao();
                } else {
                    daoC.fecharConexao();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        String retorno  = null ;
        if (cid != null) {
            retorno = cid.toString() ;
        } else {
            retorno = ter.toString() ;
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.print(retorno);
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
