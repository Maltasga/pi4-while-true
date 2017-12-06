package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author While true
 */
public class PedidosClienteDetalhes {

    private Integer produto_id;
    private String nome_produto;
    private double vl_unitario;
    private String descricao;
    private Integer quantidade;  
    private String tamanho;
    private Integer carrinho_id;
    private Date dt_compra;
    private long protocolo;
    private String nome_cliente;

    public PedidosClienteDetalhes(Integer produto_id, String nome_produto, double vl_unitario, String descricao, Integer quantidade, String tamanho, Integer carrinho_id, Date dt_compra, long protocolo, String nome_cliente) {
        this.produto_id = produto_id;
        this.nome_produto = nome_produto;
        this.vl_unitario = vl_unitario;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
        this.carrinho_id = carrinho_id;
        this.dt_compra = dt_compra;
        this.protocolo = protocolo;
        this.nome_cliente = nome_cliente;
    }

    public PedidosClienteDetalhes() {
    }

    
    
    public Integer getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Integer produto_id) {
        this.produto_id = produto_id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public double getVl_unitario() {
        return vl_unitario;
    }

    public void setVl_unitario(double vl_unitario) {
        this.vl_unitario = vl_unitario;
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

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Integer getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(Integer carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public Date getDt_compra() {
        return dt_compra;
    }

    public void setDt_compra(Date dt_compra) {
        this.dt_compra = dt_compra;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

   
}
