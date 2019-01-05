package Entity;

import java.io.Serializable;
import java.util.Date;

public class Tour implements Serializable{
    int idTour;
    int idHDV;
    int idCTHDV;
    java.sql.Date ngaybd;
    java.sql.Date ngaykt;
    String tenTour;

    public Tour() {
    }

    public Tour(int idTour, String tenTour, java.sql.Date ngaybd, java.sql.Date ngaykt) {
        this.tenTour = tenTour;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.idTour = idTour;
    }

    public Tour(int idTour, int idHDV, int idCTHDV, java.sql.Date ngaybd, java.sql.Date ngaykt, String tenTour) {
        this.idTour = idTour;
        this.idHDV = idHDV;
        this.idCTHDV = idCTHDV;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.tenTour = tenTour;
    }
    public Tour(int idTour, int idCTHDV, java.sql.Date ngaybd, java.sql.Date ngaykt, String tenTour) {
        this.idTour = idTour;
        this.idCTHDV = idCTHDV;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.tenTour = tenTour;
    }

    public Tour(String tenTour, java.sql.Date ngaybd, java.sql.Date ngaykt, int hdv){
        this.tenTour= tenTour;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.idHDV = hdv;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getIdHDV() {
        return idHDV;
    }

    public void setIdHDV(int idHDV) {
        this.idHDV = idHDV;
    }

    public int getIdCTHDV() {
        return idCTHDV;
    }

    public void setIdCTHDV(int idCTHDV) {
        this.idCTHDV = idCTHDV;
    }

    public java.sql.Date getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(java.sql.Date ngaybd) {
        this.ngaybd = ngaybd;
    }

    public java.sql.Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(java.sql.Date ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }
}
