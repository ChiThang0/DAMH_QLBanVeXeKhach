/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Thongke;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class thongkeDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Thongke> getByYear(String year) {

        List<Thongke> list = new ArrayList<>();
        String query = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and year(timestart) = ? "
                + "group by tuyenxe.tuyenxeid;";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Thongke(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Thongke> getByMonth(String month, String year) {

        List<Thongke> list = new ArrayList<>();
        String query = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and month(timestart) = ? "
                + "and year(timestart) = ?"
                + "group by tuyenxe.tuyenxeid;";

        try {
            conn = new DBContext().Getconnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, month);
            ps.setString(2, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Thongke(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5)));
            }
        } catch (Exception e) {
        }

        return list;
    }

    public List<Thongke> getByQuy(String quy, String year) {

        List<Thongke> list = new ArrayList<>();
        
        String q1 = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and month(timestart) >= 1 and month(timestart) <= 3 "
                + "and year(timestart) = ?"
                + "group by tuyenxe.tuyenxeid";
        String q2 = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and month(timestart) >= 4 and month(timestart) <= 6 "
                + "and year(timestart) = ?"
                + "group by tuyenxe.tuyenxeid";
        String q3 = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and month(timestart) >= 7 and month(timestart) <= 9 "
                + "and year(timestart) = ?"
                + "group by tuyenxe.tuyenxeid";
        String q4 = "SELECT tuyenxe.tuyenxeid, "
                + "tuyenxe.tuyenxename, "
                + "count(vexe.vexeid) as sove, "
                + "tuyenxe.price as price, "
                + "(count(vexe.vexeid) * tuyenxe.price) as doanhthu "
                + "FROM chuyenxe join tuyenxe on chuyenxe.tuyenxeid = tuyenxe.tuyenxeid "
                + "join vexe on chuyenxe.chuyenxeid = vexe.chuyenxeid "
                + "WHERE vexe.thanhtoan = 1 and month(timestart) >= 10 and month(timestart) <= 12 "
                + "and year(timestart) = ?"
                + "group by tuyenxe.tuyenxeid";
        

        try {
            conn = new DBContext().Getconnection();
            if(null != quy)switch (quy) {
                case "1":
                    ps = conn.prepareStatement(q1);
                    break;
                case "2":
                    ps = conn.prepareStatement(q2);
                    break;
                case "3":
                    ps = conn.prepareStatement(q3);
                    break;
                case "4":
                    ps = conn.prepareStatement(q4);
                    break;
                default:
                    break;
            }
            
            ps.setString(1, year);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Thongke(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getDouble(4),
                        rs.getDouble(5)));
            }
        } catch (Exception e) {
        }

        return list;
    }

}
