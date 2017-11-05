package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.EstoqueDao;
import br.edu.senac.kkcommerce.model.Estoque;
import java.util.ArrayList;
import java.util.List;

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
            if(estoque.equals(estoque))
            dao.inserir(estoque);
        }
    }

    public ArrayList<Estoque> listarPorProduto(int produtoId) throws Exception {
        ArrayList<Estoque> estoque = new ArrayList<>();
        List<Estoque> arrEstoque = dao.listar();

        for (Estoque e : arrEstoque) {
            if (e.getIdProduto() == produtoId) {
                estoque.add(e);
            }
        }
        return estoque;
    }
}
