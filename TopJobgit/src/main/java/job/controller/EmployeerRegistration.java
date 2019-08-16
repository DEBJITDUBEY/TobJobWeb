package job.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import job.dao.EmployeerDaoImpl;
import job.model.Employeer;
import job.model.Mail;


/**
 * Servlet implementation class EmployeeRegistration
 */
@MultipartConfig
public class EmployeerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeerRegistration() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		System.out.println(email+"email");
		String pwd=request.getParameter("pwd");
		System.out.println(pwd+"pwd");
		
		String mob=request.getParameter("mob");
		System.out.println(mob+"mob");
		String Rname=request.getParameter("Rname");
		System.out.println(Rname+"rname");
		String Cname=request.getParameter("Cname");
		System.out.println(Cname+"cname");
		String industryname=request.getParameter("industryname");
		System.out.println(industryname+"industryname");
		String designation=request.getParameter("designation");
		System.out.println(designation+"designation");
		String type=request.getParameter("type");
		System.out.println(type+"type");
		String GSTNO=request.getParameter("GSTNO");
		System.out.println(GSTNO+"gstno");
		String o1=request.getParameter("o1");
		System.out.println(o1+"o1");
		String c1=request.getParameter("c1");
		System.out.println(c1+" c1");
		String p1=request.getParameter("p1");
		System.out.println(p1+"p1");
		String co1=request.getParameter("co1");
		System.out.println(co1+"co1");
		String on1=request.getParameter("on1");
		System.out.println(on1+"on1");
        String c2=request.getParameter("c2");
        System.out.println(c2+"c2");
		String c4="C"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100);    //request.getParameter("c4");
		System.out.println(c4+"c4");
		
		Employeer  employeer = new Employeer(email, pwd, mob, Rname, Cname, industryname, designation, type, GSTNO, o1, c1, p1, co1, on1, c2, c4);
		
		String serverPath = "d:/imgEmployer/";
	    final Part filePart = request.getPart("p2");
	    String fileName = c4+".jpg";
	 
	    OutputStream out = null;
	    InputStream filecontent = null;
	    PrintWriter writer = response.getWriter();
	    boolean flag=false;
	    try {
		      out = new FileOutputStream(new File(serverPath + File.separator + fileName));
		      filecontent = filePart.getInputStream();
		      
		      int read = 0;
		      final byte[] bytes = new byte[1024];
		 
		      while ((read = filecontent.read(bytes)) != -1) {
		        out.write(bytes, 0, read);
		      }
		      
		      EmployeerDaoImpl employeerDaoImpl = new EmployeerDaoImpl();
		      flag= employeerDaoImpl.makeEmployerRegistration(employeer);
		      
		  System.out.println(flag);
			if(flag==true) {
				RequestDispatcher rd = request.getRequestDispatcher("scheme.jsp");
				rd.include(request, response);
				
				writer.println("Employeer is registered");
				 String subject="Registration succesfully";
				 String body="You are successfully Register";
				Mail mail=new Mail();
				mail.setRecipients(email);
				mail.setBody(body);
				mail.setSubject(subject);
				employeerDaoImpl.MailSender(mail);
				}
				else {
					RequestDispatcher rd = request.getRequestDispatcher("EmployeerRegistration.jsp");
					rd.include(request, response);
					writer.println("Employeer is not registered");
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
		
	}

}
