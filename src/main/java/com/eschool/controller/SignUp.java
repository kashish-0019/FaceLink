package com.eschool.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.eschool.model.DBHandler;
import com.eschool.model.User;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String email=request.getParameter("email");
	   String password=request.getParameter("password");
	   String name=request.getParameter("name");
	   User user=new User(email,password,name);
	   DBHandler db=new DBHandler();
	   db.save(user);
	   System.out.println(db.getMessage());
	   response.sendRedirect("login.jsp");
	}

}
