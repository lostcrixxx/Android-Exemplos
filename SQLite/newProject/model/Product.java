package br.com.envolvedesenvolve.alcoolaqui.model;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import br.com.envolvedesenvolve.alcoolaqui.db.ProductTable;

public class Product {

    private int id;
    private int fk_user;
    private String nome;
    private float porcent;
    private float tamanho;
    private float valor;
    private String titleLocal;
    private String endereco;
    private String dt_inc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPorcent() {
        return porcent;
    }

    public void setPorcent(float porcent) {
        this.porcent = porcent;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTitleLocal() {
        return titleLocal;
    }

    public void setTitleLocal(String titleLocal) {
        this.titleLocal = titleLocal;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDt_inc() {
        return dt_inc;
    }

    public void setDt_inc(String dt_inc) {
        this.dt_inc = dt_inc;
    }

    public void setInsert(Context context, ArrayList<Product> prodList){
        ContentValues cv = new ContentValues();

        for(Product proLine : prodList){
            cv.put(ProductTable.COLUMN_ID, proLine.getId());
            cv.put(ProductTable.COLUMN_FK_USER, proLine.getFk_user());
            cv.put(ProductTable.COLUMN_NOME, proLine.getNome());
            cv.put(ProductTable.COLUMN_PORCENT, proLine.getPorcent());
            cv.put(ProductTable.COLUMN_TAMANHO, proLine.getTamanho());
            cv.put(ProductTable.COLUMN_VALOR, proLine.getValor());
            cv.put(ProductTable.COLUMN_TITLE_LOCAL, proLine.getTitleLocal());
            cv.put(ProductTable.COLUMN_ENDERECO, proLine.getEndereco());
            cv.put(ProductTable.COLUMN_DT_INC, proLine.getDt_inc());
        }

        ProductTable table = new ProductTable(context);
        table.setValuesDatabase(cv);
    }
}
