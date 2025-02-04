package rocaplan.entidades;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Date;

public class Venda {
    @NotNull
    private Long venId;
    
    @NotNull
    private Date venData;
    
    @Size( min = 0, max = 60 )
    private String venNomeCliente;
    
    @NotNull
    private Boolean venSituacaoPagamento;
    
    @PositiveOrZero
    private BigDecimal venValorTotal;
    
    @NotNull
    private Usuario usuario;

    public Long getVenId() {
        return venId;
    }

    public void setVenId(Long venId) {
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

    public Boolean getVenSituacaoPagamento() {
        return venSituacaoPagamento;
    }

    public void setVenSituacaoPagamento(Boolean venSituacaoPagamento) {
        this.venSituacaoPagamento = venSituacaoPagamento;
    }

    public BigDecimal getVenValorTotal() {
        return venValorTotal;
    }

    public void setVenValorTotal(BigDecimal venValorTotal) {
        this.venValorTotal = venValorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
