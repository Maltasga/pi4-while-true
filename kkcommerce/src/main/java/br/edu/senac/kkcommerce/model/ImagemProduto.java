package br.edu.senac.kkcommerce.model;

/**
 *
 * @author While True
 */
public class ImagemProduto {

    private int id;
    private String nome;
    private String descricao;

    public ImagemProduto() {
    }

    public ImagemProduto(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
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

}
