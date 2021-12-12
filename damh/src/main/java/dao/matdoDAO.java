/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Matdo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class matdoDAO {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<Matdo> getMatDoMonth(String month, String year) {

        List<Matdo> list = new ArrayList<>();
        String query = "SELECT tuyenxe.tuyenxeid, tuyenxe.tuyenxename, "
                + "count(chuyenxe.chuyenxeid) as sochuyen "
                + "FROM chuyenxe join tuyenxe "
                + "on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "WHERE month(timestart) = ? and year(timestart) = ? "
                + "group by tuyenxe.tuyenxeid";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, month);
            ps.setString(2, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Matdo(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    
    public List<Matdo> getMatDoYear(String year) {

        List<Matdo> list = new ArrayList<>();
        String query = "SELECT tuyenxe.tuyenxeid, tuyenxe.tuyenxename, "
                + "count(chuyenxe.chuyenxeid) as sochuyen "
                + "FROM chuyenxe join tuyenxe "
                + "on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "WHERE year(timestart) = ? "
                + "group by tuyenxe.tuyenxeid";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Matdo(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }

        return list;
    }
    
    public int getTongchuyentheonam(String year){
        int sum = 0;
        List<Matdo> list = new ArrayList<>();
        list = matdoDAO.this.getMatDoYear(year);
        for (Matdo matdo : list) {
            sum += matdo.getSoluongchuyen();
        }
        return sum;
    }
    public int getTongchuyentheothang(String month, String year){
        int sum = 0;
        List<Matdo> list = new ArrayList<>();
        list = matdoDAO.this.getMatDoMonth(month, year);
        for (Matdo matdo : list) {
            sum += matdo.getSoluongchuyen();
        }
        return sum;
    }
    
}
