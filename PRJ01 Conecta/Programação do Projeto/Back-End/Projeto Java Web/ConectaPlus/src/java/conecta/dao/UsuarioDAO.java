package conecta.dao;

import conecta.entidades.Profissional;
import conecta.entidades.Usuario;
import conecta.utils.Utils;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public boolean autenticar( Usuario obj ) throws SQLException{
        
        String sql = "SELECT * FROM usuarios "+ 
                    " WHERE "+
                    " usu_email = ? "+
                    " AND "+
                    " usu_senha = ? ";
        
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){

            stmt.setString( 1, obj.getEmail());
            stmt.setString( 2, obj.getSenha());

            System.out.println("Autenticou");

            
            try ( ResultSet rs = stmt.executeQuery()){
                
                if( rs.next()){
                    
                    System.out.println("Usuário autenticado com sucesso!");
                    return true;
                    
                } else {
                    
                    System.out.println("Falha na autenticação: usuário não encontrado.");
                    return false;
                }
                
            }

        
        }catch(SQLException exc ) {
            
            exc.printStackTrace();
            return false;
                
        }
        
        
    }

    @Override
    public void atualizar(Usuario obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Usuario obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> listarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
