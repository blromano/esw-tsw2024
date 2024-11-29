/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import back.Util.Utils;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement ;
import back.entidades.Departamento ;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class DepartamentoDAO extends DAO<Departamento> {

    public DepartamentoDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Departamento obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO DEPARTAMENTOS
                                                                (DEP_NOME, DEP_DESCRICAO)
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
    public void atualizar(Departamento obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE DEPARTAMENTOS
                                                              SET
                                                                DEP_NOME = ?, 
                                                                DEP_DESCRICAO = ?
                                                              WHERE
                                                                DEP_ID = ? ;""") ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getDescricao());
        sql.setInt(3, obj.getId());
        
        sql.executeUpdate() ;
        
        sql.close();
        
    }

    @Override
    public void excluir(Departamento obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM DEPARTAMENTO
                                                              WHERE
                                                                DEP_ID = ? ;""") ;
        
        sql.setInt(1, obj.getId());
        
        sql.executeUpdate();
        
        sql.close() ;
    }

    @Override
    public List<Departamento> selecionarTodos() throws SQLException {
        List<Departamento> lista = new ArrayList<>() ;
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT DEP_ID, DEP_NOME, DEP_DESCRICAO
                                                              FROM DEPARTAMENTOS ;""") ;
        
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()){
            Departamento dep = new Departamento() ;
            
            dep.setDescricao(rs.getString("DEP_DESCRICAO"));
            dep.setNome(rs.getString("DEP_NOME"));
            dep.setId(rs.getInt("DEP_ID"));
            
            lista.add(dep) ;
        }
        
        return lista ;
    }

    @Override
    public Departamento selecionarPorID(String id) throws SQLException {
        Departamento dep = new Departamento() ;
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT DEP_ID, DEP_NOME, DEP_DESCRICAO
                                                              FROM DEPARTAMENTOS 
                                                              WHERE DEP_ID = ?;""") ;
        
        sql.setInt(1, Integer.parseInt(id));
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()){
            
            
            dep.setDescricao(rs.getString("DEP_DESCRICAO"));
            dep.setNome(rs.getString("DEP_NOME"));
            dep.setId(rs.getInt("DEP_ID"));
            
            
        }
        
        return dep ;
    }

    
}
