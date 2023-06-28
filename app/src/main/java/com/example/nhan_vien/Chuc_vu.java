package com.example.nhan_vien;

public class Chuc_vu {
    private String ma_chuc_vu;
    private String chuc_vu;

    public Chuc_vu(String ma_chuc_vu, String chuc_vu) {
        this.ma_chuc_vu = ma_chuc_vu;
        this.chuc_vu = chuc_vu;
    }

    public Chuc_vu() {
    }

    public String getMa_chuc_vu() {
        return ma_chuc_vu;
    }

    public void setMa_chuc_vu(String ma_chuc_vu) {
        this.ma_chuc_vu = ma_chuc_vu;
    }

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }
}
