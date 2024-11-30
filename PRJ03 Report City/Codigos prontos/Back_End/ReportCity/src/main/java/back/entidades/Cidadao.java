/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

/**
 *
 * @author nicho
 */
public class Cidadao {
    private int idPrivado ;
    private String idPublico ;
    private String cpf ;
    private String nome ;
    private String email ;
    private String senha ;
    private String celular;
    private String cep ;
    private String Rua ;
    private String numero ;
    private String complemento ;
    private String bairro ;
    private String cidade ;
    private String estado ;

    public int getIdPrivado() {
        return idPrivado;
    }

    public void setIdPrivado(int idPrivado) {
        this.idPrivado = idPrivado;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId() {
        return idPublico;
    }

    public void setId(String id) {
        this.idPublico = id;
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

    @Override
    public String toString() {
        return "Cidadao{" + "idPrivado=" + idPrivado + ", idPublico=" + idPublico + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", celular=" + celular + ", cep=" + cep + ", Rua=" + Rua + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + '}';
    }

    

    
    
    
}
