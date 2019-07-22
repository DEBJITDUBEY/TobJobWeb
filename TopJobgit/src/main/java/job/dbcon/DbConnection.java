	package job.dbcon;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DbConnection {
	 public Connection getConnection() throws Exception{
	  Class.forName("com.mysql.cj.jdbc.Driver"); 
	  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
	  return connection;
	 }
	}


