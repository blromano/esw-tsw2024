package rocaplan.entidades;

public class Produto {
    private int proId;
    private String proNome;
    private float proValorUnitario;
    private int proQuantidade;
    private Usuario usuario;
    private TipoProduto tipoProduto;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
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
