
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author While True
 */
public class Colecao {
    private int id;
    private String nome;
    private String periodo;
    private int ano;
    private boolean ativo;
    private java.util.Date dataCriacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Colecao(int idColecao, String nome, String periodo, int ano, boolean ativo, Date dataCriacao) {
        this.id = idColecao;
        this.nome = nome;
        this.periodo = periodo;
        this.ano = ano;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
    }
    
    public Colecao(int idColecao, String nome) {
        this.id = idColecao;
        this.nome = nome;
    }
}
