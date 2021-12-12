/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Tuyenxe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class tuyenxeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Tuyenxe> getAllTuyenxe() {
        List<Tuyenxe> list = new ArrayList<>();
        String query = "SELECT * FROM tuyenxe";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Tuyenxe(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteTuyenxe(String tuyenxeid) {

        String query = "DELETE FROM tuyenxe WHERE tuyenxeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tuyenxeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertTuyenxe(String tuyenxename,
            String tuyenxestart,
            String tuyenxeend,
            String price) {
        String query = "INSERT INTO tuyenxe VALUES (0,?,?,?,?)";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tuyenxename);
            ps.setString(2, tuyenxestart);
            ps.setString(3, tuyenxeend);
            ps.setString(4, price);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Tuyenxe getTuyenxeByID(String tuyenxeid) {
        String query = "SELECT * FROM tuyenxe WHERE tuyenxeid = ?";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tuyenxeid);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Tuyenxe(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getString(3), 
                        rs.getString(4), 
                        rs.getDouble(5));
            }
        } catch (Exception e) {
        }

        return null;
    }
    
    public void updateTuyenxe(String tuyenxeid, String tuyenxename, 
            String tuyenxestart, String tuyenxeend, String price){
        String query = "UPDATE tuyenxe SET tuyenxename = ?, tuyenxestart = ?, "
                + "tuyenxeend = ?, price = ? WHERE tuyenxeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, tuyenxename);
            ps.setString(2, tuyenxestart);
            ps.setString(3, tuyenxeend);
            ps.setString(4, price);
            ps.setString(5, tuyenxeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }

}
