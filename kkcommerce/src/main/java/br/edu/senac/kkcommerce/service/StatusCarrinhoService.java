package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.StatusCarrinhoDetalheDAO;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import java.util.List;

/**
 *
 * @author gabri
 */
public class StatusCarrinhoService extends ServiceBase {

    public StatusCarrinhoService() {
        super(new StatusCarrinhoDetalheDAO());
    }

    public List<StatusCarrinhoDetalhe> listar() throws Exception {
        List<StatusCarrinhoDetalhe> status = dao.listar();

        return status;
    }

    public void salvar(StatusCarrinhoDetalhe s) throws Exception {
        dao.inserir(s);
    }
    
    public void atualizarStatus(StatusCarrinhoDetalhe s) throws Exception {
        dao.atualizar(s);
    }
}
