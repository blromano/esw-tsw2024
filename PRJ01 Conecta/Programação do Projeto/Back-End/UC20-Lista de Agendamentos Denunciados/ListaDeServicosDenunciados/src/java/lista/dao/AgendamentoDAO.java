package lista.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lista.entidades.Agendamento;
import lista.utils.Utils;


public class AgendamentoDAO extends DAO<Agendamento>{
   
    public AgendamentoDAO() throws SQLException {
        
    }
    
    @Override
    public void salvar ( Agendamento obj ) throws SQLException {
        
        //Implementação deve ser realizada ainda
        
    }
    
    @Override
    public List<Agendamento> listarTodos() throws SQLException{
        
        List<Agendamento> agendamento = new ArrayList<>();
        //Implementar
        
       return agendamento;
        
    }
    
    @Override
    public Agendamento obterPorId (Long id) throws SQLException{
        
        Agendamento agendamento = new Agendamento();
        //Implementação deve ser realizada ainda
        
        return agendamento;
        
    }
    
}
