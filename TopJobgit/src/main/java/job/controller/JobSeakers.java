package job.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import job.dao.EmployeerDaoImpl;
import job.dao.JobseakerDaoImpl;
import job.model.Jobseaker;
import job.model.Mail;

/**
 * Servlet implementation class JobSeakers
 */
@MultipartConfig
public class JobSeakers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobSeakers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		 String name=request.getParameter("name") ;
		 String email =request.getParameter("email");
		 String password=request.getParameter("pwd") ;
		 Date Date_of_birth=null;
		try {
			Date_of_birth = sdf.parse(request.getParameter("dob"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("err:"+e.getMessage());
		}
		 String  gender=request.getParameter("gender") ;
		 String Mobile_no=request.getParameter("mobno") ;
	String gov_proof_id=request.getParameter("GOVID") ;
	 String id_details =request.getParameter("goviddetails") ;
		 String city=request.getParameter("city") ;
 String state=request.getParameter("state") ;
		 String zip=request.getParameter("zip");
 String country =request.getParameter("country");
		 String class_x_y_board=request.getParameter("10board") ;
		 String class_x_year=request.getParameter("10year") ;
		 String class_x_marks =request.getParameter("10marks");
		 String class_xii_board =request.getParameter("12board");

		 
		 String class_xii_year =request.getParameter("12year");
		 String class_xii_mark =request.getParameter("12marks");
		 System.out.println(class_xii_board+" "+class_xii_year+" "+ class_xii_mark);
		 
	 String graduate_uni =request.getParameter("uni");
	 String graduate_colname=request.getParameter("gradcolname");
		 String graduate_year=request.getParameter("gradyear") ;
		 String graduate_mark=request.getParameter("gradmark") ;
	 String graduate_branch=request.getParameter("branch") ;
		 String other_board=request.getParameter("otherboard") ;
		 String other_name=request.getParameter("othercolname") ;
	 String other_year =request.getParameter("otheryear");
	 String other_mark=request.getParameter("othermark") ;
	 String other_salary=request.getParameter("salary") ;
	
	 Jobseaker jobseaker= new  Jobseaker(name, email, password, Date_of_birth, gender, Mobile_no, gov_proof_id, id_details, city, state, zip, country, class_x_y_board, class_x_year, class_x_marks, class_xii_board, class_xii_year, class_xii_mark, graduate_uni, graduate_colname, graduate_year, graduate_mark, graduate_branch, other_board, other_name, other_year, other_mark, other_salary);
	 JobseakerDaoImpl jobseakerDaoImpl = new JobseakerDaoImpl();
	 boolean status = jobseakerDaoImpl.makeJobseakerRegistration(jobseaker);
	 
	 
	 
	 
	 if(status) {
		 
		 String serverPath = "d:/imgJobseaker/";
		 String serverPath1 = "d:/jobseakercv/";
		    final Part filePart = request.getPart("customfile");
		    final Part filePart1 = request.getPart("customfile1");
		    String fileName = id_details+".jpg";
		    String fileName1 = id_details+".pdf";
		 
		    OutputStream out = null,out1=null;
		    InputStream filecontent = null,filecontent1=null ;
		    PrintWriter writer = response.getWriter();
		    //for img
		    try {
			      out = new FileOutputStream(new File(serverPath + File.separator + fileName));
			      filecontent = filePart.getInputStream();
			      
			      int read = 0;
			       byte[] bytes = new byte[1024];
			 
			      while ((read = filecontent.read(bytes)) != -1) {
			        out.write(bytes, 0, read);
			      }
			      
			     } 
		        catch (Exception e) {
			      System.out.println("error2:"+e);

			    } 
		        finally {
			      if (out != null) {
			        out.close();
			      }
			    
			      if (filecontent != null) {
			        filecontent.close();
			      }
			    
			      if (writer != null) {
			        writer.close();
			      }
			    }
		    //for cv
		    try {
			      out1 = new FileOutputStream(new File(serverPath1 + File.separator + fileName1));
			      filecontent1 = filePart1.getInputStream();
			      
			      int read = 0;
			       byte[] bytes = new byte[1024];
			 
			      while ((read = filecontent1.read(bytes)) != -1) {
			        out1.write(bytes, 0, read);
			      }
			  
			    } 
		        catch (Exception e) {
			      System.out.println("error2:"+e);

			    } 
		        finally {
			      if (out1 != null) {
				        out1.close();
				      }
			      if (filecontent1 != null) {
				        filecontent1.close();
				      }
			    }
		    System.out.println("success");
		    String subject="Registration succesfully";
			 String body="You are successfully Register";
			Mail mail=new Mail();
			mail.setRecipients(email);
			mail.setBody(body);
			mail.setSubject(subject);
			EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
			employeerDaoImpl.MailSender(mail);
	 }
	 else
		 System.out.println("fail");
	 
	 
	 
	}

}
