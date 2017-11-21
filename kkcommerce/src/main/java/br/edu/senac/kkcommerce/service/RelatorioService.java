/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.dao.RelatorioDao;
import br.edu.senac.kkcommerce.model.Relatorio;
import java.util.ArrayList;

/**
 *
 * @author Karolina
 */
public class RelatorioService extends ServiceBase{
    
    public RelatorioService(IDaoBase dao) {
        super(new RelatorioDao());
    }
    
//    public ArrayList<Relatorio> listarTudo(){
//        
//    }
    
}
