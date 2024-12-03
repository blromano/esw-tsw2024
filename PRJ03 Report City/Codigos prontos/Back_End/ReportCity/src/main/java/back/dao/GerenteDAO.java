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
        
        AdminDAO adm= new AdminDAO() ;
        adm.selecionarPorID(obj.getAdmin()) ;
        sql.setString(1, obj.getFoto());
        sql.setString(2, obj.getNome());
        sql.setString(3, obj.getCpf());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha());
        sql.setInt(6, obj.getDep().getId()) ;
        sql.setInt(7, obj.getAdmin().getIdPrivado());
        
        adm.fecharConexao();
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Gerente obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE GERENTES
                                                              SET
                                                                GER_FOTO = ?, 
                                                                GER_NOME = ?, 
                                                                GER_CPF = ?,
                                                                GER_EMAIL = ?, 
                                                                GER_SENHA = ?, 
                                                                FK_DEPARTAMENTO_DEP_ID = ?,
                                                              WHERE
                                                                GER_ID_PUBLICO = ?;""") ;
        
        
        
        AdminDAO adm= new AdminDAO() ;
        adm.selecionarPorID(obj.getAdmin()) ;
        sql.setString(1, obj.getFoto());
        sql.setString(2, obj.getNome());
        sql.setString(3, obj.getCpf());
        sql.setString(4, obj.getEmail());
        sql.setString(5, obj.getSenha());
        sql.setInt(6, obj.getDep().getId()) ;
        sql.setInt(7, obj.getAdmin().getIdPrivado()) ;
        
        adm.fecharConexao();
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

    
    public Gerente selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_ID_PUBLICO, GER_FOTO, GER_NOME, GER_CPF,
                                                                GER_EMAIL, GER_SENHA, FK_DEPARTAMENTO_DEP_ID,
                                                                ADM_ID_PUBLICO
                                                                FROM GERENTES, ADMINISTRADORES
                                                                WHERE GER_ID_PUBLICO = ? AND
                                                                    FK_ADIMINISTRADORES_ID_PRIVADO = ADM_ID_PRIVADO;""") ;
        
        sql.setString(1, id);
        
        Gerente ger = new Gerente() ;
        
        ResultSet rs = sql.executeQuery() ;
        AdminDAO adm = new AdminDAO() ;
        DepartamentoDAO dep = new DepartamentoDAO() ;
        
        if (rs.next()) {
            
            ger.setId(rs.getString("GER_ID_PUBLICO"));
            ger.setFoto(rs.getString("GER_FOTO"));
            ger.setNome(rs.getString("GER_NOME"));
            ger.setCpf(rs.getString("GER_CPF"));
            ger.setEmail(rs.getString("GER_EMAIL"));
            ger.setSenha(rs.getString("GER_SENHA"));
            ger.setAdmin(
                        adm.selecionarPorID(rs.getString("ADM_ID_PUBLICO")));
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
                                                                    FK_DEPARTAMENTO_DEP_ID, ADM_ID_PUBLICO
                                                                FROM GERENTES, ADMINISTRADORES
                                                              WHERE ADM_ID_PRIVADO = FK_ADMINISTRADORES_ID_PRIVADO;""") ;
        
        
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
                        adm.selecionarPorID(rs.getString("ADM_ID_PUBLICO")));
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
                                                              FK_DEPARTAMENTO_DEP_ID, ADM_ID_PUBLICO
                                                                FROM GERENTES, ADIMINISTRADORES
                                                                WHERE GER_EMAIL = ? AND
                                                                    GER_SENHA = ? AND
                                                                    ADM_ID_PRIVADO = FK_ADMINISTRADORES_ID_PRIVADO;""") ;
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
                        adm.selecionarPorID(rs.getString("ADM_ID_PUBLICO")));
            ger.setDep(
                    dep.selecionarPorID(rs.getInt("FK_DEPARTAMENTO_DEP_ID")));
        
        }
        adm.fecharConexao();
        dep.fecharConexao();
        sql.close();
        return ger ;
    }
    
    void selecionarPorID(Gerente id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT GER_ID_PRIVADO
                                                                FROM GERENTES
                                                                WHERE GER_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, id.getId());
        
        
        
        ResultSet rs = sql.executeQuery() ;
        
        if (rs.next()) {
        
            id.setIdPrivado(rs.getInt("GER_ID_PRIVADO"));
            
        }
        
        sql.close();
        
    }
}
