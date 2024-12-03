/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import back.entidades.Area ;
import java.sql.PreparedStatement ;
import java.util.ArrayList;
import java.util.List;
import back.Util.Utils;
import java.sql.ResultSet;

/**
 *
 * @author nicho
 */
public class AreaDAO extends DAO<Area>{

    public AreaDAO () throws SQLException{
        super() ;
    }

    @Override
    public void salvar(Area obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                                INSERT INTO AREAS
                                                                    (ARE_NOME, ARE_DESCRICAO)
                                                                VALUES
                                                                    (?, ?) ;""",
                                                                new String[]{ "insert_id" } ) ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getDescricao());
        
        sql.executeUpdate() ;
        obj.setId( Utils.getChavePrimariaAposInsercao( sql, "insert_id" ).intValue() );
        sql.close();
        
    }

    @Override
    public void atualizar(Area obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                                UPDATE 
                                                                    AREAS
                                                                SET
                                                                    ARE_NOME = ? , 
                                                                    ARE_DESCRICAO = ?
                                                                WHERE
                                                                    ARE_ID = ?;""") ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getDescricao());
        sql.setInt(3, obj.getId());
        
        
        sql.executeUpdate() ;
        
        sql.close();
    }

    @Override
    public void excluir(Area obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM AREAS
                                                              WHERE 
                                                                ARE_ID = ? ;""") ;
        
        sql.setInt(1, obj.getId());
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Area> selecionarTodos() throws SQLException {
        List<Area> lista = new ArrayList<>() ;
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT 
                                                                ARE_ID, ARE_DESCRICAO, ARE_NOME
                                                              FROM
                                                                AREAS;
                                                              """) ;
        
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            Area a = new Area() ;
            
            a.setDescricao(rs.getString("ARE_DESCRICAO"));
            a.setId(rs.getInt("ARE_ID"));
            a.setNome(rs.getString("ARE_NOME"));
            
            lista.add(a) ;
        }
        return lista ;
    }

    public Area selecionarPorID(int id) throws SQLException {
        Area a = new Area() ;
        
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT 
                                                                ARE_ID, ARE_DESCRICAO, ARE_NOME
                                                              FROM
                                                                AREAS
                                                              WHERE
                                                                ARE_ID = ? ;
                                                              """) ;
        
        sql.setInt(1, id);
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            
            a.setDescricao(rs.getString("ARE_DESCRICAO"));
            a.setId(rs.getInt("ARE_ID"));
            a.setNome(rs.getString("ARE_NOME"));
            
            
        }
        return a ;
    }
    
}
