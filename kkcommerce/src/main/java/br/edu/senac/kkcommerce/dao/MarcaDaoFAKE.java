package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.model.Marca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class MarcaDaoFAKE implements IDaoBase<Marca> {

    @Override
    public void inserir(Marca obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Marca obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Marca> listar() throws SQLException, Exception {
        ArrayList<Marca> colecoes = new ArrayList<>();
        colecoes.add(new Marca(1, "Marca 1"));
        colecoes.add(new Marca(2, "Marca 2"));
        colecoes.add(new Marca(3, "Marca 3"));
        return colecoes;
    }

    @Override
    public Marca getById(int id) throws SQLException, Exception {
        Marca c = null;
        for (Marca marca : this.listar()) {
            if (marca.getId() == id) {
                c = marca;
                break;
            }
        }
        return c;
    }

}
