/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.RelatorioDao;
import br.edu.senac.kkcommerce.model.Relatorio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Karolina
 */
public class RelatorioService extends ServiceBase {

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public RelatorioService() {
        super(new RelatorioDao());
    }

    public List<Relatorio> listarTudo(String inicio, String fim) throws Exception {
        Calendar cIni = Calendar.getInstance();
        cIni.add(Calendar.DATE, -7);
        Calendar cFim = Calendar.getInstance();
        cFim.add(Calendar.DATE, 1);
        Date ini = cIni.getTime();
        Date f = cFim.getTime();

        if (!"".equals(inicio)) {
            ini = sdf.parse(inicio);
        }
        if (!"".equals(fim)) {
            f = sdf.parse(fim);
        }

        if (ini.after(f)) {
            return null;
        }

        RelatorioDao rdao = new RelatorioDao();
        List<Relatorio> relatorio = rdao.listarTudo(ini, f);
        return relatorio;
    }

    public List<Relatorio> listarPorCategoria(String inicio, String fim, int catId) throws Exception {
        Calendar cIni = Calendar.getInstance();
        cIni.add(Calendar.DATE, -7);
        Date ini = cIni.getTime();
        Date f = Calendar.getInstance().getTime();

        if (!"".equals(inicio)) {
            ini = sdf.parse(inicio);
        }
        if (!"".equals(fim)) {
            f = sdf.parse(fim);
        }

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
