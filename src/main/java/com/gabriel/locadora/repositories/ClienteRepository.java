package com.gabriel.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriel.locadora.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

    
}
