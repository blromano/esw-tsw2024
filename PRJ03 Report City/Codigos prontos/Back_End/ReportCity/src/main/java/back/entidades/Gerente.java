/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package back.entidades;

/**
 *
 * @author nicho
 */
public class Gerente {
    private String id ;
    private String nome ;
    private String foto ;
    private String cpf ;
    private String email ;
    private String senha ;
    private Administrador admin ;
    private Departamento dep ;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Gerente{" + "id=" + id + ", nome=" + nome + ", foto=" + foto + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + ", admin=" + admin.toString() + ", dep=" + dep.toString()
                + '}';
    }

    
    
    
}
