package conecta.dao;

import conecta.entidades.Servicos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosDAO extends DAO<Servicos> {

    public ServicosDAO() throws SQLException {
    }

    @Override
    public void salvar(Servicos obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "INSERT INTO servicos(ser_nome, ser_area, ser_descricao) VALUES(?, ?, ?);"
        );
        stmt.setString(1, obj.getSer_nome());
        stmt.setString(2, obj.getSer_area());
        stmt.setString(3, obj.getSer_descricao());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Servicos obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "UPDATE servicos SET ser_nome = ?, ser_area = ?, ser_descricao = ? WHERE id_servicos = ?;"
        );
        stmt.setString(1, obj.getSer_nome());
        stmt.setString(2, obj.getSer_area());
        stmt.setString(3, obj.getSer_descricao());
        stmt.setInt(4, obj.getId_servicos());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Servicos obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
                "DELETE FROM servicos WHERE id_servicos = ?;"
        );
        stmt.setInt(1, obj.getId_servicos());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Servicos> listarTodos() throws SQLException {
        List<Servicos> lista = new ArrayList<>();
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM servicos ORDER BY ser_nome;"
        );
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Servicos s = new Servicos();
            s.setId_servicos(rs.getInt("id_servicos"));
            s.setSer_nome(rs.getString("ser_nome"));
            s.setSer_area(rs.getString("ser_area"));
            s.setSer_descricao(rs.getString("ser_descricao"));
            lista.add(s);
        }
        rs.close();
        stmt.close();
        return lista;
    }

    public Servicos obterPorId(int id) throws SQLException {
        Servicos servico = null;
        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT * FROM servicos WHERE id_servicos = ?;"
        );
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            servico = new Servicos();
            servico.setId_servicos(rs.getInt("id_servicos"));
            servico.setSer_nome(rs.getString("ser_nome"));
            servico.setSer_area(rs.getString("ser_area"));
            servico.setSer_descricao(rs.getString("ser_descricao"));
        }
        rs.close();
        stmt.close();
        return servico;
    }

    @Override
    public Servicos obterPorId(Long id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
