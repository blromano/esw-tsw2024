/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trashtrack.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import trashtrack.dao.MoradoresColetoresDAO;
import trashtrack.dao.PontosDeColetaDAO;
import trashtrack.entidades.Coordenada;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author User
 */
@WebServlet(name = "PontoDeColetaServlet", urlPatterns = {"/processaPontoDeColeta"})
public class PontoDeColetaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        PontosDeColetaDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            
            dao = new PontosDeColetaDAO();
            
            if ( acao.equals("inserir") ) {
                
                String tipoDeLixo = request.getParameter("tipoDeLixo");
                String rua = request.getParameter("rua");
                String numero = request.getParameter("numero");
                String cidade = request.getParameter("cidade");
                String bairro = request.getParameter("bairro");
                String complemento = request.getParameter("complemento");
                String idMoradorColetor = request.getParameter("idMoradorColetor");
                
                String longitude = request.getParameter("longitude");
                String latitude = request.getParameter("latitude");
                
                double lat = Double.parseDouble(latitude);
                double lon = Double.parseDouble(longitude);
                
                int id = Integer.parseInt(idMoradorColetor);
                
                PontoDeColeta pdc = new PontoDeColeta();
                
                pdc.setTipoDeLixo(tipoDeLixo);
                pdc.setRua(rua);
                pdc.setNumero(numero);
                pdc.setCidade(cidade);
                pdc.setBairro(bairro);
                pdc.setComplemento(complemento);
                
                Coordenada c = new Coordenada();
                
                c.setLatitude(lat);
                c.setLongitude(lon);
                
                pdc.setCoordenada(c);
                
                pdc.setColetado(false);
                pdc.setDesativado(false);
                
                MoradorColetor mc = new MoradorColetor();
                
                MoradoresColetoresDAO daoMc = new MoradoresColetoresDAO();
                mc = daoMc.obterPorId(id);
                
                pdc.setMorador(mc);
                
                dao.salvar(pdc);
                
            } else if ( acao.equals("excluir") ) {
                
                String idPonto = request.getParameter("idPonto");
                
                int id = Integer.parseInt(idPonto);
                
                PontoDeColeta pontoDeColeta = dao.obterPorId(id);
                
                pontoDeColeta.setDesativado(true);
                
                dao.atualizar( pontoDeColeta );
                
            }
        } catch ( SQLException exc ) {
            
            exc.printStackTrace();
            
        } finally {
            if ( dao != null ) {
                try {
                    dao.closeConnection();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
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
