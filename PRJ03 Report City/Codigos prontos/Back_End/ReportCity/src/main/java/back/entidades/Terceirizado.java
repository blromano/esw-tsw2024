/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

/**
 *
 * @author nicho
 */
public class Terceirizado {
    private int idPrivado ;
    private String id ;
    private String nome ;
    private String cpf ;
    private String celular ;
    private String email ;
    private String senha ;
    private String codRecuperacao ;
    private Area area ;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getCodRecuperacao() {
        return codRecuperacao;
    }

    public void setCodRecuperacao(String codRecuperacao) {
        this.codRecuperacao = codRecuperacao;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public int getIdPrivado() {
        return idPrivado;
    }

    public void setIdPrivado(int idPrivado) {
        this.idPrivado = idPrivado;
    }

    @Override
    public String toString() {
        return "Terceirizado{" + "idPrivado=" + idPrivado + ", id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", celular=" + celular + ", email=" + email + ", senha=" + senha + ", codRecuperacao=" + codRecuperacao + ", area=" + area + '}';
    }

    
    
    
}
