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
import trashtrack.entidades.MoradorColetor;

/**
 *
 * @author victo
 */
public class MoradoresColetoresDAO extends DAO<MoradorColetor>{
    
    public MoradoresColetoresDAO() throws SQLException {}

    @Override
    public void salvar(MoradorColetor obj) throws SQLException {
        
        PreparedStatement stmt = this.getConnection().prepareStatement(
                "INSERT INTO " +
                "moradores_coletores( MOC_EMAIL, MOC_SENHA, MOC_NOME, "
                        + "MOC_CPF, MOC_DATA_NASCIMENTO, MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "MOC_PONTUACAO, MOC_ATIVO, MOC_QUANTIDADE_LIXO_RECICLADO ) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? );" );
        
        stmt.setString( 1, obj.getEmail() );
        stmt.setString( 2, obj.getSenha() );
        stmt.setString( 3, obj.getNome() );
        stmt.setString( 4, obj.getCpf() );
        stmt.setDate( 5, obj.getDataNascimento() );
        stmt.setInt( 6, obj.getQuantidadeLixoColetado() );
        stmt.setInt( 7, obj.getPontuacao() );
        stmt.setBoolean( 8, obj.isAtivo() );
        stmt.setInt( 9, obj.getQuantidadeLixoReciclado() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(MoradorColetor obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE moradores_coletores " +
                "SET MOC_EMAIL = ?, MOC_SENHA = ?, MOC_NOME = ?, MOC_CPF = ?, "
                        + "MOC_DATA_NASCIMENTO = ?, MOC_QUANTIDADE_LIXO_COLETADO = ?, "
                        + "MOC_PONTUACAO = ?, MOC_ATIVO = ?, MOC_QUANTIDADE_LIXO_RECICLADO = ? " +
                "WHERE MOC_ID = ?;" );
        
        stmt.setString( 1, obj.getEmail() );
        stmt.setString( 2, obj.getSenha() );
        stmt.setString( 3, obj.getNome() );
        stmt.setString( 4, obj.getCpf() );
        stmt.setDate( 5, obj.getDataNascimento() );
        stmt.setInt( 6, obj.getQuantidadeLixoColetado() );
        stmt.setInt( 7, obj.getPontuacao() );
        stmt.setBoolean( 8, obj.isAtivo() );
        stmt.setInt( 9, obj.getQuantidadeLixoReciclado() );
        stmt.setInt( 10, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(MoradorColetor obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM moradores_coletores " +
                "WHERE MOC_ID = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<MoradorColetor> listarTodos() throws SQLException {
        
        List<MoradorColetor> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT * FROM moradores_coletores " +
                "ORDER BY MOC_NOME, MOC_PONTUACAO" );
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            MoradorColetor moradorColetor = new MoradorColetor();
            moradorColetor.setEmail( rs.getString( "MOC_EMAIL" ) );
            moradorColetor.setId( rs.getInt( "MOC_ID" ) );
            moradorColetor.setSenha( rs.getString( "MOC_SENHA" ) );
            moradorColetor.setNome( rs.getString( "MOC_NOME" ) );
            moradorColetor.setCpf( rs.getString( "MOC_CPF" ) );
            moradorColetor.setDataNascimento( rs.getDate( "MOC_DATA_NASCIMENTO" ) );
            moradorColetor.setQuantidadeLixoColetado( rs.getInt( "MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor.setPontuacao( rs.getInt( "MOC_PONTUACAO" ) );
            moradorColetor.setAtivo( rs.getBoolean( "MOC_ATIVO" ) );
            moradorColetor.setQuantidadeLixoReciclado( rs.getInt( "MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
            lista.add( moradorColetor );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public MoradorColetor obterPorId(int id) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT * FROM moradores_coletores " +
                "WHERE MOC_ID = ? " );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        MoradorColetor moradorColetor = null;
        
        if ( rs.next() ) {
            
            moradorColetor = new MoradorColetor();
            moradorColetor.setEmail( rs.getString( "MOC_EMAIL" ) );
            moradorColetor.setId( rs.getInt( "MOC_ID" ) );
            moradorColetor.setSenha( rs.getString( "MOC_SENHA" ) );
            moradorColetor.setNome( rs.getString( "MOC_NOME" ) );
            moradorColetor.setCpf( rs.getString( "MOC_CPF" ) );
            moradorColetor.setDataNascimento( rs.getDate( "MOC_DATA_NASCIMENTO" ) );
            moradorColetor.setQuantidadeLixoColetado( rs.getInt( "MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor.setPontuacao( rs.getInt( "MOC_PONTUACAO" ) );
            moradorColetor.setAtivo( rs.getBoolean( "MOC_ATIVO" ) );
            moradorColetor.setQuantidadeLixoReciclado( rs.getInt( "MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
        }
        
        rs.close();
        stmt.close();
        
        return moradorColetor;
        
    }
    
    public MoradorColetor buscarPorEmail(String email) throws SQLException {
    String sql = "SELECT * FROM moradores_coletores WHERE MOC_EMAIL = ?";
    try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
        stmt.setString(1, email); 
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                MoradorColetor mc = new MoradorColetor();
                mc.setId(rs.getInt("MOC_ID"));
                mc.setEmail(rs.getString("MOC_EMAIL"));
                mc.setSenha(rs.getString("MOC_SENHA"));
                mc.setNome(rs.getString("MOC_NOME"));
                mc.setCpf(rs.getString("MOC_CPF"));
                mc.setDataNascimento(rs.getDate("MOC_DATA_NASCIMENTO"));
                mc.setQuantidadeLixoColetado(rs.getInt("MOC_QUANTIDADE_LIXO_COLETADO"));
                mc.setQuantidadeLixoReciclado(rs.getInt("MOC_QUANTIDADE_LIXO_RECICLADO"));
                mc.setPontuacao(rs.getInt("MOC_PONTUACAO"));
                mc.setAtivo(rs.getBoolean("MOC_ATIVO"));
                return mc;
            }
        }
    }
    return null;
    }
}
