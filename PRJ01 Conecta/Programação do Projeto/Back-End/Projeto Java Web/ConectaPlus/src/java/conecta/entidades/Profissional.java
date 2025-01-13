package conecta.entidades;

import java.awt.image.BufferedImage;


public class Profissional {

    
    private String telCom;
    private String endCom;
    private String cpfCnpj;
    private BufferedImage foto;
    private byte[] bytesFoto;

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
    
    
    
}
