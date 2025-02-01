package lista.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lista.entidades.Denuncia;
import lista.utils.Utils;


public class DenunciaDAO extends DAO<Denuncia> {
    
    
    public DenunciaDAO() throws SQLException {
        
    }
    
    @Override
    public void salvar ( Denuncia obj ) throws SQLException {
        
        //Implementação deve ser realizada ainda
        
    }
    
    @Override
    public List<Denuncia> listarTodos() throws SQLException{
        
        List<Denuncia> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
                """
                SELECT  
                    id_denuncias,
                    den_status,
                    den_motivo,
                    den_descricao,
                    den_id_agendamentos
                FROM denuncias;  
                """ );

        ResultSet rs = stmt.executeQuery();

        while ( rs.next() ) {

            Denuncia d = new Denuncia();

            d.setId(rs.getLong("id_denuncias"));
            d.setStatus(rs.getString("den_status"));
            d.setMotivo(rs.getString("den_motivo"));
            d.setDescricao(rs.getString("den_descricao"));
            

            lista.add( d );

        }

        rs.close();
        stmt.close();

        return lista;
        
    }
    
    @Override
    public Denuncia obterPorId (Long id) throws SQLException{
        
        Denuncia denuncia = new Denuncia();
        //Implementação deve ser realizada ainda
        
        return denuncia;
        
    }
    
    
    
}
