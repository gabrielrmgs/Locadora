package com.gabriel.locadora.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "filme")
public class Filme {

    public interface CreateFilme {

    }

    public interface UpdateFilme {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false, length = 30)
    @NotNull(groups = CreateFilme.class)
    @NotEmpty(groups = CreateFilme.class)
    private String nome;

    private String urlYoutube;
    private String dataLancamento;
    private int imdb;
    private String paisOrigem;
    private String diretor;

    private List<String> elenco = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false, updatable = false)
    private Cliente cliente;

    @Column(name = "sinopse", length = 255, nullable = false)
    @NotEmpty
    @NotNull
    @Size(min = 1, max = 255)
    private String sinopse;

    public Filme() {
    }

    public Filme(Long id, String nome, String urlYoutube, String dataLancamento, int imdb, String paisOrigem,
            String diretor, List<String> elenco, Cliente cliente, String sinopse) {
        this.id = id;
        this.nome = nome;
        this.urlYoutube = urlYoutube;
        this.dataLancamento = dataLancamento;
        this.imdb = imdb;
        this.paisOrigem = paisOrigem;
        this.diretor = diretor;
        this.elenco = elenco;
        this.cliente = cliente;
        this.sinopse = sinopse;
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

    public String getUrlYoutube() {
        return this.urlYoutube;
    }

    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    public String getDataLancamento() {
        return this.dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getimdb() {
        return this.imdb;
    }

    public void setimdb(int imdb) {
        this.imdb = imdb;
    }

    public String getPaisOrigem() {
        return this.paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public List<String> getElenco() {
        return this.elenco;
    }

    public void setElenco(List<String> elenco) {
        this.elenco = elenco;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Filme id(Long id) {
        setId(id);
        return this;
    }

    public Filme nome(String nome) {
        setNome(nome);
        return this;
    }

    public Filme urlYoutube(String urlYoutube) {
        setUrlYoutube(urlYoutube);
        return this;
    }

    public Filme dataLancamento(String dataLancamento) {
        setDataLancamento(dataLancamento);
        return this;
    }

    public Filme imdb(int imdb) {
        setimdb(imdb);
        return this;
    }

    public Filme paisOrigem(String paisOrigem) {
        setPaisOrigem(paisOrigem);
        return this;
    }

    public Filme diretor(String diretor) {
        setDiretor(diretor);
        return this;
    }

    public Filme elenco(List<String> elenco) {
        setElenco(elenco);
        return this;
    }

    public Filme cliente(Cliente cliente) {
        setCliente(cliente);
        return this;
    }

    public Filme sinopse(String sinopse) {
        setSinopse(sinopse);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Filme)) {
            return false;
        }
        Filme filme = (Filme) o;
        return Objects.equals(id, filme.id) && Objects.equals(nome, filme.nome)
                && Objects.equals(urlYoutube, filme.urlYoutube) && Objects.equals(dataLancamento, filme.dataLancamento)
                && imdb == filme.imdb && Objects.equals(paisOrigem, filme.paisOrigem)
                && Objects.equals(diretor, filme.diretor) && Objects.equals(elenco, filme.elenco)
                && Objects.equals(cliente, filme.cliente) && Objects.equals(sinopse, filme.sinopse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, urlYoutube, dataLancamento, imdb, paisOrigem, diretor, elenco, cliente, sinopse);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nome='" + getNome() + "'" +
                ", urlYoutube='" + getUrlYoutube() + "'" +
                ", dataLancamento='" + getDataLancamento() + "'" +
                ", imdb='" + getimdb() + "'" +
                ", paisOrigem='" + getPaisOrigem() + "'" +
                ", diretor='" + getDiretor() + "'" +
                ", elenco='" + getElenco() + "'" +
                ", cliente='" + getCliente() + "'" +
                ", sinopse='" + getSinopse() + "'" +
                "}";
    }

}
