/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.classData;

import java.util.Date;

/**
 *
 * @author HP
 */
public class listBKT {
    private String maBKT, maND, tenCapDo, tenChuDe, hinhThuc;
    private float Diem;
    private String NgayKiem;

    public listBKT() {
    }

    public listBKT(String maBKT, String maND, String tenCapDo, String tenChuDe, String hinhThuc, float Diem, String NgayKiem) {
        this.maBKT = maBKT;
        this.maND = maND;
        this.tenCapDo = tenCapDo;
        this.tenChuDe = tenChuDe;
        this.hinhThuc = hinhThuc;
        this.Diem = Diem;
        this.NgayKiem = NgayKiem;
    }

    public String getMaBKT() {
        return maBKT;
    }

    public void setMaBKT(String maBKT) {
        this.maBKT = maBKT;
    }

    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getTenCapDo() {
        return tenCapDo;
    }

    public void setTenCapDo(String tenCapDo) {
        this.tenCapDo = tenCapDo;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

    public String getNgayKiem() {
        return NgayKiem;
    }

    public void setNgayKiem(String NgayKiem) {
        this.NgayKiem = NgayKiem;
    }

    
    
}
