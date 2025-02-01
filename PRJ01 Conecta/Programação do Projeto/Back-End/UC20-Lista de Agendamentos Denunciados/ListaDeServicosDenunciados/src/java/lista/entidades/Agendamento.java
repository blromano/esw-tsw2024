package lista.entidades;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

public class Agendamento {
    
    @NotNull
    private Long id;
    
    @NotNull
    private Date data;
    
    /* Para implementação posterior
    @NotNull
    private Enum status;
    */

    @NotNull
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
}
