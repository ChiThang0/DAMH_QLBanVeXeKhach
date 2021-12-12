/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.tuyenxeDAO;
import dao.userDAO;
import dao.xeDAO;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Chuyenxe {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    private int chuyenxeid;
    private String chuyenxename;
    private Date timestart;
    private int tuyenxeid;
    private int xeid;
    private int userid;
    private String tuyenxename;
    private String tuyenxestart;
    private String tuyenxeend;
    private double price;
    private String xenumber;
    private int numberofseat;
    private String username;

    public Chuyenxe() {
    }

    public Chuyenxe(int chuyenxeid, String chuyenxename, Date timestart, int tuyenxeid, int xeid, int userid) {
        this.chuyenxeid = chuyenxeid;
        this.chuyenxename = chuyenxename;
        this.timestart = timestart;
        this.tuyenxeid = tuyenxeid;
        this.xeid = xeid;
        this.userid = userid;
        
        tuyenxeDAO dao = new tuyenxeDAO();
        Tuyenxe t = new Tuyenxe();
        xeDAO xedao = new xeDAO();
        Xe x = new Xe();
        userDAO userdao = new userDAO();
        User u = new User();

        try {
            t = dao.getTuyenxeByID(String.valueOf(tuyenxeid));
            setTuyenxename(t.getTuyenxename());
            setTuyenxestart(t.getTuyenxestart());
            setTuyenxeend(t.getTuyenxeend());
            setPrice(t.getPrice());

            x = xedao.getXeByID(xeid);
            setXenumber(x.getXenumber());
            setNumberofseat(x.getNumofseat());

            u = userdao.getUserByID(userid);
            setUsername(u.getUsername());
        } catch (Exception e) {
        }

    }

    public Chuyenxe(int chuyenxeid, String chuyenxename, String timestart, int tuyenxeid, int xeid, int userid) {
        this.chuyenxeid = chuyenxeid;
        this.chuyenxename = chuyenxename;
        try {
            this.timestart = formatter.parse(timestart);
        } catch (ParseException ex) {
            Logger.getLogger(Chuyenxe.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tuyenxeid = tuyenxeid;
        this.xeid = xeid;
        this.userid = userid;
        
        tuyenxeDAO dao = new tuyenxeDAO();
        Tuyenxe t = new Tuyenxe();
        xeDAO xedao = new xeDAO();
        Xe x = new Xe();
        userDAO userdao = new userDAO();
        User u = new User();

        try {
            t = dao.getTuyenxeByID(String.valueOf(tuyenxeid));
            setTuyenxename(t.getTuyenxename());
            setTuyenxestart(t.getTuyenxestart());
            setTuyenxeend(t.getTuyenxeend());
            setPrice(t.getPrice());

            x = xedao.getXeByID(xeid);
            setXenumber(x.getXenumber());
            setNumberofseat(x.getNumofseat());

            u = userdao.getUserByID(userid);
            setUsername(u.getUsername());
        } catch (Exception e) {
        }
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

    public Date getTimestart() {
        return timestart;
    }

    public void setTimestart(Date timestart) {
        this.timestart = timestart;
    }

    public int getTuyenxeid() {
        return tuyenxeid;
    }

    public void setTuyenxeid(int tuyenxeid) {
        this.tuyenxeid = tuyenxeid;
    }

    public int getXeid() {
        return xeid;
    }

    public void setXeid(int xeid) {
        this.xeid = xeid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
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

    public String getXenumber() {
        return xenumber;
    }

    public void setXenumber(String xenumber) {
        this.xenumber = xenumber;
    }

    public int getNumberofseat() {
        return numberofseat;
    }

    public void setNumberofseat(int numberofseat) {
        this.numberofseat = numberofseat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTuyenxename() {
        return tuyenxename;
    }

    public void setTuyenxename(String tuyenxename) {
        this.tuyenxename = tuyenxename;
    }

    @Override
    public String toString() {
        return "Chuyenxe{" + "chuyenxeid=" + chuyenxeid + ", chuyenxename=" + chuyenxename + ", timestart=" + timestart + ", tuyenxeid=" + tuyenxeid + ", xeid=" + xeid + ", userid=" + userid + '}';
    }

}
