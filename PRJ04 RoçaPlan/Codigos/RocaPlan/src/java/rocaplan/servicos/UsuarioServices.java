package rocaplan.servicos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import rocaplan.dao.UsuarioDAO;
import rocaplan.entidades.Usuario;


public class UsuarioServices {
    public List<Usuario> getTodos()
    {
    List<Usuario> lista = new ArrayList<>();
    
    try( UsuarioDAO dao = new UsuarioDAO() ){
        lista = dao.listarTodos();
    }catch(SQLException exc ){
        exc.printStackTrace();
    }
    
    return lista;
    }
}
