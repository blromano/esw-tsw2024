package conecta.dao;

import conecta.entidades.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends DAO<Usuario>{
    
    public UsuarioDAO() throws SQLException{
        
        
    }
    
    @Override
    public void salvar(Usuario obj) throws SQLException{
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO usuarios( "+
                " usu_nome,"+ 
                " usu_email,"+
                " usu_senha,"+
                " usu_contato,"+
                " usu_endereco,"+
                " usu_data_nasc,"+
                " usu_estado, "+
                " usu_cidade ) "+
                " VALUES ( "+
                " ?, ?, ?, ?, ?, "+
                " ?, ?, ? );");
        
        stmt.setString( 1, obj.getNome());
        stmt.setString( 2, obj.getEmail());
        stmt.setString( 3, obj.getSenha());
        stmt.setString( 4, obj.getContato());
        stmt.setString( 5, obj.getEndereco());
        java.sql.Date dataSql = new java.sql.Date(obj.getDataNasc().getTime());
        stmt.setDate(6, dataSql);
        stmt.setString( 7, obj.getEstado());
        stmt.setString( 8, obj.getCidade());
        
        stmt.executeUpdate();
        stmt.close();
        
        
    }
    
    
}
