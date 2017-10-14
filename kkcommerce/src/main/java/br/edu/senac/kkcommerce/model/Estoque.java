package br.edu.senac.kkcommerce.model;

/**
 *
 * @author While True
 */
public class Estoque {

    private int id;
    private int idProduto;
    private int idFilial;
    private String tamanho;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(int idFilial) {
        this.idFilial = idFilial;
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

    public Estoque(int id, int idProduto, int idFilial, String tamanho, int quantidade) {
        this.id = id;
        this.idProduto = idProduto;
        this.idFilial = idFilial;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
    }

    public boolean equals(Estoque e) {
        return this.idProduto == e.getIdProduto() && this.idFilial == e.getIdFilial() && this.tamanho.equals(e.getTamanho());
    }
}
