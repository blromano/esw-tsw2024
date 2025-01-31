package rocaplan.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.dao.TipoProdutoDAO;
import rocaplan.entidades.TipoProduto;

public class TipoProdutoServices {
    public List<TipoProduto> getTodos() {

        List<TipoProduto> lista = new ArrayList<>();

        try ( TipoProdutoDAO dao = new TipoProdutoDAO() ) {
            lista = dao.listarTodos();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        }

        return lista;

    }
}
