
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class student_profile extends HttpServlet {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id=request.getParameter("id");
        Connection conn = null;
        ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select * from student where student_id=? "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,id);

      ex = pst.executeQuery();
      boolean next = ex.next();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
 
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>PROFILE</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style='text-align:centre'>PROFILE</h1></br>");
            out.println(" ** In case of any errors report to admin immmediately");
            out.println("</br> </br>");
            out.println("Name :   <strong>"+ex.getString("first_name")+"  "+ex.getString("last_name")+"</strong>");
            out.println("</br></br>");
            out.println("ID  :  <strong>"+ex.getString("student_id")+"</strong>");
            out.println("</br></br> ");
            out.println("Course ID :  <strong>"+ex.getString("course_id")+"</strong>");
            out.println("</br></br>");
            out.println("Centre ID :  <strong>"+ex.getString("centre_id")+"</strong>");
            out.println("</br></br>");
            out.println("Faculty ID :  <strong>"+ex.getString("faculty_id")+"</strong>");
            out.println("</br></br>");
            out.println("Address :  <strong>"+ex.getString("address")+"</strong>");
            out.println("</br></br>");
            out.println("Phone :  <strong>"+ex.getString("phone")+"</strong>");
            out.println("</br></br>");
            out.println("</br>");
            out.println("</br>");
            out.println("YOUR STUDY MATERIAL IS AVAILABLE <a href='"+ex.getString("course_id")+".html'> HERE </a>");
            out.println("</body>");
            out.println("</html>");
       
        } catch (SQLException ex1) {
            ex1.printStackTrace();
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
