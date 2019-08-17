package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.EmployeerDaoImpl;
import job.model.Mail;


/**
 * Servlet implementation class ShortListed
 */
public class ShortListed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShortListed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String appid=request.getParameter("appid");
			String email=request.getParameter("email");
		   EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		  boolean status= employeerDaoImpl.ShortListed(appid);
			if(status) {
				String body="Congrats !!!!! You are shortlisted for Application Id:"+appid;
				String subject="ShortListed";
				Mail mail=new Mail();
				mail.setRecipients(email);
				mail.setBody(body);
				mail.setSubject(subject);
				
				employeerDaoImpl.MailSender(mail);
				response.sendRedirect("EmployeerViewJobs.jsp");
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
