/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trashtrack.entidades;

import java.sql.Date;

/**
 *
 * @author victo
 */
public class Denuncia {
    
    private int id;
    private String descricao;
    private Date dataDenuncia;
    private boolean desativado;
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

    public Date getDataDenuncia() {
        return dataDenuncia;
    }

    public void setDataDenuncia(Date dataDenuncia) {
        this.dataDenuncia = dataDenuncia;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public PontoDeColeta getPontoDeColeta() {
        return pontoDeColeta;
    }

    public void setPontoDeColeta(PontoDeColeta pontoDeColeta) {
        this.pontoDeColeta = pontoDeColeta;
    }
    
    
    
}
