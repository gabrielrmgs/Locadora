package com.gabriel.locadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.locadora.models.Filme;
import com.gabriel.locadora.models.Cliente;
import com.gabriel.locadora.repositories.FilmeRepository;

@Service
public class FilmeService {
    
    @Autowired
    private ClienteService clienteService;
    
    @Autowired
    private FilmeRepository filmeRepository;


    public Filme findById(Long id){
        Optional<Filme> filme = this.filmeRepository.findById(id);
        return filme.orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    @Transactional
    public Filme criarFilme(Filme obj){
        Cliente cliente = this.clienteService.findById(obj.getCliente().getId());
        obj.setId(null);
        obj.setCliente(cliente);
        obj = this.filmeRepository.save(obj);
        return obj;
    }

    @Transactional
    public Filme atualizarFilme(Filme obj){
        Filme newobj = findById(obj.getId());
        newobj.setSinopse(obj.getSinopse());
        return this.filmeRepository.save(obj);
    }

    public void deletarFilme(long id){
        findById(id);
        try {
            this.filmeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível deletar pois há entidades relacionais!");
        }
    }
}
