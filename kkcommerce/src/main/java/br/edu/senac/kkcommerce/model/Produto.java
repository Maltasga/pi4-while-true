package br.edu.senac.kkcommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author While True
 */
public class Produto {

    private Integer id;
    private String nome;
    private String descricao;
    private Integer idCategoria;
    private Integer idColecao;
    private Integer idMarca;
    private Double valor;
    private Double percDesconto;
    private Boolean ativo;
    private Date dataCadastro;
    private Marca marca;
    private Colecao colecao;
    private ArrayList<Estoque> estoque;
    private ArrayList<ImagemProduto> imagens;

    private MultipartFile[] arquivos;

    public Produto() {
        estoque = new ArrayList<>();
        imagens = new ArrayList<>();
    }

    public Produto(int id, String nome, String descricao, int idCategoria, int idColecao, int idMarca, double valor, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.idCategoria = idColecao;
        this.idColecao = idColecao;
        this.idMarca = idMarca;
        this.valor = valor;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public Integer getId() {
        if (this.id == null) {
            return 0;
        }
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

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
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

    public Double getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(Double percDesconto) {
        this.percDesconto = percDesconto;
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

    public ArrayList<ImagemProduto> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemProduto> imagens) {
        this.imagens = (ArrayList<ImagemProduto>) imagens;
    }

    public void addImagem(ImagemProduto imagem) {
        this.imagens.add(imagem);
    }

    public MultipartFile[] getArquivos() {
        return arquivos;
    }

    public void setArquivos(MultipartFile[] arquivo) {
        this.arquivos = arquivo;
    }

    public String getUrlImagemPrincipal() {
        if (this.imagens.size() > 0) {
            return this.imagens.get(0).getUrlImagem();
        } else {
            return ImagemProduto.IMG_NOT_FOUND;
        }
    }

    public boolean getEstaDisponivel() {
        return this.estoque.size() > 0;
    }

    public boolean getPossuiDesconto() {
        return this.percDesconto != null && this.percDesconto > 0;
    }

    public Double getValorComDesconto() {
        if (this.getPossuiDesconto()) {
            return this.valor * ((100 - this.percDesconto) / 100);
        }
        return this.valor;
    }

    public int getQuantidadeTotalEstoque() {
        int qtde = 0;
        if (this.estoque != null) {
            for (Estoque e : this.estoque) {
                qtde += e.getQuantidade();
            }
        }
        return qtde;
    }
}
