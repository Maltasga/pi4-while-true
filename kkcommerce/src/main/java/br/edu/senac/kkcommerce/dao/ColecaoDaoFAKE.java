package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.model.Colecao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class ColecaoDaoFAKE implements IDaoBase<Colecao> {

    @Override
    public int inserir(Colecao obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Colecao obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Colecao> listar() throws SQLException, Exception {
        ArrayList<Colecao> colecoes = new ArrayList<>();
        colecoes.add(new Colecao(1, "Coleção 1"));
        colecoes.add(new Colecao(2, "Coleção 2"));
        colecoes.add(new Colecao(3, "Coleção 3"));
        return colecoes;
    }

    @Override
    public Colecao getById(int id) throws SQLException, Exception {
        Colecao c = null;
        for (Colecao colecao : this.listar()) {
            if (colecao.getId() == id) {
                c = colecao;
                break;
            }
        }
        return c;
    }

}
