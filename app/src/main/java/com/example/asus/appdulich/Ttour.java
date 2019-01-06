package com.example.asus.appdulich;

public class Ttour {
    String ten;
    String ngaydi;
    String ngayve;
    String hdv;

    public Ttour(){}

    public Ttour(String ten, String ngaydi, String ngayve, String hdv)
    {
        this.ten=ten;
        this.ngaydi=ngaydi;
        this.ngayve=ngayve;
        this.hdv=hdv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getNgayve() {
        return ngayve;
    }

    public void setNgayve(String ngayve) {
        this.ngayve = ngayve;
    }

    public String getHdv() {
        return hdv;
    }

    public void setHdv(String hdv) {
        this.hdv = hdv;
    }

    public String toString(){
        return "Tour: "+ten+ "Ngày đi: "+ngaydi+"Ngày về:"+ngayve+"Hướng dẫn viên:"+hdv;
    }
}
