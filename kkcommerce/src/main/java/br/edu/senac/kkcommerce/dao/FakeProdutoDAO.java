package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class FakeProdutoDAO implements IDaoBase<Produto> {

    private static ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    public void inserir(Produto obj) {
        produtos.add(obj);
    }

    @Override
    public void atualizar(Produto obj) {
        for (Produto produto : produtos) {
            if (produto.equals(obj)) {
                produto = obj;
            }
        }
    }

    @Override
    public void excluir(int id) {
        produtos.removeIf((Produto t) -> t.getId() == id);
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }

    @Override
    public Produto getById(int id) {
        Produto p = null;
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                p = produto;
                break;
            }
        }
        return p;
    }
}
