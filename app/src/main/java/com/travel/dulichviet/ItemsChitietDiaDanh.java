package com.travel.dulichviet;

public class ItemsChitietDiaDanh {
    int id;
    String ten;
    String mota;
    byte[] hinh1;
    byte[] hinh2;
    byte[] hinh3;
    byte[] hinh4;

    public ItemsChitietDiaDanh(int id, String ten, String mota, byte[] hinh1, byte[] hinh2, byte[] hinh3, byte[] hinh4) {
        this.id = id;
        this.ten = ten;
        this.mota = mota;
        this.hinh1 = hinh1;
        this.hinh2 = hinh2;
        this.hinh3 = hinh3;
        this.hinh4 = hinh4;
    }

    public int getId() {
        return id;
    }

    public String getTen() {
        return ten;
    }

    public String getMota() {
        return mota;
    }

    public byte[] getHinh1() {
        return hinh1;
    }

    public byte[] getHinh2() {
        return hinh2;
    }

    public byte[] getHinh3() {
        return hinh3;
    }

    public byte[] getHinh4() {
        return hinh4;
    }
}
