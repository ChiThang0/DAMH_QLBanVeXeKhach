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
public class chuyenxeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Chuyenxe> getAllchuyenxe() {

        List<Chuyenxe> list = new ArrayList<>();
        String query = "SELECT * FROM chuyenxe";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Chuyenxe(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getDate(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteChuyenxe(String chuyenxeid){
        String query = "DELETE FROM chuyenxe WHERE chuyenxeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertChuyenxe(String chuyenxename,
            String timestart,
            String tuyenxeid,
            String xeid,
            String userid) {
        String query = "INSERT INTO chuyenxe VALUES (0,?,?,?,?,?)";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxename);
            ps.setString(2, timestart);
            ps.setString(3, tuyenxeid);
            ps.setString(4, xeid);
            ps.setString(5, userid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Chuyenxe getChuyenxeByID(String chuyenxeid) {

        List<Chuyenxe> list = new ArrayList<>();
        String query = "SELECT * FROM chuyenxe WHERE chuyenxeid = ?";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxeid);
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Chuyenxe(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getDate(3), 
                        rs.getInt(4), 
                        rs.getInt(5), 
                        rs.getInt(6)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateChuyenXe(String chuyenxeid, String chuyenxename, 
            String timestart, String tuyenxeid, String xeid, String userid){
        String query = "UPDATE chuyenxe "
                + "SET chuyenxename = ?, timestart = ?, tuyenxeid = ?, xeid = ?, userid = ? "
                + "WHERE chuyenxeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxename);
            ps.setString(2, timestart);
            ps.setString(3, tuyenxeid);
            ps.setString(4, xeid);
            ps.setString(5, userid);
            ps.setString(6, chuyenxeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }

}
