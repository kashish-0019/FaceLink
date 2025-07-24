<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FaceLink | Log In</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f0f2f5;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .navbar {
            background-color: #1877f2;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        .navbar-brand {
            font-size: 26px;
            font-weight: bold;
        }

        .login-container {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-card {
            background-color: #ffffff;
            border-radius: 12px;
            padding: 40px 30px;
            width: 100%;
            max-width: 400px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .login-card h3 {
            text-align: center;
            font-weight: 700;
            margin-bottom: 25px;
            color: #333;
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #1877f2;
        }

        .btn-primary {
            background-color: #1877f2;
            border: none;
            font-weight: 600;
        }

        .btn-primary:hover {
            background-color: #145dbf;
        }

        .footer-text {
            margin-top: 15px;
            font-size: 14px;
            text-align: center;
        }

        .footer-text a {
            color: #1877f2;
            text-decoration: none;
            font-weight: 500;
        }

        .footer-text a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<%if(request.getParameter("msg") != null)
{
	 %>
<h3><%= request.getParameter("msg") %></h3>
<%} %>

    <nav class="navbar navbar-dark">
        <div class="container">
            <a class="navbar-brand text-white" href="#">FaceLink</a>
        </div>
    </nav>

    <div class="login-container">
        <div class="login-card">
            <h3>Log In to FaceLink</h3>
            <form action="Login" method="post">
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email" placeholder="Enter Email" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="pass" class="form-control" name="pass" placeholder="Enter Password" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Log In</button>
            </form>
            <div class="footer-text">
                Don't have an account? <a href="index.jsp">Sign Up</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
