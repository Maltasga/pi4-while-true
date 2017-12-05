/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author While true
 */
public class PedidosClienteDetalhes {

    private Integer produto_id;
    private String descricao;
    private Integer quantidade;
    private double vl_total;
    private double vl_unitario;
    private Integer Carrinho_id;
    private Date dt_compra;
    private String nome;  

    public PedidosClienteDetalhes(Integer produto_id, String descricao, Integer quantidade, double vl_total, double vl_unitario, Integer Carrinho_id, Date dt_compra, String nome) {
        this.produto_id = produto_id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.vl_total = vl_total;
        this.vl_unitario = vl_unitario;
        this.Carrinho_id = Carrinho_id;
        this.dt_compra = dt_compra;
        this.nome = nome;
    }

    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getVl_total() {
        return vl_total;
    }

    public void setVl_total(double vl_total) {
        this.vl_total = vl_total;
    }

    public double getVl_unitario() {
        return vl_unitario;
    }

    public void setVl_unitario(double vl_unitario) {
        this.vl_unitario = vl_unitario;
    }

    public Integer getCarrinho_id() {
        return Carrinho_id;
    }

    public void setCarrinho_id(Integer Carrinho_id) {
        this.Carrinho_id = Carrinho_id;
    }

    public Date getDt_compra() {
        return dt_compra;
    }

    public void setDt_compra(Date dt_compra) {
        this.dt_compra = dt_compra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    

}
