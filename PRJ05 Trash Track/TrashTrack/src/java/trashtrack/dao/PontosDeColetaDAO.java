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
import trashtrack.entidades.Coordenada;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author victo
 */
public class PontosDeColetaDAO extends DAO<PontoDeColeta>{
    
    public PontosDeColetaDAO() throws SQLException {}

    @Override
    public void salvar(PontoDeColeta obj) throws SQLException {
        
        PreparedStatement stmt = this.getConnection().prepareStatement(
                "INSERT INTO " +
                "pontos_de_coleta( PON_TIPO_LIXO, PON_COORDENADA, PON_RUA, PON_NUMERO, "
                        + "PON_CIDADE, PON_BAIRRO, PON_COMPLEMENTO, PON_COLETADO, "
                        + "PON_DESATIVADO, FK_MORADORES_COLETORES_MOC_ID ) " +
                "VALUES ( ?, POINT( ?, ? ), ?, ?, ?, ?, ?, ?, ?, ? );" );
        
        stmt.setString( 1, obj.getTipoDeLixo() );
        stmt.setDouble( 2, obj.getCoordenada().getLongitude() );
        stmt.setDouble( 3, obj.getCoordenada().getLatitude() );
        stmt.setString( 4, obj.getRua() );
        stmt.setString( 5, obj.getNumero() );
        stmt.setString( 6, obj.getCidade() );
        stmt.setString( 7, obj.getBairro() );
        stmt.setString( 8, obj.getComplemento() );
        stmt.setBoolean( 9, obj.isColetado() );
        stmt.setBoolean( 10, obj.isDesativado() );
        stmt.setInt( 11, obj.getMorador().getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(PontoDeColeta obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE pontos_de_coleta " +
                "SET PON_TIPO_LIXO = ?, PON_COORDENADA = POINT( ?, ? ), PON_RUA = ?, "
                        + "PON_NUMERO = ?, PON_CIDADE = ?, PON_BAIRRO = ?, "
                        + "PON_COMPLEMENTO = ?, PON_COLETADO = ?, "
                        + "PON_DESATIVADO = ?, FK_MORADORES_COLETORES_MOC_ID = ? " +
                "WHERE PON_ID = ?;" );
        
        stmt.setString( 1, obj.getTipoDeLixo() );
        stmt.setDouble( 2, obj.getCoordenada().getLongitude() );
        stmt.setDouble( 3, obj.getCoordenada().getLatitude() );
        stmt.setString( 4, obj.getRua() );
        stmt.setString( 5, obj.getNumero() );
        stmt.setString( 6, obj.getCidade() );
        stmt.setString( 7, obj.getBairro() );
        stmt.setString( 8, obj.getComplemento() );
        stmt.setBoolean( 9, obj.isColetado() );
        stmt.setBoolean( 10, obj.isDesativado() );
        stmt.setInt( 11, obj.getMorador().getId() );
        stmt.setInt( 12, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(PontoDeColeta obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM pontos_de_coleta " +
                "WHERE PON_ID = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<PontoDeColeta> listarTodos() throws SQLException {
        
        List<PontoDeColeta> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT pontos_de_coleta.PON_ID, "
                        + "pontos_de_coleta.PON_TIPO_LIXO, "
                        + "ST_X(pontos_de_coleta.PON_COORDENADA) as PON_COORDENADA_X, "
                        + "ST_Y(pontos_de_coleta.PON_COORDENADA) as PON_COORDENADA_Y, "
                        + "pontos_de_coleta.PON_RUA, "
                        + "pontos_de_coleta.PON_NUMERO, "
                        + "pontos_de_coleta.PON_CIDADE, "
                        + "pontos_de_coleta.PON_BAIRRO, "
                        + "pontos_de_coleta.PON_COMPLEMENTO, "
                        + "pontos_de_coleta.PON_COLETADO, "
                        + "pontos_de_coleta.PON_DESATIVADO, "
                        + "moradores_coletores.MOC_EMAIL, "
                        + "moradores_coletores.MOC_ID, "
                        + "moradores_coletores.MOC_SENHA, "
                        + "moradores_coletores.MOC_NOME, "
                        + "moradores_coletores.MOC_CPF, "
                        + "moradores_coletores.MOC_DATA_NASCIMENTO, "
                        + "moradores_coletores.MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moradores_coletores.MOC_PONTUACAO, "
                        + "moradores_coletores.MOC_ATIVO, "
                        + "moradores_coletores.MOC_QUANTIDADE_LIXO_RECICLADO " +
                "FROM pontos_de_coleta, moradores_coletores " + 
                "WHERE pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moradores_coletores.MOC_ID " +
                "ORDER BY pontos_de_coleta.PON_ID, moradores_coletores.MOC_ID" );
        
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
            
            Coordenada coordenadaDoPonto = new Coordenada();
            coordenadaDoPonto.setLongitude(rs.getDouble( "PON_COORDENADA_X" ) );
            coordenadaDoPonto.setLatitude( rs.getDouble( "PON_COORDENADA_Y" ) );
            
            PontoDeColeta pontoDeColeta = new PontoDeColeta();
            pontoDeColeta.setId( rs.getInt( "PON_ID" ) );
            pontoDeColeta.setTipoDeLixo( rs.getString( "PON_TIPO_LIXO" ) );
            pontoDeColeta.setCoordenada( coordenadaDoPonto );
            pontoDeColeta.setRua( rs.getString( "PON_RUA" ) );
            pontoDeColeta.setNumero( rs.getString( "PON_NUMERO" ) );
            pontoDeColeta.setCidade( rs.getString( "PON_CIDADE" ) );
            pontoDeColeta.setBairro( rs.getString( "PON_BAIRRO" ) );
            pontoDeColeta.setComplemento( rs.getString( "PON_COMPLEMENTO" ) );
            pontoDeColeta.setColetado( rs.getBoolean( "PON_COLETADO" ) );
            pontoDeColeta.setDesativado( rs.getBoolean( "PON_DESATIVADO" ) );
            pontoDeColeta.setMorador( moradorColetor );
            
            lista.add( pontoDeColeta );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public PontoDeColeta obterPorId(int id) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT pontos_de_coleta.PON_ID, "
                        + "pontos_de_coleta.PON_TIPO_LIXO, "
                        + "ST_X(pontos_de_coleta.PON_COORDENADA) as PON_COORDENADA_X, "
                        + "ST_Y(pontos_de_coleta.PON_COORDENADA) as PON_COORDENADA_Y, "
                        + "pontos_de_coleta.PON_RUA, "
                        + "pontos_de_coleta.PON_NUMERO, "
                        + "pontos_de_coleta.PON_CIDADE, "
                        + "pontos_de_coleta.PON_BAIRRO, "
                        + "pontos_de_coleta.PON_COMPLEMENTO, "
                        + "pontos_de_coleta.PON_COLETADO, "
                        + "pontos_de_coleta.PON_DESATIVADO, "
                        + "moradores_coletores.MOC_EMAIL, "
                        + "moradores_coletores.MOC_ID, "
                        + "moradores_coletores.MOC_SENHA, "
                        + "moradores_coletores.MOC_NOME, "
                        + "moradores_coletores.MOC_CPF, "
                        + "moradores_coletores.MOC_DATA_NASCIMENTO, "
                        + "moradores_coletores.MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moradores_coletores.MOC_PONTUACAO, "
                        + "moradores_coletores.MOC_ATIVO, "
                        + "moradores_coletores.MOC_QUANTIDADE_LIXO_RECICLADO " +
                "FROM pontos_de_coleta, moradores_coletores " + 
                "WHERE pontos_de_coleta.PON_ID = ? AND "
                        + "pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moradores_coletores.MOC_ID " +
                "ORDER BY pontos_de_coleta.PON_ID, moradores_coletores.MOC_ID" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        PontoDeColeta pontoDeColeta = null;
        
        if ( rs.next() ) {
            
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
            
            Coordenada coordenadaDoPonto = new Coordenada();
            coordenadaDoPonto.setLongitude( rs.getDouble( "PON_COORDENADA_X" ) );
            coordenadaDoPonto.setLatitude( rs.getDouble( "PON_COORDENADA_Y" ) );
            
            pontoDeColeta = new PontoDeColeta();
            pontoDeColeta.setId( rs.getInt( "PON_ID" ) );
            pontoDeColeta.setTipoDeLixo( rs.getString( "PON_TIPO_LIXO" ) );
            pontoDeColeta.setCoordenada( coordenadaDoPonto );
            pontoDeColeta.setRua( rs.getString( "PON_RUA" ) );
            pontoDeColeta.setNumero( rs.getString( "PON_NUMERO" ) );
            pontoDeColeta.setCidade( rs.getString( "PON_CIDADE" ) );
            pontoDeColeta.setBairro( rs.getString( "PON_BAIRRO" ) );
            pontoDeColeta.setComplemento( rs.getString( "PON_COMPLEMENTO" ) );
            pontoDeColeta.setColetado( rs.getBoolean( "PON_COLETADO" ) );
            pontoDeColeta.setDesativado(rs.getBoolean( "PON_DESATIVADO" ) );
            pontoDeColeta.setMorador( moradorColetor );
            
        }
        
        rs.close();
        stmt.close();
        
        return pontoDeColeta;
    }
    
}
