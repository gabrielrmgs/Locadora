package com.gabriel.locadora.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

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
    private int IMDb;
    private String paisOrigem;
    private String diretor;


    private List<String> elenco = new ArrayList<>();


    public Filme() {
    }


    public Filme(Long id, @NotNull(groups = CreateFilme.class) @NotEmpty(groups = CreateFilme.class) String nome,
            String urlYoutube, String dataLancamento, int iMDb, String paisOrigem, String diretor,
            List<String> elenco) {
        this.id = id;
        this.nome = nome;
        this.urlYoutube = urlYoutube;
        this.dataLancamento = dataLancamento;
        IMDb = iMDb;
        this.paisOrigem = paisOrigem;
        this.diretor = diretor;
        this.elenco = elenco;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getUrlYoutube() {
        return urlYoutube;
    }


    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }


    public String getDataLancamento() {
        return dataLancamento;
    }


    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }


    public int getIMDb() {
        return IMDb;
    }


    public void setIMDb(int iMDb) {
        IMDb = iMDb;
    }


    public String getPaisOrigem() {
        return paisOrigem;
    }


    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }


    public String getDiretor() {
        return diretor;
    }


    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }


    public List<String> getElenco() {
        return elenco;
    }


    public void setElenco(List<String> elenco) {
        this.elenco = elenco;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((urlYoutube == null) ? 0 : urlYoutube.hashCode());
        result = prime * result + ((dataLancamento == null) ? 0 : dataLancamento.hashCode());
        result = prime * result + IMDb;
        result = prime * result + ((paisOrigem == null) ? 0 : paisOrigem.hashCode());
        result = prime * result + ((diretor == null) ? 0 : diretor.hashCode());
        result = prime * result + ((elenco == null) ? 0 : elenco.hashCode());
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
        Filme other = (Filme) obj;
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
        if (urlYoutube == null) {
            if (other.urlYoutube != null)
                return false;
        } else if (!urlYoutube.equals(other.urlYoutube))
            return false;
        if (dataLancamento == null) {
            if (other.dataLancamento != null)
                return false;
        } else if (!dataLancamento.equals(other.dataLancamento))
            return false;
        if (IMDb != other.IMDb)
            return false;
        if (paisOrigem == null) {
            if (other.paisOrigem != null)
                return false;
        } else if (!paisOrigem.equals(other.paisOrigem))
            return false;
        if (diretor == null) {
            if (other.diretor != null)
                return false;
        } else if (!diretor.equals(other.diretor))
            return false;
        if (elenco == null) {
            if (other.elenco != null)
                return false;
        } else if (!elenco.equals(other.elenco))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Filme [id=" + id + ", nome=" + nome + ", urlYoutube=" + urlYoutube + ", dataLancamento="
                + dataLancamento + ", IMDb=" + IMDb + ", paisOrigem=" + paisOrigem + ", diretor=" + diretor
                + ", elenco=" + elenco + "]";
    }


    

}
