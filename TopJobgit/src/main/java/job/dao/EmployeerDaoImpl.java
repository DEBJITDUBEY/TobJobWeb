package job.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import job.model.PostedJob;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import job.dbcon.DbConnection;
import job.model.Employeer;
import job.model.Mail;
import job.model.Schemes;




public class EmployeerDaoImpl {
	public   boolean makeEmployerRegistration(Employeer employeer) {
		boolean status=false;
		try {
			Connection con= new DbConnection().getConnection();
			PreparedStatement smt = con.prepareStatement("insert into employeer (email,pwd,mob,Rname,Cname,industryname,designation,employeertype,GSTNO,office_address,city,pin,country,office_number,Government_id,Employee_id_number) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			smt.setString(1,employeer.getEmail());
			smt.setString(2,employeer.getPwd());
			smt.setString(3,employeer.getMobile());
			smt.setString(4,employeer.getRegistername());
			smt.setString(5,employeer.getCompanyname());
			smt.setString(6,employeer.getIndustryname());
			smt.setString(7,employeer.getDesignation());
			smt.setString(8,employeer.getType());
			smt.setString(9,employeer.getGSTNO());
			smt.setString(10,employeer.getOfficeAdrress());
			smt.setString(11,employeer.getCity());
			smt.setString(12,employeer.getPin());
			smt.setString(13,employeer.getCountry());
			smt.setString(14,employeer.getOfficenumber());
			smt.setString(15,employeer.getGovid());
			smt.setString(16,employeer.getEmpid());
			
			
			int result = smt.executeUpdate();
			
			System.out.println("Result:"+result);
			con.close();
			if(result>0)
				status=true;
			}
					catch(Exception e) {
						System.out.println("error"+e.getMessage());  
					}
		return status;
	}

public String makeUsersLogin(Employeer employer) {
	String status=null;
	try {
		Connection con= new DbConnection().getConnection();
		PreparedStatement smt = con.prepareStatement("select * from employeer where email=? and pwd=?");
		smt.setString(1,employer.getEmail());
		smt.setString(2, employer.getPwd());
		ResultSet result = smt.executeQuery();
		if(result.next())
			status=result.getString(16);
		
		con.close();
		}
	catch(Exception e) {
		System.out.println(e);  
		}
	return status;
}

	public   boolean makeEmployerSchemeRegistration(String emailid, Schemes schemes) {
		boolean status=false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			String sql="update employeer set Scheme_id=?,Scheme_Duration=?,Prchasing_Date=current_date,End_Date=adddate(current_date,interval "+ schemes.getDuration() +" day),status_scheme='T' where email=?";
			PreparedStatement smt1=con.prepareStatement(sql);
			smt1.setString(1,schemes.getSchemeid());
			smt1.setInt(2,schemes.getDuration());
			//smt.setInt(3, duration);
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
			Date curdate=new Date();
			
			//smt.setString(1,sdf.format(curdate));
			smt1.setString(3,emailid);
			int row= smt1.executeUpdate();
			System.out.println(row);
			con.close();
			if(row>0)
				status=true;
			}
		catch(Exception e) {
		    System.out.println("error"+e.getMessage());  
		}
		return status;
	}

