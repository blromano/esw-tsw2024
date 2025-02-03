package agenda.entidades;

import jakarta.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

public class Agendamento {
    
    @NotNull
    private Long id;
    
    @NotNull
    private Date data;
    
    @NotNull
    private Time horario;
    
    @NotNull
    private String status; 

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

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    
    
}

