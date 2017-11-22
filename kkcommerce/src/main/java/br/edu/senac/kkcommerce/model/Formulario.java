package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author gabib
 */
public class Formulario {

    private Integer id;
    private String Nome;
    private String Email;
    private String Telefone;
    private String Mensagem;
    private Date dt_cadastro;

    public Formulario() {
    }

    public Formulario(Integer id, String Nome, String Email, String Telefone, String Mensagem, Date dt_cadastro) {
        this.id = id;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
        this.Mensagem = Mensagem;
        this.dt_cadastro = dt_cadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
}
