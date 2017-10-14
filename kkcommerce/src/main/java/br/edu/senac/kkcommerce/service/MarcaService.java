package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.MarcaDao;
import br.edu.senac.kkcommerce.model.Marca;
import java.util.List;

/**
 *
 * @author while true
 */
public class MarcaService extends ServiceBase {
    
    public MarcaService() {
        super(new MarcaDao());
    }

    public List<Marca> listar() throws Exception {
        return dao.listar();
    }

    public Marca buscar(int id) throws Exception {
        return (Marca) dao.getById(id);
    }

}
