/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.chuyenxeDAO;
import dao.tuyenxeDAO;
import dao.vexeDAO;
import entity.Chuyenxe;
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
@WebServlet(name = "createvexe", urlPatterns = {"/createvexe"})
public class createvexe extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            chuyenxeDAO dao = new chuyenxeDAO();
            List<Chuyenxe> list = dao.getAllchuyenxe();
            
            request.setAttribute("listV", list);
            request.getRequestDispatcher("createvexe.jsp").forward(request, response);
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
        chuyenxeDAO dao = new chuyenxeDAO();
        List<Chuyenxe> list = dao.getAllchuyenxe();
        
        request.setAttribute("listV", list);
        request.getRequestDispatcher("createvexe.jsp").forward(request, response);
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
        //processRequest(request, response);
        String vexeid = request.getParameter("vexeid");
        String chuyenxeid = request.getParameter("chuyenxeid");
        String numberofseat = request.getParameter("numberofseat");
        String thanhtoan = request.getParameter("thanhtoan");

        vexeDAO dao = new vexeDAO();
        dao.insertVexe(vexeid, chuyenxeid, numberofseat, thanhtoan);
        response.sendRedirect("vexe");
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
