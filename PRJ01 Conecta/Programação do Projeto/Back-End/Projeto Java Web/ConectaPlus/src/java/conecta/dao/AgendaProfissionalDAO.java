package conecta.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conecta.entidades.Agendamento;
import conecta.entidades.Cliente;
import conecta.entidades.Usuario;
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
                    a.id_agendamentos id_agendamentos,
                    a.age_data age_data,
                    a.age_horario age_horario,
                    a.age_status age_status,
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

    @Override
    public void atualizar(Agendamento obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Agendamento obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
