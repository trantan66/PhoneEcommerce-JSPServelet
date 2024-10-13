<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "poppins", sans-serif;
}

body {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background: url('img/iphonebanner1.jpg') no-repeat;
	background-size: cover;
	background-position: center;
}

.wrapper {
	width: 420px;
	background: transparent;
	border: 2px solid rgba(255, 255, 255, .2);
	backdrop-filter: blur(20px);
	box-shadow: 0 0 10px rgba(0, 0, 0, .2);
	color: #fff;
	border-radius: 10px;
	padding: 30px 40px;
}

.wrapper h1 {
	font-size: 36px;
	text-align: center;
}

.wrapper .input-box {
	position: relative;
	width: 100%;
	height: 50px;
	margin: 30px 0;
}

.input-box input {
	width: 100%;
	height: 100%;
	background: transparent;
	border: none;
	outline: none;
	border: 2px solid rgba(255, 255, 255, .2);
	border-radius: 40px;
	font-size: 16px;
	color: #fff;
	padding: 20px 45px 20px 20px;
}

.input-box input::placeholder {
	color: #fff;
}

.input-box i {
	position: absolute;
	right: 20px;
	top: 50%;
	transform: translateY(-50%);
	font-size: 20px;
}

.wrapper .remember-forgot {
	display: flex;
	justify-content: space-between;
	font-size: 14.5px;
	margin: -15px 0 15px;
}

.remember-forgot label input {
	accent-color: #fff;
	margin-right: 3px;
}

.remember-forgot a {
	color: #fff;
	text-decoration: none;
}

.remember-forgot a:hover {
	text-decoration: underline;
}

.wrapper .btn {
	width: 100%;
	height: 45px;
	background: #fff;
	border: none;
	outline: none;
	border: none;
	border-radius: 40px;
	box-shadow: 0 0 10px rgba(0, 0, 0, .1);
	cursor: pointer;
	font-size: 16px;
	color: #333;
	font-weight: 600;
}

.wrapper .register-link {
	font-size: 14.5px;
	text-align: center;
	margin-top: 20px 0 15px;
	padding-top: 30px;
}

.register-link p a {
	color: #fff;
	text-decoration: none;
	font-weight: 600;
}

.register-link p a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<div class="wrapper">
		<form action="LoginController">
			<h1>Login</h1>

			<div class="input-box">
				<input name="username" type="text" placeholder="Enter your username" required>
				<i class='bx bxs-user'></i>
			</div>
			<div class="input-box">
				<input name="password" type="password" placeholder="Enter your password"
					required> <i class='bx bxs-lock'></i>
			</div>
			<%
			String message = (String) request.getAttribute("message");
			%>
			<%
			if (message != null) {
			%>
			<p class="alert alert-success"><%=message%></p>
			<%
			}
			%>
			<div class="remember-forgot">
				<label><input type="checkbox"> Remember me</label>
			</div>
			<button type="submit" class="btn">Login</button>

			<div class="register-link">
				<p>
					Don't have an account <a href="Register.jsp">Register</a>
				</p>

			</div>

		</form>
	</div>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>

	<!-- Popper JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>