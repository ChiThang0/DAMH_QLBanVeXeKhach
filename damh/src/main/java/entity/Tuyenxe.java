/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Tuyenxe {
    private int tuyenxeid;
    private String tuyenxename;
    private String tuyenxestart;
    private String tuyenxeend;
    private double price;

    public Tuyenxe() {
    }

    public Tuyenxe(int tuyenxeid, String tuyenxename, String tuyenxestart, String tuyenxeend, double price) {
        this.tuyenxeid = tuyenxeid;
        this.tuyenxename = tuyenxename;
        this.tuyenxestart = tuyenxestart;
        this.tuyenxeend = tuyenxeend;
        this.price = price;
    }

    public int getTuyenxeid() {
        return tuyenxeid;
    }

    public void setTuyenxeid(int tuyenxeid) {
        this.tuyenxeid = tuyenxeid;
    }

    public String getTuyenxename() {
        return tuyenxename;
    }

    public void setTuyenxename(String tuyenxename) {
        this.tuyenxename = tuyenxename;
    }

    public String getTuyenxestart() {
        return tuyenxestart;
    }

    public void setTuyenxestart(String tuyenxestart) {
        this.tuyenxestart = tuyenxestart;
    }

    public String getTuyenxeend() {
        return tuyenxeend;
    }

    public void setTuyenxeend(String tuyenxeend) {
        this.tuyenxeend = tuyenxeend;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tuyenxe{" + "tuyenxeid=" + tuyenxeid + ", tuyenxename=" + tuyenxename + ", tuyenxestart=" + tuyenxestart + ", tuyenxeend=" + tuyenxeend + ", price=" + price + '}';
    }
    
}
