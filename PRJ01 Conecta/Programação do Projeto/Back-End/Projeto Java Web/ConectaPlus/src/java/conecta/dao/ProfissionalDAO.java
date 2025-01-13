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
                "   pro_tel_com, "+
                "   pro_end_com,"+ 
                "   pro_foto, "+
                "   pro_cpf_cnpj ) "+
                " VALUES( "+
                " ?, ?, ?);");
        
        stmt.setString( 1, obj.getTelCom());
        stmt.setString( 2, obj.getEndCom());
        stmt.setBytes(0, obj.getBytesFoto());
        stmt.setString( 3, obj.getCpfCnpj());
        
        stmt.executeUpdate();
        stmt.close();
        
        
    }
    
    
}
