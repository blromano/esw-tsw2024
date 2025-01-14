package conecta.entidades;

import java.awt.image.BufferedImage;
import jakarta.validation.constraints.NotNull;


public class Profissional {

    @NotNull
    private Long id;
    
    @NotNull
    private String telCom;
    
    @NotNull
    private String endCom;
    
    @NotNull
    private String cpfCnpj;
    
    private BufferedImage foto;
    
    @NotNull
    private byte[] bytesFoto;
    
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getBytesFoto() {
        return bytesFoto;
    }

    public void setBytesFoto(byte[] bytesFoto) {
        this.bytesFoto = bytesFoto;
    }

    public BufferedImage getFoto() {
        return foto;
    }

    public void setFoto(BufferedImage foto) {
        this.foto = foto;
    }

    public String getTelCom() {
        return telCom;
    }

    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }

    public String getEndCom() {
        return endCom;
    }

    public void setEndCom(String endCom) {
        this.endCom = endCom;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
