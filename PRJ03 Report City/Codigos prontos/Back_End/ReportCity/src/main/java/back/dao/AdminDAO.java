/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import back.entidades.Administrador ;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicho
 */
public class AdminDAO extends DAO<Administrador>{

    public AdminDAO() throws SQLException{
        super();
    }
    
    @Override
    public void salvar(Administrador obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSET INTO ADMINISTRADORES
                                                                    (ADM_NOME, ADM_EMAIL, ADM_SENHA)
                                                                VALUES 
                                                                    (?, ?, ?) ;""") ;
        
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getEmail());
        sql.setString(3, obj.getSenha());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Administrador obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE ADMINISTRADORES
                                                                SET
                                                                ADM_NOME = ?,
                                                                ADM_EMAIL = ?,
                                                                ADM_SENHA = ?
                                                              WHERE 
                                                              ADM_ID_PUBLICO = ? ;""") ;
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getEmail());
        sql.setString(3, obj.getSenha());
        sql.setString(4, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(Administrador obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM ADMINISTRADORES
                                                              WHERE 
                                                              ADM_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Administrador> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT ADM_ID_PUBLICO, ADM_NOME, ADM_EMAIL, ADM_SENHA 
                                                                      FROM ADMINISTRADORES ;""") ;
        
        List<Administrador>lista = new ArrayList<>() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            Administrador ad = new Administrador() ;
            
            ad.setEmail(rs.getString("ADM_EMAIL"));
            ad.setId(rs.getString("ADM_ID_PUBLICO"));
            ad.setNome(rs.getString("ADM_NOME"));
            ad.setSenha(rs.getString("ADM_SENHA"));
            
            lista.add(ad) ;
        }
        sql.close();
        return lista ;
    }
    
    public Administrador selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT ADM_ID_PUBLICO, ADM_NOME, ADM_EMAIL, ADM_SENHA 
                                                                FROM ADMINISTRADORES 
                                                                WHERE ADM_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id);
        
        Administrador ad = new Administrador() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            ad.setEmail(rs.getString("ADM_EMAIL"));
            ad.setId(rs.getString("ADM_ID_PUBLICO"));
            ad.setNome(rs.getString("ADM_NOME"));
            ad.setSenha(rs.getString("ADM_SENHA"));
            
        }
        sql.close();
        return ad ;
    }
    
    public Administrador procurarPorEmailESenha (String email, String senha) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT ADM_ID_PUBLICO, 
                                                                    ADM_EMAIL, ADM_NOME, ADM_SENHA 
                                                              FROM ADMINISTRADORES 
                                                                WHERE ADM_EMAIL = ? AND
                                                                    ADM_SENHA = ?;""") ;
        sql.setString(1, email);
        sql.setString(2, senha);
        
        
        Administrador ad = new Administrador() ;
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            ad.setEmail(rs.getString("ADM_EMAIL"));
            ad.setId(rs.getString("ADM_ID_PUBLICO"));
            ad.setNome(rs.getString("ADM_NOME"));
            ad.setSenha(rs.getString("ADM_SENHA"));
            
        
        }
        sql.close();
        return ad ;
    }
    
    void selecionarPorID(Administrador ad) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT ADM_ID_PRIVADO
                                                                FROM ADMINISTRADORES 
                                                                WHERE ADM_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, ad.getId());
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            ad.setIdPrivado(rs.getInt("ADM_ID_PRIVADO"));
            
        }
        sql.close();
    }
    
}
