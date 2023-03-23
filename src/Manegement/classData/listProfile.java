/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.classData;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP
 */
public class listProfile {
    private String MaND, TaiKhoan, MatKhau, HoTen;
    private boolean GioiTinh;
    private String NgaySinh, DiaChi, SDT, Email;

    public listProfile() {
    }

    public listProfile(String MaND, String Taikhoan, String MatKhau, String HoTen, boolean GioiTinh, String NgaySinh, String DiaChi, String SDT, String Email) {
        this.MaND = MaND;
        this.TaiKhoan = Taikhoan;
        this.MatKhau = MatKhau;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.Email = Email;
    }

    public String getMaND() {
        return MaND;
    }

    public void setMaND(String MaND) {
        this.MaND = MaND;
    }

    public String getTaikhoan() {
        return TaiKhoan;
    }

    public void setTaikhoan(String Taikhoan) {
        this.TaiKhoan = Taikhoan;
    }
    
    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
