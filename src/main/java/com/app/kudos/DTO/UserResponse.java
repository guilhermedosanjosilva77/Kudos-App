package com.app.kudos.DTO;

import com.app.kudos.Entity.UserEntity;

public record UserResponse(Long id, String nome, String email,String departamento) {
    public UserResponse(UserEntity userEntity){
        this(
            userEntity.getId(),
            userEntity.getNome(),
            userEntity.getEmail(),
            userEntity.getDepartamento()
);
    }
}
