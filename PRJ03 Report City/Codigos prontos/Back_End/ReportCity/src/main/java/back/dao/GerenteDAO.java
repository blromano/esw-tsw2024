/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement ;
import back.entidades.Gerente ;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author nicho
 */
public class GerenteDAO extends DAO<Gerente>{

    public GerenteDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Gerente obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO GERENTES
                                                                    (GER_FOTO, GER_NOME, GER_CPF,
                                                                        GER_EMAIL, GER_SENHA, FK_DEPARTAMENTO_DEP_ID,
                                                                        FK_ADMINISTRADORES_ADM_ID_PRIVADO)
                                                                VALUES 
                                                                    (?, ?, ?, 
                                                                        ?, ?, ?, 
                                                                        ?) ;""") ;
        
        sql.setString(1, obj.getFoto());
        sql.setString(2, obj.getNome());
        sql.setString(3, obj.getCpf());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha());
        sql.setInt(6, obj.getDep().getId()) ;
        sql.setString(7, obj.getAdmin().getId()) ;
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Gerente obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE CIDADOES
                                                              SET
                                                                GER_FOTO = ?, 
                                                                GER_NOME = ?, 
                                                                GER_CPF = ?,
                                                                GER_EMAIL = ?, 
                                                                GER_SENHA = ?, 
                                                                FK_DEPARTAMENTO_DEP_ID = ?,
                                                                FK_ADMINISTRADORES_ADM_ID_PRIVADO = ?
                                                              WHERE
                                                                GER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, obj.getFoto());
        sql.setString(2, obj.getNome());
        sql.setString(3, obj.getCpf());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha());
        sql.setInt(6, obj.getDep().getId()) ;
        sql.setString(7, obj.getAdmin().getId()) ;
        
        
        sql.executeUpdate() ;
        sql.close();
        
    }

    @Override
    public void excluir(Gerente obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM GERENTES
                                                              WHERE 
                                                              GER_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public Gerente selecionarPorID(int id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_FOTO, GER_NOME, GER_CPF,
                                                                GER_EMAIL, GER_SENHA, FK_DEPARTAMENTO_DEP_ID,
                                                                FK_ADMINISTRADORES_ADM_ID_PRIVADO
                                                                FROM GERENTES
                                                                WHERE GER_ID_PRIVADO = ?;""") ;
        
        sql.setInt(1, id);
        
        Gerente ger = new Gerente() ;
        
        ResultSet rs = sql.executeQuery() ;
        AdminDAO adm = new AdminDAO() ;
        DepartamentoDAO dep = new DepartamentoDAO() ;
        
        if (rs.next()) {
            
            
            ger.setFoto(rs.getString("CID_FOTO"));
            ger.setNome(rs.getString("CID_NOME"));
            ger.setCpf(rs.getString("CID_CPF"));
            ger.setEmail(rs.getString("CID_EMAIL"));
            ger.setSenha(rs.getString("CID_SENHA"));
            ger.setAdmin(
                        adm.selecionarPorID(rs.getString("FK_ADMINISTRADORES_ADM_ID_PRIVADO")));
            ger.setDep(
                    dep.selecionarPorID(rs.getInt("FK_DEPARTAMENTO_DEP_ID")));
        
            
        }
        
        adm.fecharConexao();
        dep.fecharConexao();
        sql.close();
        return ger ;
    }

    @Override
    public List<Gerente> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_FOTO, GER_NOME, GER_CPF,
                                                              GER_ID_PUBLICO, GER_EMAIL, GER_SENHA, 
                                                              FK_DEPARTAMENTO_DEP_ID, FK_ADMINISTRADORES_ADM_ID_PRIVADO
                                                                FROM GERENTES ;""") ;
        
        
        Gerente ger = new Gerente() ;
        List<Gerente> lista = new ArrayList<>() ;
        ResultSet rs = sql.executeQuery() ;
        AdminDAO adm = new AdminDAO() ;
        DepartamentoDAO dep = new DepartamentoDAO() ;
        
        while (rs.next()) {
            
            ger.setNome(rs.getString("GER_NOME"));
            ger.setFoto(rs.getString("GER_FOTO"));
            ger.setCpf(rs.getString("GER_CPF"));
            ger.setEmail(rs.getString("GER_EMAIL"));
            ger.setSenha(rs.getString("GER_SENHA"));
            ger.setId(rs.getString("GER_ID_PUBLICO"));
            
            ger.setAdmin(
                        adm.selecionarPorID(rs.getString("FK_ADMINISTRADORES_ADM_ID_PRIVADO")));
            ger.setDep(
                    dep.selecionarPorID(rs.getInt("FK_DEPARTAMENTO_DEP_ID")));
        
            lista.add(ger) ;
        }
        adm.fecharConexao();
        dep.fecharConexao();
        sql.close();
        return lista ;
    }
    
    public Gerente procurarPorEmailESenha (String email, String senha) throws SQLException{
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_FOTO, GER_NOME, GER_CPF,
                                                              GER_ID_PUBLICO, GER_SENHA, GER_EMAIL,
                                                              FK_DEPARTAMENTO_DEP_ID, FK_ADMINISTRADORES_ADM_ID_PRIVADO
                                                                FROM GERENTES 
                                                                WHERE GER_EMAIL = ? AND
                                                                    GER_SENHA = ?;""") ;
        sql.setString(1, email);
        sql.setString(2, senha);
        
        Gerente ger = new Gerente() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        AdminDAO adm = new AdminDAO() ;
        DepartamentoDAO dep = new DepartamentoDAO() ;
        if (rs.next()) {
            
            ger.setNome(rs.getString("GER_NOME"));
            ger.setFoto(rs.getString("GER_FOTO"));
            ger.setCpf(rs.getString("GER_CPF"));
            ger.setEmail(rs.getString("GER_EMAIL"));
            ger.setSenha(rs.getString("GER_SENHA"));
            ger.setId(rs.getString("GER_ID_PUBLICO"));
            
            ger.setAdmin(
                        adm.selecionarPorID(rs.getString("FK_ADMINISTRADORES_ADM_ID_PRIVADO")));
            ger.setDep(
                    dep.selecionarPorID(rs.getInt("FK_DEPARTAMENTO_DEP_ID")));
        
        }
        adm.fecharConexao();
        dep.fecharConexao();
        sql.close();
        return ger ;
    }
    
    public Gerente selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_FOTO, GER_NOME, GER_CPF,
                                                                GER_EMAIL, GER_SENHA, FK_DEPARTAMENTO_DEP_ID,
                                                                FK_ADMINISTRADORES_ADM_ID_PRIVADO
                                                                FROM GERENTES
                                                                WHERE GER_ID_PUBLICO = ?;""") ;
        
        sql.setString(1, id);
        
        Gerente ger = new Gerente() ;
        
        ResultSet rs = sql.executeQuery() ;
        
        AdminDAO adm = new AdminDAO() ;
        DepartamentoDAO dep = new DepartamentoDAO() ;
        if (rs.next()) {
            
            
            ger.setFoto(rs.getString("CID_FOTO"));
            ger.setNome(rs.getString("CID_NOME"));
            ger.setCpf(rs.getString("CID_CPF"));
            ger.setEmail(rs.getString("CID_EMAIL"));
            ger.setSenha(rs.getString("CID_SENHA"));
            ger.setAdmin(
                        adm.selecionarPorID(rs.getString("FK_ADMINISTRADORES_ADM_ID_PRIVADO")));
            ger.setDep(
                    dep.selecionarPorID(rs.getInt("FK_DEPARTAMENTO_DEP_ID")));
            
        }
        adm.fecharConexao();
        dep.fecharConexao();
        sql.close();
        return ger ;
    }
}
