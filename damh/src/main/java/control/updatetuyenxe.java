/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.tuyenxeDAO;
import entity.Tuyenxe;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "updatetuyenxe", urlPatterns = {"/updatetuyenxe"})
public class updatetuyenxe extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updatetuyenxe</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatetuyenxe at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String tuyenxeid = request.getParameter("tuyenxeid");
        tuyenxeDAO dao = new tuyenxeDAO();
        Tuyenxe t = dao.getTuyenxeByID(tuyenxeid);
        request.setAttribute("tuyenxe", t);
        request.getRequestDispatcher("updatetuyenxe.jsp").forward(request, response);

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
        String tuyenxeid = request.getParameter("tuyenxeid");
        String tuyenxename = request.getParameter("tuyenxename");
        String tuyenxestart = request.getParameter("tuyenxestart");
        String tuyenxeend = request.getParameter("tuyenxeend");
        String price = request.getParameter("price");
        
        tuyenxeDAO dao = new tuyenxeDAO();
        dao.updateTuyenxe(tuyenxeid, tuyenxename, tuyenxestart, tuyenxeend, price);
        response.sendRedirect("tuyenxe");
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
