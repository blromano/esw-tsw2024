package agenda.entidades;

import jakarta.validation.constraints.NotNull;

public class Cliente {
    
    @NotNull
    private Long id;
    
    @NotNull
    private String cpf;
    
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
