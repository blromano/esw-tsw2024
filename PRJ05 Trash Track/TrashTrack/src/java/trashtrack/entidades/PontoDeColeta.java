/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trashtrack.entidades;

/**
 *
 * @author victo
 */

public class PontoDeColeta {
    
    private int id;
    private String tipoDeLixo;
    private Coordenada coordenada;
    private String rua;
    private String numero;
    private String cidade;
    private String bairro;
    private String complemento;
    private boolean coletado;
    private boolean desativado;
    private MoradorColetor morador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDeLixo() {
        return tipoDeLixo;
    }

    public void setTipoDeLixo(String tipoDeLixo) {
        this.tipoDeLixo = tipoDeLixo;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public boolean isColetado() {
        return coletado;
    }

    public void setColetado(boolean coletado) {
        this.coletado = coletado;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public MoradorColetor getMorador() {
        return morador;
    }

    public void setMorador(MoradorColetor morador) {
        this.morador = morador;
    }
    
}
