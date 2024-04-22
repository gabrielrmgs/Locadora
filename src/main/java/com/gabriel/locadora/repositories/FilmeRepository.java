package com.gabriel.locadora.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/* import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param; */
import org.springframework.stereotype.Repository;

import com.gabriel.locadora.models.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByCliente_Id(Long id);

    /* @Query(value = "SELECT f FROM Filme f WHERE f.cliente.id = :id")     
    List<Filme> findByClienteId(@Param("id") Long id);

    @Query(value = "SELECT * FROM filme f WHERE f.cliente.id = :cliente_id", nativeQuery = true)
    List<Filme> findByCliente_Id(@Param("cliente_id") Long id); */

}