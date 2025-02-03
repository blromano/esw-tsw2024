package conecta.services;

import conecta.dao.ServicosDAO;
import conecta.entidades.Servicos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicosServices {

    public List<Servicos> getTodos() {
        List<Servicos> lista = new ArrayList<>();
        ServicosDAO dao = null;

        try {
            dao = new ServicosDAO();
            lista = dao.listarTodos();
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }

        return lista;
    }
}
