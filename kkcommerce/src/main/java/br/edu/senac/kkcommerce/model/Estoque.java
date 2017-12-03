package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class Estoque {

    private Integer id;
    private Integer idProduto;
    private String tamanho;
    private int quantidade;

        public Estoque() {
    }

    public Estoque(int id, int idProduto, String tamanho, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }    
    
    public int getId() {
        if (this.id == null) {
            return 0;
        }
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        if (this.idProduto == null) {
            return 0;
        }
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean equals(Estoque e) {
        return this.idProduto == e.getIdProduto() && this.tamanho.equals(e.getTamanho());
    }

    public static ArrayList<Estoque> getRelacaoEstoque() {
        ArrayList<Estoque> lista = new ArrayList<>();
        lista.add(new Estoque(0, 0, "PP", 0));
        lista.add(new Estoque(0, 0, "P", 0));
        lista.add(new Estoque(0, 0, "M", 0));
        lista.add(new Estoque(0, 0, "G", 0));
        lista.add(new Estoque(0, 0, "GG", 0));
        lista.add(new Estoque(0, 0, "3G", 0));
        return lista;
    }
}
