package rocaplan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.Produto;
import rocaplan.entidades.Usuario;
import rocaplan.entidades.TipoProduto;

public class ProdutoDAO extends DAO<Produto> {

    public ProdutoDAO() throws SQLException {
    }

    @Override
    public void salvar(Produto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                INSERT INTO
                produtos(pro_nome, pro_valor_unitario, pro_quantidade, fk_usu_id, fk_tpr_id)
                VALUES (?, ?, ?, ?, ?);
            """
        );

        stmt.setString(1, obj.getProNome());
        stmt.setFloat(2, obj.getProValorUnitario());
        stmt.setInt(3, obj.getProQuantidade());
        stmt.setInt(4, obj.getUsuario().getUsuId());
        stmt.setInt(5, obj.getTipoProduto().getTprId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void atualizar(Produto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                UPDATE produtos SET
                    pro_nome = ?,
                    pro_valor_unitario = ?,
                    pro_quantidade = ?,
                    fk_usu_id = ?,
                    fk_tpr_id = ?
                WHERE
                    pro_id = ?;
            """
        );

        stmt.setString(1, obj.getProNome());
        stmt.setFloat(2, obj.getProValorUnitario());
        stmt.setInt(3, obj.getProQuantidade());
        stmt.setInt(4, obj.getUsuario().getUsuId());
        stmt.setInt(5, obj.getTipoProduto().getTprId());
        stmt.setInt(6, obj.getProId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Produto obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                DELETE FROM produtos
                WHERE pro_id = ?;
            """
        );

        stmt.setInt(1, obj.getProId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Produto> listarTodos() throws SQLException {
        List<Produto> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    pro_id,
                    pro_nome,
                    pro_valor_unitario,
                    pro_quantidade,
                    usu_id,
                    usu_nome,
                    tpr_id,
                    tpr_nome
                FROM
                    produtos,
                    usuarios,
                    tipo_produtos
                WHERE
                    fk_usu_id = usu_id AND
                    fk_tpr_id = tpr_id
                ORDER BY pro_id DESC;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getInt("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getFloat("pro_valor_unitario"));
            p.setProQuantidade(rs.getInt("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getInt("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getInt("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

            lista.add(p);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Produto obterPorId(int id) throws SQLException {
        Produto p = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    pro_id,
                    pro_nome,
                    pro_valor_unitario,
                    pro_quantidade,
                    usu_id,
                    usu_nome,
                    tpr_id,
                    tpr_nome
                FROM
                    produtos,
                    usuarios,
                    tipo_produtos
                WHERE
                    fk_usu_id = usu_id AND
                    fk_tpr_id = tpr_id AND
                    pro_id = ?;
            """
        );

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getInt("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getFloat("pro_valor_unitario"));
            p.setProQuantidade(rs.getInt("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getInt("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getInt("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

        }

        rs.close();
        stmt.close();

        return p;
    }

}
