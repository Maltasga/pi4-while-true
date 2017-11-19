/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author while true
 */
public class TicketSac {

    private Integer id;
    private int clienteId;
    private Date data_transacao;
    private String tipo_erro;
    private String descricao;
    private long protocolo;
    private String status;

    public TicketSac(Integer id, int clienteId, Date data_transacao, String tipo_erro, String descricao, long protocolo) {
        this.id = id;
        this.clienteId = clienteId;
        this.data_transacao = data_transacao;
        this.tipo_erro = tipo_erro;
        this.descricao = descricao;
        this.protocolo = protocolo;
    }

    public TicketSac(Integer id, String tipo_erro, String descricao, Date data_transacao, String status) {
        this.id = id;
        this.data_transacao = data_transacao;
        this.tipo_erro = tipo_erro;
        this.descricao = descricao;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    public String getTipo_erro() {
        return tipo_erro;
    }

    public void setTipo_erro(String tipo_erro) {
        this.tipo_erro = tipo_erro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

}
