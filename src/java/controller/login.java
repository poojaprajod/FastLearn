
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class login extends HttpServlet {
   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        List errors=new LinkedList();
        String user=request.getParameter("user");
        String pass=request.getParameter("pass");
        Connection conn = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select * from login where id=? and password=?"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,user);
      pst.setString(2,pass);
      ResultSet ex = pst.executeQuery();
      if (!ex.next()){
          errors.add("INCORRECT USERNAME OR PASSWORD");
      }
      else{
          String bl=ex.getString(3);
          String temp="yes";
          if (bl.equals(temp)){
          errors.add("You are blocked...contact admin soon");
          }
      }
     }catch(SQLException se){
       errors.add(se.getMessage());
   }catch(Exception e){
      errors.add(e.getMessage());
   }
     if (!errors.isEmpty()){
         request.setAttribute("errors", errors);
         RequestDispatcher v=request.getRequestDispatcher("login.jsp");
         v.forward(request, response);
         return;
     }  
        
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>LOGGED</title>");  
            out.println("</head>");
            out.println("<body>");
            if(user.matches("S\\d\\d\\d\\d")){
                 RequestDispatcher v=request.getRequestDispatcher("student_actions.jsp?id="+user);
                  v.forward(request, response);
            }
            if(user.matches("A\\d\\d\\d\\d")){
                 RequestDispatcher v=request.getRequestDispatcher("admin_actions.jsp");
                  v.forward(request, response);
            }
            if(user.matches("F\\d\\d\\d\\d")){
                 RequestDispatcher v=request.getRequestDispatcher("faculty_actions.jsp?id="+user);
                  v.forward(request, response);
            }
            out.println("</body>");
            out.println("</html>");
            
        } finally {            
            out.close();
        }
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
