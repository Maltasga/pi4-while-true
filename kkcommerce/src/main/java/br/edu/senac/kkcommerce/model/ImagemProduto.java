package br.edu.senac.kkcommerce.model;

/**
 *
 * @author While True
 */
public class ImagemProduto {

    private int id;
    private int produtoId;
    private String nome;
    private String descricao;

    public ImagemProduto() {
    }

    public ImagemProduto(int id, int produtoId, String nome, String descricao) {
        this.id = id;
        this.produtoId = produtoId;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
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

    public String getUrlImagem() {
        if (this.nome == null || "".equals(this.nome)) {
            return "/imagens/produtos/img_not_found.jpg";
        }
        return "/imagens/produtos/" + this.nome;
    }
}
