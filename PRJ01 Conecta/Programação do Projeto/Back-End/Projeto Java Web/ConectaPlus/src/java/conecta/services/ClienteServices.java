package conecta.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conecta.entidades.Cliente;
import conecta.dao.ClienteDAO;

// Classe de serviços para a entidade Profissional.

public class ClienteServices {
    
    //Usa o ClienteDAO para obter todas os clientes
    
    /* 
        Falta implementação no DAO da função listarTodos(); 
    */
    
    /*
    public List<Cliente> getTodos(){
        
        List<Cliente> lista = new ArrayList<>();
        
        try ( ClienteDAO dao = new ClienteDAO() ){
            lista = dao.listarTodos();
        } catch ( SQLException exc ){
            exc.printStackTrace();
        }
        
        return lista;
        
    }

    */
    
}
