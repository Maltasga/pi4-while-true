package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.IDaoBase;

/**
 *
 * @author while true
 */
public abstract class ServiceBase {
    protected IDaoBase dao;

    public ServiceBase(IDaoBase dao) {
        this.dao = dao;
    }
}
