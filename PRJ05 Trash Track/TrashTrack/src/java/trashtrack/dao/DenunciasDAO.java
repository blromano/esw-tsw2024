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
import trashtrack.entidades.Denuncia;
import trashtrack.entidades.MoradorColetor;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author victo
 */
public class DenunciasDAO extends DAO<Denuncia> {

    public DenunciasDAO() throws SQLException {}
    
    @Override
    public void salvar(Denuncia obj) throws SQLException {
        PreparedStatement stmt = this.getConnection().prepareStatement(
                "INSERT INTO " +
                "denuncias( DEN_DESCRICAO, DEN_DATA_DENUNCIA, DEN_DESATIVADO, FK_PONTOS_DE_COLETA_PON_ID ) " +
                "VALUES ( ?, ?, ?, ? );" );
        
        stmt.setString( 1, obj.getDescricao());
        stmt.setDate( 2, obj.getDataDenuncia() );
        stmt.setBoolean( 3, obj.isDesativado() );
        stmt.setInt( 4, obj.getPontoDeColeta().getId() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Denuncia obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE denuncias " +
                "SET DEN_DESCRICAO = ?, DEN_DATA_DENUNCIA = ?, DEN_DESATIVADO = ?, FK_PONTOS_DE_COLETA_PON_ID = ? " +
                "WHERE DEN_ID = ?;" );
        
        stmt.setString( 1, obj.getDescricao());
        stmt.setDate( 2, obj.getDataDenuncia() );
        stmt.setBoolean( 3, obj.isDesativado() );
        stmt.setInt( 4, obj.getPontoDeColeta().getId() );
        stmt.setInt( 5, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(Denuncia obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM denuncias " +
                "WHERE DEN_ID = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<Denuncia> listarTodos() throws SQLException {
        
        List<Denuncia> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT denuncias.DEN_ID, "
                        + "denuncias.DEN_DESCRICAO, "
                        + "denuncias.DEN_DATA_DENUNCIA, "
                        + "denuncias.DEN_DESATIVADO, "
                        + "pontos_de_coleta.PON_ID, "
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
                "FROM denuncias, pontos_de_coleta, moradores_coletores " + 
                "WHERE denuncias.FK_PONTOS_DE_COLETA_PON_ID = pontos_de_coleta.PON_ID AND "
                        + "pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moradores_coletores.MOC_ID " +
                "ORDER BY denuncias.DEN_DATA_DENUNCIA, pontos_de_coleta.PON_ID" );
        
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
            coordenadaDoPonto.setLatitude( rs.getDouble( "PON_COORDENADA_X" ) );
            coordenadaDoPonto.setLongitude( rs.getDouble( "PON_COORDENADA_Y" ) );
            
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
            pontoDeColeta.setDesativado(rs.getBoolean( "PON_DESATIVADO" ) );
            pontoDeColeta.setMorador( moradorColetor );
            
            Denuncia denuncia = new Denuncia();
            denuncia.setId( rs.getInt( "DEN_ID" ) );
            denuncia.setDescricao( rs.getString( "DEN_DESCRICAO" ) );
            denuncia.setDataDenuncia( rs.getDate( "DEN_DATA_DENUNCIA" ) );
            denuncia.setDesativado( rs.getBoolean("DEN_DESATIVADO") );
            denuncia.setPontoDeColeta( pontoDeColeta );
            
            lista.add( denuncia );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public Denuncia obterPorId(int id) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT denuncias.DEN_ID, "
                        + "denuncias.DEN_DESCRICAO, "
                        + "denuncias.DEN_DATA_DENUNCIA, "
                        + "denuncias.DEN_DESATIVADO, "
                        + "pontos_de_coleta.PON_ID, "
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
                "FROM denuncias, pontos_de_coleta, moradores_coletores " + 
                "WHERE denuncias.DEN_ID = ? AND "
                        + "denuncias.FK_PONTOS_DE_COLETA_PON_ID = pontos_de_coleta.PON_ID AND "
                        + "pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moradores_coletores.MOC_ID " +
                "ORDER BY denuncias.DEN_DATA_DENUNCIA, pontos_de_coleta.PON_ID" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        Denuncia denuncia = null;
        
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
            coordenadaDoPonto.setLatitude( rs.getDouble( "PON_COORDENADA_X" ) );
            coordenadaDoPonto.setLongitude( rs.getDouble( "PON_COORDENADA_Y" ) );
            
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
            pontoDeColeta.setDesativado(rs.getBoolean( "PON_DESATIVADO" ) );
            pontoDeColeta.setMorador( moradorColetor );
            
            denuncia = new Denuncia();
            denuncia.setId( rs.getInt( "DEN_ID" ) );
            denuncia.setDescricao( rs.getString( "DEN_DESCRICAO" ) );
            denuncia.setDataDenuncia( rs.getDate( "DEN_DATA_DENUNCIA" ) );
            denuncia.setDesativado( rs.getBoolean("DEN_DESATIVADO") );
            denuncia.setPontoDeColeta( pontoDeColeta );
            
        }
        
        rs.close();
        stmt.close();
        
        return denuncia;
        
    }
    
}
