package com.app.kudos.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Tabela Relacional
    @OneToMany(mappedBy = "remetente")
    private List<MensagemEntity> mensagemEntityRemetente;

    @OneToMany(mappedBy = "destinatario")
    private List<MensagemEntity> mensagemEntityDestinatario;

    private String nome;
    private String email;
    private String senha;
    private String departamento;

    public UserEntity() {
    }

    public UserEntity(Long id, String nome, String email, String senha, String departamento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    

    
    
}
