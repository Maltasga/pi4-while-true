/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class StatusCarrinhoDetalhe {

    private Integer id;
    private Integer Status_id;
    private Integer Carrinho_id;
    private Date dt_cadastro;
    private String Status;
    private String nome;
    private long protocolo;
    private Date dt_transacao;
    private double vl_total;

    public StatusCarrinhoDetalhe(Integer id, Integer Status_id, Integer Carrinho_id, Date dt_cadastro, String Status, String nome, long protocolo, Date dt_transacao, double vl_total) {
        this.id = id;
        this.Status_id = Status_id;
        this.Carrinho_id = Carrinho_id;
        this.dt_cadastro = dt_cadastro;
        this.Status = Status;
        this.nome = nome;
        this.protocolo = protocolo;
        this.dt_transacao = dt_transacao;
        this.vl_total = vl_total;
    }

    public StatusCarrinhoDetalhe(Integer Status_id, Integer Carrinho_id) {
        this.Status_id = Status_id;
        this.Carrinho_id = Carrinho_id;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public Date getDt_transacao() {
        return dt_transacao;
    }

    public void setDt_transacao(Date dt_transacao) {
        this.dt_transacao = dt_transacao;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }

    public StatusCarrinhoDetalhe() {
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus_id() {
        return Status_id;
    }

    public void setStatus_id(Integer Status_id) {
        this.Status_id = Status_id;
    }

    public Integer getCarrinho_id() {
        return Carrinho_id;
    }

    public void setCarrinho_id(Integer Carrinho_id) {
        this.Carrinho_id = Carrinho_id;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

}
