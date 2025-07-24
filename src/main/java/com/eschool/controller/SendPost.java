package com.eschool.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.eschool.model.DBHandler;
import com.eschool.model.Friend;
import com.eschool.model.Wpost;


@WebServlet("/SendPost")
public class SendPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String sender,message,dop;
		    HttpSession session = request.getSession();
		    sender=session.getAttribute("email").toString();
		    message=request.getParameter("message");
		    dop = new java.sql.Date(System.currentTimeMillis()).toString();
		    DBHandler db =new DBHandler();
		    Wpost wpost=new Wpost(0,sender, message, dop);
		    db.save(wpost);
		    response.sendRedirect("Welcome");
		    
	}

}
