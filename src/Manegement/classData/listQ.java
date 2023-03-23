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
public class listQ {

    private String MaCHTN, CHTN, Option1, Option2, Option3, Option4;
    private byte[] image;
    private String Answer, Topic, MaTV;

    public listQ() {
    }

    public listQ(String MaCHTN, String CHTN, String Option1, String Option2, String Option3, String Option4, byte[] image, String Answer, String Topic, String MaTV) {
        this.MaCHTN = MaCHTN;
        this.CHTN = CHTN;
        this.Option1 = Option1;
        this.Option2 = Option2;
        this.Option3 = Option3;
        this.Option4 = Option4;
        this.image = image;
        this.Answer = Answer;
        this.Topic = Topic;
        this.MaTV = MaTV;
    }

    public String getMaCHTN() {
        return MaCHTN;
    }

    public void setMaCHTN(String MaCHTN) {
        this.MaCHTN = MaCHTN;
    }

    public String getCHTN() {
        return CHTN;
    }

    public void setCHTN(String CHTN) {
        this.CHTN = CHTN;
    }

    public String getOption1() {
        return Option1;
    }

    public void setOption1(String Option1) {
        this.Option1 = Option1;
    }

    public String getOption2() {
        return Option2;
    }

    public void setOption2(String Option2) {
        this.Option2 = Option2;
    }

    public String getOption3() {
        return Option3;
    }

    public void setOption3(String Option3) {
        this.Option3 = Option3;
    }

    public String getOption4() {
        return Option4;
    }

    public void setOption4(String Option4) {
        this.Option4 = Option4;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String Topic) {
        this.Topic = Topic;
    }

    public String getMaTV() {
        return MaTV;
    }

    public void setMaTV(String MaTV) {
        this.MaTV = MaTV;
    }

}
