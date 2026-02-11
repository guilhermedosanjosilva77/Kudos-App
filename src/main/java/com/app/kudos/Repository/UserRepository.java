package com.app.kudos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.kudos.Entity.UserEntity;

public interface UserRepository extends JpaRepository <UserEntity, Long> {

    
} 