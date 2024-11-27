/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

import java.awt.Point;
import java.sql.Date ;

/**
 *
 * @author nicho
 */
public class Denuncia {
    private enum tipo{
    buracoNaPista,
    arvoreCaida,
    fioQuebrado,
    };
    private String id ;
    private String titulo ;
    private String descricao ;
    private Point coordenada ;
    private Date created ;
    private Date updated ;
    private String feedback ;
    private String imagem ;
    private Cidadao cidadao ;
    private Status Status ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Point getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Point coordenada) {
        this.coordenada = coordenada;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status Status) {
        this.Status = Status;
    }

    public void setTipo(String entrada) {
        tipo.valueOf(entrada) ;
    }

    public void getTipo() {
        
    }

    @Override
    public String toString() {
        return "Denuncia{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", coordenada=" + coordenada + ", created=" + created + ", updated=" + updated + ", feedback=" + feedback + ", imagem=" + imagem + ", cidadao=" + cidadao.toString() + ", Status=" + Status.toString() + '}';
    }
    
    
    
}
