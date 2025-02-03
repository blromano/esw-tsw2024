/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conecta.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conecta.dao.AgendaProfissionalDAO;
import conecta.entidades.Agendamento;

/**
 *
 * @author otavi
 */
public class AgendaProfissionalService {
    
    public List<Agendamento> getTodos() throws SQLException {

        List<Agendamento> lista = new ArrayList<>();

        AgendaProfissionalDAO dao = new AgendaProfissionalDAO();
        
        lista = dao.listarTodos();
       

        return lista;

    }
    
}
