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
public class listQDT {
    private String MaCHDT, CauHoiDT;
    private byte[] image;
    private String CauTraLoi, TenChuDe, MaTV;

    public listQDT() {
    }

    public listQDT(String MaCHDT, String CauHoiDT, byte[] image, String CauTraLoi, String TenChuDe, String MaTV) {
        this.MaCHDT = MaCHDT;
        this.CauHoiDT = CauHoiDT;
        this.image = image;
        this.CauTraLoi = CauTraLoi;
        this.TenChuDe = TenChuDe;
        this.MaTV = MaTV;
    }

    public String getMaCHDT() {
        return MaCHDT;
    }

    public void setMaCHDT(String MaCHDT) {
        this.MaCHDT = MaCHDT;
    }

    public String getCauHoiDT() {
        return CauHoiDT;
    }

    public void setCauHoiDT(String CauHoiDT) {
        this.CauHoiDT = CauHoiDT;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getCauTraLoi() {
        return CauTraLoi;
    }

    public void setCauTraLoi(String CauTraLoi) {
        this.CauTraLoi = CauTraLoi;
    }

    public String getTenChuDe() {
        return TenChuDe;
    }

    public void setTenChuDe(String TenChuDe) {
        this.TenChuDe = TenChuDe;
    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String MaTV) {
        this.MaTV = MaTV;
    }


}
