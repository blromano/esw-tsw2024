package lista.entidades;

import jakarta.validation.constraints.NotNull;

public class Denuncia {
    
    @NotNull
    private Long id;
    
    @NotNull
    private String status;
    
    @NotNull
    private String motivo;

    @NotNull
    private String descricao;
    
    @NotNull
    private Agendamento agendamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }
    
    
}
