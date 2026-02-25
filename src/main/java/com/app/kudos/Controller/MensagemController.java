package com.app.kudos.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.kudos.DTO.MensagemRequest;
import com.app.kudos.DTO.MensagemResponse;
import com.app.kudos.Service.MensagemService;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    private final MensagemService mensagemService;

    
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }


    //CREATE - POST
    @PostMapping
    public MensagemResponse criar(@RequestBody MensagemRequest mensagemRequest) {
        
        return mensagemService.criar(mensagemRequest);
    }

    //READ - GET
    @GetMapping
    public List<MensagemResponse>buscar() {
        return mensagemService.buscar();
    }

    //READ BY ID
    @GetMapping("{id}")
    public MensagemResponse listarPorId(@PathVariable Long id) {
        return mensagemService.buscarPorId(id);
    }

    //UPDATE - PUT
    @PutMapping("{id}")
    public MensagemResponse atualizar(@PathVariable Long id, @RequestBody MensagemRequest mensagemRequest) {
        return mensagemService.atualizar(id, mensagemRequest);
    }

    //DELETE - DELETE
    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        
    }
    
    
    

    
    
}
