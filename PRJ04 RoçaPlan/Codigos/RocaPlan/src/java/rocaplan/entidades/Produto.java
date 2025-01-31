package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class Produto {
    @NotNull
    private Long proId;
    
    @NotNull
    @Size( min = 1, max = 40 )
    private String proNome;
    
    @NotNull
    @PositiveOrZero
    private BigDecimal proValorUnitario;
    
    @NotNull
    @PositiveOrZero
    private BigDecimal proQuantidade;
    
    @NotNull
    private Usuario usuario;
    
    @NotNull
    private TipoProduto tipoProduto;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProNome() {
        return proNome;
    }

    public void setProNome(String proNome) {
        this.proNome = proNome;
    }

    public BigDecimal getProValorUnitario() {
        return proValorUnitario;
    }

    public void setProValorUnitario(BigDecimal proValorUnitario) {
        this.proValorUnitario = proValorUnitario;
    }

    public BigDecimal getProQuantidade() {
        return proQuantidade;
    }

    public void setProQuantidade(BigDecimal proQuantidade) {
        this.proQuantidade = proQuantidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
