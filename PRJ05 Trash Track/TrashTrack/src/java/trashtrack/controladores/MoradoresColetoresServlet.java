/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trashtrack.controladores;

import jakarta.json.Json;
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
import trashtrack.dao.MoradoresColetoresDAO;
import trashtrack.entidades.MoradorColetor;
import java.sql.Date;

/**
 *
 * @author User
 */
@WebServlet(name = "MoradoresColetoresServlet", urlPatterns = {"/processaMoradorColetor"})
public class MoradoresColetoresServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        MoradoresColetoresDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try {
            
            dao = new MoradoresColetoresDAO();
            
            if ( acao.equals("inserir") ) {
                
                String email = request.getParameter("email");
                String senha = request.getParameter("senha");
                String nome = request.getParameter("nome");
                String cpf = request.getParameter("cpf");
                String dataNascimento = request.getParameter("dataNascimento");
                
                LocalDate dataNascimentoLocal = LocalDate.parse(dataNascimento,dtf);
                
                MoradorColetor mc = new MoradorColetor();
                
                mc.setEmail(email);
                mc.setSenha(senha);
                mc.setNome(nome);
                mc.setCpf(cpf);
                mc.setDataNascimento(Date.valueOf(dataNascimentoLocal));
                mc.setQuantidadeLixoColetado(0);
                mc.setQuantidadeLixoReciclado(0);
                mc.setPontuacao(0);
                mc.setAtivo(true);
                
                dao.salvar(mc);
                
                disp = request.getRequestDispatcher("login.html");
                
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
        
        if ( disp != null ) {
            disp.forward(request, response);
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
