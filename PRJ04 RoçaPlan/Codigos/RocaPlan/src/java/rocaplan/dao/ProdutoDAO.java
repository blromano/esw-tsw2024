package rocaplan.dao;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.Produto;
import rocaplan.entidades.Usuario;
import rocaplan.entidades.TipoProduto;
import rocaplan.utils.Utils;

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
            """,
                new String[]{"insert_id"});

        stmt.setString(1, obj.getProNome());
        stmt.setBigDecimal(2, obj.getProValorUnitario());
        stmt.setBigDecimal(3, obj.getProQuantidade());
        stmt.setLong(4, obj.getUsuario().getUsuId());
        stmt.setLong(5, obj.getTipoProduto().getTprId());

        stmt.executeUpdate();
        obj.setProId(Utils.getChavePrimariaAposInsercao(stmt, "insert_id"));
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
        stmt.setBigDecimal(2, obj.getProValorUnitario());
        stmt.setBigDecimal(3, obj.getProQuantidade());
        stmt.setLong(4, obj.getUsuario().getUsuId());
        stmt.setLong(5, obj.getTipoProduto().getTprId());
        stmt.setLong(6, obj.getProId());

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

        stmt.setLong(1, obj.getProId());

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
                ORDER BY pro_nome;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getBigDecimal("pro_valor_unitario"));
            p.setProQuantidade(rs.getBigDecimal("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

            lista.add(p);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    public List<Produto> listarComPaginacao(int pagina) throws SQLException {
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
                ORDER BY pro_id DESC
                LIMIT ?, 5;
            """
        );

        stmt.setInt(1, pagina * 5);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getBigDecimal("pro_valor_unitario"));
            p.setProQuantidade(rs.getBigDecimal("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

            lista.add(p);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Produto obterPorId(Long id) throws SQLException {
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

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getBigDecimal("pro_valor_unitario"));
            p.setProQuantidade(rs.getBigDecimal("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

        }

        rs.close();
        stmt.close();

        return p;
    }

    public List<Produto> filtrar(String where, String proNome, Long tprId, BigDecimal proValorUnitario) throws SQLException {
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
            """ + where + " ORDER BY pro_id DESC;"
        );

        int count = 1;

        if (proNome != null && !proNome.isEmpty()) {
            stmt.setString(count, "%" + proNome + "%");
            count++;
        }

        if (tprId != null) {
            stmt.setLong(count, tprId);
            count++;
        }

        if (proValorUnitario != null) {
            stmt.setBigDecimal(count, proValorUnitario);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Produto p = new Produto();
            Usuario u = new Usuario();
            TipoProduto tp = new TipoProduto();

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));
            p.setProValorUnitario(rs.getBigDecimal("pro_valor_unitario"));
            p.setProQuantidade(rs.getBigDecimal("pro_quantidade"));
            p.setUsuario(u);
            p.setTipoProduto(tp);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            tp.setTprId(rs.getLong("tpr_id"));
            tp.setTprNome(rs.getString("tpr_nome"));

            lista.add(p);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    public int totalProdutos() throws SQLException {
        int total = 0;

        PreparedStatement stmt = getConnection().prepareStatement(
                "SELECT COUNT(*) as total FROM produtos;");

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            total = rs.getInt("total");
        }

        rs.close();
        stmt.close();

        return total;
    }
}
