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
public class Thongke {
    
    private int tuyenxeid;
    private String tuyenxename;
    private int sove;
    private double price;
    private double doanhthu;

    public Thongke() {
    }

    public Thongke(int tuyenxeid, String tuyenxename, int sove, double price, double doanhthu) {
        this.tuyenxeid = tuyenxeid;
        this.tuyenxename = tuyenxename;
        this.sove = sove;
        this.price = price;
        this.doanhthu = doanhthu;
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

    public int getSove() {
        return sove;
    }

    public void setSove(int sove) {
        this.sove = sove;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }

    @Override
    public String toString() {
        return "Thongkedoanhthu{" + "tuyenxeid=" + tuyenxeid + ", tuyenxename=" + tuyenxename + ", sove=" + sove + ", price=" + price + ", doanhthu=" + doanhthu + '}';
    }
    
}
