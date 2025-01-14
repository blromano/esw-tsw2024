package conecta.dao;

import conecta.entidades.Cliente;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

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

