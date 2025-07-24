package com.eschool.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.eschool.model.DBHandler;
import com.eschool.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        DBHandler db = new DBHandler();
        User user = db.getUser(email); 
        if(user==null) {
        	response.sendRedirect("index.jsp?msg=invalid_email");
        }
        else if(user.getPassword().equals(pass))
        {
        	HttpSession session=request.getSession();
        	session.setAttribute("email",email);
        	response.sendRedirect("Welcome");
        }
        else{
        	response.sendRedirect("index.jsp?msg=invalid_password");
        }
	}

}
