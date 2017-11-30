package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.PromocaoDao;
import br.edu.senac.kkcommerce.model.Promocao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class PromocaoService extends ServiceBase {

    public PromocaoService() {
        super(new PromocaoDao());
    }

    public int salvar(Promocao promocao) throws Exception {
        if (promocao.getPromocaoId() == 0) {
            return dao.inserir(promocao);
        } else {
            dao.atualizar(promocao);
            return promocao.getPromocaoId();
        }
    }

    public ArrayList<Promocao> listar(int produtoId) throws Exception {
        List<Promocao> listPromocao = dao.listar();
        ArrayList<Promocao> promocoes = new ArrayList<>();

        for (Promocao p : listPromocao) {
            if (produtoId == p.getProdutoId()) {
                promocoes.add(p);
            }
        }
        return promocoes;
    }

    public void encerrar(int promoId)throws Exception{
        dao.excluir(promoId);
    }
}
