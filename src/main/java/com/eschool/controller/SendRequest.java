package com.eschool.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import com.eschool.model.DBHandler;
import com.eschool.model.Friend;

@WebServlet("/SendRequest")
public class SendRequest extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String sender,rec,dor;
	    int stat=0;
	    HttpSession session = request.getSession();
	    sender=session.getAttribute("email").toString();
	    rec=request.getParameter("rec");
	    dor = new java.sql.Date(System.currentTimeMillis()).toString();
	    DBHandler db =new DBHandler();
	    Friend friend = new Friend(0,sender,rec,stat,dor);
	    db.save(friend);
	    response.sendRedirect("Welcome");
	    
	}

}
