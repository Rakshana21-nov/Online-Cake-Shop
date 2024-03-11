package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import models.RegisterModel;

public class SignupController {
	String name,pass,phone;
	String dbUrl="jdbc:mysql://localhost:3306/customer";
    String dbUname="root";
    String dbPassword="";
    String dbDriver="com.mysql.cj.jdbc.Driver";
    RegisterModel rm;
	public SignupController(RegisterModel rm){
		this.rm=rm;
	}
	public void toStore(){
		Connection con = null;
   		try{
   			Class.forName(dbDriver);  //class not found exception
 			con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception
 			String sql = "insert into batch2 (username,email,password,phone)"
 					+ "values('"+rm.getName()+"','"+rm.getEmail()+"','"+rm.getPass()+"','"+rm.getPhone()+"')";
 			Statement s = con.createStatement();
 			s.execute(sql);
 		   	con.close();
		 }catch(Exception e){      
			e.printStackTrace();
		 }
	
	
	
	}

}
