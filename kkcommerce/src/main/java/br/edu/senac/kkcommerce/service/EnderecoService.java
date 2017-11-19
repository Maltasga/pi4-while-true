/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.EnderecoDao;
import br.edu.senac.kkcommerce.model.Endereco;
import java.util.ArrayList;

/**
 *
 * @author Karolina G. K.
 */
public class EnderecoService extends ServiceBase {

    public EnderecoService() {
        super(new EnderecoDao());
    }

    public void salvar(Endereco e) throws Exception {
        if (e.getId() == 0) {
            dao.inserir(e);
        } else {
            dao.atualizar(e);
        }
    }

    public Endereco buscarPorId(int id) throws Exception {
        try {
            return (Endereco) dao.getById(id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public ArrayList<Endereco> buscarPorCliente(int clienteId) {
        ArrayList<Endereco> retorno = new ArrayList<>();
        try {
            ArrayList<Endereco> enderecos = (ArrayList<Endereco>) dao.listar();
            for (Endereco e : enderecos) {
                if (e.getClienteId() == clienteId) {
                    retorno.add(e);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return retorno;
    }

    public void atualizaEnderecoPrincipal(int id, int clienteId) throws Exception {
        try {
            EnderecoDao endDao = new EnderecoDao();
            endDao.rotinaSetEnderecoPrincipal(id, clienteId);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
