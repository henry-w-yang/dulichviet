package com.travel.dulichviet;

public class DiaDanh_Modles {
<<<<<<< HEAD
    int ID;
    byte[] Logo_Diadanh;
    String Ten_Diadanh;
    String mota;

    public DiaDanh_Modles(int ID, byte[] logo_Diadanh, String ten_Diadanh, String mota) {
        this.ID = ID;
        Logo_Diadanh = logo_Diadanh;
        Ten_Diadanh = ten_Diadanh;
        this.mota = mota;
    }

=======
    byte[] Logo_Diadanh;
    String Ten_Diadanh;
    int ID;

>>>>>>> 2d5c1ad41669ed9f69b4fa0627614d9ff93d626c
    public byte[] getLogo_Diadanh() {
        return Logo_Diadanh;
    }

    public String getTen_Diadanh() {
        return Ten_Diadanh;
    }
<<<<<<< HEAD

    public String getMota() {
        return mota;
    }

=======
>>>>>>> 2d5c1ad41669ed9f69b4fa0627614d9ff93d626c
    public int getid_DiaDanh() {
        return ID;
    }
    public DiaDanh_Modles(int ID,byte[] logo_Diadanh, String ten_Diadanh) {
        this.ID = ID;
        this.Logo_Diadanh = logo_Diadanh;
        this.Ten_Diadanh = ten_Diadanh;
    }
}

