/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author Karolina
 */
public class Relatorio {
    
    private String protocolo;
    private int quantProdutos;
    private double frete;
    private double valorTotal;
    private Date dataVenda;

    public Relatorio(String protocolo, int quantProdutos, double frete, double valorTotal, Date dataVenda) {
        this.protocolo = protocolo;
        this.quantProdutos = quantProdutos;
        this.frete = frete;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public int getQuantProdutos() {
        return quantProdutos;
    }

    public void setQuantProdutos(int quantProdutos) {
        this.quantProdutos = quantProdutos;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
}
