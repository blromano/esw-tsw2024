/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestesDAO;

import trashtrack.entidades.MoradorColetor;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import trashtrack.dao.MoradoresColetoresDAO;

/**
 *
 * @author victo
 */


public class TesteMoradoresColetoresDAO {
    
    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        MoradorColetor moradorColetor = new MoradorColetor();
    
        //moradorColetor.setId(1);
        moradorColetor.setEmail("AAAAAAAAAAA");
        moradorColetor.setSenha("senha");
        moradorColetor.setNome("TesteMorador");
        moradorColetor.setCpf("123123123");
        moradorColetor.setDataNascimento( Date.valueOf( "2004-06-13" ) );
        moradorColetor.setQuantidadeLixoColetado(6);
        moradorColetor.setPontuacao(7);
        moradorColetor.setAtivo(true);
        moradorColetor.setQuantidadeLixoReciclado(5);
        
        MoradoresColetoresDAO dao = null;
              
        
        try {
            
            dao = new MoradoresColetoresDAO();
            
            dao.salvar(moradorColetor);
            
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            
            if (dao != null) {
                try {
                    dao.closeConnection();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
            
        }
                
    }

}
