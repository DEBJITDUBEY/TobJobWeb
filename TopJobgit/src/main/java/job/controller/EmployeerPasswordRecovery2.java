package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.EmployeerDaoImpl;

/**
 * Servlet implementation class EmployeerPasswordRecovery2
 */
public class EmployeerPasswordRecovery2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeerPasswordRecovery2() {
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
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		System.out.println(pwd);
		System.out.println(email);
		EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		boolean status=employeerDaoImpl.CheckRandomPassword(email, pwd);
		if(status) {
			RequestDispatcher rd = request.getRequestDispatcher("NewPassword.jsp");
			rd.include(request, response);
			
			
		}
		else {
			System.out.println("Wrong entry");
		}
		
	}

}
