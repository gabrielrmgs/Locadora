package com.gabriel.locadora.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.locadora.models.Filme;
import com.gabriel.locadora.services.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    @Autowired
    private FilmeService filmeService;

    @GetMapping("/{id}")
    public ResponseEntity<Filme> findById(@PathVariable long id) {
        Filme obj = this.filmeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Filme obj) {
        this.filmeService.criarFilme(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody Filme obj, @PathVariable Long id) {
        obj.setId(id);
        this.filmeService.atualizarFilme(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.filmeService.deletarFilme(id);
        return ResponseEntity.noContent().build();
    }
}
