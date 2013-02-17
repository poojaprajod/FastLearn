
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class reset_password_view extends HttpServlet {
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
      String sql = "select id from login"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RESET PASSWORD</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> SELECT ID TO BE UNBLOCKED </h3>");
            out.println("<form action='reset_password.do' method='POST'>");
            out.println("<select name='id'>");
            while(ex.next()){
                String val=ex.getString("id");
            out.println("<option value="+val +">"+val+"</option>");
            }
            out.println("</select>");
            out.println(" New Password: <input type='text' name='pass' /><br />");
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
