package conecta.dao;

import conecta.entidades.Profissional;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;


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
