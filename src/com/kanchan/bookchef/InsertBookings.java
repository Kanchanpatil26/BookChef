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
import com.kanchan.db.User;

/**
 * Servlet implementation class InsertBookings
 */
@WebServlet("/InsertBookings")
public class InsertBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBookings() {
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
			int bid=0;
			int uid= User.getUid();
			
			int cid= Integer.parseInt(request.getParameter("cid"));
			String bdetails=request.getParameter("bdetails");
			String bdate=request.getParameter("bdate");
			String btime=request.getParameter("btime");
			String bstatus="pending";
			Connection con=ConnectDB.dbCon();
			PreparedStatement ps=con.prepareStatement("insert into bookings values(?,?,?,?,?,?,?)");
			ps.setInt(1,bid);
			ps.setInt(2,uid);
			ps.setInt(3,cid);
			ps.setString(4,bdetails);
			ps.setString(5,bdate);
			ps.setString(6,btime);
			ps.setString(7,bstatus);
			int i=ps.executeUpdate();
			if(i>0){
		
				response.sendRedirect("viewYourBookings.jsp");
				
			}
			else
			{
				System.out.println("error.html");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
