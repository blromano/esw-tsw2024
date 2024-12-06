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
/*
import java.io.File;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
*/
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
        
        String saida = "{" + den.toString() + "}" ;
        try (PrintWriter out = response.getWriter()) {
            out.print(saida);
        }
    }
    
    private Denuncia ReceberImagem (HttpServletRequest request, HttpServletResponse response, Denuncia den) {
        /*
        long serialVersionUID = 1L;
        String UPLOAD_DIRECTORY = "uploads";

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(request.getServletContext().getRealPath("/") + UPLOAD_DIRECTORY + File.separator + name));
                    }
                }
                request.setAttribute("message", "Arquivo carregado com sucesso!");
            } catch (Exception ex) {
                request.setAttribute("message", "Erro no carregamento do arquivo: " + ex.getMessage());
            }
        } else {
            request.setAttribute("message", "Essa requisição não contém dados de upload");
        }
        request.getRequestDispatcher("/result.jsp").forward(request, response);
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
