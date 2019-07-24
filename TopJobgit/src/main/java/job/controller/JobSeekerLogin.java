package job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import job.dao.JobseakerDaoImpl;

import job.model.Jobseaker;

/**
 * Servlet implementation class JobSeekerLogin
 */
public class JobSeekerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobSeekerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailid = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		Jobseaker jobseaker=new Jobseaker();
		jobseaker.setEmail(emailid);
		jobseaker.setPassword(pwd);
		
		JobseakerDaoImpl   jobseakerDaoImpl  = new JobseakerDaoImpl();
		boolean status = jobseakerDaoImpl.makeUsersLogin(jobseaker);
		
		if(status) {
			HttpSession session=request.getSession();
			session.setAttribute("emailid", emailid);
			//RequestDispatcher rd = request.getRequestDispatcher("JobseekerHome.jsp");
			response.sendRedirect("JobseekerHome.jsp");
			//PrintWriter out = response.getWriter();
			//rd.include(request, response);
			//out.println("<h3>Welcome.......</h3>");
		}
		
		else {
			request.setAttribute("status","Sorry! Try again......");
			//RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			//PrintWriter out = response.getWriter();
			//rd.forward(request, response);
			response.sendRedirect("index.jsp");
	}

}

}
