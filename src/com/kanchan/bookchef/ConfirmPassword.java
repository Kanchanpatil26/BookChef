package com.kanchan.bookchef;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanchan.db.ConnectDB;
import com.kanchan.db.Password;

/**
 * Servlet implementation class ConfirmPassword
 */
@WebServlet("/ConfirmPassword")
public class ConfirmPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try{
			String npassword=request.getParameter("npassword");
			String conpassword=request.getParameter("conpassword");
			String cpassword=Password.getCpassword();
			Connection con=ConnectDB.dbCon();
			if(npassword.equals(conpassword)){
				PreparedStatement ps=con.prepareStatement("update chef set cpassword=? where cpassword=?");
				ps.setString(1,npassword);
				ps.setString(2,cpassword);
				int i=ps.executeUpdate();
				if(i>0){
					response.sendRedirect("success.html");
					
				}
				else
				{
					response.sendRedirect("error.html");
				}
			}
			else{
				response.sendRedirect("error.html");
			}
			
			
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
