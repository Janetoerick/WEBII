package com.ufrn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ufrn.DTO.TurmaDTO;
import com.ufrn.model.Turma;
import com.ufrn.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService service;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TurmaDTO save( @RequestBody TurmaDTO turma){
        return service.save(turma);
    }
    
    @GetMapping("{id}")
    public Turma getById( @PathVariable Integer id ){
        return service.findById(id);
    }
    
    @GetMapping
    public List<Turma> getAll(){
        return service.findAll();
    }
    
    @PutMapping("{id}")
    public TurmaDTO Update( @PathVariable Integer id, @RequestBody TurmaDTO turma){
        return service.update(id, turma);
    }
    
    @DeleteMapping("{id}")
    public boolean removeById(@PathVariable Integer id) {
        return service.deleteById(id);
    }
}