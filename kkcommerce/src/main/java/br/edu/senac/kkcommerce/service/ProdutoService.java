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
    private EstoqueService estoqueService = new EstoqueService();
    private ImagemService imagemService = new ImagemService();
    
    public ProdutoService() {
        super(new ProdutoDao());
    }
    
    public List<Produto> listar() throws Exception {
        return dao.listar();
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
            
            // TODO - salvar estoque, salvar imagens do produto
            
            estoqueService.salvar(p.getEstoque());
            imagemService.salvar(p.getImagens());
        } else {
            dao.atualizar(p);
        }
    }
    
    public void remover(int id) throws Exception {
        dao.excluir(id);
    }
    
    public Produto buscar(int id) throws Exception {
        return (Produto) dao.getById(id);
    }
}
