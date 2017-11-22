/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.model;

/**
 *
 * @author gabri
 */
public class StatusCarrinho {

    private Integer id;
    private Integer Status_id;
    private String Status;

    public StatusCarrinho(Integer id, Integer Status_id, String Status) {
        this.id = id;
        this.Status_id = Status_id;
        this.Status = Status;
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
