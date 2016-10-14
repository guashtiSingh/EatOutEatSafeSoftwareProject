package conf;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {
	 private static final String  MYSQL_DRIVER  = "com.mysql.jdbc.Driver";
	 private static final String  MYSQL_URL  = "jdbc:mysql://127.0.0.1:3306/eoes?useUnicode=true&characterEncoding=UTF8";
	 private static final String  MYSQL_USER  = "root";
	 private static final String  MYSQL_PASSWD  = "qwe123";
	 
	 
	 public dbConnection() throws Exception{
		 try{
			 Class.forName(MYSQL_DRIVER);
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
		 }
	 }
		 
	 public Connection getConnection() throws Exception{
		 Connection con = null;
		 
		 try{
			 con = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWD);
		 } catch (Exception e) {
			 System.out.println(e.getMessage());
		 } 

		 return con;
		 
	 }
}
