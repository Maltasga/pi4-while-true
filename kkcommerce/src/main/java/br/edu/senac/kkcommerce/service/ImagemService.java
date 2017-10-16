/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ImagemDao;

/**
 *
 * @author while true
 */
public class ImagemService extends ServiceBase{
    
    public ImagemService() {
        super(new ImagemDao());
    }
    
}
