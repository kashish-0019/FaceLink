package com.eschool.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.eschool.model.DBHandler;

@WebServlet("/AcceptRequest")
public class AcceptRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid=Integer.parseInt(request.getParameter("fid"));
		DBHandler db = new DBHandler();
		db.acceptRequest(fid);
		response.sendRedirect("Welcome");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
