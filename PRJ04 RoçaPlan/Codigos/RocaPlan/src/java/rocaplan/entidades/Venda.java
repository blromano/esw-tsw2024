package rocaplan.entidades;

import java.sql.Date;

public class Venda {
    private int venId;
    private Date venData;
    private String venNomeCliente;
    private int venSituacaoPagamento;
    private float venValorTotal;
    private Usuario usuario;

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    public Date getVenData() {
        return venData;
    }

    public void setVenData(Date venData) {
        this.venData = venData;
    }

    public String getVenNomeCliente() {
        return venNomeCliente;
    }

    public void setVenNomeCliente(String venNomeCliente) {
        this.venNomeCliente = venNomeCliente;
    }

    public int getVenSituacaoPagamento() {
        return venSituacaoPagamento;
    }

    public void setVenSituacaoPagamento(int venSituacaoPagamento) {
        this.venSituacaoPagamento = venSituacaoPagamento;
    }

    public float getVenValorTotal() {
        return venValorTotal;
    }

    public void setVenValorTotal(float venValorTotal) {
        this.venValorTotal = venValorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
