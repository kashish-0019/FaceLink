<%@ page import="com.eschool.model.Friend" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String email = (String) session.getAttribute("email");
    if (email == null) {
        response.sendRedirect("login.jsp?msg=please_login_first");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FaceLink | Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #e0f7fa, #f1f8e9);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
        }
        .navbar {
            background-color: #1976d2;
            padding: 10px 0;
        }
        .navbar-brand {
            font-size: 24px;
            font-weight: 600;
            color: #fff;
        }
        .main-content {
            margin-top: 40px;
        }
        .glass-card {
            background: rgba(255, 255, 255, 0.9);
            backdrop-filter: blur(8px);
            border-radius: 16px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
            padding: 20px;
            min-height: 400px;
        }
        .section-title {
            font-weight: 600;
            font-size: 20px;
            color: #333;
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #1976d2;
            border: none;
            font-weight: 600;
        }
        .btn-primary:hover {
            background-color: #125ca1;
        }
        .friend-card {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin-bottom: 10px;
            background-color: #fff;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container d-flex justify-content-between align-items-center">
        <a class="navbar-brand" href="#">FaceLink</a>
        <span class="text-white">Welcome, <%= email %></span>
    </div>
</nav>

<div class="container main-content">
    <div class="row gy-4">

        <!-- Pending Requests -->
        <div class="col-md-3">
            <div class="glass-card">
                <div class="section-title">Pending Requests</div>
                <%
                    ArrayList<Friend> pendingRequests = (ArrayList<Friend>) request.getAttribute("pendingRequests");
                    if (pendingRequests == null) {
                %>
                    <p>No pending requests available.</p>
                <%
                    } else {
                        boolean found = false;
                        for (Friend f : pendingRequests) {
                            if (f.getRec().equals(email)) {
                                found = true;
                %>
                    <div class="friend-card">
                        <strong><%= f.getSender() %></strong><br>
                        <a class="btn btn-sm btn-success mt-2" href="AcceptRequest?fid=<%= f.getFid() %>">Accept</a>
                        <a class="btn btn-sm btn-danger mt-2 ms-2" href="RejectRequest?fid=<%= f.getFid() %>">Reject</a>
                    </div>
                <%
                            }
                        }
                        if (!found) {
                %>
                    <p>No pending requests.</p>
                <%
                        }
                    }
                %>
            </div>
        </div>

        <!-- Post and Send Request -->
        <div class="col-md-6">
            <!-- Post Message -->
            <div class="glass-card mb-4">
                <div class="section-title">Make a Post</div>
                <form action="SendPost" method="post">
                    <input type="text" class="form-control mb-3" name="message" placeholder="What's on your mind?" required>
                    <button type="submit" class="btn btn-primary w-100">Post</button>
                </form>
            </div>

            <!-- Send Friend Request -->
            <div class="glass-card">
                <div class="section-title">Send Friend Request</div>
                <form action="SendRequest" method="post">
                    <input type="email" class="form-control mb-3" name="rec" placeholder="Enter receiver's email" required>
                    <button type="submit" class="btn btn-primary w-100">Send Request</button>
                </form>
            </div>
        </div>

        <!-- Friend List -->
        <div class="col-md-3">
            <div class="glass-card">
                <div class="section-title">Your Friends</div>
                <%
                    ArrayList<String> friends = (ArrayList<String>) request.getAttribute("friends");
                    if (friends != null && !friends.isEmpty()) {
                        for (String f : friends) {
                %>
                    <div class="friend-card">
                        <%= f %>
                    </div>
                <%
                        }
                    } else {
                %>
                    <p>You have no friends yet.</p>
                <%
                    }
                %>
            </div>
        </div>

    </div>
</div>

</body>
</html>
