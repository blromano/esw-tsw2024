package conecta.services;

import conecta.dao.AgendaProfissionalDAO;
import conecta.entidades.Agendamento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AgendaProfissionalService {
    
    public List<Agendamento> getTodos() throws SQLException {

        List<Agendamento> lista = new ArrayList<>();

        AgendaProfissionalDAO dao = new AgendaProfissionalDAO();
        
        lista = dao.listarTodos();
       

        return lista;

    }
    
}
