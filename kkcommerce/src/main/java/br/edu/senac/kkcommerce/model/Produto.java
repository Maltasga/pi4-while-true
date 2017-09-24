package br.edu.senac.kkcommerce.model;

import br.edu.senac.kkcommerce.dao.IEntidade;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author While True
 */
public class Produto implements IEntidade {

    private int id;
    private String nome;
    private String descricao;
    private int idColecao;
    private String tipo;
    private String cor;
    private double valor;
    private boolean ativo;
    private Date dataCadastro;
    private Colecao colecao;
    private ArrayList<Estoque> estoque;
    private ArrayList<ImagemProduto> imagens;

    public Produto(int id, String nome, String descricao, int idColecao, String tipo, String cor, double valor, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idColecao = idColecao;
        this.tipo = tipo;
        this.cor = cor;
        this.valor = valor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdColecao() {
        return idColecao;
    }

    public void setIdColecao(int idColecao) {
        this.idColecao = idColecao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ArrayList<Estoque> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<Estoque> estoque) {
        this.estoque = estoque;
    }

    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    public Colecao getColecao() {
        return colecao;
    }

    public void setImagens(ArrayList<ImagemProduto> imagens) {
        this.imagens = imagens;
    }

    public void addImagem(ImagemProduto imagem) {
        this.imagens.add(imagem);
    }

    @Override
    public boolean equals(Object o) {
        return ((Produto) o).getId() == this.id;
    }
}
