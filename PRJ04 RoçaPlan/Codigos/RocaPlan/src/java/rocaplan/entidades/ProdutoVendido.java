package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class ProdutoVendido {
    @NotNull
    private Long prvId;
    
    @NotNull
    @Positive
    private BigDecimal prvQuantidade;
    
    @NotNull
    private Venda venda;
    
    @NotNull
    private Produto produto;

    public Long getPrvId() {
        return prvId;
    }

    public void setPrvId(Long prvId) {
        this.prvId = prvId;
    }

    public BigDecimal getPrvQuantidade() {
        return prvQuantidade;
    }

    public void setPrvQuantidade(BigDecimal prvQuantidade) {
        this.prvQuantidade = prvQuantidade;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
