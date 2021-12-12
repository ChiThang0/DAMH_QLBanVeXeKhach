/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.chuyenxeDAO;
import dao.tuyenxeDAO;
import dao.userDAO;
import dao.xeDAO;
import entity.Chuyenxe;
import entity.Tuyenxe;
import entity.User;
import entity.Xe;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updatechuyenxe", urlPatterns = {"/updatechuyenxe"})
public class updatechuyenxe extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try ( PrintWriter out = response.getWriter()) {

            //b1: get data từ tuyenxeDAO
            tuyenxeDAO dao = new tuyenxeDAO();
            List<Tuyenxe> list = dao.getAllTuyenxe();

            xeDAO xdao = new xeDAO();
            List<Xe> listx = xdao.getAllXe();

            userDAO udao = new userDAO();
            List<User> listu = udao.getAllDriver();

            //b2: set data đến jsp
            request.setAttribute("listC", list);
            request.setAttribute("listX", listx);
            request.setAttribute("listU", listu);
            request.getRequestDispatcher("createchuyenxe.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        tuyenxeDAO tdao = new tuyenxeDAO();
        List<Tuyenxe> list = tdao.getAllTuyenxe();
        xeDAO xdao = new xeDAO();
        List<Xe> listx = xdao.getAllXe();
        userDAO udao = new userDAO();
        List<User> listu = udao.getAllDriver();
        request.setAttribute("listX", listx);
        request.setAttribute("listU", listu);
        request.setAttribute("listC", list);

        String chuyenxeid = request.getParameter("chuyenxeid");
        chuyenxeDAO dao = new chuyenxeDAO();
        Chuyenxe c = dao.getChuyenxeByID(chuyenxeid);
        request.setAttribute("chuyenxe", c);
        request.getRequestDispatcher("updatechuyenxe.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String chuyenxeid = request.getParameter("chuyenxeid");
        String chuyenxename = request.getParameter("chuyenxename");
        String timestart = request.getParameter("timestart");
        String tuyenxeid = request.getParameter("tuyenxeid");
        String xeid = request.getParameter("xeid");
        String userid = request.getParameter("userid");

        chuyenxeDAO dao = new chuyenxeDAO();
        dao.updateChuyenXe(chuyenxeid, chuyenxename, timestart, tuyenxeid, xeid, userid);
        response.sendRedirect("chuyenxe");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
