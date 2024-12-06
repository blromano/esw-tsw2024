/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trashtrack.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import trashtrack.dao.DenunciasDAO;
import trashtrack.entidades.Denuncia;
import java.sql.Date;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author User
 */
@WebServlet(name = "DenunciaServlet", urlPatterns = {"/processaDenuncia"})
public class DenunciaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String acao = request.getParameter("acao");
        DenunciasDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            
            dao = new DenunciasDAO();
            
            if ( acao.equals("inserir") ) {
                
                String descricao = request.getParameter("descricao");
                String idPontoDeColeta = request.getParameter("idPontoDeColeta");
                
                int id = Integer.parseInt(idPontoDeColeta);
                
                Denuncia d = new Denuncia();
                
                d.setDescricao(descricao);
                d.setDataDenuncia(Date.valueOf(LocalDate.now()));
                d.setDesativado(false);
                
                PontoDeColeta pdc = new PontoDeColeta();
                
                pdc.setId(id);
                
                d.setPontoDeColeta(pdc);
                
                dao.salvar(d);
            }
            
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.closeConnection();
                } catch ( SQLException e ) {
                    e.printStackTrace();
                }
            }
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
