/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestesDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import trashtrack.dao.DenunciasDAO;
import trashtrack.dao.NotificacoesDAO;
import trashtrack.entidades.Coordenada;
import trashtrack.entidades.Denuncia;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.Notificacao;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author victo
 */
public class TesteNotificacoesDAO {
    
    public static void main(String[] args) {
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        MoradorColetor moradorColetor = new MoradorColetor();
        moradorColetor.setId(2);
        moradorColetor.setEmail("AAAAAAAAAAA");
        moradorColetor.setSenha("senha");
        moradorColetor.setNome("TesteMorador");
        moradorColetor.setCpf("123123123");
        moradorColetor.setDataNascimento( Date.valueOf( "2004-06-13" ) );
        moradorColetor.setQuantidadeLixoColetado(6);
        moradorColetor.setPontuacao(7);
        moradorColetor.setAtivo(true);
        moradorColetor.setQuantidadeLixoReciclado(5);
        
        MoradorColetor moradorColetor2 = new MoradorColetor();
        moradorColetor2.setId(2);
        moradorColetor2.setEmail("BBBBBBBBB");
        moradorColetor2.setSenha("senhaaaa");
        moradorColetor2.setNome("TesteMorador2");
        moradorColetor2.setCpf("123123123");
        moradorColetor2.setDataNascimento( Date.valueOf( "2002-07-05" ) );
        moradorColetor2.setQuantidadeLixoColetado(6);
        moradorColetor2.setPontuacao(7);
        moradorColetor2.setAtivo(true);
        moradorColetor2.setQuantidadeLixoReciclado(5);
        
        Coordenada coordenada = new Coordenada();
        coordenada.setLongitude(-21.827400);
        coordenada.setLatitude(-46.905896);
        
        PontoDeColeta pontoDeColeta = new PontoDeColeta();
        pontoDeColeta.setId(24);
        pontoDeColeta.setBairro("bairro");
        pontoDeColeta.setCidade("Vargem Grande do Sul");
        pontoDeColeta.setColetado(true);
        pontoDeColeta.setComplemento("complemento");
        pontoDeColeta.setCoordenada( coordenada );
        pontoDeColeta.setDesativado(true);
        pontoDeColeta.setMorador( moradorColetor );
        pontoDeColeta.setNumero("123A");
        pontoDeColeta.setRua("Rua");
        pontoDeColeta.setTipoDeLixo("OR");
        
        Denuncia denuncia = new Denuncia();
        denuncia.setId(1);
        denuncia.setDataDenuncia( Date.valueOf("2002-07-05") );
        denuncia.setDesativado(true);
        denuncia.setDescricao("descricaoooooooo");
        denuncia.setPontoDeColeta(pontoDeColeta);
        
        Notificacao notificacao = new Notificacao();
        notificacao.setId(1);
        notificacao.setDescricao("descricaoNotificacao2");
        notificacao.setMoradorColetor(moradorColetor2);
        notificacao.setPontoDeColeta(pontoDeColeta);
              
        NotificacoesDAO dao = null;
        
        try {
            
            dao = new NotificacoesDAO();
         
            dao.salvar(notificacao);
            
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
