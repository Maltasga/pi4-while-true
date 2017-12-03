/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

/**
 *
 * @author gabib
 */
public class DetalhePedido {

    private int id_compra;
    private long protocolo;
    private int quantidade;
    private int id_produto;
    private String nome_produto;
    private double valor;
    private String nome_cliente;

    public DetalhePedido(int id_compra, long protocolo, int quantidade, int id_produto, String nome_produto, double valor, String nome_cliente) {
        this.id_compra = id_compra;
        this.protocolo = protocolo;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.valor = valor;
        this.nome_cliente = nome_cliente;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorTotal() {
        return this.quantidade * this.valor;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

}
