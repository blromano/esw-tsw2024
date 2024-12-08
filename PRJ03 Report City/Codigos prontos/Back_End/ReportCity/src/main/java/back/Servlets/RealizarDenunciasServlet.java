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
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author nicho
 */
@WebServlet(name = "RealizarDenunciasServlet", urlPatterns = {"/pRealizarDenuncias"})
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class RealizarDenunciasServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";
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
            
            ReceberImagem(request, response, den) ;
            
            dao.salvar(den);
            den.getImagem().salvarImagem();
            
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

 
    protected void ReceberImagem(HttpServletRequest request, HttpServletResponse response, Denuncia den)
            throws ServletException, IOException {
        // Determinar o caminho real do diretório de uploads
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;

        // Criar o diretório de uploads, se não existir
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // Processar cada parte enviada pelo formulário
            for (Part part : request.getParts()) {
                String fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    den.getImagem().setCaminho(uploadPath + File.separator + fileName);
                    
                }
            }
        } catch (Exception e) {
            response.getWriter().println("Erro ao enviar arquivo: " + e.getMessage());
        }
    }

    // Extrair o nome do arquivo da parte
    private String extractFileName(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        for (String content : contentDisposition.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
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
