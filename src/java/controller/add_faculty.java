
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.LinkedList;
import java.sql.*;
import javax.servlet.RequestDispatcher;


public class add_faculty extends HttpServlet {
       final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List errors=new LinkedList();
        String faculty_id=request.getParameter("faculty_id").trim();
        String course_id=request.getParameter("course_id").trim();
        String centre_id=request.getParameter("centre_id").trim();
        String fname=request.getParameter("first_name").trim();
        String lname=request.getParameter("last_name").trim();
        String f=request.getParameter("phone").trim();
        String address=request.getParameter("address").trim();
        long phone=Long.parseLong(f);
        
        if (course_id.length()!=5){
            errors.add("INCORRECT Course ID");
        }
        if (faculty_id.length()!=5){
            errors.add("INCORRECT Faculty ID");
        }
        if (centre_id.length()!=5){
            errors.add("INCORRECT Centre ID");
        }
        
         Connection conn = null;
          Statement stmt = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      conn.setAutoCommit(false);
      String sql = "insert into faculty(faculty_id,first_name,last_name,course_id,centre_id,phone,address) values (?,?,?,?,?,?,?)"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,faculty_id);
      pst.setString(2,fname);
      pst.setString(3,lname);
      pst.setString(4,course_id);
      pst.setString(5,centre_id);
      pst.setLong(6, phone);
      pst.setString(7,address);
      int ex = pst.executeUpdate();
      sql = "insert into login(id,password,blocked) values (?,?,'no')"; 
      pst =  conn.prepareStatement(sql);
      pst.setString(1,faculty_id);
      pst.setString(2,faculty_id);
      ex = pst.executeUpdate();
      conn.commit();
     }catch(SQLException se){
       errors.add(se.getMessage());
   }catch(Exception e){
      errors.add(e.getMessage());
   }
     if (!errors.isEmpty()){
         request.setAttribute("errors", errors);
         RequestDispatcher v=request.getRequestDispatcher("add_faculty.jsp");
         v.forward(request, response);
         return;
     }        
       RequestDispatcher v=request.getRequestDispatcher("success.jsp?page=add_faculty");
         v.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
