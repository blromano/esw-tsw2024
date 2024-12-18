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
                "   cli_cpf )"+
                " VALUES( "+
                " ? );");
        
        stmt.setString( 1, obj.getCpf());
        
        stmt.executeUpdate();
        stmt.close();
        
    }

}

