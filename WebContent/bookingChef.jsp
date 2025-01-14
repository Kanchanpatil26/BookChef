<%@page import="java.sql.*" %>
<%@page import="com.kanchan.db.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>
<!-- Include Font Awesome CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background: url('foodd.png') no-repeat center center fixed;
        background-size: cover; /* Ensures the image covers the whole background */
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        min-height: 100vh;
    }
    .header {
         background-color: rgba(0, 0, 0, 0.8); /* Semi-transparent background */
        color: #fff;
        padding: 20px;
        text-align: center;
        font-size: 2em;
        font-weight: bold;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        position: relative; /* Ensure relative positioning for absolute child */
    }
    .header .fa {
        position: absolute;
        top: 50%;
        transform: translateY(-50%);
        left: 20px;
        color: #fff;
        font-size: 1.5em;
    }
    .header .admin-icon {
        position: absolute;
        top: 50%;
        left: 100px; /* Adjust as needed */
        transform: translateY(-50%);
        color: #fff;
        font-size: 1em;
    }
    .header .title {
        display: flex;
        align-items: center;
        justify-content: center;
        margin-left: 100px; /* Adjust this value to move the text right */
    }
    .header .title i {
        margin-right: 10px;
        font-size: 1em;
    }
    .main-container {
        display: flex;
        flex: 1;
        width: 100%;
        justify-content: center; /* Center content horizontally */
    }
    .sidebar {
        background-color: rgba(0, 0, 0, 0.8); /* Semi-transparent background */
        padding: 20px;
        width: 300px;
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .sidebar h1 {
        color: #fff;
        margin-top: 10px;
        margin-bottom: 1em;
    }
    .menu {
        list-style: none;
        padding: 0;
        margin: 0;
        width: 100%;
    }
    .menu li {
        margin: 10px 0;
    }
    .menu a {
        text-decoration: none;
        color: #fff;
        background-color: #444; /* Slightly darker purple for contrast */
        padding: 10px 20px;
        display: flex;
        align-items: center;
        border-radius: 5px;
        transition: background-color 0.3s, color 0.3s;
    }
    .menu a i {
        margin-right: 10px;
    }
    .menu a:hover {
        background-color:rgb(53, 88, 53); /* Lighter purple for hover effect */
        color: #fff;
    }
    .content {
        margin-left: -50px; /* Adjust content margin to move it closer to the sidebar */
        padding: 20px;
        flex-grow: 1;
        margin-top: 100px;
        text-align: center;
    }
    .content.h1{
    color:rgb(53, 88, 53);
    }
    
    table {
        width: 80%; /* Adjust table width as needed */
        margin: 0 auto; /* Center align the table */
        border-collapse: collapse;
        background-color: rgba(0, 0, 0, 0.8);
        border: 2px solid rgb(53, 88, 53);
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        border-radius: 1em;
    }
    table th, table td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: left;
        color:#fff
    }
    table th {
        background-color: rgb(53, 88, 53);
        color: #fff;
    }
    table tr: {
        background-color:#fff ;
    }
    table tr:hover {
        background-color: black;
    }
    /* Styling for the search form */
    .search-form-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
        width: 100%;
    }
    .search-form {
        padding: 20px;
        background-color: rgba(0, 0, 0, 0.8);
        border: none;
        border-radius: 1em;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 400px;
        width: 100%;
        text-align: center;
    }
    .search-form h2 {
        color: #fff;
        background-color:rgb(53, 88, 53);
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 1em;
    }
    .search-form input[type="number"], .search-form input[type="submit"],.search-form input[type="text"] {
        width: 100%;
        padding: 0.75em;
        margin: 0.5em 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    .search-form input[type="submit"] {
          background-color: rgb(53, 88, 53);
        color: #fff;
        cursor: pointer;
        transition: background-color 0.3s, color 0.3s;
    }
    .search-form input[type="submit"]:hover {
        background-color: rgb(53, 88, 53); /* Darker blue on hover */
    }
</style>

</head>
<body>
<div class="header">
    <i class="fas fa-user-cog admin-icon"></i>
    <div class="title">
        <i class="fas fa-university"></i>
        Welcome to BookChef
    </div>
</div>

<div class="main-container">
    <div class="sidebar">
        <h1>Dashboard</h1>
        <ul class="menu">
              <li><a href="viewAllChefs.jsp"><i class="fas fa-eye"></i>Chefs By City</a></li>
            <li><a href="viewChefSpeciality.jsp"><i class="fas fa-money-bill-wave"></i>Chefs By Their Speciality</a></li>
            <li><a href="viewYourBookings.jsp"><i class="fas fa-money-check-alt"></i>View Your Bookings</a></li>
            
            <li><a href="changePasswordUser.html"><i class="fas fa-sign-out-alt"></i>Change Password</a></li>
            <li><a href="index.html"><i class="fas fa-sign-out-alt"></i>Go to Home</a></li>
        </ul>
    </div>
    <div class="content">
        <div class="search-form-container">
        	
        	<%int cid= Integer.parseInt(request.getParameter("id")); %>
        	
            <form action="InsertBookings" method="post" class="search-form">
                <h2>Fill the form to book the chef....</h2>
                 <input type="text" name="cid" value=<%=cid %>>
                
                <input type="text" name="bdetails" placeholder="Enter the details ">
                <input type="text" name="bdate" placeholder="Enter the date when you want to book chef">
                <input type="text" name="btime" placeholder="Enter the time when you need the chef">
                
                <input type="submit" value="Submit">
            </form>
        </div>
       
    </div>
</div>

</body>
</html>
