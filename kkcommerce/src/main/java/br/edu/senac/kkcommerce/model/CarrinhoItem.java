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

    public CarrinhoItem(long carrinhoId, Produto produto, int quantidade) {
        this.carrinhoId = carrinhoId;
        this.produto = produto;
        this.quantidade = quantidade;
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
        return this.produto.getValor() * this.quantidade;
    }
}
