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
public class User {
    
    private int userid;
    private String username;
    private String userphone;
    private String useraccount;
    private String userpassword;
    private int isadmin;
    private int issell;
    private int isdriver;

    public User() {
    }

    public User(int userid, String username, String userphone, String useraccount, String userpassword, int isadmin, int issell, int isdriver) {
        this.userid = userid;
        this.username = username;
        this.userphone = userphone;
        this.useraccount = useraccount;
        this.userpassword = userpassword;
        this.isadmin = isadmin;
        this.issell = issell;
        this.isdriver = isdriver;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public int getIssell() {
        return issell;
    }

    public void setIssell(int issell) {
        this.issell = issell;
    }

    public int getIsdriver() {
        return isdriver;
    }

    public void setIsdriver(int isdriver) {
        this.isdriver = isdriver;
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", username=" + username + ", userphone=" + userphone + ", useraccount=" + useraccount + ", userpassword=" + userpassword + ", isadmin=" + isadmin + ", issell=" + issell + ", isdriver=" + isdriver + '}';
    }
    
}
