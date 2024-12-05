/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

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


    public Terceirizado selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_ID_PUBLICO, SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id);
        
        Terceirizado ter = new Terceirizado() ;
        
        ResultSet rs = sql.executeQuery() ;
        AreaDAO are = new AreaDAO() ;
        
        if (rs.next()) {
            
            ter.setId(rs.getString("SER_ID_PUBLICO"));
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setArea(are.selecionarPorID(rs.getInt("FK_AREAS_ARE_ID")));
            
            
        }
        are.fecharConexao();
        sql.close();
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
        AreaDAO are = new AreaDAO() ;
        
        while (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(are.selecionarPorID(rs.getInt("FK_AREAS_ARE_ID")));
            
            lista.add(ter) ;
            
        }
        are.fecharConexao();
        sql.close();
        return lista ;
    }
    
    public Terceirizado procurarPorEmailESenha (String email, String senha) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_EMAIL = ? AND
                                                                    SER_SENHA = ? ;""") ;
        
        sql.setString(1, email);
        sql.setString(2, senha);
        Terceirizado ter = new Terceirizado() ;
        ResultSet rs = sql.executeQuery() ;
        AreaDAO are = new AreaDAO() ;
        
        if (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(are.selecionarPorID(rs.getInt("FK_AREAS_ARE_ID")));
            
            
            
        }
        are.fecharConexao();
        sql.close();
        return ter ;
    }
    
    
    void selecionarPorID(Terceirizado id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_ID_PRIVADO
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id.getId());
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            id.setIdPrivado(rs.getInt("SER_ID_PRIVADO"));
            
        }
        
        sql.close();
        
    }
    
    public Terceirizado procurarPorEmail (String email) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT SER_NOME, SER_CPF, SER_CELULAR,
                                                                    SER_EMAIL, SER_SENHA, FK_AREAS_ARE_ID
                                                                FROM SERVICOS_TERCEIRIZADOS
                                                                WHERE SER_EMAIL = ? ;""") ;
        
        sql.setString(1, email);
        
        Terceirizado ter = new Terceirizado() ;
        ResultSet rs = sql.executeQuery() ;
        AreaDAO are = new AreaDAO() ;
        
        if (rs.next()) {
            
            ter.setNome(rs.getString("SER_NOME"));
            ter.setCpf(rs.getString("SER_CPF"));
            ter.setCelular(rs.getString("SER_CELULAR"));
            ter.setEmail(rs.getString("SER_EMAIL"));
            ter.setSenha(rs.getString("SER_SENHA"));
            ter.setSenha(rs.getString("CID_SENHA"));
            ter.setArea(are.selecionarPorID(rs.getInt("FK_AREAS_ARE_ID")));
            
            
            
        }
        are.fecharConexao();
        sql.close();
        return ter ;
    }
    
    public void salvarSenhaAtualizacao (Terceirizado obj) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE SERVICOS_TERCEIRIZADOS
                                                              SET
                                                                SER_COD_RECUPERACAO = ?
                                                              WHERE
                                                                SER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, obj.getCodRecuperacao());
        sql.setInt(2, obj.getArea().getId());
        
        
        sql.executeUpdate() ;
    }
}
