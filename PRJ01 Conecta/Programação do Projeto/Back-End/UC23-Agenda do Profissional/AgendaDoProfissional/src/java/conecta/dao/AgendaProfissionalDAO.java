package conecta.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conecta.utils.Utils;


public class AgendaProfissionalDAO extends DAO<Agendamento>{
   
    public AgendaProfissionalDAO() throws SQLException {
        
    }
    
    @Override
    public void salvar ( Agendamento obj ) throws SQLException {
        
        //Implementação deve ser realizada ainda
        
    }
    
    @Override
    public List<Agendamento> listarTodos() throws SQLException{
        
        List<Agendamento> agendamento = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT
                    a.id_agendamentos idAgendamentos,
                    a.age_data ageData,
                    a.age_horario ageHorario,
                    a.age_status ageStatus,
                    a.age_id_clientes ageIdCliente,
                    c.id_clientes idCliente,
                    c.cli_id_usuarios cliIdUsuarios,
                    u.id_usuarios idUsuarios,
                    u.usu_nome usuNome    
                FROM 
                    agendamentos a,
                    clientes c,
                    usuarios u
                WHERE
                    a.age_id_clientes = c.id_clientes
                AND
                    c.cli_id_usuarios  = u.id_usuarios ;
                """);
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next()) {
            
            Agendamento a = new Agendamento();
            Cliente c = new Cliente();
            Usuario u = new Usuario();
            
            u.setId(rs.getLong("idUsuarios"));
            u.setNome(rs.getString("usuNome"));
            
            c.setId(rs.getLong("idCliente"));
            c.setUsuario(u);
            
            a.setId_agendamentos(rs.getInt("id_agendamentos"));
            a.setAge_data(rs.getDate("age_data"));
            a.setAge_horario(rs.getTime("age_horario"));
            a.setAge_status(rs.getString("age_status"));
            a.setCliente(c);
            
            if ( !"Concluido".equals(a.getAge_status()) && !"Cancelado".equals(a.getAge_status())){
                agendamento.add(a);
            }
            
        }
        
        rs.close();
        stmt.close();
                
        
        return agendamento;
        
    }
    
    @Override
    public Agendamento obterPorId (Long id) throws SQLException{
        
        Agendamento agendamento = new Agendamento();
        //Implementação deve ser realizada ainda
        
        return agendamento;
        
    }
    
}
