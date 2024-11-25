/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trashtrack.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trashtrack.entidades.Administrador;

/**
 *
 * @author victo
 */
public class AdministradoresDAO extends DAO<Administrador> {
    
    public AdministradoresDAO() throws SQLException {}

    @Override
    public void salvar(Administrador obj) throws SQLException {
        
        PreparedStatement stmt = this.getConnection().prepareStatement(
                "INSERT INTO " +
                "administradores( ADM_EMAIL, ADM_SENHA ) " +
                "VALUES ( ?, ? );" );
        
        stmt.setString( 1, obj.getEmail() );
        stmt.setString( 2, obj.getSenha() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(Administrador obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE administradores " +
                "SET ADM_EMAIL = ?, ADM_SENHA = ? " +
                "WHERE ADM_ID = ?;" );
        
        stmt.setString( 1, obj.getEmail() );
        stmt.setString( 2, obj.getSenha() );
        stmt.setInt( 3, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(Administrador obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM administradores " +
                "WHERE ADM_ID = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<Administrador> listarTodos() throws SQLException {
        
        List<Administrador> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * " +
                "FROM administradores " +
                "ORDER BY ADM_EMAIL" );
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            Administrador administrador = new Administrador();
            
            administrador.setId( rs.getInt( "ADM_ID" ) );
            administrador.setEmail( rs.getString( "ADM_EMAIL" ) );
            administrador.setSenha( rs.getString( "ADM_SENHA" ) );
            
            lista.add( administrador );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public Administrador obterPorId(int id) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT * " +
                "FROM administradores " +
                "WHERE ADM_ID = ?;" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        Administrador administrador = null;
        
        if ( rs.next() ) {
            
            administrador = new Administrador();
            
            administrador.setId( rs.getInt( "ADM_ID" ) );
            administrador.setEmail( rs.getString( "ADM_EMAIL" ) ); 
            administrador.setSenha( rs.getString( "ADM_SENHA" ) );
            
        }
        
        rs.close();
        stmt.close();
        
        return administrador;
        
    }
    
}
