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
public class MoradorColetor {
    
    private int id;
    private String email;
    private String senha;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private int quantidadeLixoColetado;
    private int pontuacao;
    private boolean ativo;
    private int quantidadeLixoReciclado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getQuantidadeLixoColetado() {
        return quantidadeLixoColetado;
    }

    public void setQuantidadeLixoColetado(int quantidadeLixoColetado) {
        this.quantidadeLixoColetado = quantidadeLixoColetado;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getQuantidadeLixoReciclado() {
        return quantidadeLixoReciclado;
    }

    public void setQuantidadeLixoReciclado(int quantidadeLixoReciclado) {
        this.quantidadeLixoReciclado = quantidadeLixoReciclado;
    }
    
    
    
}
