/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Chuyenxe;
import entity.Tuyenxe;
import entity.User;
import entity.Xe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class userDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public User getUserByID(int userid) {

        String query = "SELECT * FROM user WHERE userid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }

        } catch (Exception e) {
        }
        return null;
    }
    
    public List<User> getAllUser() {
        
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    public List<User> getAllDriver() {
        
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user WHERE user.isdriver = 1";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8)));
            }

        } catch (Exception e) {
        }
        return list;
    }
    
    public User login(String useraccount, String userpassword){
        
        String query = "SELECT * FROM user WHERE useraccount = ? and userpassword = ? "
                + "and (isadmin = 1 or issell = 1)";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, useraccount);
            ps.setString(2, userpassword);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8));
            }

        } catch (Exception e) {
        }
        return null;
        
    }

}
