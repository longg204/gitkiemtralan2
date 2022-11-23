package com.example.baikiemtralan2;

public class mainmodel {
    private String tenkhoahoc, tenthuonggoi, dactinh, congdung, lieudung, luuydung, url;

    mainmodel() {}

    public mainmodel(String tenkhoahoc, String tenthuonggoi, String dactinh, String congdung, String lieudung, String luuydung, String url) {
        this.tenkhoahoc = tenkhoahoc;
        this.tenthuonggoi = tenthuonggoi;
        this.dactinh = dactinh;
        this.congdung = congdung;
        this.lieudung = lieudung;
        this.luuydung = luuydung;
        this.url = url;
    }

    public String getTenkhoahoc() {
        return tenkhoahoc;
    }

    public void setTenkhoahoc(String tenkhoahoc) {
        this.tenkhoahoc = tenkhoahoc;
    }

    public String getTenthuonggoi() {
        return tenthuonggoi;
    }

    public void setTenthuonggoi(String tenthuonggoi) {
        this.tenthuonggoi = tenthuonggoi;
    }

    public String getDactinh() {
        return dactinh;
    }

    public void setDactinh(String dactinh) {
        this.dactinh = dactinh;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public String getLieudung() {
        return lieudung;
    }

    public void setLieudung(String lieudung) {
        this.lieudung = lieudung;
    }

    public String getLuuydung() {
        return luuydung;
    }

    public void setLuuydung(String luuydung) {
        this.luuydung = luuydung;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
