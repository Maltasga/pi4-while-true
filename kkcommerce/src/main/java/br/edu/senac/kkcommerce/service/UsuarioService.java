package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.UsuarioDao;
import br.edu.senac.kkcommerce.model.Usuario;
import java.util.List;

/**
 *
 * @author while true
 */
public class UsuarioService extends ServiceBase {

    public UsuarioService() {
        super(new UsuarioDao());
    }

    public List<Usuario> listar() throws Exception {
        return dao.listar();
    }

    public void salvar(Usuario u) throws Exception {
        u.setHashSenha(u.getSenha());
        if (dao.getById(u.getId()) == null) {
            dao.inserir(u);
        } else {
            dao.atualizar(u);
        }
    }

    public void remover(int id) throws Exception {
        dao.excluir(id);
    }

    public Usuario buscar(int produtoId) throws Exception {
        return (Usuario) dao.getById(produtoId);
    }
}
