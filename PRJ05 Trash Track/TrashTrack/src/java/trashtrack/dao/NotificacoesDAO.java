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
import trashtrack.entidades.Notificacao;
import trashtrack.entidades.PontoDeColeta;

/**
 *
 * @author victo
 */
public class NotificacoesDAO extends DAO<Notificacao> {

    public NotificacoesDAO() throws SQLException {}
    
    @Override
    public void salvar(Notificacao obj) throws SQLException {
        
        PreparedStatement stmt = this.getConnection().prepareStatement(
                "INSERT INTO " +
                "notificacoes( NOT_DESCRICAO, FK_MORADORES_COLETORES_MOC_ID, FK_PONTOS_DE_COLETA_PON_ID ) " +
                "VALUES ( ?, ?, ? );" );
        
        stmt.setString( 1, obj.getDescricao() );
        stmt.setInt( 2, obj.getMoradorColetor().getId() );
        stmt.setInt( 3, obj.getPontoDeColeta().getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void atualizar(Notificacao obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE notificacoes " +
                "SET NOT_DESCRICAO = ?, FK_MORADORES_COLETORES_MOC_ID = ?, FK_PONTOS_DE_COLETA_PON_ID = ? " +
                "WHERE NOT_ID = ?;" );
        
        stmt.setString( 1, obj.getDescricao());
        stmt.setInt( 2, obj.getMoradorColetor().getId() );
        stmt.setInt( 3, obj.getPontoDeColeta().getId() );
        stmt.setInt( 4, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public void excluir(Notificacao obj) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM notificacoes " +
                "WHERE NOT_ID = ?;" );
        
        stmt.setInt( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
        
    }

    @Override
    public List<Notificacao> listarTodos() throws SQLException {
        
        List<Notificacao> lista = new ArrayList<>();
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT notificacoes.NOT_ID, "
                        + "notificacoes.NOT_DESCRICAO, "
                        + "moc_notificacao.MOC_EMAIL AS NOT_MOC_EMAIL, "
                        + "moc_notificacao.MOC_ID AS NOT_MOC_ID,"
                        + "moc_notificacao.MOC_SENHA AS NOT_MOC_SENHA, "
                        + "moc_notificacao.MOC_NOME AS NOT_MOC_NOME, "
                        + "moc_notificacao.MOC_CPF AS NOT_MOC_CPF, "
                        + "moc_notificacao.MOC_DATA_NASCIMENTO AS NOT_MOC_DATA_NASCIMENTO, "
                        + "moc_notificacao.MOC_QUANTIDADE_LIXO_COLETADO AS NOT_MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moc_notificacao.MOC_PONTUACAO AS NOT_MOC_PONTUACAO, "
                        + "moc_notificacao.MOC_ATIVO AS NOT_MOC_ATIVO, "
                        + "moc_notificacao.MOC_QUANTIDADE_LIXO_RECICLADO AS NOT_MOC_QUANTIDADE_LIXO_RECICLADO, "
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
                        + "moc_ponto_de_coleta.MOC_EMAIL AS PON_MOC_EMAIL, "
                        + "moc_ponto_de_coleta.MOC_ID AS PON_MOC_ID, "
                        + "moc_ponto_de_coleta.MOC_SENHA AS PON_MOC_SENHA, "
                        + "moc_ponto_de_coleta.MOC_NOME AS PON_MOC_NOME, "
                        + "moc_ponto_de_coleta.MOC_CPF AS PON_MOC_CPF, "
                        + "moc_ponto_de_coleta.MOC_DATA_NASCIMENTO AS PON_MOC_DATA_NASCIMENTO, "
                        + "moc_ponto_de_coleta.MOC_QUANTIDADE_LIXO_COLETADO AS PON_MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moc_ponto_de_coleta.MOC_PONTUACAO AS PON_MOC_PONTUACAO, "
                        + "moc_ponto_de_coleta.MOC_ATIVO AS PON_MOC_ATIVO, "
                        + "moc_ponto_de_coleta.MOC_QUANTIDADE_LIXO_RECICLADO AS PON_MOC_QUANTIDADE_LIXO_RECICLADO " +
                "FROM notificacoes "
                        + "INNER JOIN moradores_coletores moc_notificacao ON notificacoes.FK_MORADORES_COLETORES_MOC_ID = moc_notificacao.MOC_ID "
                        + "INNER JOIN pontos_de_coleta ON notificacoes.FK_PONTOS_DE_COLETA_PON_ID = pontos_de_coleta.PON_ID "
                        + "INNER JOIN moradores_coletores moc_ponto_de_coleta ON pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moc_ponto_de_coleta.MOC_ID " + 
                "ORDER BY moc_notificacao.MOC_ID, notificacoes.NOT_ID" );
        
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {
            
            MoradorColetor moradorColetor_PON = new MoradorColetor();
            moradorColetor_PON.setEmail( rs.getString( "PON_MOC_EMAIL" ) );
            moradorColetor_PON.setId( rs.getInt( "PON_MOC_ID" ) );
            moradorColetor_PON.setSenha( rs.getString( "PON_MOC_SENHA" ) );
            moradorColetor_PON.setNome( rs.getString( "PON_MOC_NOME" ) );
            moradorColetor_PON.setCpf( rs.getString( "PON_MOC_CPF" ) );
            moradorColetor_PON.setDataNascimento( rs.getDate( "PON_MOC_DATA_NASCIMENTO" ) );
            moradorColetor_PON.setQuantidadeLixoColetado( rs.getInt( "PON_MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor_PON.setPontuacao( rs.getInt( "PON_MOC_PONTUACAO" ) );
            moradorColetor_PON.setAtivo( rs.getBoolean( "PON_MOC_ATIVO" ) );
            moradorColetor_PON.setQuantidadeLixoReciclado( rs.getInt( "PON_MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
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
            pontoDeColeta.setMorador( moradorColetor_PON );
            
            MoradorColetor moradorColetor_NOT = new MoradorColetor();
            moradorColetor_NOT.setEmail( rs.getString( "NOT_MOC_EMAIL" ) );
            moradorColetor_NOT.setId( rs.getInt( "NOT_MOC_ID" ) );
            moradorColetor_NOT.setSenha( rs.getString( "NOT_MOC_SENHA" ) );
            moradorColetor_NOT.setNome( rs.getString( "NOT_MOC_NOME" ) );
            moradorColetor_NOT.setCpf( rs.getString( "NOT_MOC_CPF" ) );
            moradorColetor_NOT.setDataNascimento( rs.getDate( "NOT_MOC_DATA_NASCIMENTO" ) );
            moradorColetor_NOT.setQuantidadeLixoColetado( rs.getInt( "NOT_MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor_NOT.setPontuacao( rs.getInt( "NOT_MOC_PONTUACAO" ) );
            moradorColetor_NOT.setAtivo( rs.getBoolean( "NOT_MOC_ATIVO" ) );
            moradorColetor_NOT.setQuantidadeLixoReciclado( rs.getInt( "NOT_MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
            Notificacao notificacao = new Notificacao();
            notificacao.setId( rs.getInt( "NOT_ID" ) );
            notificacao.setDescricao( rs.getString( "NOT_DESCRICAO" ) );
            notificacao.setMoradorColetor( moradorColetor_NOT );
            notificacao.setPontoDeColeta( pontoDeColeta );
            
            lista.add( notificacao );
        }
        
        rs.close();
        stmt.close();
        
        return lista;
        
    }

    @Override
    public Notificacao obterPorId(int id) throws SQLException {
        
        PreparedStatement stmt = getConnection().prepareStatement( 
                "SELECT notificacoes.NOT_ID, "
                        + "notificacoes.NOT_DESCRICAO, "
                        + "moc_notificacao.MOC_EMAIL AS NOT_MOC_EMAIL, "
                        + "moc_notificacao.MOC_ID AS NOT_MOC_ID,"
                        + "moc_notificacao.MOC_SENHA AS NOT_MOC_SENHA, "
                        + "moc_notificacao.MOC_NOME AS NOT_MOC_NOME, "
                        + "moc_notificacao.MOC_CPF AS NOT_MOC_CPF, "
                        + "moc_notificacao.MOC_DATA_NASCIMENTO AS NOT_MOC_DATA_NASCIMENTO, "
                        + "moc_notificacao.MOC_QUANTIDADE_LIXO_COLETADO AS NOT_MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moc_notificacao.MOC_PONTUACAO AS NOT_MOC_PONTUACAO, "
                        + "moc_notificacao.MOC_ATIVO AS NOT_MOC_ATIVO, "
                        + "moc_notificacao.MOC_QUANTIDADE_LIXO_RECICLADO AS NOT_MOC_QUANTIDADE_LIXO_RECICLADO, "
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
                        + "moc_ponto_de_coleta.MOC_EMAIL AS PON_MOC_EMAIL, "
                        + "moc_ponto_de_coleta.MOC_ID AS PON_MOC_ID, "
                        + "moc_ponto_de_coleta.MOC_SENHA AS PON_MOC_SENHA, "
                        + "moc_ponto_de_coleta.MOC_NOME AS PON_MOC_NOME, "
                        + "moc_ponto_de_coleta.MOC_CPF AS PON_MOC_CPF, "
                        + "moc_ponto_de_coleta.MOC_DATA_NASCIMENTO AS PON_MOC_DATA_NASCIMENTO, "
                        + "moc_ponto_de_coleta.MOC_QUANTIDADE_LIXO_COLETADO AS PON_MOC_QUANTIDADE_LIXO_COLETADO, "
                        + "moc_ponto_de_coleta.MOC_PONTUACAO AS PON_MOC_PONTUACAO, "
                        + "moc_ponto_de_coleta.MOC_ATIVO AS PON_MOC_ATIVO, "
                        + "moc_ponto_de_coleta.MOC_QUANTIDADE_LIXO_RECICLADO AS PON_MOC_QUANTIDADE_LIXO_RECICLADO " +
                "FROM notificacoes "
                        + "INNER JOIN moradores_coletores moc_notificacao ON notificacoes.FK_MORADORES_COLETORES_MOC_ID = moc_notificacao.MOC_ID "
                        + "INNER JOIN pontos_de_coleta ON notificacoes.FK_PONTOS_DE_COLETA_PON_ID = pontos_de_coleta.PON_ID "
                        + "INNER JOIN moradores_coletores moc_ponto_de_coleta ON pontos_de_coleta.FK_MORADORES_COLETORES_MOC_ID = moc_ponto_de_coleta.MOC_ID "
                        + "WHERE notificacoes.NOT_ID = ? " + 
                "ORDER BY moc_notificacao.MOC_ID, notificacoes.NOT_ID" );
        
        stmt.setInt( 1, id );
        
        ResultSet rs = stmt.executeQuery();
        
        Notificacao notificacao = null;
        
        if ( rs.next() ) {
            
            MoradorColetor moradorColetor_PON = new MoradorColetor();
            moradorColetor_PON.setEmail( rs.getString( "PON_MOC_EMAIL" ) );
            moradorColetor_PON.setId( rs.getInt( "PON_MOC_ID" ) );
            moradorColetor_PON.setSenha( rs.getString( "PON_MOC_SENHA" ) );
            moradorColetor_PON.setNome( rs.getString( "PON_MOC_NOME" ) );
            moradorColetor_PON.setCpf( rs.getString( "PON_MOC_CPF" ) );
            moradorColetor_PON.setDataNascimento( rs.getDate( "PON_MOC_DATA_NASCIMENTO" ) );
            moradorColetor_PON.setQuantidadeLixoColetado( rs.getInt( "PON_MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor_PON.setPontuacao( rs.getInt( "PON_MOC_PONTUACAO" ) );
            moradorColetor_PON.setAtivo( rs.getBoolean( "PON_MOC_ATIVO" ) );
            moradorColetor_PON.setQuantidadeLixoReciclado( rs.getInt( "PON_MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
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
            pontoDeColeta.setMorador( moradorColetor_PON );
            
            MoradorColetor moradorColetor_NOT = new MoradorColetor();
            moradorColetor_NOT.setEmail( rs.getString( "NOT_MOC_EMAIL" ) );
            moradorColetor_NOT.setId( rs.getInt( "NOT_MOC_ID" ) );
            moradorColetor_NOT.setSenha( rs.getString( "NOT_MOC_SENHA" ) );
            moradorColetor_NOT.setNome( rs.getString( "NOT_MOC_NOME" ) );
            moradorColetor_NOT.setCpf( rs.getString( "NOT_MOC_CPF" ) );
            moradorColetor_NOT.setDataNascimento( rs.getDate( "NOT_MOC_DATA_NASCIMENTO" ) );
            moradorColetor_NOT.setQuantidadeLixoColetado( rs.getInt( "NOT_MOC_QUANTIDADE_LIXO_COLETADO" ) );
            moradorColetor_NOT.setPontuacao( rs.getInt( "NOT_MOC_PONTUACAO" ) );
            moradorColetor_NOT.setAtivo( rs.getBoolean( "NOT_MOC_ATIVO" ) );
            moradorColetor_NOT.setQuantidadeLixoReciclado( rs.getInt( "NOT_MOC_QUANTIDADE_LIXO_RECICLADO" ) );
            
            notificacao = new Notificacao();
            notificacao.setId( rs.getInt( "NOT_ID" ) );
            notificacao.setDescricao( rs.getString( "NOT_DESCRICAO" ) );
            notificacao.setMoradorColetor( moradorColetor_NOT );
            notificacao.setPontoDeColeta( pontoDeColeta );
            
        }
        
        rs.close();
        stmt.close();
        
        return notificacao;
    }
    
}
