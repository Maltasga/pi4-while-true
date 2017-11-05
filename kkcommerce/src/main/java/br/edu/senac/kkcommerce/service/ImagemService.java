/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ImagemDao;
import br.edu.senac.kkcommerce.model.ImagemProduto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class ImagemService extends ServiceBase {

    public ImagemService() {
        super(new ImagemDao());
    }

    public void salvar(ArrayList<ImagemProduto> imagens) throws Exception {
        for (ImagemProduto imagem : imagens) {
            dao.inserir(imagem);
        }
    }

    public List<ImagemProduto> listar(int produtoId) throws Exception {
        ArrayList<ImagemProduto> imagens = new ArrayList<>();

        List<ImagemProduto> arrImg = dao.listar();
        for (ImagemProduto item : arrImg) {
            if (item.getProdutoId() == produtoId) {
                imagens.add(item);
            }
        }

        return imagens;
    }
    
    public ImagemProduto buscar(int id) throws Exception {
        return (ImagemProduto) dao.getById(id);
    }

}
