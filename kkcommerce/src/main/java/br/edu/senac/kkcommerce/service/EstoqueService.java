
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.EstoqueDao;

/**
 *
 * @author while true
 */
public class EstoqueService extends ServiceBase {

    public EstoqueService() {
        super(new EstoqueDao());
    }

}
