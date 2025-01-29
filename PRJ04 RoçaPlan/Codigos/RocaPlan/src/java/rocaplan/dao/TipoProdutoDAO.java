package rocaplan.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.TipoProduto;
import rocaplan.utils.Utils;

public class TipoProdutoDAO extends DAO<TipoProduto> {

    public TipoProdutoDAO() throws SQLException {
    }

    @Override
    public void salvar(TipoProduto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                INSERT INTO
                tipo_produtos(tpr_nome)
                VALUES (?);
            """
        );

        stmt.setString(1, obj.getTprNome());

        stmt.executeUpdate();
        obj.setTprId(Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ));
        stmt.close();
    }

    @Override
    public void atualizar(TipoProduto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                UPDATE tipo_produtos SET
                    tpr_nome = ?
                WHERE
                    tpr_id = ?;
            """
        );

        stmt.setString(1, obj.getTprNome());
        stmt.setLong(2, obj.getTprId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(TipoProduto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                DELETE FROM tipo_produtos
                WHERE tpr_id = ?;
            """
        );

        stmt.setLong(1, obj.getTprId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<TipoProduto> listarTodos() throws SQLException {
        List<TipoProduto> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT * FROM tipo_produtos
                ORDER BY tpr_nome;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TipoProduto tp = new TipoProduto();

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

            lista.add(tp);
        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public TipoProduto obterPorId(Long id) throws SQLException {
        TipoProduto tp = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT * FROM tipo_produtos
                WHERE tpr_id = ?;
            """
        );

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            tp = new TipoProduto();

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

        }

        rs.close();
        stmt.close();

        return tp;
    }

}
