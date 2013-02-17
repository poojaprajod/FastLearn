
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class edit_faculty_view extends HttpServlet {
  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
          Connection conn = null;
          Statement stmt = null;
          ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select faculty_id,first_name,last_name from faculty"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EDIT FACULTY</title>");  
            out.println("</head>");
            out.println("<body>");
            List errors=(LinkedList) request.getAttribute("errors"); 
            if(errors !=null){
            Iterator item= errors.iterator(); 
            out.println("<ul>");
             while(item.hasNext()){
            String msg=(String) item.next();
            out.println("<li>"+msg+"</li");
            }
             out.println("</ul>");}
            out.println("<h3> SELECT FACULTY TO BE EDITED </h3>");
            out.println("<form action='edit_faculty.do' method='POST'>");
            out.println("<select name='id'>");
            while(ex.next()){
                String val=ex.getString("faculty_id")+"  "+ex.getString("first_name")+"  "+ex.getString("last_name");
            out.println("<option value="+ex.getString("faculty_id") +">"+val+"</option>");
            }
            out.println("</select>");
            out.println("<select name='feild'>");
            out.println("<option value = 'course_id' >COURSE</option>");
            out.println("<option value = 'centre_id' >CENTRE</option>");
            out.println("<option value = 'phone' >PHONE</option>");
            out.println("<option value = 'address' >ADDRESS</option>");
            out.println("</select>");
            out.println(" New value : <input type='text' name='value' /><br />");
            out.println("<input type='submit' value='GO'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }catch(SQLException s){
            
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
