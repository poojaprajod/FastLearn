package controller;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class initial extends HttpServlet {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

            Connection conn = null;
            Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql = "create table if not exists student (student_id char(5) unique,first_name varchar(20),last_name varchar(20),course_id char(5),faculty_id char(5),centre_id char(5),phone bigint(11),address varchar(75));"; 
      boolean ex = stmt.execute(sql);
      sql = "create table if not exists faculty (faculty_id char(5) unique,first_name varchar(20),last_name varchar(20),course_id char(5),centre_id char(5),phone bigint(11),address varchar(75));"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists course (course_id char(5) unique,name varchar(20),fee double(8,2),prerequisite varchar(50),duration integer(2));"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists centre (centre_id char(5) unique,name varchar(20),location varchar(20));"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists faq (query_id integer(8) not null auto_increment primary key,query varchar(1000),solution varchar(1000),query_date date,solution_date date);"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists feedback (feed_id integer(8) not null auto_increment primary key,feed varchar(1000),feed_date date);"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists login (id char(5),password varchar(20),blocked varchar(3));"; 
      ex = stmt.execute(sql);
      sql = "create table if not exists notice (message varchar(1000),message_date date);"; 
      ex = stmt.execute(sql);
      sql = "insert into login(id,password) values ('A0001','A0001');"; 
      ex = stmt.execute(sql);
      }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }
  RequestDispatcher v=request.getRequestDispatcher("success.jsp?page=initial");
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
