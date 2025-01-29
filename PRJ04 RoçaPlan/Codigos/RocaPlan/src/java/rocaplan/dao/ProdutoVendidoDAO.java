package rocaplan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.ProdutoVendido;
import rocaplan.entidades.Produto;
import rocaplan.entidades.Venda;
import rocaplan.utils.Utils;

public class ProdutoVendidoDAO extends DAO<ProdutoVendido> {
    
    public ProdutoVendidoDAO() throws SQLException {
    }

    @Override
    public void salvar(ProdutoVendido obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                INSERT INTO
                produtos_vendidos(prv_quantidade, fk_pro_id, fk_ven_id)
                VALUES (?, ?, ?);
            """
        );

        stmt.setInt(1, obj.getPrvQuantidade());
        stmt.setLong(2, obj.getProduto().getProId());
        stmt.setLong(3, obj.getVenda().getVenId());

        stmt.executeUpdate();
        obj.setPrvId(Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ));
        stmt.close();
    }

    @Override
    public void atualizar(ProdutoVendido obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                UPDATE produtos_vendidos SET
                    prv_quantidade = ?,
                    fk_pro_id = ?,
                    fk_ven_id = ?
                WHERE
                    prv_id = ?;
            """
        );

        stmt.setInt(1, obj.getPrvQuantidade());
        stmt.setLong(2, obj.getProduto().getProId());
        stmt.setLong(3, obj.getVenda().getVenId());
        stmt.setLong(4, obj.getPrvId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(ProdutoVendido obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                DELETE FROM produtos_vendidos
                WHERE prv_id = ?;
            """
        );

        stmt.setLong(1, obj.getPrvId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<ProdutoVendido> listarTodos() throws SQLException {
        List<ProdutoVendido> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    prv_id,
                    prv_quantidade,
                    pro_id,
                    pro_nome,
                    ven_id,
                    ven_data
                FROM
                    produtos_vendidos,
                    produtos,
                    vendas
                WHERE
                    fk_pro_id = pro_id AND
                    fk_ven_id = ven_id
                ORDER BY prv_id DESC;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            ProdutoVendido pv = new ProdutoVendido();
            Produto p = new Produto();
            Venda v = new Venda();

            pv.setPrvId(rs.getLong("prv_id"));
            pv.setPrvQuantidade(rs.getInt("prv_quantidade"));
            pv.setProduto(p);
            pv.setVenda(v);

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));

            v.setVenId(rs.getLong("ven_id"));
            v.setVenData(rs.getDate("ven_data"));

            lista.add(pv);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public ProdutoVendido obterPorId(Long id) throws SQLException {
        ProdutoVendido pv = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    prv_id,
                    prv_quantidade,
                    pro_id,
                    pro_nome,
                    ven_id,
                    ven_data
                FROM
                    produtos_vendidos,
                    produtos,
                    vendas
                WHERE
                    fk_pro_id = pro_id AND
                    fk_ven_id = ven_id AND
                    prv_id = ?;
            """
        );

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            pv = new ProdutoVendido();
            Produto p = new Produto();
            Venda v = new Venda();

            pv.setPrvId(rs.getLong("prv_id"));
            pv.setPrvQuantidade(rs.getInt("prv_quantidade"));
            pv.setProduto(p);
            pv.setVenda(v);

            p.setProId(rs.getLong("pro_id"));
            p.setProNome(rs.getString("pro_nome"));

            v.setVenId(rs.getLong("ven_id"));
            v.setVenData(rs.getDate("ven_data"));

        }

        rs.close();
        stmt.close();

        return pv;
    }
    
}
