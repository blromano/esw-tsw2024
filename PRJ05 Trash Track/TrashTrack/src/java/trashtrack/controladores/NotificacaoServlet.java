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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import trashtrack.dao.NotificacoesDAO;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.Notificacao;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author User
 */
@WebServlet(name = "NotificacaoServlet", urlPatterns = {"/processaNotificacao"})
public class NotificacaoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        NotificacoesDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            
            dao = new NotificacoesDAO();
            
            if ( acao.equals("inserir") ) {
                
                String descricao = request.getParameter("descricao");
                String idMoradorColetor = request.getParameter("idMoradorColetor");
                String idPontoDeColeta = request.getParameter("idPontoDeColeta");
                
                int idMorador = Integer.parseInt(idMoradorColetor);
                int idPonto = Integer.parseInt(idPontoDeColeta);
                
                Notificacao n = new Notificacao();
                
                n.setDescricao(descricao);
                
                MoradorColetor mc = new MoradorColetor();
                
                mc.setId(idMorador);
                
                PontoDeColeta pdc = new PontoDeColeta();
                
                pdc.setId(idPonto);
                
                n.setMoradorColetor(mc);
                n.setPontoDeColeta(pdc);
                
                dao.salvar(n);
            } else if ( acao.equals("listar") ) {
                
                int id = Integer.parseInt(request.getParameter("id"));
                
                List<Notificacao> lista = dao.listarTodos();
                List<Notificacao> listaNotificacaoPropria = new ArrayList<>();
                
                
                for (Notificacao notificacao : lista) {
                    if ( notificacao.getMoradorColetor().getId() == id ) {
                        listaNotificacaoPropria.add(notificacao);
                    }
                }
                
                PrintWriter pw = response.getWriter();
                pw.print(jb.toJson(listaNotificacaoPropria)); 
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
