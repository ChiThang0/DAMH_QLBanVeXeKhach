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
public class Xe {
    
    private int xeid;
    private String xename;
    private String xenumber;
    private int numofseat;

    public Xe() {
    }

    public Xe(int xeid, String xename, String xenumber, int numofseat) {
        this.xeid = xeid;
        this.xename = xename;
        this.xenumber = xenumber;
        this.numofseat = numofseat;
    }

    public int getXeid() {
        return xeid;
    }

    public void setXeid(int xeid) {
        this.xeid = xeid;
    }

    public String getXename() {
        return xename;
    }

    public void setXename(String xename) {
        this.xename = xename;
    }

    public String getXenumber() {
        return xenumber;
    }

    public void setXenumber(String xenumber) {
        this.xenumber = xenumber;
    }

    public int getNumofseat() {
        return numofseat;
    }

    public void setNumofseat(int numofseat) {
        this.numofseat = numofseat;
    }

    @Override
    public String toString() {
        return "Xe{" + "xeid=" + xeid + ", xename=" + xename + ", xenumber=" + xenumber + ", numofseat=" + numofseat + '}';
    }
    
    
}
