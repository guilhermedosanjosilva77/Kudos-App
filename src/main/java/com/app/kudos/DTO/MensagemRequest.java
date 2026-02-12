package com.app.kudos.DTO;

import java.util.Date;

public record MensagemRequest(String mensagem, Date dataEnvio, Long remetenteId, Long destinatarioId) {

    
}
