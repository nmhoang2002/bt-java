
package model;

import java.io.Serializable;

public class HocVien implements Serializable {
    private String mahv ;
    private String hovaten;
    private float diemthi ;
    private String mon;
    private String lop;

    public HocVien(String mahv, String hovaten, float diemthi, String mon, String lop) {
        this.mahv = mahv;
        this.hovaten = hovaten;
        this.diemthi = diemthi;
        this.mon = mon;
        this.lop = lop;
    }

    public String getMahv() {
        return mahv;
    }

    public void setMahv(String mahv) {
        this.mahv = mahv;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public float getDiemthi() {
        return diemthi;
    }

    public void setDiemthi(float diemthi) {
        this.diemthi = diemthi;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
    
}
