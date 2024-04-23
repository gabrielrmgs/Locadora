package com.gabriel.locadora.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "cliente")
public class Cliente {

    public interface CreateCliente {
    }

    public interface UpdateCliente {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "clientenome", nullable = false, unique = true, length = 90)
    @NotNull(groups = CreateCliente.class)
    @NotEmpty(groups = CreateCliente.class)
    @Size(groups = CreateCliente.class, min = 3, max = 90)
    private String nome;

    @JsonProperty(access = Access.WRITE_ONLY)
    @Column(name = "clientesenha", nullable = false, length = 12)
    @NotNull(groups = { CreateCliente.class, UpdateCliente.class })
    @NotEmpty(groups = { CreateCliente.class, UpdateCliente.class })
    @Size(groups = { CreateCliente.class, UpdateCliente.class }, min = 6, max = 12)
    private String senha;

    @OneToMany(mappedBy = "cliente")
    private List<Filme> filmes = new ArrayList<>();

    public Cliente(Long id,
            @NotNull(groups = CreateCliente.class) @NotEmpty(groups = CreateCliente.class) @Size(groups = CreateCliente.class, min = 3, max = 90) String nome,
            @NotNull(groups = { CreateCliente.class, UpdateCliente.class }) @NotEmpty(groups = { CreateCliente.class,
                    UpdateCliente.class }) @Size(groups = { CreateCliente.class,
                            UpdateCliente.class }, min = 6, max = 12) String senha,
            List<Filme> filmes) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.filmes = filmes;
    }

    public Cliente() {
    }

    public Cliente(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", senha=" + senha + "]";
    }

}
