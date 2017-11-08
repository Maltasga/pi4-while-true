/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

/**
 *
 * @author while true
 */
public class Checkout {
    private int clienteId;
    private Endereco endereco;
    private int formaPgto;

    public Checkout() {
    }

    public Checkout(int clienteId, Endereco endereco, int formaPgto) {
        this.clienteId = clienteId;
        this.endereco = endereco;
        this.formaPgto = formaPgto;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(int formaPgto) {
        this.formaPgto = formaPgto;
    }
}
