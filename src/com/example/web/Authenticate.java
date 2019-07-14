package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.example.model.*;
import java.sql.*; 

public class Authenticate extends HttpServlet {

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

PrintWriter out=response.getWriter();

out.println("ok works nigger");   

Database dobj=new Database();
Connection cobj=null;
try{
cobj=dobj.getConnection();
Statement stmt=cobj.createStatement();



}catch(SQLException ex){
out.println("exception occured");
}

        
if(cobj!=null){
try{
cobj.close();
       
}catch(SQLException se){
se.printStackTrace();
}           
}
}
}