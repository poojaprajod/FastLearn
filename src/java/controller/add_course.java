
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

public class add_course extends HttpServlet {
   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List errors=new LinkedList();
        String id=request.getParameter("course_id").trim();
        String name=request.getParameter("name").trim();
        String prerequisite=request.getParameter("prerequisite").trim(); 
        String f=request.getParameter("fee").trim();
        String d=request.getParameter("duration").trim();
        float fee=Float.parseFloat(f);
        int duration=Integer.parseInt(d);
        if (id.length()!=5){
            errors.add("INCORRECT ID");
        }
         Connection conn = null;
          Statement stmt = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "insert into course(course_id,name,fee,prerequisite,duration) values (?,?,?,?,?)"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,id);
      pst.setString(2,name);
      pst.setFloat(3, fee);
      pst.setString(4,prerequisite);
      pst.setInt(5, duration);
      int ex = pst.executeUpdate();
     }catch(SQLException se){
       errors.add(se.getMessage());
   }catch(Exception e){
      errors.add(e.getMessage());
   }
     if (!errors.isEmpty()){
         request.setAttribute("errors", errors);
         RequestDispatcher v=request.getRequestDispatcher("add_course.jsp");
         v.forward(request, response);
         return;
     }        
        RequestDispatcher v=request.getRequestDispatcher("success.jsp?page=add_course");
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
