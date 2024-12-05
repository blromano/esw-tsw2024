/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.*;
import back.entidades.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date ;
import java.sql.SQLException;

/**
 *
 * @author nicho
 */
@WebServlet(name = "CriarTarefaDenunciaGerenteServlet", urlPatterns = {"/pCriarTarefaDenunciaGerente"})
public class CriarTarefaDenunciaGerenteServlet extends HttpServlet {

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
        
        TarefaDAO dao = null ;
        Tarefa tar = new Tarefa() ;
        DenunciaDAO denD = null ;
        Denuncia den = new Denuncia() ;
        GerenteDAO genD = null ;
        Gerente gen = new Gerente() ;
        TerceirizadoDAO terD = null ;
        Terceirizado ter = new Terceirizado() ;
        StatusDAO staD = null ;
        Status sta = new Status() ;
        
        String salva ;
        try {
            dao = new TarefaDAO() ;
            denD = new DenunciaDAO() ;
            genD = new GerenteDAO() ;
            terD = new TerceirizadoDAO() ;
            staD = new StatusDAO() ;
            
            den = denD.selecionarPorID(request.getParameter("DenunciaId")) ;
            gen = genD.selecionarPorID(request.getParameter("gerenteId")) ;
            ter = terD.selecionarPorID(request.getParameter("terceirizadoId")) ;
            sta = staD.selecionarPorID(Integer.parseInt(request.getParameter("statusID"))) ;
            
            tar.setDescricao(den.getDescricao());
            tar.setCreated(new Date(System.currentTimeMillis()));
            tar.setNome(request.getParameter("Nome"));
            tar.setChamado(request.getParameter("chamado"));
            
            tar.setDenuncia(den);
            tar.setGerente(gen);
            tar.setServicoTereirizado(ter);
            tar.setStatus(sta);
            
            dao.salvar(tar);
            salva = "Sucesso" ;
        } catch (SQLException ex) {
            ex.printStackTrace();
            salva = "falha" ;
        } finally {
            
            try {
               dao.fecharConexao();
               denD.fecharConexao();
               genD.fecharConexao();
               terD.fecharConexao();
               staD.fecharConexao();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
                    
        }
            
        try (PrintWriter out = response.getWriter()) {
            out.print(salva);
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
