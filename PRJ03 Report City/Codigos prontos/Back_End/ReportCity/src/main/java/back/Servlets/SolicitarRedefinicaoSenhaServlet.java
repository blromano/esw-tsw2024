/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package back.Servlets;

import back.dao.CidadaoDAO ;
import back.dao.TerceirizadoDAO ;
import back.entidades.Cidadao ;
import back.entidades.Terceirizado ;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 *
 * @author nicho
 */
@WebServlet(name = "SolicitarRedefinicaoSenhaServlet", urlPatterns = {"/pSolicitarRedefinicaoSenha"})
public class SolicitarRedefinicaoSenhaServlet extends HttpServlet {

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
        String tipo = request.getParameter("usuario") ;
        String valido = "aceito";
        String enviado = null ;
        CidadaoDAO daoC = null ;
        TerceirizadoDAO daoT = null ;
        
        try{
            if (tipo.equals("c")) {

                daoC = new CidadaoDAO() ;
                Cidadao cid = daoC.procurarPorEmail(request.getParameter("email")) ;
                
                String seguranca = "senha" ;
                
                enviado = gerarEmail(seguranca, cid.getEmail()) ;
                
                
            } else if (tipo.equals("t")) {
                
                daoT = new TerceirizadoDAO() ;
                Terceirizado ter = daoT.procurarPorEmail(request.getParameter("email")) ;
                
                String seguranca = "senha" ;
                
                enviado = gerarEmail(seguranca, ter.getEmail()) ;
                
            } else {
                
                valido = "nao aceito" ;
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            valido = "falha" ;
        } finally {
            
            try {
                
                if (daoC == null) {
                    daoT.fecharConexao();
                } else {
                    daoC.fecharConexao();
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.print(valido);
            out.print(enviado);
        }
    }
    
    protected String gerarEmail(String senha, String email) {
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        /* 
            Lembrete, não pretendo realizar isso completamente
            Porque não possuo um email que possa usar como o exemplo necessário e não vou fazer um
            portanto a logica está aqui mas para uso trocar o 
        
            return new PasswordAuthentication("seuEmail@gmail.com", "suaSenha"); abaixo

            por valores validos no emial e senha do email, neste caso usamos o Gmail como servidor smtp
        */
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("seuEmail@gmail.com", "suaSenha");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(
                    new InternetAddress("seuEmail@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO, 
                    InternetAddress.parse(email));
            message.setSubject("Recuperacao de email");
            message.setText("Sua senha para recuperação do login é: " + senha);

            Transport.send(message);
            
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Falha" ;
        }
    
        return "E-mail enviado com sucesso!";

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
