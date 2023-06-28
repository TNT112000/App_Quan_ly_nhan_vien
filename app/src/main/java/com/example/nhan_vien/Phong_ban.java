package com.example.nhan_vien;

public class Phong_ban {
    private String phong_ban;
    private String truong_phong;

    public Phong_ban(String phong_ban, String truong_phong) {
        this.phong_ban = phong_ban;
        this.truong_phong = truong_phong;
    }

    public Phong_ban() {
    }

    public String getPhong_ban() {
        return phong_ban;
    }

    public void setPhong_ban(String phong_ban) {
        this.phong_ban = phong_ban;
    }

    public String getTruong_phong() {
        return truong_phong;
    }

    public void setTruong_phong(String truong_phong) {
        this.truong_phong = truong_phong;
    }
}
