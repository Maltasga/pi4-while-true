/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.dao.RelatorioDao;
import br.edu.senac.kkcommerce.model.Relatorio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Karolina
 */
public class RelatorioService extends ServiceBase {

    public RelatorioService() {
        super(new RelatorioDao());
    }

    public List<Relatorio> listarTudo(String inicio, String fim) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ini = sdf.parse(inicio);
        Date f = sdf.parse(fim);
        System.out.println(inicio + " " + fim);
        RelatorioDao rdao = new RelatorioDao();
        List<Relatorio> relatorio = rdao.listarTudo(ini, f);
        return relatorio;
    }

    public List<Relatorio> listarPorCategoria(String inicio, String fim, int catId) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date ini = sdf.parse(inicio);
        Date f = sdf.parse(fim);
        System.out.println(inicio + " " + fim);
        RelatorioDao rdao = new RelatorioDao();
        List<Relatorio> relatorio = rdao.listarCat(ini, f, catId);
        return relatorio;
    }

    public List<Relatorio> listarPorGenero(Date inicio, Date fim, String gen) throws Exception {
        RelatorioDao rdao = new RelatorioDao();
        List<Relatorio> relatorio = rdao.listarTudoGenero(inicio, fim, gen);
        return relatorio;
    }
}
