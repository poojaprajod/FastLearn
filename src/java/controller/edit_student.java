
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;


public class edit_student extends HttpServlet {
   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List errors=new LinkedList();
        String id=request.getParameter("id").trim();
        String feild=request.getParameter("feild").trim();
        String value=request.getParameter("value").trim();
        Connection conn = null;
        if (feild.equals("centre_id")||feild.equals("faculty_id")||feild.equals("course_id")){
        if (value.length()!=5){
            errors.add("INCORRECT Course ID");
        }}
      
      if (!errors.isEmpty()){
         request.setAttribute("errors", errors);
         RequestDispatcher v=request.getRequestDispatcher("edit_student.jsp");
         v.forward(request, response);
         return;
     }        
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "update student set "+feild+"="+"? where student_id=?" ;
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,value);
      pst.setString(2, id);
       if(feild.equals("phone")){
           long val=Long.parseLong(value);
           pst.setLong(1,val);
       }
      int ex = pst.executeUpdate();
      }catch(SQLException se){
       errors.add(se.getMessage());
   }catch(Exception e){
       e.getMessage();
   }
RequestDispatcher v=request.getRequestDispatcher("success.jsp?page=edit_student");
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