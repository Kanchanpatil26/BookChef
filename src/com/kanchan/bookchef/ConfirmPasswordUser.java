package com.kanchan.bookchef;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanchan.db.ConnectDB;
import com.kanchan.db.Password;
import com.kanchan.db.PasswordUser;

/**
 * Servlet implementation class ConfirmPasswordUser
 */
@WebServlet("/ConfirmPasswordUser")
public class ConfirmPasswordUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmPasswordUser() {
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
			String upassword=PasswordUser.getUpassword();
			Connection con=ConnectDB.dbCon();
			if(npassword.equals(conpassword)){
				PreparedStatement ps=con.prepareStatement("update user set upassword=? where upassword=?");
				ps.setString(1,npassword);
				ps.setString(2,upassword);
				int i=ps.executeUpdate();
				if(i>0){
					response.sendRedirect("successUser.html");
					
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
