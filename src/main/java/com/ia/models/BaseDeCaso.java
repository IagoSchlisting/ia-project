package com.ia.models;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Entity
@Table(name = "BASEDECASOS")
@Repository
public class BaseDeCaso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BASE_ID")
    private Integer id;

    private Companhia companhia;

    private Avaliacao importanciaAvaliacao;

    private Avaliacao importanciaOscar;

    private Avaliacao importanciaSerRecente;

    private String filme;

    private String urlImagem;

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Companhia getCompanhia() {
        return companhia;
    }

    public void setCompanhia(Companhia companhia) {
        this.companhia = companhia;
    }

    public Avaliacao getImportanciaAvaliacao() {
        return importanciaAvaliacao;
    }

    public void setImportanciaAvaliacao(Avaliacao importanciaAvaliacao) {
        this.importanciaAvaliacao = importanciaAvaliacao;
    }

    public Avaliacao getImportanciaOscar() {
        return importanciaOscar;
    }

    public void setImportanciaOscar(Avaliacao importanciaOscar) {
        this.importanciaOscar = importanciaOscar;
    }

    public Avaliacao getImportanciaSerRecente() {
        return importanciaSerRecente;
    }

    public void setImportanciaSerRecente(Avaliacao importanciaSerRecente) {
        this.importanciaSerRecente = importanciaSerRecente;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }
}
