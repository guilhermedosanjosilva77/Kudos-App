package com.app.kudos.DTO;

import java.util.Date;

import com.app.kudos.Entity.MensagemEntity;

public record MensagemResponse(String mensagem, Date dataEnvio, Long remetenteId, Long destinatarioId) {
    public MensagemResponse(MensagemEntity mensagemEntity) {
    this(
        mensagemEntity.getMensagem(),
        mensagemEntity.getDataEnvio(),
        mensagemEntity.getRemetente().getId(),
        mensagemEntity.getDestinatario().getId()

    );
    }
} 