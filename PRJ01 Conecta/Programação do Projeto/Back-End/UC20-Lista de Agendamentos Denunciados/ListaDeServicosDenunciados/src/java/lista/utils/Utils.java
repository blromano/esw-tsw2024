package lista.utils;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public abstract class Utils {
    
    /*
    * Realiza a leitura da chave primária após
    * a inserção no banco.
    */
    
    public static Long getChavePrimariaAposInsercao(
                PreparedStatement stmt, String nomeColunaChave )
                throws SQLException {
        
        Long pk = null;
        
        try ( ResultSet rsPK = stmt.getGeneratedKeys() ){
            
            if( rsPK.next() ){
                
                pk = rsPK.getLong( nomeColunaChave );
            }
        }
        
        return pk;
        
    }
    
}
