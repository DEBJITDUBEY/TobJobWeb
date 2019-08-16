package job.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.EmployeerDaoImpl;

/**
 * Servlet implementation class setPassword
 */
public class setPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public setPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		EmployeerDaoImpl employeerDaoImpl=new EmployeerDaoImpl();
		boolean status=employeerDaoImpl.setNeWPassword(email, password);
		if(status) {
			EmployeerDaoImpl daoImpl=new EmployeerDaoImpl();
			daoImpl.dltRpass(email);
			System.out.println("Succesfully Change Password");
			RequestDispatcher rd=request.getRequestDispatcher("EmployeerLogin.jsp");
			rd.include(request, response);
		}
		
	}

}
