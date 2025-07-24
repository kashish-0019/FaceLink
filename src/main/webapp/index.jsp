<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>FaceLink | Sign Up</title>
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

        .signup-container {
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .signup-card {
            background-color: #ffffff;
            border-radius: 12px;
            padding: 40px 30px;
            width: 100%;
            max-width: 420px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
        }

        .signup-card h3 {
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
            background-color: #155db2;
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

    <nav class="navbar navbar-dark">
        <div class="container">
            <a class="navbar-brand text-white" href="#">FaceLink</a>
        </div>
    </nav>

    <div class="signup-container">
        <div class="signup-card">
            <h3>Create Your Account</h3>
            <form action="SignUp" method="post">
                <div class="mb-3">
                    <label class="form-label">Email</label>
                    <input type="text" class="form-control" name="email" placeholder="Enter Email" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" placeholder="Enter Password" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Full Name</label>
                    <input type="text" class="form-control" name="name" placeholder="Enter Full Name" required>
                </div>
                <button type="submit" class="btn btn-primary w-100">Sign Up</button>
            </form>
            <div class="footer-text">
                Already have an account? <a href="login.jsp">Log In</a>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
