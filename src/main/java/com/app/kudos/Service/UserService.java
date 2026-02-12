package com.app.kudos.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.kudos.DTO.UserRequest;
import com.app.kudos.DTO.UserResponse;
import com.app.kudos.Entity.UserEntity;
import com.app.kudos.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //CREATE
    public UserResponse criar(UserRequest userRequest) {
        boolean JaExiste = userRepository.existsByEmail(null);
        if (JaExiste == true) {
            throw new RuntimeException("Email já cadastrado");
        }
        UserEntity userEntity = new UserEntity();

        userEntity.setNome(userRequest.nome());
        userEntity.setEmail(userRequest.email());
        userEntity.setDepartamento(userRequest.departamento());

        userRepository.save(userEntity);
        return new UserResponse(userEntity); // Placeholder, deve retornar UserResponse
    }

    //READ
    public List<UserResponse> listar(){
        return userRepository.findAll().stream().map(UserResponse::new).toList();
        
    }

    //READ BY ID
    public UserResponse listarPorId(Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return new UserResponse(userEntity);
    }

    //UPDATE
    public UserResponse atualizar(Long id, UserRequest atualizar){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        userEntity.setNome(atualizar.nome());
        userEntity.setEmail(atualizar.email()); 
        userEntity.setDepartamento(atualizar.departamento());

        userRepository.save(userEntity);
        return new UserResponse(userEntity);

    }

    //DELETE
    public void deletar(Long id){
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        if(userEntity == null){
            throw new RuntimeException("Usuário não encontrado");
        }
        userRepository.delete(userEntity);
    }
    
}
