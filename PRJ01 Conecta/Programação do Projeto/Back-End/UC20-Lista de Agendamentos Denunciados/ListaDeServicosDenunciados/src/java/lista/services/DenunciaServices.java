/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lista.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lista.dao.DenunciaDAO;
import lista.entidades.Denuncia;

/**
 *
 * @author otavi
 */
public class DenunciaServices {
    
    public List<Denuncia> getTodos() throws SQLException {

        List<Denuncia> lista = new ArrayList<>();

        DenunciaDAO dao = new DenunciaDAO();
        
        lista = dao.listarTodos();
       

        return lista;

    }
    
}
