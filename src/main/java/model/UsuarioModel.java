package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@model.Entity
class UsuarioModel {
    private String nome;
    private String sexo;
    private String celular;
    private String email;

    @Id
    private int id;

    public UsuarioModel(String nome, String sexo, String celular, String email, int id) {
        this.nome = nome;
        this.sexo = sexo;
        this.celular = celular;
        this.email = email;
        this.id = id;
    }

    public UsuarioModel() {}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
