package com.app.kudos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kudos.DTO.MensagemRequest;
import com.app.kudos.DTO.MensagemResponse;
import com.app.kudos.Entity.MensagemEntity;
import com.app.kudos.Entity.UserEntity;
import com.app.kudos.Enums.TipoMensagemEnum;
import com.app.kudos.Repository.MensagemRepository;
import com.app.kudos.Repository.UserRepository;

@Service
public class MensagemService {
    private final MensagemRepository mensagemRepository;
    private final UserRepository userRepository;

    public MensagemService(MensagemRepository mensagemRepository, UserRepository userRepository) {
        this.mensagemRepository = mensagemRepository;
        this.userRepository = userRepository;
    }

    //CREATE
    public MensagemResponse criar(MensagemRequest mensagemRequest){

        MensagemEntity mensagemEntity = new MensagemEntity();
        mensagemEntity.setMensagem(mensagemRequest.mensagem());
        mensagemEntity.setDataEnvio(mensagemRequest.dataEnvio());

        //Aqui voce precisa receber o id do remetente e destinatario, buscar eles no banco de dados e setar eles na mensagemEntity
        UserEntity remetente = userRepository.findById(mensagemRequest.remetenteId()).orElse(null);

        UserEntity destinatario = userRepository.findById(mensagemRequest.destinatarioId()).orElse(null);

        mensagemEntity.setRemetente(remetente);
        mensagemEntity.setDestinatario(destinatario);
        
        mensagemEntity.setTipoMensagem(TipoMensagemEnum.valueOf(mensagemRequest.tipoMensagem()));

        mensagemRepository.save(mensagemEntity);

        return new MensagemResponse(mensagemEntity);
}

//READ
public List<MensagemResponse> buscar(){
    return mensagemRepository.findAll().stream().map(MensagemResponse::new).toList();
}

//READ BY ID
public MensagemResponse buscarPorId(Long id){
    MensagemEntity mensagemEntity = mensagemRepository.findById(id).orElse(null);

    return new MensagemResponse(mensagemEntity);
}

//UPDATE
public MensagemResponse atualizar (Long id, MensagemRequest atualizar){
    MensagemEntity mensagemEntity = mensagemRepository.findById(id).orElse(null);
    if(mensagemEntity == null){
        throw new RuntimeException("Id não encontrada");
    }
    mensagemEntity.setMensagem(atualizar.mensagem());
    mensagemEntity.setDataEnvio(atualizar.dataEnvio());
    mensagemEntity.setTipoMensagem(TipoMensagemEnum.valueOf(atualizar.tipoMensagem()));
    mensagemRepository.save(mensagemEntity);
    return new MensagemResponse(mensagemEntity);
}

//DELETE
public void deletar(Long id){
    MensagemEntity mensagemEntity = mensagemRepository.findById(id).orElse(null);
    if(mensagemEntity == null){
        throw new RuntimeException("Id não encontrada");
    }
    mensagemRepository.delete(mensagemEntity);
}
}
