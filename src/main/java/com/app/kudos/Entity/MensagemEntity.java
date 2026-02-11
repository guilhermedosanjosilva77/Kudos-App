package com.app.kudos.Entity;

import java.sql.Date;

import com.app.kudos.Enums.TipoMensagemEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensagem")
public class MensagemEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    //Relacionamento entre as tabelas
    @ManyToOne
    @JoinColumn(name = "id_remetente")
    private UserEntity remetente;

    //Relacionamento entre as tabelas
    @ManyToOne
    @JoinColumn(name = "id_destinatario")
    private UserEntity destinatario;

    @Enumerated(EnumType.STRING)
    private TipoMensagemEnum tipoMensagem;
    
    private String mensagem;
    private Date dataEnvio;

    

    public MensagemEntity() {
    }



    public MensagemEntity(Long id, UserEntity remetente, UserEntity destinatario, TipoMensagemEnum tipoMensagem,
            String mensagem, Date dataEnvio) {
        this.id = id;
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tipoMensagem = tipoMensagem;
        this.mensagem = mensagem;
        this.dataEnvio = dataEnvio;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }



    public UserEntity getRemetente() {
        return remetente;
    }



    public void setRemetente(UserEntity remetente) {
        this.remetente = remetente;
    }



    public UserEntity getDestinatario() {
        return destinatario;
    }



    public void setDestinatario(UserEntity destinatario) {
        this.destinatario = destinatario;
    }



    public TipoMensagemEnum getTipoMensagem() {
        return tipoMensagem;
    }



    public void setTipoMensagem(TipoMensagemEnum tipoMensagem) {
        this.tipoMensagem = tipoMensagem;
    }



    public String getMensagem() {
        return mensagem;
    }



    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }



    public Date getDataEnvio() {
        return dataEnvio;
    }



    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    

    
    
    
}
