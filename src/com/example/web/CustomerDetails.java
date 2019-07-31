package com.example.web;
import com.example.model.Retdata;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.example.model.Database;
import java.sql.*;
import java.io.PrintWriter;
import javax.mail.*;
import java.util.Date;
import java.util.Properties;
import javax.mail.internet.*;

public class CustomerDetails extends HttpServlet{


public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{


String firstname=request.getParameter("firstname");
String lastname=request.getParameter("lastname");
String gender=request.getParameter("gender");
String country=request.getParameter("country");
String mobileno=request.getParameter("mobileno");
String email=request.getParameter("email");
String documentoption=request.getParameter("document");
String documentno=request.getParameter("documentno");
int age=Integer.parseInt(request.getParameter("age"));
String address=request.getParameter("address");
 





try{

Database dobj=new Database();
Connection cobj=dobj.getConnection();

          


PreparedStatement pstmt=cobj.prepareStatement("insert into contact_info(NAME,AGE,ADDRESS,PHONE,EMAIL,COUNTRY,DOCUMENTNO,GENDER,DOCUMENTTYPE) values (?,?,?,?,?,?,?,?,?)");

          pstmt.setString(1,firstname+lastname);
	   pstmt.setInt(2, age);
          pstmt.setString(3, address);
          pstmt.setString(4, mobileno);
          pstmt.setString(5, email);
          pstmt.setString(6, country);
          pstmt.setString(7, documentno);
          pstmt.setString(8, gender);
          pstmt.setString(9, documentoption);
   
          
pstmt.execute();



}catch(SQLException sql){
sql.printStackTrace();
}

	HttpSession sessn=request.getSession(false);  
        ArrayList<Retdata> ret=(ArrayList<Retdata>)sessn.getAttribute("return");
	int index=(int)sessn.getAttribute("btn");
  






//send mail to the customer


	final String username = "khatiparaspk@gmail.com";
        final String password = "p@r@s123";

        Properties prop = new Properties();
	
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Successful Confimation");
            message.setText("Dear Customer,"
                    + "\n\n Confirmation has been successful!");

            Transport.send(message);

            System.out.println("Done");

         } catch (MessagingException e) {
            e.printStackTrace();
        }







}

}