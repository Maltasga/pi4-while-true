package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ClienteDao;
import br.edu.senac.kkcommerce.model.Cliente;
import java.util.List;

/**
 *
 * @author while true
 */
public class ClienteService extends ServiceBase {

    private EnderecoService enderecoService = new EnderecoService();

    public ClienteService() {
        super(new ClienteDao());
    }

    public int salvar(Cliente c) throws Exception {
        if (dao.getById(c.getId()) == null) {
            return dao.inserir(c);
        } else {
            dao.atualizar(c);
            return c.getId();
        }
    }

    public Cliente buscar(int clienteId) throws Exception {
        Cliente c = (Cliente) dao.getById(clienteId);
        c.setEnderecos(enderecoService.buscarPorCliente(clienteId));
        return c;
    }

    public List<Cliente> listar() throws Exception {
        return dao.listar();
    }
}
