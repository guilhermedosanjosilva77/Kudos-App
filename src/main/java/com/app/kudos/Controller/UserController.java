package com.app.kudos.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kudos.DTO.UserRequest;
import com.app.kudos.DTO.UserResponse;
import com.app.kudos.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CREATE (POST)
    @PostMapping
    public UserResponse criar (@RequestBody UserRequest userRequest) {
        
        return userService.criar(userRequest);
    }

    //READ (GET)
    @GetMapping("path")
    public List<UserResponse> listar() {
        return userService.listar();
    }

    //READ BY ID (GET)
    @GetMapping("{/id}")
    public UserResponse listarPorID(@PathVariable Long id) {
        return userService.listarPorId(id);
    }

    //UPDATE (PUT)
    @PutMapping("/{id}")
    public UserResponse atualizar(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.atualizar(id, userRequest);
    }

    //DELETE (DELETE)
    @DeleteMapping("{/id}")
    public void deletar(@PathVariable Long id){
        userService.deletar(id);
    }
    
    
    
    
}
