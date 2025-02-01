package lista.dao;

import lista.entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lista.entidades.Usuario;

public class ClienteDAO extends DAO<Cliente>{
    
    public ClienteDAO() throws SQLException{
        
        
    }
    
    @Override
    public void salvar(Cliente obj) throws SQLException{
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO clientes( "+ 
                "   cli_cpf,"+ 
                "   cli_id_usuarios)"+
                " VALUES( "+
                " ?, ? );");
        
        stmt.setString( 1, obj.getCpf());
        stmt.setLong(2, obj.getUsuario().getId());
        
        stmt.executeUpdate();
        stmt.close();
        
    }
    
    @Override
    public List<Cliente> listarTodos() throws SQLException{
        
        List<Cliente> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "+
                "   c.id_clientes idCliente,"+
                "   u.id_usuarios usuId,"+
                "   u.usu_nome usuNome,"+
                "   u.usu_email usuEmail,"+
                " FROM "+
                "   clientes c,"+
                "   usuarios u "+
                " WHERE "+
                "   c.cli_id_usuarios = u.id_usuarios; "
                 );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            
            Cliente c = new Cliente();
            Usuario u = new Usuario();
            
            c.setId(rs.getLong("idCliente"));
            c.setUsuario(u);
            
            u.setId(rs.getLong("usuId"));
            u.setNome(rs.getString("usuNome"));
            u.setEmail(rs.getString("usuEmail"));
            
            lista.add(c);
            
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }
    
    /*
        Falta implementação
        Criado apenas para evitar erros
    */
    @Override 
    public Cliente obterPorId( Long id ) throws SQLException{
        
        Cliente cliente = new Cliente();
        
        return cliente;
        
    }
    
    /*------------------------------------*/

}

