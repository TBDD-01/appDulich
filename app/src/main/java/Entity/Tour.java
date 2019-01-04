package Entity;

import java.io.Serializable;
import java.util.Date;

public class Tour implements Serializable{
    int idTour;
    String idHDV;
    int idCTHDV;
    String ngaybd;
    String ngaykt;
    String tenTour;
    public Tour(int idTour,String tenTour,String ngaybd, String ngaykt) {
        this.tenTour = tenTour;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.idTour = idTour;
    }

    public Tour(String tenTour, String ngaybd, String ngaykt, String hdv){
        this.tenTour= tenTour;
        this.ngaybd = ngaybd;
        this.ngaykt = ngaykt;
        this.idHDV = hdv;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getIdHDV() {
        return idHDV;
    }

    public void setIdHDV(String idHDV) {
        this.idHDV = idHDV;
    }

    public int getIdCTHDV() {
        return idCTHDV;
    }

    public void setIdCTHDV(int idCTHDV) {
        this.idCTHDV = idCTHDV;
    }

    public String getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(String ngaybd) {
        this.ngaybd = ngaybd;
    }

    public String getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(String ngaykt) {
        this.ngaykt = ngaykt;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }
}
