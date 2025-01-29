package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Usuario {
    @NotNull
    private Long usuId;
    
    @NotNull
    @Size( min = 1, max = 60 )
    private String usuNome;
    
    @NotNull
    @Size( min = 1, max = 60 )
    private String usuEmail;
    
    @NotNull
    @Size( min = 8, max = 16 )
    private String usuSenha;

    public Long getUsuId() {
        return usuId;
    }

    public void setUsuId(Long usuId) {
        this.usuId = usuId;
    }

    public String getUsuNome() {
        return usuNome;
    }

    public void setUsuNome(String usuNome) {
        this.usuNome = usuNome;
    }

    public String getUsuEmail() {
        return usuEmail;
    }

    public void setUsuEmail(String usuEmail) {
        this.usuEmail = usuEmail;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
}
