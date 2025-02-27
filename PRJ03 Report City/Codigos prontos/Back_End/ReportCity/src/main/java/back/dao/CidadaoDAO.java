/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement ;
import back.entidades.Cidadao ;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class CidadaoDAO extends DAO<Cidadao>{

    public CidadaoDAO () throws SQLException{
        super() ;
    }

    @Override
    public void salvar(Cidadao obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO CIDADOES
                                                                    (CID_COMPLEMENTO, CID_NUMERO, CID_NOME, 
                                                                        CID_CPF, CID_CELULAR, CID_EMAIL, 
                                                                        CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                        CID_CIDADE, CID_ESTADO, CID_SENHA)
                                                                VALUES 
                                                                    (?, ?, ?, 
                                                                        ?, ?, ?, 
                                                                        ?, ?, ?, 
                                                                        ?, ?, ?) ;""") ;
        
        sql.setString(1, obj.getComplemento());
        sql.setString(2, obj.getNumero());
        sql.setString(3, obj.getNome());
        sql.setString(4, obj.getCpf());
        sql.setString(5, obj.getCelular());
        sql.setString(6, obj.getEmail());
        sql.setString(7, obj.getCep());
        sql.setString(8, obj.getRua());
        sql.setString(9, obj.getBairro());
        sql.setString(10, obj.getCidade());
        sql.setString(11, obj.getEstado());
        sql.setString(12, obj.getSenha());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Cidadao obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE CIDADOES
                                                              SET
                                                                CID_COMPLEMENTO = ?,
                                                                CID_NUMERO = ?, 
                                                                CID_NOME = ?, 
                                                                CID_CPF = ?, 
                                                                CID_CELULAR = ?, 
                                                                CID_EMAIL = ?, 
                                                                CID_CEP = ?, 
                                                                CID_RUA = ?, 
                                                                CID_BAIRRO = ?,
                                                                CID_CIDADE = ?, 
                                                                CID_ESTADO = ?, 
                                                                CID_SENHA = ?
                                                              WHERE
                                                                CID_ID_PRIVADO = ?;""") ;
        
        this.selecionarPorID(obj);
        sql.setString(1, obj.getComplemento());
        sql.setString(2, obj.getNumero());
        sql.setString(3, obj.getNome());
        sql.setString(4, obj.getCpf());
        sql.setString(5, obj.getCelular());
        sql.setString(6, obj.getEmail());
        sql.setString(7, obj.getCep());
        sql.setString(8, obj.getRua());
        sql.setString(9, obj.getBairro());
        sql.setString(10, obj.getCidade());
        sql.setString(11, obj.getEstado());
        sql.setString(12, obj.getSenha());
        sql.setInt(13, obj.getIdPrivado());
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(Cidadao obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM CIDADOES
                                                              WHERE 
                                                              ADM_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Cidadao> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PUBLICO, CID_COMPLEMENTO, CID_NUMERO, CID_NOME, 
                                                                CID_CPF, CID_CELULAR, CID_EMAIL, 
                                                                CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                CID_CIDADE, CID_ESTADO, CID_SENHA
                                                                FROM CIDADOES ;""") ;
        
        
        Cidadao cid = new Cidadao() ;
        List<Cidadao> lista = new ArrayList<>() ;
        ResultSet rs = sql.executeQuery() ;
        
        while (rs.next()) {
            
            cid.setId(rs.getString("CID_ID_PUBLICO"));
            cid.setComplemento(rs.getString("CID_COMPLEMENTO"));
            cid.setNumero(rs.getString("CID_NUMERO"));
            cid.setNome(rs.getString("CID_NOME"));
            cid.setCpf(rs.getString("CID_CPF"));
            cid.setCelular(rs.getString("CID_CELULAR"));
            cid.setEmail(rs.getString("CID_EMAIL"));
            cid.setCep(rs.getString("CID_CEP"));
            cid.setRua(rs.getString("CID_RUA"));
            cid.setBairro(rs.getString("CID_BAIRRO"));
            cid.setCidade(rs.getString("CID_CIDADE"));
            cid.setEstado(rs.getString("CID_ESTADO"));
            cid.setSenha(rs.getString("CID_SENHA"));
        
            lista.add(cid) ;
        }
        sql.close();
        return lista ;
    }
    
    public Cidadao selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PUBLICO, CID_COMPLEMENTO, CID_NUMERO, CID_NOME, 
                                                                CID_CPF, CID_CELULAR, CID_EMAIL, 
                                                                CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                CID_CIDADE, CID_ESTADO, CID_SENHA
                                                                FROM CIDADOES 
                                                                WHERE CID_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id);
        
        Cidadao cid = new Cidadao() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            cid.setId(rs.getString("CID_ID_PUBLICO"));
            cid.setComplemento(rs.getString("CID_COMPLEMENTO"));
            cid.setNumero(rs.getString("CID_NUMERO"));
            cid.setNome(rs.getString("CID_NOME"));
            cid.setCpf(rs.getString("CID_CPF"));
            cid.setCelular(rs.getString("CID_CELULAR"));
            cid.setEmail(rs.getString("CID_EMAIL"));
            cid.setCep(rs.getString("CID_CEP"));
            cid.setRua(rs.getString("CID_RUA"));
            cid.setBairro(rs.getString("CID_BAIRRO"));
            cid.setCidade(rs.getString("CID_CIDADE"));
            cid.setEstado(rs.getString("CID_ESTADO"));
            cid.setSenha(rs.getString("CID_SENHA"));
        
            
        }
        sql.close();
        return cid ;
    }
    
    public Cidadao procurarPorEmailESenha (String email, String senha) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PUBLICO, CID_COMPLEMENTO, 
                                                                CID_NUMERO, CID_NOME, 
                                                                CID_CPF, CID_CELULAR, 
                                                                CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                CID_CIDADE, CID_ESTADO, CID_SENHA, CID_EMAIL
                                                                FROM CIDADOES 
                                                                WHERE  CID_EMAIL = ? AND
                                                                        CID_SENHA = ? ;""") ;
        
        sql.setString(1, email);
        sql.setString(2, senha);
        Cidadao cid = new Cidadao() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            cid.setId(rs.getString("CID_ID_PUBLICO"));
            cid.setComplemento(rs.getString("CID_COMPLEMENTO"));
            cid.setNumero(rs.getString("CID_NUMERO"));
            cid.setNome(rs.getString("CID_NOME"));
            cid.setCpf(rs.getString("CID_CPF"));
            cid.setCelular(rs.getString("CID_CELULAR"));
            cid.setEmail(rs.getString("CID_EMAIL"));
            cid.setCep(rs.getString("CID_CEP"));
            cid.setRua(rs.getString("CID_RUA"));
            cid.setBairro(rs.getString("CID_BAIRRO"));
            cid.setCidade(rs.getString("CID_CIDADE"));
            cid.setEstado(rs.getString("CID_ESTADO"));
            cid.setSenha(rs.getString("CID_SENHA"));
        
            
        }
        sql.close();
        return cid ;
    }
    
    void selecionarPorID(Cidadao id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PRIVADO
                                                              FROM CIDADOES 
                                                                WHERE CID_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id.getId());
        
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            id.setIdPrivado(rs.getInt("CID_ID_PRIVADO"));
            
        }
        
        sql.close();
        
    }
    
    public Cidadao procurarPorEmail (String email) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PUBLICO, CID_COMPLEMENTO, 
                                                                CID_NUMERO, CID_NOME, 
                                                                CID_CPF, CID_CELULAR, 
                                                                CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                CID_CIDADE, CID_ESTADO, CID_SENHA, CID_EMAIL
                                                                FROM CIDADOES 
                                                                WHERE  CID_EMAIL = ? ;""") ;
        
        sql.setString(1, email);
        Cidadao cid = new Cidadao() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            cid.setId(rs.getString("CID_ID_PUBLICO"));
            cid.setComplemento(rs.getString("CID_COMPLEMENTO"));
            cid.setNumero(rs.getString("CID_NUMERO"));
            cid.setNome(rs.getString("CID_NOME"));
            cid.setCpf(rs.getString("CID_CPF"));
            cid.setCelular(rs.getString("CID_CELULAR"));
            cid.setEmail(rs.getString("CID_EMAIL"));
            cid.setCep(rs.getString("CID_CEP"));
            cid.setRua(rs.getString("CID_RUA"));
            cid.setBairro(rs.getString("CID_BAIRRO"));
            cid.setCidade(rs.getString("CID_CIDADE"));
            cid.setEstado(rs.getString("CID_ESTADO"));
            cid.setSenha(rs.getString("CID_SENHA"));
        
            
        }
        sql.close();
        return cid ;
    }
    
    public void salvarSenhaAtualizacao (Cidadao obj) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE CIDADOES
                                                              SET
                                                                CID_COD_RECUPERACAO = ?
                                                              WHERE
                                                                CID_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, obj.getCodigoRec());
        sql.setString(2, obj.getId());
        
        
        sql.executeUpdate() ;
    }
    
    public Cidadao selecionarPorCodigoRecuperacao (String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT CID_ID_PUBLICO, CID_COMPLEMENTO, CID_NUMERO, CID_NOME, 
                                                                CID_CPF, CID_CELULAR, CID_EMAIL, 
                                                                CID_CEP, CID_RUA, CID_BAIRRO, 
                                                                CID_CIDADE, CID_ESTADO, CID_SENHA
                                                                FROM CIDADOES 
                                                                WHERE CID_COD_RECUPERACAO = ?;""") ;
        
        sql.setString(1, id);
        
        Cidadao cid = new Cidadao() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
            
            cid.setId(rs.getString("CID_ID_PUBLICO"));
            cid.setComplemento(rs.getString("CID_COMPLEMENTO"));
            cid.setNumero(rs.getString("CID_NUMERO"));
            cid.setNome(rs.getString("CID_NOME"));
            cid.setCpf(rs.getString("CID_CPF"));
            cid.setCelular(rs.getString("CID_CELULAR"));
            cid.setEmail(rs.getString("CID_EMAIL"));
            cid.setCep(rs.getString("CID_CEP"));
            cid.setRua(rs.getString("CID_RUA"));
            cid.setBairro(rs.getString("CID_BAIRRO"));
            cid.setCidade(rs.getString("CID_CIDADE"));
            cid.setEstado(rs.getString("CID_ESTADO"));
            cid.setSenha(rs.getString("CID_SENHA"));
        
            
        }
        sql.close();
        return cid ;
    }
}
