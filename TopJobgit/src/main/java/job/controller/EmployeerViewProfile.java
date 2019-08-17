package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import job.dao.EmployeerDaoImpl;
import job.model.Employeer;

/**
 * Servlet implementation class EmployeerViewProfile
 */
public class EmployeerViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeerViewProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email=(String) session.getAttribute("emailid");
		EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		Employeer employeer= employeerDaoImpl.employeerViewProfile(email);
		String email1=employeer.getEmail();
		  System.out.println(email1);
		
		RequestDispatcher rd=request.getRequestDispatcher("EmployeerViewProfile.jsp");
		request.setAttribute("employeer", employeer);
		rd.include(request, response);
	}


	

}
