package agenda.dao;

import agenda.entidades.Usuario;
import agenda.utils.Utils;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends DAO<Usuario>{

    public static Usuario autenticar(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
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
                " ?, ?, ? );",
                new String[]{"insert_id"} );
        
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
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ));
        stmt.close();
        
        
    }
    
    @Override
    public List<Usuario> listarTodos() throws SQLException{
        
        List<Usuario> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "+
                "   u.id_usuarios usuId,"+
                "   u.usu_nome usuNome,"+
                "   u.usu_email usuEmail,"+
                " FROM "+
                "   usuarios u; "
                 );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            
            Usuario u = new Usuario();
            
            u.setId(rs.getLong("usuId"));
            u.setNome(rs.getString("usuNome"));
            u.setEmail(rs.getString("usuEmail"));
            
            lista.add(u);
            
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
    public Usuario obterPorId( Long id ) throws SQLException{
        
        Usuario usuario = null;
        
        return usuario;
        
    }
    
    /*--------------------------------------------*/
    
    //Tentativa inicial de sistema de login (Não finalizada)
    public void autenticar( Usuario obj ) throws SQLException{
        
        try {
            
            PreparedStatement stmt = getConnection().prepareStatement(
                    "SELECT * FROM usuario "+ 
                    " WHERE "+
                    " usu_email = ? "+
                    " AND "+
                    " usu_senha = ? " );
            
            stmt.setString( 1, obj.getEmail());
            stmt.setString( 2, obj.getSenha());
            
        } catch ( SQLException exc ){
            
            System.out.println("Nao encontrado no banco de dados");
            
        }
        
    }
}