	public   boolean checkEmployeerValidity(String emailid) {
		boolean status=false;
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			String sql="select * from employeer where email=? and status_scheme='T' and end_date>=current_date()";
			PreparedStatement smt1=con.prepareStatement(sql);
			smt1.setString(1,emailid);
			ResultSet row= smt1.executeQuery();
			if(row.next())
				status=true;
			con.close();
			
			}
		catch(Exception e) {
		    System.out.println("error"+e.getMessage());  
		}
		return status;
	}

  public void MailSender(Mail mail) {
	  final String username = "topjobasansol@gmail.com";
      final String password = "1234@5678";

      Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.port", "587");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.starttls.enable", "true");
      
      Session session = Session.getInstance(prop,
              new javax.mail.Authenticator() {
                  protected PasswordAuthentication getPasswordAuthentication() {
                      return new PasswordAuthentication(username, password);
                  }
              });

      try {

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("from@gmail.com"));
          message.setRecipients(
                  Message.RecipientType.TO,
                  InternetAddress.parse(mail.getRecipients())
          );
          message.setSubject(mail.getSubject());
          message.setText(mail.getBody());

          Transport.send(message);

          System.out.println("Done");

      } catch (MessagingException e) {
          e.printStackTrace();
      }
  }
	  public boolean cheakmailId(String email) {
		  boolean status=false;
		  try {
			
				Connection con= new DbConnection().getConnection();
				PreparedStatement smt = con.prepareStatement("select * from employeer where email=?");
				smt.setString(1,email);
				ResultSet result = smt.executeQuery();
				if(result.next())
					status=true;
				
				con.close();
				}
			catch(Exception e) {
				System.out.println(e);  
				}
			return status;
	  
	  
  }
	  
	  public void creatpassword(String email,String pwd) {
		  try {
				Connection con= new DbConnection().getConnection();
				PreparedStatement smt = con.prepareStatement("insert into precover (email,pwd)values (?,?)");
				smt.setString(1,email);
				smt.setString(2,pwd);
		  
				int result = smt.executeUpdate();
		  }
		  catch(Exception e) {
			  
		  }
		  
		  
	  }
	  
	
	 public boolean CheckRandomPassword(String email,String pwd) {
		 boolean status=false;
		 try {
				Connection con= new DbConnection().getConnection();
				PreparedStatement smt = con.prepareStatement("select * from precover where email=? and pwd=?");
				smt.setString(1,email);
				smt.setString(2, pwd);
				ResultSet result = smt.executeQuery();
				if(result.next())
				status=true;
		 }
			catch(Exception e) {
				System.out.println(e);  
				}
	 
	  return status;
	  
	  
}
	 public boolean setNeWPassword(String email,String pwd) {
		 boolean status=false;
	 
			try {
				
				Connection con= new DbConnection().getConnection();
		 String sql="update employeer set pwd=? where email=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,pwd);
			smt.setString(2,email);
			int row= smt.executeUpdate();
			if(row>0) {
		 status=true;
			}
	 }
			catch(Exception e) {
				
			}
			return status;
}
	 public void dltRpass(String email) {
		 try {
				
				Connection con= new DbConnection().getConnection();
		 String sql="delete from precover where email=?";
			PreparedStatement smt=con.prepareStatement(sql);
			smt.setString(1,email);
			int row= smt.executeUpdate();
		
			}
	 
			catch(Exception e) {
				System.out.println(e);
			}
			
	 }
	 
	 public String getDaysRemain(String email) {
		 String days = null;
	 
		 try {
				
				Connection con= new DbConnection().getConnection();
				PreparedStatement smt = con.prepareStatement("SELECT DATEDIFF(End_Date,current_date())from employeer where email=?");
				smt.setString(1, email);
				ResultSet result = smt.executeQuery();   
				 if(result.next()){
					 days=result.getString(1);
				 }
		 
	 }catch(Exception e) {
		 System.out.println(e);
	 }
	  return days;
}
	 
	 public boolean ShortListed(String appid) {
		 boolean status=false;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
				PreparedStatement smt=con.prepareStatement("update applyjob set status='Yes' where app_id=?");
				smt.setString(1,appid);
				int rs=smt.executeUpdate();
				
				con.close();
				if(rs>0) {
		   status=true;}
		 }
		 catch(Exception e) {
			 
		 }
		return status;
		 
		 
		 
		 
	 }
	 
	 public Employeer employeerViewProfile(String email) {
		 Employeer employeer=new Employeer();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver"); 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
			 PreparedStatement smt=con.prepareStatement("select * from employeer where email=?");
			 smt.setString(1,email);
			 ResultSet rs=smt.executeQuery();
			 
			 if(rs.next()) {
				 employeer.setEmail(rs.getString(1));
			 }
			 
		 }
		 catch(Exception e) {
		 }
		return employeer;
		 
	 }
	 public List<PostedJob> ViewJobs(String empid) {
		
		 List jlist=new ArrayList<PostedJob>();
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdb?useSSL=false","root","myroot");
		 PreparedStatement smt=con.prepareStatement("select * from jobs where Employee_id=?");
		 smt.setString(1,empid);
		 ResultSet rs=smt.executeQuery();
		 while(rs.next()) {
			 PostedJob job=new PostedJob();
			 job.setJobId(rs.getString(1));
			 job.setCname(rs.getString(4));
			 job.setCwebsite(rs.getString(5));
			 job.setEmployeeId(rs.getString(2));
			 job.setExperience(rs.getString(8));
			 job.setJdescription(rs.getString(6));
			 job.setJlocation(rs.getString(10));
			 job.setJobTitle(rs.getString(3));
			 job.setSalary(rs.getString(9));
			 job.setSkills(rs.getString(7));
			 job.setStatus(rs.getString(11));
			 jlist.add(job);
		 }
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		return jlist;
		 
	 }
	 
}