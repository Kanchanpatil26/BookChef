package com.kanchan.bookchef;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kanchan.db.Chef;
import com.kanchan.db.ConnectDB;
import com.kanchan.db.Password;
import com.kanchan.db.User;

/**
 * Servlet implementation class LoginChef
 */
@WebServlet("/LoginChef")
public class LoginChef extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginChef() {
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
			String cemail=request.getParameter("cemail");
			String cpassword=request.getParameter("cpassword");
			String cstatus="approved";
			Connection con=ConnectDB.dbCon();
			PreparedStatement ps=con.prepareStatement("select * from chef where (cemail=? and cpassword=?) and cstatus=? ");
			ps.setString(1,cemail);
			ps.setString(2,cpassword);
			ps.setString(3,cstatus);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
			
			     Chefs.setCid(rs.getInt(1));
				Password.setCpassword(cpassword);
				response.sendRedirect("welcomeChef.html");
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
