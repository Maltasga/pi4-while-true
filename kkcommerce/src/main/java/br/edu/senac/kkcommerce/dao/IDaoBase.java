package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.model.Carrinho;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author gabri
 * @param <T>
 */
public interface IDaoBase<T> {

    int inserir(T obj) throws SQLException, Exception ;

    void atualizar(T obj) throws SQLException, Exception;

    void excluir(int id) throws SQLException, Exception;

    List<T> listar() throws SQLException, Exception;
    
    T getById(int id) throws SQLException, Exception;

}
