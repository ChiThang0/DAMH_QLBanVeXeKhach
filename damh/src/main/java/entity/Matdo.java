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
public class Matdo {
    
    private int tuyenxeid;
    private String tuyenxename;
    private int soluongchuyen;

    public Matdo() {
    }

    public Matdo(int tuyenxeid, String tuyenxename, int soluongchuyen) {
        this.tuyenxeid = tuyenxeid;
        this.tuyenxename = tuyenxename;
        this.soluongchuyen = soluongchuyen;
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

    public int getSoluongchuyen() {
        return soluongchuyen;
    }

    public void setSoluongchuyen(int soluongchuyen) {
        this.soluongchuyen = soluongchuyen;
    }

    @Override
    public String toString() {
        return "Matdo{" + "tuyenxeid=" + tuyenxeid + ", tuyenxename=" + tuyenxename + ", soluongchuyen=" + soluongchuyen + '}';
    }
    
}
