package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;
import java.util.Calendar;

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
        valorTotal = 0;
        for (CarrinhoItem item : itens) {
            valorTotal += item.getValorItem();
        }
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static Carrinho getCarrinhoMock() {
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto(10, "Camiseta Azul", "Camiseta Azul", 0, 0, 39.90, true, Calendar.getInstance().getTime());
        Produto p2 = new Produto(10, "Agasalho Moleton", "Agasalho Moleton Cinza", 0, 0, 189.30, true, Calendar.getInstance().getTime());
        Produto p3 = new Produto(10, "Vestido Florido", "Vestido Florido", 0, 0, 87.0, true, Calendar.getInstance().getTime());

        carrinho.addItem(new CarrinhoItem(0, p1, 3));
        carrinho.addItem(new CarrinhoItem(0, p2, 1));
        carrinho.addItem(new CarrinhoItem(0, p3, 1));
        return carrinho;
    }
}
