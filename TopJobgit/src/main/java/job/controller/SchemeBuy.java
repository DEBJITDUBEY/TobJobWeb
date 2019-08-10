package job.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import job.dao.EmployeerDaoImpl;
import job.dao.SchemesDaoImpl;
import job.model.Schemes;

/**
 * Servlet implementation class SchemeBuy
 */
public class SchemeBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchemeBuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("scid");
		String email=request.getParameter("email");
		
		Schemes schemes = new SchemesDaoImpl().getSechemeById(sid);
		if(schemes!=null) {
			boolean result = new EmployeerDaoImpl().makeEmployerSchemeRegistration(email, schemes);
			if(result)
			   response.sendRedirect("EmployeerLogin.jsp");
			else {
				RequestDispatcher rd = request.getRequestDispatcher("SchemeBuy.jsp");
				rd.forward(request, response);
			}
		}
				
		}
	}


