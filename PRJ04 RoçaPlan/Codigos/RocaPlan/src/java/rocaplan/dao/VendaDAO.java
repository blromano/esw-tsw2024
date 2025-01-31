package rocaplan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.entidades.Venda;
import rocaplan.entidades.Usuario;
import rocaplan.utils.Utils;

public class VendaDAO extends DAO<Venda> {

    public VendaDAO() throws SQLException {
    }

    @Override
    public void salvar(Venda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                INSERT INTO
                vendas(ven_data, ven_nome_cliente, ven_situacao_pagamento, ven_valor_total, fk_usu_id)
                VALUES (?, ?, ?, ?, ?);
            """
        , new String[]{ "insert_id" });

        stmt.setDate(1, obj.getVenData());
        stmt.setString(2, obj.getVenNomeCliente());
        stmt.setInt(3, obj.getVenSituacaoPagamento());
        stmt.setFloat(4, obj.getVenValorTotal());
        stmt.setLong(5, obj.getUsuario().getUsuId());

        stmt.executeUpdate();
        obj.setVenId(Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ));
        stmt.close();
    }

    @Override
    public void atualizar(Venda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                UPDATE vendas SET
                    ven_data = ?,
                    ven_nome_cliente = ?,
                    ven_situacao_pagamento = ?,
                    ven_valor_total = ?,
                    fk_usu_id = ?
                WHERE
                    ven_id = ?;
            """
        );

        stmt.setDate(1, obj.getVenData());
        stmt.setString(2, obj.getVenNomeCliente());
        stmt.setInt(3, obj.getVenSituacaoPagamento());
        stmt.setFloat(4, obj.getVenValorTotal());
        stmt.setLong(5, obj.getUsuario().getUsuId());
        stmt.setLong(6, obj.getVenId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Venda obj) throws SQLException {
        PreparedStatement stmt = getConnection().prepareStatement(
            """
                DELETE FROM vendas
                WHERE ven_id = ?;
            """
        );

        stmt.setLong(1, obj.getVenId());

        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Venda> listarTodos() throws SQLException {
        List<Venda> lista = new ArrayList<>();

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    ven_id,
                    ven_data,
                    ven_nome_cliente,
                    ven_situacao_pagamento,
                    ven_valor_total,
                    usu_id,
                    usu_nome
                FROM
                    vendas,
                    usuarios
                WHERE
                    fk_usu_id = usu_id
                ORDER BY ven_id DESC;
            """
        );

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            Venda v = new Venda();
            Usuario u = new Usuario();

            v.setVenId(rs.getLong("ven_id"));
            v.setVenData(rs.getDate("ven_date"));
            v.setVenNomeCliente(rs.getString("ven_nome_cliente"));
            v.setVenSituacaoPagamento(rs.getInt("ven_situacao_pagamento"));
            v.setVenValorTotal(rs.getFloat("ven_valor_total"));
            v.setUsuario(u);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

            lista.add(v);

        }

        rs.close();
        stmt.close();

        return lista;
    }

    @Override
    public Venda obterPorId(Long id) throws SQLException {
        Venda v = null;

        PreparedStatement stmt = getConnection().prepareStatement(
            """
                SELECT
                    ven_id,
                    ven_data,
                    ven_nome_cliente,
                    ven_situacao_pagamento,
                    ven_valor_total,
                    usu_id,
                    usu_nome
                FROM
                    vendas,
                    usuarios
                WHERE
                    fk_usu_id = usu_id AND
                    ven_id = ?;
            """
        );

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {

            v = new Venda();
            Usuario u = new Usuario();

            v.setVenId(rs.getLong("ven_id"));
            v.setVenData(rs.getDate("ven_date"));
            v.setVenNomeCliente(rs.getString("ven_nome_cliente"));
            v.setVenSituacaoPagamento(rs.getInt("ven_situacao_pagamento"));
            v.setVenValorTotal(rs.getFloat("ven_valor_total"));
            v.setUsuario(u);

            u.setUsuId(rs.getLong("usu_id"));
            u.setUsuNome(rs.getString("usu_nome"));

        }

        rs.close();
        stmt.close();

        return v;
    }

}
