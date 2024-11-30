/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

import java.sql.Date;
/**
 *
 * @author nicho
 */
public class Tarefa {
    private int idPrivate ;
    private String id ;
    private String nome ;
    private String descricao ;
    private Date created ;
    private String chamado ;
    private Denuncia denuncia ;
    private Status status;
    private Terceirizado ServicoTereirizado ;
    private Gerente gerente ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getChamado() {
        return chamado;
    }

    public void setChamado(String chamado) {
        this.chamado = chamado;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Terceirizado getServicoTereirizado() {
        return ServicoTereirizado;
    }

    public void setServicoTereirizado(Terceirizado ServicoTereirizado) {
        this.ServicoTereirizado = ServicoTereirizado;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public int getIdPrivate() {
        return idPrivate;
    }

    public void setIdPrivate(int idPrivate) {
        this.idPrivate = idPrivate;
    }
    

    @Override
    public String toString() {
        return "Tarefa{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", created=" + created + ", chamado=" + chamado + ", denuncia=" + denuncia.toString() + ", status=" + status.toString() + ", ServicoTereirizado=" + ServicoTereirizado.toString() + ", gerente=" + gerente.toString() + '}';
    }
    
}
