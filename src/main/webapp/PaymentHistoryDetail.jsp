<!DOCTYPE html>
<%@page import="model.dao.DAO"%>
<%@page import="model.bean.OrderDetail"%>
<%@page import="model.bean.Order"%>
<%@page import="model.bean.Cart"%>
<%@page import="model.bean.Product"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<meta charset="utf-8">
<title>EShopper</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">


</head>

<body>
	<!-- Topbar Start -->
	<div class="container-fluid">
		<div class="row bg-secondary py-2 px-xl-5"></div>
		<div class="row align-items-center py-3 px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a href="HomeController" class="text-decoration-none">
					<h1 class="m-0 display-5 font-weight-semi-bold">
						<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
					</h1>
				</a>
			</div>
			<div class="col-lg-6 col-6 text-left">
				<form action="SearchController">
					<div class="input-group">
						<%
						String txtSearch = (String) request.getAttribute("txtSearch");
						%>
						<input type="text" name="search" class="form-control"
							placeholder="Search for products" <%if (txtSearch != null) {%>
							value="<%=txtSearch%>" <%}%>>
						<div class="input-group-append">
							<span class="input-group-text bg-transparent text-primary">
								<i class="fa fa-search"></i>
							</span>
						</div>
					</div>
				</form>
			</div>
			<%
			List<Cart> listCart = (List<Cart>) session.getAttribute("cart-list");
			if (listCart != null) {
			%>
			<div class="col-lg-3 col-6 text-right">
				<a href="CartController" class="btn border"> <i
					class="fas fa-shopping-cart text-primary"></i> <span class="badge"><%=listCart.size()%></span>
				</a>
			</div>
			<%
			} else {
			%>
			<div class="col-lg-3 col-6 text-right">
				<a href="CartController" class="btn border"> <i
					class="fas fa-shopping-cart text-primary"></i> <span class="badge">0</span>
				</a>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<!-- Topbar End -->


	<!-- Navbar Start -->
	<div class="container-fluid">
		<div class="row border-top px-xl-5">
			<div class="col-lg-3 d-none d-lg-block">
				<a
					class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100"
					data-toggle="collapse" href="#navbar-vertical"
					style="height: 65px; margin-top: -1px; padding: 0 30px;">
					<h6 class="m-0">Categories</h6> <i
					class="fa fa-angle-down text-dark"></i>
				</a>
				<nav
					class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light"
					id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
					<div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
						<%
						List<Category> listC = (List<Category>) request.getAttribute("listC");
						for (int i = 0; i < listC.size(); i++) {
						%>
						<a href="CategoryController?cid=<%=listC.get(i).getId()%>"
							class="nav-item nav-link"><%=listC.get(i).getName()%></a>
						<%
						}
						%>
					</div>
				</nav>
			</div>
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
					<a href="" class="text-decoration-none d-block d-lg-none">
						<h1 class="m-0 display-5 font-weight-semi-bold">
							<span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper
						</h1>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="HomeController" class="nav-item nav-link">Home</a> <a
								href="ShopController" class="nav-item nav-link">Shop</a>
							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown">Pages</a>
								<div class="dropdown-menu rounded-0 m-0">
									<a href="CartController" class="dropdown-item">Shopping
										Cart</a> <a href="CheckOutController" class="dropdown-item">Checkout</a>
								</div>
							</div>
						</div>
						<%
						if (session.getAttribute("adminSession") == null && session.getAttribute("userSession") == null) {
						%>
						<div class="navbar-nav ml-auto py-0">
							<a href="Login.jsp" class="nav-item nav-link"><i
								class="fa-solid fa-right-to-bracket"></i> Login</a> <a
								href="Register.jsp" class="nav-item nav-link"><i
								class="fa-solid fa-registered"></i> Register</a>
						</div>
						<%
						}
						if (session.getAttribute("adminSession") != null) {
						%>
						<div class="navbar-nav ml-auto py-0">
							<a href="ManagerController" class="nav-item nav-link"><i
								class="fa-solid fa-user-tie"></i> Manage Product</a> <a
								href="LogoutController" class="nav-item nav-link"><i
								class="fa-solid fa-right-from-bracket"></i> Logout</a>
						</div>
						<%
						}
						%>
						<%
						if (session.getAttribute("userSession") != null) {
						%>
						<div class="navbar-nav ml-auto py-0">
							<p class="nav-item nav-link">
								Welcome <i class="fa-sharp fa-solid fa-hand-wave"></i><%=session.getAttribute("lastname")%></p>
							<a href="EditProfileController" class="nav-item nav-link"><i
								class="fa-solid fa-address-card"></i> Profile</a> <a
								href="PaymentHistoryController" class="nav-item nav-link"><i
								class="fa-solid fa-credit-card"></i> Payment history</a> <a
								href="LogoutController" class="nav-item nav-link"><i
								class="fa-solid fa-right-from-bracket"></i> Logout</a>
						</div>
						<%
						}
						%>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->

	<!-- Page Header Start -->
	<div class="container-fluid bg-secondary mb-5">
		<div
			class="d-flex flex-column align-items-center justify-content-center"
			style="min-height: 300px">
			<h1 class="font-weight-semi-bold text-uppercase mb-3">Payment history detail</h1>
			<div class="d-inline-flex">
				<p class="m-0">
					<a href="HomeController">Home</a>
				</p>
				<p class="m-0 px-2">-</p>
				<p class="m-0">Payment history detail</p>
			</div>
		</div>
	</div>
	<!-- Page Header End -->
	<div class="container-fluid pt-5">
		<%
		List<OrderDetail> list = (List<OrderDetail>) request.getAttribute("listOrderDetail");
		Double subtotal = 0.0;
		String payment = "";
		%>
		<div class="row px-xl-5">
			<div class="col-lg-8">
				<div class="mb-4">
					<h4 class="font-weight-semi-bold mb-4">Billing Address</h4>
					<div class="row">

						<div class="col-md-6 form-group">
							<label>First Name</label> <input class="form-control" type="text"
								name="firstname" value="<%=list.getLast().getFirstname()%>"
								readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>Last Name</label> <input class="form-control" type="text"
								value="<%=list.getLast().getLastname()%>" readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>E-mail</label> <input class="form-control" type="text"
								value="<%=list.getLast().getGmail()%>" readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>Mobile No</label> <input class="form-control" type="text"
								value="<%=list.getLast().getPhonenumber()%>"
								readonly="readonly">
						</div>

						<div class="col-md-6 form-group">
							<label>Address</label> <input class="form-control" type="text"
								value="<%=list.getLast().getAddress()%>" readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>Country</label> <input class="form-control" type="text"
								value="<%=list.getLast().getCountry()%>" readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>City</label> <input class="form-control" type="text"
								value="<%=list.getLast().getCity()%>" readonly="readonly">
						</div>
						<div class="col-md-6 form-group">
							<label>State</label> <input class="form-control" type="text"
								value="<%=list.getLast().getState()%>" readonly="readonly">
						</div>

					</div>
				</div>
			</div>
			<div class="col-lg-4">
				<div class="card border-secondary mb-5">
					<div class="card-header bg-secondary border-0">
						<h4 class="font-weight-semi-bold m-0">Order Total</h4>
					</div>
					<div class="card-body">
						<h5 class="font-weight-medium mb-3">Products</h5>
						<%
						for (int i = 0; i < list.size(); i++) {
							payment = list.get(i).getPayment();
							subtotal += list.get(i).getTotal();
						%>
						<div class="d-flex justify-content-between">
							<p><%=list.get(i).getName()%></p>
							<p>
								x
								<%=list.get(i).getQuantity()%></p>
							<p>
								$<%=list.get(i).getTotal()%></p>
						</div>
						<%
						}
						%>
						<hr class="mt-0">
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Payment</h6>
							<h6 class="font-weight-medium">
								<%=payment%></h6>
						</div>
						<div class="d-flex justify-content-between mb-3 pt-1">
							<h6 class="font-weight-medium">Subtotal</h6>
							<h6 class="font-weight-medium">
								$<%=subtotal%></h6>
						</div>
						<div class="d-flex justify-content-between">
							<h6 class="font-weight-medium">Shipping</h6>
							<h6 class="font-weight-medium">$10</h6>
						</div>
					</div>
					<div class="card-footer border-secondary bg-transparent">
						<div class="d-flex justify-content-between mt-2">
							<h5 class="font-weight-bold">Total</h5>
							<h5 class="font-weight-bold">
								$<%=subtotal + 10%></h5>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Add Modal HTML -->

	<!-- Footer Start -->
	<div class="container-fluid bg-secondary text-dark mt-5 pt-5">
		<div class="row px-xl-5 pt-5">
			<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
				<a href="" class="text-decoration-none">
					<h1 class="mb-4 display-5 font-weight-semi-bold">
						<span
							class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper
					</h1>
				</a>
				<p>TranDucTan Cooperation</p>
				<p class="mb-2">
					<i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street,
					New York, USA
				</p>
				<p class="mb-2">
					<i class="fa fa-envelope text-primary mr-3"></i>tranductan66vn@gmail.com
				</p>
				<p class="mb-0">
					<i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890
				</p>
			</div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-4 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-dark mb-2" href="HomeController"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-dark mb-2" href="ShopController"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-dark mb-2" href="CartController"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-dark mb-2" href="CheckOutController"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-dark mb-2" href="HomeController"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-dark mb-2" href="ShopController"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-dark mb-2" href="CartController"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-dark mb-2" href="CheckOutController"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row border-top border-light mx-xl-5 py-4">
			<div class="col-md-6 px-xl-0">
				<p class="mb-md-0 text-center text-md-left text-dark">
					&copy; <a class="text-dark font-weight-semi-bold"
						href="HomeController">EShopper</a>. All Rights Reserved. Designed
					by <label class="text-dark font-weight-semi-bold">Tran Duc
						Tan</label> <br> Distributed By <label
						class="text-dark font-weight-semi-bold">Tran Duc Tan</label>
				</p>
			</div>
			<div class="col-md-6 px-xl-0 text-center text-md-right">
				<img class="img-fluid" src="img/payments.png" alt="">
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="mail/jqBootstrapValidation.min.js"></script>
	<script src="mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>

</body>

</html>