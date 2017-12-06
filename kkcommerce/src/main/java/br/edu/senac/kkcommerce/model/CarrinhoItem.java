package br.edu.senac.kkcommerce.model;

/**
 *
 * @author while true
 */
public class CarrinhoItem {

    private long id;
    private long carrinhoId;
    private Produto produto;
    private int quantidade;
    private String tamanho;

    public CarrinhoItem(long carrinhoId, Produto produto, int quantidade, String tamanho) {
        this.carrinhoId = carrinhoId;
        this.produto = produto;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCarrinhoId() {
        return carrinhoId;
    }

    public void setCarrinhoId(long carrinhoId) {
        this.carrinhoId = carrinhoId;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        double valor = 0;

        if (this.produto.getPossuiDesconto()) {
            valor = this.produto.getValorComDesconto();
        } else {
            valor = this.produto.getValor();
        }

        return valor * this.quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
}
