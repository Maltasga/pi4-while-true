package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ColecaoDao;
import br.edu.senac.kkcommerce.model.Colecao;

/**
 *
 * @author while true
 */
public class ColecaoService extends ServiceBase {
    
    public ColecaoService() {
        super(new ColecaoDao());
    }
    
    public Colecao buscar(int id) throws Exception{
        return (Colecao) dao.getById(id);
    }
}
