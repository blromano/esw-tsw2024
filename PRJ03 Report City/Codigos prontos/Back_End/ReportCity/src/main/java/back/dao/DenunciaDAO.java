/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement ;
import back.entidades.Denuncia ;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.postgresql.geometric.PGpoint ;
/**
 *
 * @author nicho
 */
public class DenunciaDAO extends DAO<Denuncia> {

    public DenunciaDAO() throws SQLException {
        super() ;
    }

    @Override
    public void salvar(Denuncia obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              INSERT INTO DENUNCIAS
                                                                ( DEN_TITULO, DEN_DESCRICAO, DEN_COORDENADA, DEN_CREATED_AT,
                                                                    DEN_UPDATED_AT, DEN_FEEDBACK, DEN_IMAGEM, DEN_TIPO,
                                                                    FK_CIDADOES_CID_ID_PRIVADO, FK_STATUS_STA_ID)
                                                              VALUES
                                                                ( ?, ?, ST_MakePoint(?,?), ?, ?, ?, ?, ?, ?, ?) ;""", new String[]{ "insert_id" } ) ;
        
        CidadaoDAO cid = new CidadaoDAO();
        cid.selecionarPorID(obj.getCidadao());
        
        sql.setString(1, obj.getTitulo());
        sql.setString(2, obj.getDescricao());
        sql.setDouble(3, obj.getCoordenadaX());
        sql.setDouble(4, obj.getCoordenadaY());
        sql.setDate(5, obj.getCreated());
        sql.setDate(6, obj.getUpdated());
        sql.setString(7, obj.getFeedback());
        sql.setString(9, obj.getImagem());
        sql.setString(10,obj.getTipo());
        sql.setInt(11,obj.getCidadao().getIdPrivado());
        sql.setInt(12, obj.getStatus().getId());
        
        cid.fecharConexao();
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void atualizar(Denuncia obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              UPDATE DENUNCIAS
                                                              SET
                                                                DEN_TITULO = ? , 
                                                                DEN_DESCRICAO = ?, 
                                                                DEN_COORDENADA = ST_MakePoint(?, ?), 
                                                                DEN_CREATED_AT = ?,
                                                                DEN_UPDATED_AT = ?, 
                                                                DEN_FEEDBACK = ?, 
                                                                DEN_IMAGEM = ?, 
                                                                DEN_TIPO = ?,
                                                                FK_CIDADOES_CID_ID_PRIVADO = ?, 
                                                                FK_STATUS_STA_ID = ?
                                                              WHERE
                                                                DEN_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getTitulo());
        sql.setString(2, obj.getDescricao());
        sql.setDouble(3, obj.getCoordenadaX());
        sql.setDouble(4, obj.getCoordenadaY());
        sql.setDate(5, obj.getCreated());
        sql.setDate(6, obj.getUpdated());
        sql.setString(7, obj.getFeedback());
        sql.setString(9, obj.getImagem());
        sql.setString(10,obj.getTipo());
        sql.setInt(11,obj.getCidadao().getIdPrivado());
        sql.setInt(12, obj.getStatus().getId());
        sql.setString(13, obj.getId());
        
        sql.executeUpdate() ;
        sql.close();
    }

    @Override
    public void excluir(Denuncia obj) throws SQLException {
        PreparedStatement sql = getConexao().prepareStatement("""
                                                              DELETE FROM DENUNCIAS
                                                              WHERE DEN_ID_PUBLICO = ? ;""") ;
        
        sql.setString(1, obj.getId());
        
        
        sql.executeUpdate() ;
        sql.close();
                
    }

    @Override
    public List<Denuncia> selecionarTodos() throws SQLException {
        PreparedStatement sql  = getConexao().prepareStatement("""
                                                               SELECT DEN_ID_PUBLICO, DEN_TITULO, DEN_DESCRICAO, DEN_COORDENADA, DEN_CREATED_AT,
                                                                    DEN_UPDATED_AT, CEN_FEEDBACK, DEN_IMAGEM, DEN_TIPO, 
                                                                    CID_ID_PUBLICO, FK_STATUS_STA_ID
                                                               FROM DENUNCIAS, CIDADOES
                                                               WHERE
                                                                CID_ID_PRIVADO = FK_CIDADOES_CID_ID_PRIVADO;
                                                               """) ;
        
        List<Denuncia> lista = new ArrayList<>() ;
        ResultSet rs = sql.executeQuery() ;
        CidadaoDAO cid = new CidadaoDAO() ;
        StatusDAO sta = new StatusDAO() ;
        
        while(rs.next()) {
            Denuncia d = new Denuncia() ;
            
            d.setCreated(rs.getDate("DEN_CREATED_AT"));
            d.setDescricao(rs.getString("DEN_DESCRICAO"));
            d.setFeedback(rs.getString("DEN_FEEDBACK"));
            d.setId(rs.getString("DEN_ID_PUBLICO"));
            d.setImagem(rs.getString("DEN_IMAGEM"));
            d.setTipo(rs.getString("DEN_TIPO"));
            d.setTitulo(rs.getString("DEN_TITULO"));
            d.setUpdated(rs.getDate("DEN_UPDATED_AT"));
            
            d.setCidadao(
                    cid.selecionarPorID(
                            rs.getString("CID_ID_PUBLICO")));
            d.setStatus(
                    sta.selecionarPorID(
                            rs.getInt("FK_STATUS_STA_ID")));
            
        }
        
        cid.fecharConexao();
        sta.fecharConexao();
        sql.close();
        return lista ;
    }

    
    void selecionarPorID(Denuncia id) throws SQLException {
        PreparedStatement sql  = getConexao().prepareStatement("""
                                                               SELECT DEN_ID_PRIVATE
                                                               FROM DENUNCIAS 
                                                               WHERE DEN_ID_PUBLICO = ? ;
                                                               """) ;
        
        sql.setString(1, id.getId());
        
        ResultSet rs = sql.executeQuery() ;
        
        if(rs.next()) {
            
            id.setIdPrivate(rs.getInt("DEN_ID_PRIVATE"));
            
        }
        
        sql.close();
        
    }
    
    public Denuncia selecionarPorID(String id) throws SQLException {
        PreparedStatement sql  = getConexao().prepareStatement("""
                                                               SELECT DEN_ID_PUBLICO, DEN_TITULO, DEN_DESCRICAO, DEN_COORDENADA, DEN_CREATED_AT,
                                                                    DEN_UPDATED_AT, CEN_FEEDBACK, DEN_IMAGEM, DEN_TIPO, 
                                                                    CID_ID_PUBLICO, FK_STATUS_STA_ID
                                                               FROM DENUNCIAS, CIDADOES
                                                               WHERE DEN_ID_PUBLICO = ? AND
                                                               FK_CIDADOES_CID_ID = CID_ID_PRIVADO;
                                                               """) ;
        
        sql.setString(1, id);
        
        
        Denuncia d = new Denuncia() ;
        ResultSet rs = sql.executeQuery() ;
        CidadaoDAO cid = new CidadaoDAO() ;
        StatusDAO sta = new StatusDAO() ;
        
        if(rs.next()) {
            
            d.setId(rs.getString("DEN_ID_PUBLICO"));
            d.setCreated(rs.getDate("DEN_CREATED_AT"));
            d.setDescricao(rs.getString("DEN_DESCRICAO"));
            d.setFeedback(rs.getString("DEN_FEEDBACK"));
            d.setId(rs.getString("DEN_ID_PUBLICO"));
            d.setImagem(rs.getString("DEN_IMAGEM"));
            d.setTipo(rs.getString("DEN_TIPO"));
            d.setTitulo(rs.getString("DEN_TITULO"));
            d.setUpdated(rs.getDate("DEN_UPDATED_AT"));
            
            d.setCidadao(
                    cid.selecionarPorID(
                            rs.getString("CID_ID_PUBLICO")));
            d.setStatus(
                    sta.selecionarPorID(
                            rs.getInt("FK_STATUS_STA_ID")));
            
        }
        
        cid.fecharConexao();
        sta.fecharConexao();
        sql.close();
        return d ;
    }
   
    
}
