package lista.dao;

import lista.entidades.Profissional;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lista.entidades.Usuario;


public class ProfissionalDAO extends DAO<Profissional>{
    
    public ProfissionalDAO() throws SQLException{
        
        
    }
    
    @Override
    public void salvar( Profissional obj) throws SQLException{
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO profissionais( "+
                "   pro_status, "+
                "   pro_tel_com, "+
                "   pro_end_com,"+ 
                "   pro_foto,"+ 
                "   pro_id_usuarios, "+
                "   pro_cpf_cnpj ) "+
                " VALUES( "+
                " 'Ativo', ?, ?,"+
                " ?, ?, ?);");
        
        stmt.setString( 1, obj.getTelCom());
        stmt.setString( 2, obj.getEndCom());
        stmt.setBytes(3, obj.getBytesFoto());
        stmt.setLong(4, obj.getUsuario().getId());
        stmt.setString( 5, obj.getCpfCnpj());
        
        stmt.executeUpdate();
        stmt.close();
        
        
    }
    
    @Override
    public List<Profissional> listarTodos() throws SQLException{
        
        List<Profissional> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT "+
                "   p.id_profissionais idProfissional,"+
                "   u.id_usuarios usuId,"+
                "   u.usu_nome usuNome,"+
                "   u.usu_email usuEmail,"+
                " FROM "+
                "   profissionais p,"+
                "   usuarios u "+
                " WHERE "+
                "   p.pro_id_usuarios = u.id_usuarios; "
                 );
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            
            Profissional p = new Profissional();
            Usuario u = new Usuario();
            
            p.setId(rs.getLong("idProfissional"));
            p.setUsuario(u);
            
            u.setId(rs.getLong("usuId"));
            u.setNome(rs.getString("usuNome"));
            u.setEmail(rs.getString("usuEmail"));
            
            lista.add(p);
            
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
    public Profissional obterPorId( Long id ) throws SQLException{
        
        Profissional profissional = new Profissional();
        
        return profissional;
        
    }
    
    /*--------------------------------------------*/
    
}
