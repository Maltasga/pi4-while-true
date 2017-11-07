package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class Carrinho {

    private long id;
    private ArrayList<CarrinhoItem> itens;
    private double valorTotal;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public Carrinho(ArrayList<CarrinhoItem> itens, double valorTotal) {
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<CarrinhoItem> getItens() {
        return itens;
    }

    public void setItens(ArrayList<CarrinhoItem> itens) {
        this.itens = itens;
    }

    public void addItem(CarrinhoItem item) {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        }
        this.itens.add(item);
    }

    public double getValorTotal() {
        double t = 0;
        for (CarrinhoItem iten : itens) {
            t += (iten.getProduto().getValor() * iten.getQuantidade());
        }
        valorTotal = t;
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
