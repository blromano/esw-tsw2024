/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import agenda.dao.AgendamentoDAO;
import agenda.entidades.Agendamento;

/**
 *
 * @author otavi
 */
public class AgendamentoServices {
    
    public List<Agendamento> getTodos() throws SQLException {

        List<Agendamento> lista = new ArrayList<>();

        AgendamentoDAO dao = new AgendamentoDAO();
        
        lista = dao.listarTodos();
       

        return lista;

    }
    
}
