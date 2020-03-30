package com.travel.dulichviet;

public class MAPS {
    int id;
    String ten;
    Double e;
    Double n;

    public MAPS(int id, String ten, Double n, Double e) {
        this.id = id;
        this.ten = ten;

        this.n = n;
        this.e = e;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getE() {
        return e;
    }

    public void setE(Double e) {
        this.e = e;
    }

    public Double getN() {
        return n;
    }

    public void setN(Double n) {
        this.n = n;
    }
}
