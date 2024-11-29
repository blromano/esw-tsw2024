/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import back.entidades.Area;
import java.sql.SQLException;
import java.util.List;
import back.entidades.Terceirizado ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class TerceirizadoDAO extends DAO<Terceirizado>{

    public TerceirizadoDAO() throws SQLException{
        super();
    }

    @Override
    public void salvar(Terceirizado obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO SERVICOS_TERCEIRIZADOS
                                                                    (SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID)
                                                                VALUES 
                                                                    (?, ?, ?, 
                                                                        ?, ?, ?) ;""") ;
        
        
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getCpf());
        sql.setString(3, obj.getCelular());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha()) ;
        sql.setInt(7, obj.getArea().getId()) ;
        
        sql.executeUpdate() ;
        
    }

    @Override
    public void atualizar(Terceirizado obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE SERVICOS_TERCEIRIZADOS
                                                              SET
                                                                SER_NOME = ?, 
                                                                SER_CPF = ?, 
                                                                SER_CELULAR = ?,
                                                                SER_EMAIL = ?, 
                                                                SER_SENHA = ?, 
                                                                FK_AREAS_ARE_ID = ?
                                                              WHERE
                                                                SER_ID_PUBLICO = ?;""") ;
        
        
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getCpf());
        sql.setString(3, obj.getCelular());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha());
        sql.setInt(6, obj.getArea().getId());
        
        
        sql.executeUpdate() ;
        
        
    }

    @Override
    public void excluir(Terceirizado obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM SERVICOS_TERCEIRIZADOS
                                                              WHERE 
                                                              GER_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getId());
        
        sql.executeUpdate() ;
    }

    @Override
    public Terceirizado selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id);
        
        Terceirizado ter = new Terceirizado() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(new Area(rs.getInt("FK_AREAS_ARE_ID")));
            
            
        }
        return ter ;
    }

    @Override
    public List<Terceirizado> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS ;""") ;
        
        
        Terceirizado ter = new Terceirizado() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        List<Terceirizado> lista = new ArrayList<>() ;
        while (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(new Area(rs.getInt("FK_AREAS_ARE_ID")));
            
            lista.add(ter) ;
            
        }
        return lista ;
    }
    
    public List<Terceirizado> procurarPorEmail (String email) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_EMAIL = ?;""") ;
        
        sql.setString(1, email);
        List<Terceirizado> lista = new ArrayList<>() ;
        Terceirizado ter = new Terceirizado() ;
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(new Area(rs.getInt("FK_AREAS_ARE_ID")));
            
            lista.add(ter) ;
            
        }
        return lista ;
    }
    
    public List<Terceirizado> procurarPorSenha (String senha) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_SENHA = ?;""") ;
        
        sql.setString(1, senha);
        List<Terceirizado> lista = new ArrayList<>() ;
        Terceirizado ter = new Terceirizado() ;
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(new Area(rs.getInt("FK_AREAS_ARE_ID")));
            
            lista.add(ter) ;
            
        }
        return lista ;
    }
    
}
