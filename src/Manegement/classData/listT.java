/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manegement.classData;

/**
 *
 * @author HP
 */
public class listT {
    private String tenChuDe, maTV, maCHTN, maCHDT;

    public listT() {
    }

    public listT(String tenChuDe, String maTV, String maCHTN, String maCHDT) {
        this.tenChuDe = tenChuDe;
        this.maTV = maTV;
        this.maCHTN = maCHTN;
        this.maCHDT = maCHDT;
    }

    public String getTenChuDe() {
        return tenChuDe;
    }

    public void setTenChuDe(String tenChuDe) {
        this.tenChuDe = tenChuDe;
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getMaCHTN() {
        return maCHTN;
    }

    public void setMaCHTN(String maCHTN) {
        this.maCHTN = maCHTN;
    }

    public String getMaCHDT() {
        return maCHDT;
    }

    public void setMaCHDT(String maCHDT) {
        this.maCHDT = maCHDT;
    }
    
    
}
