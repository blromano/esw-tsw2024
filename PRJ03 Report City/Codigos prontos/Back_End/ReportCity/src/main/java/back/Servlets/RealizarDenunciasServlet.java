/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.DenunciaDAO ;
import back.entidades.Cidadao;
import back.entidades.Denuncia ;
import back.entidades.Status;
import java.sql.Date ;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.io.File;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author nicho
 */
@WebServlet(name = "RealizarDenunciasServlet", urlPatterns = {"/pRealizarDenuncias"})
public class RealizarDenunciasServlet extends HttpServlet {

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
        
        
        Cidadao cid = new Cidadao() ;
        Denuncia den = new Denuncia() ;
        Status sta = new Status() ;
        DenunciaDAO dao = null ;
        
        int status = Integer.parseInt(request.getParameter("idStatus")) ;
        String cidadao = request.getParameter("idCidadao") ;
        double x = Double.parseDouble(request.getParameter("localizacaoX"));
        double y = Double.parseDouble(request.getParameter("localizacaoY"));
        String descricao = request.getParameter("descricao") ;
        String feedback = request.getParameter("feedback") ;
        String tipo = request.getParameter("tipo") ;
        String titulo = request.getParameter("titulo");
        
        try {
            dao = new DenunciaDAO() ;
            
            cid.setId(cidadao);
            sta.setId(status);
            
            den.setCidadao(cid);
            den.setStatus(sta);
            
            den.setCoordenadaX(x);
            den.setCoordenadaY(y);
            den.setDescricao(descricao);
            den.setFeedback(feedback);
            
            den.setTipo(tipo);
            den.setTitulo(titulo);
            
            den.setCreated(new Date(System.currentTimeMillis()));
            den.setUpdated(new Date(System.currentTimeMillis()));
            
            den = ReceberImagem(request, response, den) ;
            
            dao.salvar(den);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            
            try {
                dao.fecharConexao();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        
        try (PrintWriter out = response.getWriter()) {
            
        }
    }
    
    private Denuncia ReceberImagem (HttpServletRequest request, HttpServletResponse response, Denuncia den) 
            throws ServletException{
        
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // Perguntar para o Professor david se ele 
        //faz alguma ideia de como resolver o erro que está aparecendo
        /*List<FileItem> items = upload.parseRequest(request) ;
        
        for (FileItem item : items) {
            if (!item.isFormField()) {
                String fileName = item.getName();
                String contentType = item.getContentType();
                
            } else {
                //campos normais
                String campo = item.getFieldName();
                String valor = item.getString();
            }
        }
        */
        return den ;
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
