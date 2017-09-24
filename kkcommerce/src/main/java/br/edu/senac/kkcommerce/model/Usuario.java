package br.edu.senac.kkcommerce.model;

import java.util.Date;

/**
 *
 * @author while true
 */
public class Usuario {
    private int id;
    private int idPerfil;
    private String nome;
    private String email;
    private String login;
    private String senha;
    private boolean ativo;
    private Date dataCadastro;

    public Usuario() {
    }

    public Usuario(int id, int idPerfil, String nome, String email, String login, String senha, boolean ativo, Date dataCadastro) {
        this.id = id;
        this.idPerfil = idPerfil;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
}
