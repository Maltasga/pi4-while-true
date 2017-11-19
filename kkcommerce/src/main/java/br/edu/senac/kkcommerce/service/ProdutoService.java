package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ProdutoDao;
import br.edu.senac.kkcommerce.model.Estoque;
import br.edu.senac.kkcommerce.model.ImagemProduto;
import br.edu.senac.kkcommerce.model.Produto;
import java.util.List;

/**
 *
 * @author while true
 */
public class ProdutoService extends ServiceBase {

    private final EstoqueService estoqueService = new EstoqueService();
    private final ImagemService imagemService = new ImagemService();

    public ProdutoService() {
        super(new ProdutoDao());
    }

    public List<Produto> listar() throws Exception {
        List<Produto> produtos = dao.listar();
        
        for (Produto p : produtos) {
            p.setImagens(imagemService.listar(p.getId()));
        }
        return produtos;
    }

    public void salvar(Produto p) throws Exception {
        if (dao.getById(p.getId()) == null) {
            int idProduto = dao.inserir(p);
            for (ImagemProduto imagem : p.getImagens()) {
                imagem.setProdutoId(idProduto);
            }
            for (Estoque estoque : p.getEstoque()) {
                estoque.setIdProduto(idProduto);
            }

            estoqueService.salvar(p.getEstoque());
            imagemService.salvar(p.getImagens());
        } else {
            dao.atualizar(p);
        }
    }

    public void remover(int id) throws Exception {
        dao.excluir(id);
    }

    public Produto buscar(int produtoId) throws Exception {
        Produto p = (Produto) dao.getById(produtoId);
        p.setImagens(imagemService.listar(produtoId));
        p.setEstoque(estoqueService.listarPorProduto(produtoId));
        return p;
    }
}
