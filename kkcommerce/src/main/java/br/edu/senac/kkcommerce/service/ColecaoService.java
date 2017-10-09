package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ColecaoDao;
import br.edu.senac.kkcommerce.model.Colecao;
import java.util.List;

/**
 *
 * @author while true
 */
public class ColecaoService extends ServiceBase {

    public ColecaoService() {
        super(new ColecaoDao());
    }

    public List<Colecao> listar() throws Exception {
        return dao.listar();
    }

    public Colecao buscar(int id) throws Exception {
        return (Colecao) dao.getById(id);
    }
}
