package conecta.services;

import conecta.entidades.Agendamento;
import conecta.dao.AgendamentoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoService {

    public List<Agendamento> getTodos() {
        List<Agendamento> lista = new ArrayList<>();
        AgendamentoDAO dao = null;

        try {
            dao = new AgendamentoDAO();
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
