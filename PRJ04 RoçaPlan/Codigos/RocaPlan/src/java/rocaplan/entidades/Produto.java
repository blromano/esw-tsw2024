package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Produto {
    @NotNull
    private Long proId;
    
    @NotNull
    @Size( min = 1, max = 40 )
    private String proNome;
    
    @NotNull
    private float proValorUnitario;
    
    @NotNull
    private int proQuantidade;
    
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

    public float getProValorUnitario() {
        return proValorUnitario;
    }

    public void setProValorUnitario(float proValorUnitario) {
        this.proValorUnitario = proValorUnitario;
    }

    public int getProQuantidade() {
        return proQuantidade;
    }

    public void setProQuantidade(int proQuantidade) {
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
