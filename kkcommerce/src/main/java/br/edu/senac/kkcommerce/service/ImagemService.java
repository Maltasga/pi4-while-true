/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ImagemDao;
import br.edu.senac.kkcommerce.model.ImagemProduto;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class ImagemService extends ServiceBase {

    public ImagemService() {
        super(new ImagemDao());
    }

    void salvar(ArrayList<ImagemProduto> imagens) throws Exception {
        for (ImagemProduto imagem : imagens) {
            dao.inserir(imagem);
        }
    }

}
