/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trashtrack.entidades;

/**
 *
 * @author victo
 */
public class Notificacao {
    
    private int id;
    private String descricao;
    private MoradorColetor moradorColetor;
    private PontoDeColeta pontoDeColeta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MoradorColetor getMoradorColetor() {
        return moradorColetor;
    }

    public void setMoradorColetor(MoradorColetor moradorColetor) {
        this.moradorColetor = moradorColetor;
    }

    public PontoDeColeta getPontoDeColeta() {
        return pontoDeColeta;
    }

    public void setPontoDeColeta(PontoDeColeta pontoDeColeta) {
        this.pontoDeColeta = pontoDeColeta;
    }
    
    
    
}
