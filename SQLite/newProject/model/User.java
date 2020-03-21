package br.com.envolvedesenvolve.alcoolaqui.model;

public class User {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String imei;
    private String dt_inc;
    private String dt_upd;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getDt_inc() {
        return dt_inc;
    }

    public void setDt_inc(String dt_inc) {
        this.dt_inc = dt_inc;
    }

    public String getDt_upd() {
        return dt_upd;
    }

    public void setDt_upd(String dt_upd) {
        this.dt_upd = dt_upd;
    }
}
