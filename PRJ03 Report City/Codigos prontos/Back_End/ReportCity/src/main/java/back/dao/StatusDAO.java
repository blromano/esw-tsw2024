/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import back.Util.Utils;
import java.sql.SQLException;
import java.util.List;
import back.entidades.Status ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class StatusDAO extends DAO<Status>{

    public StatusDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Status obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO STATUS
                                                                (STA_NOME)
                                                              VALUES
                                                                (?) ;""",
                                                               new String[]{ "insert_id" } ) ;
        sql.setString(1, obj.getStatus());
        
        
        sql.executeUpdate() ;
        obj.setId( Utils.getChavePrimariaAposInsercao( sql, "insert_id" ).intValue() );
        sql.close();
    }

    @Override
    public void atualizar(Status obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE STATUS
                                                              SET
                                                                STA_NOME = ?
                                                              WHERE
                                                                STA_ID = ? ;""") ;
        
        sql.setString(1, obj.getStatus());
        sql.setInt(2, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(Status obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM STATUS
                                                              WHERE
                                                                STA_ID = ? ;""") ;
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Status> selecionarTodos() throws SQLException {
        List<Status> lista = new ArrayList<>() ;
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT STA_ID, STA_NOME
                                                                FROM STATUS ;""") ;
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()){
            Status s = new Status() ;
            
            s.setId(rs.getInt("STA_ID"));
            s.setStatus(rs.getString("STA_NOME"));
            
            lista.add(s) ;
        }
        
        
        return lista ;
    }

    public Status selecionarPorID(int id) throws SQLException {
        Status s = new Status() ;
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT STA_ID, STA_NOME
                                                                FROM STATUS 
                                                              WHERE
                                                                STA_ID = ? ;""") ;
        
        sql.setInt(1, id);
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()){
            
            
            s.setId(rs.getInt("STA_ID"));
            s.setStatus(rs.getString("STA_NOME"));
            
            
        }
        
        
        return s ;
    }

}
