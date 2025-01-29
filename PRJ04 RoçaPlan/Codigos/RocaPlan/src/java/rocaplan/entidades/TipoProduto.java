package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TipoProduto {
    @NotNull
    private Long tprId;
    
    @NotNull
    @Size( min = 1, max = 10 )
    private String tprNome;

    public Long getTprId() {
        return tprId;
    }

    public void setTprId(Long tprId) {
        this.tprId = tprId;
    }

    public String getTprNome() {
        return tprNome;
    }

    public void setTprNome(String tprNome) {
        this.tprNome = tprNome;
    }
}
