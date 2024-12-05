/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.CidadaoDAO;
import back.entidades.Cidadao;
import back.dao.TerceirizadoDAO;
import back.entidades.Terceirizado;
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
@WebServlet(name = "RedefinirSenhaServlet", urlPatterns = {"/pRedefinirSenha"})
public class RedefinirSenhaServlet extends HttpServlet {

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
        
        String novaSenha = request.getParameter("senha") ;
        String copiaSenha = request.getParameter("garantia") ;
        String id = request.getParameter("id") ;
        String tipo = request.getParameter("tipo") ;
        
        CidadaoDAO daoC = null ;
        Cidadao cid = null ;
        TerceirizadoDAO daoT = null ;
        Terceirizado ter = null ;
        
        String saida = null ;
        
        try {
           
            if (tipo.equals("cidadao")) {
                daoC = new CidadaoDAO() ;
                cid = daoC.selecionarPorID(id) ;
                
                if (novaSenha.equals(copiaSenha)) {
                    
                    cid.setSenha(novaSenha);
                    daoC.atualizar(cid);
                    saida = cid.toString() ;
                    
                } else {
                    saida = "Senhas Diferentes" ;
                }
            }else if (tipo.equals("Terceirizado")) {
                daoT = new TerceirizadoDAO() ;
                
                ter = daoT.selecionarPorID(id) ;
                
                if (novaSenha.equals(copiaSenha)) {
                    
                    ter.setSenha(novaSenha);
                    daoT.atualizar(ter);
                    saida = ter.toString() ;
                    
                } else {
                    saida = "Senhas Diferentes" ;
                }
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            
          try {
              if (daoC != null) {
                  daoC.fecharConexao();
              } else {
                  daoT.fecharConexao();
              }
          }  catch (SQLException ex) {
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
