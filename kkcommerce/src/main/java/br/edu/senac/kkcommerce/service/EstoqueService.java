package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.EstoqueDao;
import br.edu.senac.kkcommerce.model.Estoque;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class EstoqueService extends ServiceBase {

    public EstoqueService() {
        super(new EstoqueDao());
    }

    public void salvar(ArrayList<Estoque> listaEstoque) throws Exception {
        for (Estoque estoque : listaEstoque) {
            dao.inserir(estoque);
        }
    }
}
