/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestesDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import trashtrack.dao.MoradoresColetoresDAO;
import trashtrack.dao.PontosDeColetaDAO;
import trashtrack.entidades.Coordenada;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author victo
 */
public class TestePontosDeColetaDAO {
    
    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        MoradorColetor moradorColetor = new MoradorColetor();
        moradorColetor.setId(3);
        /*moradorColetor.setEmail("DASDADASDASD");
        moradorColetor.setSenha("senha");
        moradorColetor.setNome("TesteMorador");
        moradorColetor.setCpf("123123123");
        moradorColetor.setDataNascimento( Date.valueOf( "2004-06-13" ) );
        moradorColetor.setQuantidadeLixoColetado(6);
        moradorColetor.setPontuacao(7);
        moradorColetor.setAtivo(true);
        moradorColetor.setQuantidadeLixoReciclado(5);*/
        
        Coordenada coordenada = new Coordenada();
        
        //Coordenadas de sao joao 
        
        coordenada.setLatitude(-21.831483392479155);
        coordenada.setLongitude(-46.89219365740519);
        
        PontoDeColeta pontoDeColeta = new PontoDeColeta();
        pontoDeColeta.setBairro("testePonto2");
        pontoDeColeta.setCidade("Vargem Grande do Sul");
        pontoDeColeta.setColetado(false);
        pontoDeColeta.setComplemento("complemento");
        pontoDeColeta.setCoordenada( coordenada );
        pontoDeColeta.setDesativado(false);
        pontoDeColeta.setMorador( moradorColetor );
        pontoDeColeta.setNumero("123A");
        pontoDeColeta.setRua("Rua");
        pontoDeColeta.setTipoDeLixo("OR");
              
        PontosDeColetaDAO dao = null;
        
        try {
            
            dao = new PontosDeColetaDAO();
            
            dao.salvar(pontoDeColeta);
            
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
