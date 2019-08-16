package job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.EmployeerDaoImpl;
import job.model.Employeer;


/**
 * Servlet implementation class EmployeerLogin
 */
public class EmployeerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeerLogin() {
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
		String emailid = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		Employeer employer=new Employeer();
		employer.setEmail(emailid);
		employer.setPwd(pwd);
		
		EmployeerDaoImpl   employersDaoImpl  = new EmployeerDaoImpl();
		String empid = employersDaoImpl.makeUsersLogin(employer); // if valid returns empid
		
		if(empid!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("emailid", emailid);
			session.setAttribute("empid", empid);
			//session.setAttribute("c4", status);
		
			
			EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
			int s=Integer.parseInt(employeerDaoImpl.getDaysRemain(emailid));
			
			if(s<0) {
				RequestDispatcher rd1 = request.getRequestDispatcher("scheme.jsp?email="+emailid);
				PrintWriter out1 = response.getWriter();
				rd1.include(request, response);
				out1.println("<h3>Scheme Expire.......</h3>");
				
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("EmployeerHome.jsp");
				PrintWriter out = response.getWriter();
				rd.include(request, response);
				out.println("<h3>Welcome.......</h3>");
				
			}
			
		}
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("EmployeerLogin.jsp");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<h3>Sorry! Try again......</h3>");
			out.close();
	}

}
}
