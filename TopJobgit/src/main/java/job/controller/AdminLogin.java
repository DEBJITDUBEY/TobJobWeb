package job.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.AdminDaoImpl;
import job.model.Admin;


/**
 * Servlet implementation class Admin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String password = request.getParameter("pwd");
		
		  Admin admin = new Admin();
		  admin.setId(id);
		  admin.setPassword(password);
		 
		  AdminDaoImpl    adminDaoImpl = new AdminDaoImpl();
		  boolean status = adminDaoImpl.makeAdminLogin(admin);
		
		if(status) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			
		}
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
			PrintWriter out = response.getWriter();
			rd.include(request, response);
			out.println("<h3>Sorry! Try again......</h3>");
			out.close();
		}
		
	}
	}

