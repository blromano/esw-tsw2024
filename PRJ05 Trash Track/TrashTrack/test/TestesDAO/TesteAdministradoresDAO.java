/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestesDAO;

import trashtrack.dao.AdministradoresDAO;
import trashtrack.entidades.Administrador;
import java.sql.SQLException;

/**
 *
 * @author victo
 */
public class TesteAdministradoresDAO {
    
    public static void main(String[] args) {
        
        Administrador administrador = new Administrador();
        administrador.setId(3);
        administrador.setEmail("emailEmail");
        administrador.setSenha("senha");
        
        AdministradoresDAO dao = null;
        
        try {
            
            dao = new AdministradoresDAO();
            
            dao.salvar(administrador);
            
            
        } catch (SQLException exc) {
            
        }
        
    }
    
}
