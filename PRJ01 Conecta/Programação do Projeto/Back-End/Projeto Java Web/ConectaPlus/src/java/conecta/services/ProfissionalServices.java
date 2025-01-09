package conecta.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conecta.entidades.Profissional;
import conecta.dao.ProfissionalDAO;

// Classe de Serviços para a entidade Profissional.

public class ProfissionalServices {
    
    //Usa o ProfissionalDAO para obter todas os profissionais
    
    /* 
        Falta implementação no DAO da função listarTodos(); 
    */
    
    /*
    public List<Profissional> getTodos(){
        
        List<Profissional> lista = new ArrayList<>();
        
        try ( ProfissionalDAO dao = new ProfissionalDAO() ){
            lista = dao.listarTodos();
        } catch ( SQLException exc ){
            exc.printStackTrace();
        }
        
        return lista;
        
    }

    */
    
}
