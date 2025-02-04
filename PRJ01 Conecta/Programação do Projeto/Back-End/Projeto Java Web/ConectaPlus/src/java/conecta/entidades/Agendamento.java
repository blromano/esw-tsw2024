package conecta.entidades;

import java.sql.Time;
import java.util.Date;

public class Agendamento {

    private int id_agendamentos;
    private Date age_data;
    private Time age_horario;
    private String age_status;
    private Cliente cliente;


    public int getId_agendamentos() {
        return id_agendamentos;
    }

    public void setId_agendamentos(int id_agendamentos) {
        this.id_agendamentos = id_agendamentos;
    }

    public Date getAge_data() {
        return age_data;
    }

    public void setAge_data(Date age_data) {
        this.age_data = age_data;
    }

    public Time getAge_horario() {
        return age_horario;
    }

    public void setAge_horario(Time age_horario) {
        this.age_horario = age_horario;
    }

    public String getAge_status() {
        return age_status;
    }

    public void setAge_status(String age_status) {
        this.age_status = age_status;
    }
    
     public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
