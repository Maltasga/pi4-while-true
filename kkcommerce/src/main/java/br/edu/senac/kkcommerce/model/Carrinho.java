package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author while true
 */
public class Carrinho {

    private long id;
    private ArrayList<CarrinhoItem> itens;
    private double valorTotal;
    private double valorFinal;
    private int clienteId;
    private int formaPgto;
    private Date data_transacao;
    private long protocolo;
    private DetalhePedido detalhePedido;

    public Carrinho() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0;
    }

    public Carrinho(ArrayList<CarrinhoItem> itens, double valorTotal, int clienteId, Date data_transacao) {
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.clienteId = clienteId;
        this.data_transacao = data_transacao;
    }

    public Carrinho(ArrayList<CarrinhoItem> itens, double valorTotal, int clienteId, Date data_transacao, long protocolo) {
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.clienteId = clienteId;
        this.data_transacao = data_transacao;
        this.protocolo = protocolo;
    }

    public Carrinho(long protocolo, double valorFinal, Date data_transacao) {
        this.protocolo = protocolo;
        this.valorFinal = valorFinal;
        this.data_transacao = data_transacao;
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

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public void addItem(CarrinhoItem item) {
        if (this.itens == null) {
            this.itens = new ArrayList<>();
        }
        boolean flag = true;

        for (CarrinhoItem c : this.itens) {
            if (Objects.equals(item.getProduto().getId(), c.getProduto().getId())) {
                if (item.getTamanho().equals(c.getTamanho())) {
                    c.setQuantidade(c.getQuantidade() + item.getQuantidade());
                    flag = false;
                }
            }
        }
        if (flag) {
            this.itens.add(item);
        }
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

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public static Carrinho getCarrinhoMock() {
        Carrinho carrinho = new Carrinho();
        Produto p1 = new Produto(10, "Camiseta Azul", "Camiseta Azul", 1, 0, 0, 39.90, true, Calendar.getInstance().getTime());
        Produto p2 = new Produto(10, "Agasalho Moleton", "Agasalho Moleton Cinza", 2, 0, 0, 189.30, true, Calendar.getInstance().getTime());
        Produto p3 = new Produto(10, "Vestido Florido", "Vestido Florido", 3, 0, 0, 87.0, true, Calendar.getInstance().getTime());

        carrinho.addItem(new CarrinhoItem(0, p1, 3, "P"));
        carrinho.addItem(new CarrinhoItem(0, p2, 1, "M"));
        carrinho.addItem(new CarrinhoItem(0, p3, 1, "P"));
        return carrinho;
    }

    public void setFormaPgto(int formaPgto) {
        this.formaPgto = formaPgto;
    }

    public int getFormaPgto() {
        return formaPgto;
    }

    public DetalhePedido getDetalhePedido() {
        return detalhePedido;
    }

    public void setDetalhePedido(DetalhePedido detalhePedido) {
        this.detalhePedido = detalhePedido;
    }

}
