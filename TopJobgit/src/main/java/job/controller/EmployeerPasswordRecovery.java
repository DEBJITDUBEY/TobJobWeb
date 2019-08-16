package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.EmployeerDaoImpl;
import job.model.Mail;

/**
 * Servlet implementation class EmployeerPasswordRecovery
 */
public class EmployeerPasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeerPasswordRecovery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mailId=request.getParameter("email");
		EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		boolean status=employeerDaoImpl.cheakmailId(mailId);
		String Pass="J"+(int)(Math.random()*100)+(int)(Math.random()*100)+(int)(Math.random()*100);  
		if(status) {
			 String subject="Password Recovery";
			 String body="You Secret Key is "+Pass+"Please enter it";
			Mail mail=new Mail();
			mail.setRecipients(mailId);
			mail.setBody(body);
			mail.setSubject(subject);
			employeerDaoImpl.MailSender(mail);
			employeerDaoImpl.creatpassword(mailId, Pass);
			HttpSession session=request.getSession();
			session.setAttribute("mailId", mailId);
			RequestDispatcher rd=request.getRequestDispatcher("PassChk.jsp");
			rd.include(request, response);
		}
	}

}
