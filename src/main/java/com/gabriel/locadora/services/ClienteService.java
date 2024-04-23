package com.gabriel.locadora.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.locadora.models.Cliente;
import com.gabriel.locadora.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente findById(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente criarCliente(Cliente obj) {
        obj.setId(null);
        obj = this.clienteRepository.save(obj);
        return obj;
    }

    @Transactional
    public Cliente atualizarCliente(Cliente obj) {
        Cliente newObj = findById(obj.getId());
        newObj.setSenha(obj.getSenha());
        return this.clienteRepository.save(obj);
    }

    @Transactional
    public void excluirCliente(Long id){
        findById(id);
        try {
            this.clienteRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível excluir o cliente pois há entidades relacionadas");
        }
    }
}
