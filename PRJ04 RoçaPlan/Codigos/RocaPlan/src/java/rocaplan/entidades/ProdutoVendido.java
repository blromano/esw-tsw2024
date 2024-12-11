package rocaplan.entidades;

public class ProdutoVendido {
    private int prvId;
    private int prvQuantidade;
    private Venda venda;
    private Produto produto;

    public int getPrvId() {
        return prvId;
    }

    public void setPrvId(int prvId) {
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
