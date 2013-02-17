
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class add_faculty_view extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ADD STUDENT</title>");  
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
             out.println("</ul>");
          }
      out.println("<p style='color:green;text-align:center'>Enter details of student to be added</p>");
      out.println("<form action='add_faculty.do' method='POST'>");
         out.println(" Faculty ID (5 character): <input type='text' name='faculty_id' /><br />");
         out.println(" First name: <input type='text' name='first_name' /><br />");
         out.println(" Last name: <input type='text' name='last_name' /><br />");
         out.println("Course ID (5 character): <input type='text' name='course_id' /><br />");
         out.println("Centre ID (5 character): <input type='text' name='centre_id' /><br />");
         out.println("Phone : <input type='text' name='phone' /><br />");
         out.println("Address : <input type='text' name='address' /><br />");
         out.println(" <input type='submit' value='SUBMIT' />");
     out.println("</form>");
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
