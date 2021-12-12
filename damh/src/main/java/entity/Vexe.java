/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.chuyenxeDAO;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Vexe {

    private int vexeid;
    private int chuyenxeid;
    private String chuyenxename;
    private String tuyenxestart;
    private String tuyenxeend;
    private Date timestart;
    private int numberofseat;
    private double price;
    private int thanhtoan;

    public Vexe() {
    }

    public Vexe(int vexeid, int chuyenxeid, int numberofseat, int thanhtoan) {
        this.vexeid = vexeid;
        this.chuyenxeid = chuyenxeid;
        this.numberofseat = numberofseat;
        this.thanhtoan = thanhtoan;
        try {
            chuyenxeDAO cdao = new chuyenxeDAO();
            Chuyenxe c = cdao.getChuyenxeByID(String.valueOf(chuyenxeid));
            setChuyenxename(c.getChuyenxename());
            setTuyenxestart(c.getTuyenxestart());
            setTuyenxeend(c.getTuyenxeend());
            setTimestart(c.getTimestart());
            setPrice(c.getPrice());
        } catch (Exception e) {
        }

    }

    public int getVexeid() {
        return vexeid;
    }

    public void setVexeid(int vexeid) {
        this.vexeid = vexeid;
    }

    public int getChuyenxeid() {
        return chuyenxeid;
    }

    public void setChuyenxeid(int chuyenxeid) {
        this.chuyenxeid = chuyenxeid;
    }

    public String getChuyenxename() {
        return chuyenxename;
    }

    public void setChuyenxename(String chuyenxename) {
        this.chuyenxename = chuyenxename;
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

    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public int getNumberofseat() {
        return numberofseat;
    }

    public void setNumberofseat(int numberofseat) {
        this.numberofseat = numberofseat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getThanhtoan() {
        return thanhtoan;
    }

    public void setThanhtoan(int thanhtoan) {
        this.thanhtoan = thanhtoan;
    }

    @Override
    public String toString() {
        return "Vexe{" + "vexeid=" + vexeid + ", chuyenxeid=" + chuyenxeid + ", chuyenxename=" + chuyenxename + ", tuyenxestart=" + tuyenxestart + ", tuyenxeend=" + tuyenxeend + ", timestart=" + timestart + ", numberofseat=" + numberofseat + ", price=" + price + ", thanhtoan=" + thanhtoan + '}';
    }

}
