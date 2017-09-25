package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.FakeProdutoDAO;
import br.edu.senac.kkcommerce.model.Produto;
import java.util.List;

/**
 *
 * @author while true
 */
public class ProdutoService extends ServiceBase {

    public ProdutoService() {
        super(new FakeProdutoDAO());
    }

    public List<Produto> listar() throws Exception {
        return dao.listar();
    }

    public void salvar(Produto p) throws Exception {
        if (dao.getById(p.getId()) == null) {
            dao.inserir(p);
        } else {
            dao.atualizar(p);
        }
    }
    
    public void remover(int id) throws Exception{
        dao.excluir(id);
    }
    
    public Produto buscar(int id) throws Exception{
        return (Produto) dao.getById(id);
    }
}
