package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.model.Formulario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gabib
 */
public class FormularioDAO implements IDaoBase<Formulario> {

    @Override
    public int inserir(Formulario obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void atualizar(Formulario obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<Formulario> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Formulario getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
