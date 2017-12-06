/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author While True
 */
public class PedidosCliente {

    private Integer carrinho_id;
    private Integer cliente_id;
    private Date dt_compra;
    private String Status;
    private long protocolo;
    private Date dt_atualizacao_status;

    public PedidosCliente(Integer carrinho_id, long protocolo, Date dt_compra, Integer cliente_id, String Status, Date dt_atualizacao_status) {
        this.carrinho_id = carrinho_id;
        this.protocolo = protocolo;
        this.dt_compra = dt_compra;
        this.cliente_id = cliente_id;
        this.Status = Status;
        this.dt_atualizacao_status = dt_atualizacao_status;
    }

    public Integer getCarrinho_id() {
        return carrinho_id;
    }

    public void setCarrinho_id(Integer carrinho_id) {
        this.carrinho_id = carrinho_id;
    }

    public Integer getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getDt_compra() {
        return dt_compra;
    }

    public void setDt_compra(Date dt_compra) {
        this.dt_compra = dt_compra;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public Date getDt_atualizacao_status() {
        return dt_atualizacao_status;
    }

    public void setDt_atualizacao_status(Date dt_atualizacao_status) {
        this.dt_atualizacao_status = dt_atualizacao_status;
    }

}
