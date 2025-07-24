package com.eschool.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import com.eschool.model.DBHandler;
import com.eschool.model.Friend;
import com.eschool.model.Wpost;

@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession();

	        if (session.getAttribute("email") == null) {
	            response.sendRedirect("index.jsp?msg=session_expired");
	            return;
	        }

	        String email = session.getAttribute("email").toString();
	        System.out.println("Session Email: " + email);
	        DBHandler db = new DBHandler();
	        ArrayList<Wpost> wposts = db.getPosts(email);
	        ArrayList<Friend> pendingRequests = db.getPendingRequests(email);
	        System.out.println("Pending requests size: " + pendingRequests.size());
	        ArrayList<String> friends = db.getFriends(email);

	        request.setAttribute("wposts", wposts);
	        request.setAttribute("pendingRequests", pendingRequests);
	        request.setAttribute("friends", friends);

	        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
	        rd.forward(request, response);	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
