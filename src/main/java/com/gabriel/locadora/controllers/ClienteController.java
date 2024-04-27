package com.gabriel.locadora.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.locadora.models.Cliente;
import com.gabriel.locadora.models.Cliente.CreateCliente;
import com.gabriel.locadora.models.Cliente.UpdateCliente;
import com.gabriel.locadora.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Validated
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        Cliente obj = this.clienteService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/verificado/{nome}")
    public ResponseEntity<Cliente> findByNome(@PathVariable String nome){

        Cliente obj = this.clienteService.findByNome(nome);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @Validated(CreateCliente.class)
    public ResponseEntity<Void> create(@Valid @RequestBody Cliente obj) {

        this.clienteService.criarCliente(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/{id}")
    @Validated(UpdateCliente.class)
    public ResponseEntity<Void> update(@Valid @RequestBody Cliente obj, @PathVariable Long id){
        
        obj.setId(id);
        this.clienteService.atualizarCliente(obj);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        this.clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

}
