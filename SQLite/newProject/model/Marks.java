package br.com.envolvedesenvolve.alcoolaqui.model;

import android.content.ContentValues;

import br.com.envolvedesenvolve.alcoolaqui.db.UserTable;

public class Marks {

    private int id;
    private int fk_product;
    private double lat;
    private double lon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_product() {
        return fk_product;
    }

    public void setFk_product(int fk_product) {
        this.fk_product = fk_product;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
