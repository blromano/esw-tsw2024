package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;

public class ProdutoVendido {
    @NotNull
    private Long prvId;
    
    @NotNull
    private int prvQuantidade;
    
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

    public int getPrvQuantidade() {
        return prvQuantidade;
    }

    public void setPrvQuantidade(int prvQuantidade) {
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
