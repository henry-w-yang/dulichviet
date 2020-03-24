package com.travel.dulichviet;

public class DiaDanh_Modles {
    byte[] Logo_Diadanh;
    String Ten_Diadanh;
    int ID;

    public byte[] getLogo_Diadanh() {
        return Logo_Diadanh;
    }

    public String getTen_Diadanh() {
        return Ten_Diadanh;
    }
    public int getid_DiaDanh() {
        return ID;
    }
    public DiaDanh_Modles(int ID,byte[] logo_Diadanh, String ten_Diadanh) {
        this.ID = ID;
        this.Logo_Diadanh = logo_Diadanh;
        this.Ten_Diadanh = ten_Diadanh;
    }
}

