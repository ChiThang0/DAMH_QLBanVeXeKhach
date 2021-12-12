/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Vexe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class vexeDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Vexe> getAllVexe() {

        List<Vexe> list = new ArrayList<>();
        String query = "SELECT * FROM vexe";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Vexe(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public void deleteVexe(String vexeid){
        String query = "DELETE FROM vexe WHERE vexeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, vexeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertVexe(String vexeid, String chuyenxeid, String numberofseat, String thanhtoan) {
        String query = "INSERT INTO vexe VALUES (0, ?, ?, ?)";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxeid);
            ps.setString(2, numberofseat);
            ps.setString(3, thanhtoan);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public Vexe getVexeByID(String vexeid) {

        List<Vexe> list = new ArrayList<>();
        String query = "SELECT * FROM vexe WHERE vexeid = ?";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, vexeid);
            rs = ps.executeQuery();
            while(rs.next()){
                return(new Vexe(rs.getInt(1), 
                        rs.getInt(2), 
                        rs.getInt(3), 
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public void updateVeXe(String vexeid, String chuyenxeid, String numberofseat, String thanhtoan){
        String query = "UPDATE vexe "
                + "SET chuyenxeid = ?, numberofseat = ?, thanhtoan = ?"
                + "WHERE vexeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, chuyenxeid);
            ps.setString(2, numberofseat);
            ps.setString(3, thanhtoan);
            ps.setString(4, vexeid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        
    }
    
}
