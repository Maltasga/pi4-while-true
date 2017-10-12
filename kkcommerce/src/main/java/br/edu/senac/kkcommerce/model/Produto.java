package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author While True
 */
public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer idColecao;
    private Integer idMarca;
    private Double valor;
    private Boolean ativo;
    private Date dataCadastro;
    private Marca marca;
    private Colecao colecao;
    private ArrayList<Estoque> estoque;
    private ArrayList<ImagemProduto> imagens;

    private MultipartFile arquivo;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, int idColecao, int idMarca, double valor, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idColecao = idColecao;
        this.idMarca = idMarca;
        this.valor = valor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getIdColecao() {
        return idColecao;
    }

    public void setIdColecao(Integer idColecao) {
        this.idColecao = idColecao;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setImagens(ArrayList<ImagemProduto> imagens) {
        this.imagens = imagens;
    }

    public void addImagem(ImagemProduto imagem) {
        this.imagens.add(imagem);
    }
    
    public MultipartFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(MultipartFile arquivo) {
        this.arquivo = arquivo;
    }
}
