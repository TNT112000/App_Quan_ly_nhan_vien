package com.example.nhan_vien;

public class Nhan_vien {
    private String ma_nhan_vien;

    private String gioi_tinh;
    private String ngay_sinh;
    private String ten;
    private String phong_ban;
    private String chuc_vu;

    public Nhan_vien(String ma_nhan_vien, String ten, String phong_ban,  String chuc_vu , String gioi_tinh,String ngay_sinh) {
        this.ma_nhan_vien = ma_nhan_vien;
        this.ten = ten;
        this.phong_ban = phong_ban;
        this.chuc_vu = chuc_vu;
        this.gioi_tinh= gioi_tinh;
        this.ngay_sinh = ngay_sinh;
    }

    public Nhan_vien() {
    }

    public String getMa_nhan_vien() {
        return ma_nhan_vien;
    }

    public void setMa_nhan_vien(String ma_nhan_vien) {
        this.ma_nhan_vien = ma_nhan_vien;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getNgay_sinh() {
        return ngay_sinh;
    }

    public void setNgay_sinh(String ngay_sinh) {
        this.ngay_sinh = ngay_sinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhong_ban() {
        return phong_ban;
    }

    public void setPhong_ban(String phong_ban) {
        this.phong_ban = phong_ban;
    }

    public String getChuc_vu() {
        return chuc_vu;
    }

    public void setChuc_vu(String chuc_vu) {
        this.chuc_vu = chuc_vu;
    }

}
