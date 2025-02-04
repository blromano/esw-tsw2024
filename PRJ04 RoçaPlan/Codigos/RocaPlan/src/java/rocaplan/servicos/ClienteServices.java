package rocaplan.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.dao.VendaDAO;

public class ClienteServices {
    public List<String> getTodos() {

        List<String> lista = new ArrayList<>();

        try ( VendaDAO dao = new VendaDAO() ) {
            lista = dao.listarClientes();
        } catch ( SQLException exc ) {
            exc.printStackTrace();
        }

        return lista;

    }
}
