/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
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
public class xeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Xe getXeByID(int xeid) {

        List<Xe> list = new ArrayList<>();
        String query = "SELECT * FROM xe WHERE xeid = ?";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, xeid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return(new Xe(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Xe> getAllXe() {
        
        List<Xe> list = new ArrayList<>();
        String query = "SELECT * FROM xe";
        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Xe(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }

        } catch (Exception e) {
        }
        return list;
    }
}
