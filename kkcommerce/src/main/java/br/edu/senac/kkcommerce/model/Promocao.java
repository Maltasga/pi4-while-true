package br.edu.senac.kkcommerce.model;

import java.util.Calendar;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author while true
 */
public class Promocao {

    private int produtoId;
    private String nomeProduto;
    private int promocaoId;
    private Double percDesconto;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataInicio;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataFim;

    public Promocao() {

    }

    public Promocao(int produtoId, String nomeProduto, int promocaoId, Date dataInicio, Date dataFim, Double percDesconto) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.promocaoId = promocaoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.percDesconto = percDesconto;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getPromocaoId() {
        return promocaoId;
    }

    public void setPromocaoId(int promocaoId) {
        this.promocaoId = promocaoId;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Double getPercDesconto() {
        return percDesconto;
    }

    public void setPercDesconto(Double percDesconto) {
        this.percDesconto = percDesconto;
    }

    public boolean isAtivo() {
        if (this.dataFim != null) {
            return Calendar.getInstance().getTime().compareTo(this.dataFim) <= 0;
        }
        return true;

    }
}
