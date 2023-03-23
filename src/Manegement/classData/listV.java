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
public class listV {
    private String maTV, tenTV, pro, vn;
    private byte[] image;
    private String topic;

    public listV() {
    }

    public listV(String maTV, String tenTV, String pro, String vn, byte[] image, String topic) {
        this.maTV = maTV;
        this.tenTV = tenTV;
        this.pro = pro;
        this.vn = vn;
        this.image = image;
        this.topic = topic;
    }

    public String getMaTV() {
        return maTV;
    }

    public void setMaTV(String maTV) {
        this.maTV = maTV;
    }

    public String getTenTV() {
        return tenTV;
    }

    public void setTenTV(String tenTV) {
        this.tenTV = tenTV;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    
}
