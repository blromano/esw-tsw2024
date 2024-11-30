/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import java.util.List;
import back.entidades.Tarefa ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nicho
 */
public class TarefaDAO extends DAO<Tarefa>{

    public TarefaDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Tarefa obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO TAREFAS
                                                                (TAR_NOME, TAR_DESCRICAO, TAR_CREATED_AT, 
                                                                TAR_CHAMADOS, FK_DENUNCIAS_DEN_ID_PRIVADO,
                                                                FK_STATUS_STA_ID,
                                                                FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO,
                                                                FK_GERENTES_GER_ID_PRIVADO)
                                                              VALUES
                                                                (?, ?, ?, ?, ?, ?, ?, ?) ;
                                                              """, new String[]{ "insert_id" } ) ;
        
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getDescricao());
        sql.setDate(3, obj.getCreated());
        sql.setString(4, obj.getChamado());
        sql.setInt(5, obj.getDenuncia().getIdPrivate());
        sql.setInt(6, obj.getStatus().getId());
        sql.setInt(7, obj.getServicoTereirizado().getIdPrivado());
        sql.setInt(8, obj.getGerente().getIdPrivado());
        
        sql.executeUpdate() ;
        sql.close();
        
        
        
        
    }

    @Override
    public void atualizar(Tarefa obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE TAREFAS
                                                              SET
                                                                    TAR_NOME = ?, 
                                                                    TAR_DESCRICAO = ?, 
                                                                    TAR_CREATED_AT = ?,
                                                                    TAR_CHAMADOS = ?, 
                                                                    FK_DENUNCIAS_DEN_ID_PRIVADO = ?,
                                                                    FK_STATUS_STA_ID = ?,
                                                                    FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO = ?,
                                                                    FK_GERENTES_GER_ID_PRIVADO = ?
                                                              WHERE
                                                                    TAR_ID_PUBLICO = ? ;
                                                              """) ;
        
        sql.setString(1, obj.getNome());
        sql.setString(2, obj.getDescricao());
        sql.setDate(3, obj.getCreated());
        sql.setString(4, obj.getChamado());
        sql.setInt(5, obj.getDenuncia().getIdPrivate());
        sql.setInt(6, obj.getStatus().getId());
        sql.setInt(7, obj.getServicoTereirizado().getIdPrivado());
        sql.setInt(8, obj.getGerente().getIdPrivado());
        sql.setString(9, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void excluir(Tarefa obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE DROM TAREFAS
                                                              WHERE TAR_ID_PUBLICO = ?""") ;
        sql.setString(1, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public List<Tarefa> selecionarTodos() throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT
                                                                TAR_ID_PUBLICO, TAR_NOME, TAR_DESCRICAO, TAR_CREATED_AT, 
                                                                TAR_CHAMADOS, FK_DENUNCIAS_DEN_ID_PRIVADO,
                                                                FK_STATUS_STA_ID,
                                                                FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO,
                                                                FK_GERENTES_GER_ID_PRIVADO
                                                              FROM
                                                                TAREFAS;
                                                              """);
        
        List<Tarefa> lista = new ArrayList<>() ;
        
        ResultSet rs = sql.executeQuery() ;
        TerceirizadoDAO ter = new TerceirizadoDAO() ;
        GerenteDAO gen = new GerenteDAO() ;
        StatusDAO sta = new StatusDAO() ;
        DenunciaDAO den = new DenunciaDAO() ;
        
        while (rs.next()) {
            Tarefa t = new Tarefa() ;
            
            t.setChamado(rs.getString("TAR_CHAMADOS"));
            t.setCreated(rs.getDate("TAR_CREATED_AT"));
            t.setDenuncia(den.selecionarPorID(rs.getInt("FK_DEN_ID_PRIVADO")));
            t.setDescricao(rs.getString("TAR_DESCRICAO"));
            t.setGerente(gen.selecionarPorID(rs.getInt("FK_GERENTES_GER_ID_PRIVADO")));
            t.setId(rs.getString("TAR_ID_PUBLICO"));
            t.setNome(rs.getString("TAR_NOME"));
            t.setServicoTereirizado(ter.selecionarPorID(rs.getInt("FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO")));
            t.setStatus(sta.selecionarPorID(rs.getInt("FK_STATUS_STA_ID")));
            
            lista.add(t) ;
            
        }
        ter.fecharConexao();
        gen.fecharConexao();
        sta.fecharConexao();
        den.fecharConexao();
        
        return lista ;
        
    }

    @Override
    public Tarefa selecionarPorID(int id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT
                                                                TAR_ID_PUBLICO, TAR_NOME, TAR_DESCRICAO, TAR_CREATED_AT, 
                                                                TAR_CHAMADOS, FK_DENUNCIAS_DEN_ID_PRIVADO,
                                                                FK_STATUS_STA_ID,
                                                                FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO,
                                                                FK_GERENTES_GER_ID_PRIVADO
                                                              FROM
                                                                TAREFAS
                                                              WHERE
                                                                TAR_ID_PRIVADO = ?;
                                                              """);
        sql.setInt(1, id);
        
        Tarefa t = new Tarefa() ;
        
        ResultSet rs = sql.executeQuery() ;
        TerceirizadoDAO ter = new TerceirizadoDAO() ;
        GerenteDAO gen = new GerenteDAO() ;
        StatusDAO sta = new StatusDAO() ;
        DenunciaDAO den = new DenunciaDAO() ;
        
        if (rs.next()) {
            
            
            t.setChamado(rs.getString("TAR_CHAMADOS"));
            t.setCreated(rs.getDate("TAR_CREATED_AT"));
            t.setDenuncia(den.selecionarPorID(rs.getInt("FK_DEN_ID_PRIVADO")));
            t.setDescricao(rs.getString("TAR_DESCRICAO"));
            t.setGerente(gen.selecionarPorID(rs.getInt("FK_GERENTES_GER_ID_PRIVADO")));
            t.setId(rs.getString("TAR_ID_PUBLICO"));
            t.setNome(rs.getString("TAR_NOME"));
            t.setServicoTereirizado(ter.selecionarPorID(rs.getInt("FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO")));
            t.setStatus(sta.selecionarPorID(rs.getInt("FK_STATUS_STA_ID")));
            
            
            
        }
        ter.fecharConexao();
        gen.fecharConexao();
        sta.fecharConexao();
        den.fecharConexao();
        
        return t ;
    }

    public Tarefa selecionarPorID(String id) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              SELECT
                                                                TAR_ID_PRIVATE, TAR_NOME, TAR_DESCRICAO, TAR_CREATED_AT, 
                                                                TAR_CHAMADOS, FK_DENUNCIAS_DEN_ID_PRIVADO,
                                                                FK_STATUS_STA_ID,
                                                                FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO,
                                                                FK_GERENTES_GER_ID_PRIVADO
                                                              FROM
                                                                TAREFAS
                                                              WHERE
                                                                TAR_ID_PUBLICO = ?;
                                                              """);
        sql.setString(1, id);
        
        Tarefa t = new Tarefa() ;
        
        ResultSet rs = sql.executeQuery() ;
        TerceirizadoDAO ter = new TerceirizadoDAO() ;
        GerenteDAO gen = new GerenteDAO() ;
        StatusDAO sta = new StatusDAO() ;
        DenunciaDAO den = new DenunciaDAO() ;
        
        if (rs.next()) {
            
            
            t.setChamado(rs.getString("TAR_CHAMADOS"));
            t.setCreated(rs.getDate("TAR_CREATED_AT"));
            t.setDenuncia(den.selecionarPorID(rs.getInt("FK_DEN_ID_PRIVADO")));
            t.setDescricao(rs.getString("TAR_DESCRICAO"));
            t.setGerente(gen.selecionarPorID(rs.getInt("FK_GERENTES_GER_ID_PRIVADO")));
            t.setIdPrivate(rs.getInt("TAR_ID_PRIVATE"));
            t.setNome(rs.getString("TAR_NOME"));
            t.setServicoTereirizado(ter.selecionarPorID(rs.getInt("FK_SERVICOS_TERCEIRIZADOS_SER_ID_PRIVADO")));
            t.setStatus(sta.selecionarPorID(rs.getInt("FK_STATUS_STA_ID")));
            
            
            
        }
        ter.fecharConexao();
        gen.fecharConexao();
        sta.fecharConexao();
        den.fecharConexao();
        
        return t ;
    }
    
}
