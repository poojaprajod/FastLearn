
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


public class change_password extends HttpServlet {
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List err=new LinkedList();
        String user=request.getParameter("user");
        String oldpass=request.getParameter("oldpass");
        String pass=request.getParameter("pass");
        Connection conn = null;
        
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select * from login where id=? and password=?"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,user);
      pst.setString(2,oldpass);
      ResultSet ex = pst.executeQuery();
      if (!ex.next()){
          err.add("INCORRECT USERNAME OR PASSWORD");
      }
      else{
          String bl=ex.getString("blocked");
          String temp="yes";
          if (bl.equals(temp)){
          err.add("you are blocked...contact admin soon");
          }
          
      }
     }catch(SQLException se){
       err.add(se.getMessage());
   }catch(Exception e){
          err.add(e.getMessage());
   }
    if (!err.isEmpty()){
         request.setAttribute("errors", err);
         RequestDispatcher v=request.getRequestDispatcher("change_password.jsp?id="+request.getParameter("id"));
         v.forward(request, response);
         return;
     }  
     
            
            try {
                Class.forName("com.mysql.jdbc.Driver");
          
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                String sql = "update login set password=?,blocked='no' where id=? "; 
                PreparedStatement pst =  conn.prepareStatement(sql);
                pst.setString(1,pass);
                pst.setString(2,user);
                int nex = pst.executeUpdate();
            } catch (SQLException ex) {
            }catch (Exception e){
                
            }
         
         RequestDispatcher nv=request.getRequestDispatcher("login.jsp");
         nv.forward(request, response);
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