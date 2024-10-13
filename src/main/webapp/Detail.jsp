<%@page import="model.bean.Cart"%>
<%@page import="model.bean.Category"%>
<%@page import="model.bean.ProductDetail"%>
<%@page import="model.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" >   
    
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="HomeController" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                </a>
            </div>
           <div class="col-lg-6 col-6 text-left">
                <form action="SearchController">
                    <div class="input-group">
                    <% String txtSearch = (String)request.getAttribute("txtSearch"); %>
                        <input type="text" name = "search" class="form-control" placeholder="Search for products" <% if(txtSearch != null){ %> value="<%=txtSearch %>" <% } %>>
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <% List<Cart> listCart = (List<Cart>)session.getAttribute("cart-list"); 
            	if(listCart != null){
            %>
            <div class="col-lg-3 col-6 text-right">
                <a href="CartController" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge"><%= listCart.size() %></span>
                </a>
            </div>
            <% }else{ %>
            <div class="col-lg-3 col-6 text-right">
                <a href="CartController" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">0</span>
                </a>
            </div>
            <% } %>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden" style="height: 410px">
                    <%
                    List<Product> list = (List<Product>)request.getAttribute("listP");
                    int listSize = list.size();
                    List<Category> listC = (List<Category>)request.getAttribute("listC");
					for(int i = 0; i< listC.size(); i++){
                    %>
                        <a href="CategoryController?cid=<%=listC.get(i).getId() %>" class="nav-item nav-link"><%=listC.get(i).getName() %></a>
                      <% } %>
                    </div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Shopper</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="HomeController" class="nav-item nav-link">Home</a>
                            <a href="ShopController" class="nav-item nav-link active">Shop</a>
                            <div class="nav-item dropdown">
                                <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Pages</a>
                                <div class="dropdown-menu rounded-0 m-0">
                                    <a href="CartController" class="dropdown-item">Shopping Cart</a>
                                    <a href="CheckOutController" class="dropdown-item">Checkout</a>
                                </div>
                            </div>
                        </div>
                         <% if(session.getAttribute("adminSession") == null && session.getAttribute("userSession") == null){ %>
                        <div class="navbar-nav ml-auto py-0">
                            <a href="Login.jsp" class="nav-item nav-link"><i class="fa-solid fa-right-to-bracket"></i> Login</a>
                            <a href="Register.jsp" class="nav-item nav-link"><i class="fa-solid fa-registered"></i> Register</a>
                        </div>
                        <% } if(session.getAttribute("adminSession") != null){ %>
                        <div class="navbar-nav ml-auto py-0">
                            <a href="ManagerController" class="nav-item nav-link"><i class="fa-solid fa-user-tie"></i> Manage Product</a>
                            <a href="LogoutController" class="nav-item nav-link"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
                        </div>
                        <% } %>
                        <% if(session.getAttribute("userSession") != null){ %>
                        <div class="navbar-nav ml-auto py-0">
                        <p class="nav-item nav-link"> Welcome <i class="fa-sharp fa-solid fa-hand-wave"></i><%= session.getAttribute("lastname") %></p>
                        <a href="EditProfileController" class="nav-item nav-link"><i class="fa-solid fa-address-card"></i> Profile</a>
                        <a href="PaymentHistoryController" class="nav-item nav-link"><i class="fa-solid fa-credit-card"></i> Payment history</a>
                        <a href="LogoutController" class="nav-item nav-link"><i class="fa-solid fa-right-from-bracket"></i> Logout</a>
                        </div>
                        <% } %>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Shop Detail</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="HomeController">Home</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Shop Detail</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Shop Detail Start -->
    <div class="container-fluid py-5">
        <div class="row px-xl-5">
                <%
        //ResultSet rs = dbconnect.getResultFromSqlQuery("select * from product");
		//while (rs.next()) {
			for(int i = 0; i< list.size(); i++){
        %>
            <div class="col-lg-5 pb-5">
                <div id="product-carousel" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner border">
                        <div class="carousel-item active">
                            <img class="w-100 h-100" src="<%= list.get(i).getImage() %>" alt="Image">
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-7 pb-5">
                <h3 class="font-weight-semi-bold"><%= list.get(i).getName() %></h3>
                <div class="d-flex mb-3">
                    <div class="text-primary mr-2">
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star"></small>
                        <small class="fas fa-star-half-alt"></small>
                        <small class="far fa-star"></small>
                    </div>
                    <small class="pt-1">(50 Reviews)</small>
                </div>
                <h3 class="font-weight-semi-bold mb-4"><%= list.get(i).getPrice() %>$</h3>
                
                <p class="mb-4"><%= list.get(i).getDescription() %></p>
                
                <div class="d-flex align-items-center mb-4 pt-2">
                    <div class="input-group quantity mr-3" style="width: 130px;">
                        <div class="input-group-btn">
                            <button class="btn btn-primary btn-minus" >
                            <i class="fa fa-minus"></i>
                            </button>
                        </div>
                        <input type="text" class="form-control bg-secondary text-center" value="1">
                        <div class="input-group-btn">
                            <button class="btn btn-primary btn-plus">
                                <i class="fa fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    
                    <a href="AddToCartController?idP=<%= list.get(i).getId() %>" class="btn btn-primary px-3"><i class="fa fa-shopping-cart mr-1"></i> Add To Cart</a>
                </div>
                <div class="d-flex pt-2">
                    <p class="text-dark font-weight-medium mb-0 mr-2">Share on:</p>
                    <div class="d-inline-flex">
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-facebook-f"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-linkedin-in"></i>
                        </a>
                        <a class="text-dark px-2" href="">
                            <i class="fab fa-pinterest"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="nav nav-tabs justify-content-center border-secondary mb-4">
                    <a class="nav-item nav-link active" data-toggle="tab" href="#tab-pane-1">Description</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-2">Information</a>
                    <a class="nav-item nav-link" data-toggle="tab" href="#tab-pane-3">Reviews (0)</a>
                </div>
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="tab-pane-1">
                        <h4 class="mb-3">Product Description</h4>
                        <p><%= list.get(i).getDescription() %></p>
                    </div>
                    <% } %>
                    <div class="tab-pane fade" id="tab-pane-2">
                        <h4 class="mb-3">Information</h4>
                        <div class="row">
                            <div class="col-md-6">
                                <ul class="list-group list-group-flush">
                                <%
                                List<ProductDetail> listD = (List<ProductDetail>)request.getAttribute("listD");
                    			for(int i = 0; i< listD.size(); i++){
                                %>
                                    <li class="list-group-item px-0">
                                        Màn hình: <%= listD.get(i).getScreen() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Hệ điều hành: <%= listD.get(i).getSystem() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Camera trước: <%= listD.get(i).getFrontcamera() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Camera sau: <%= listD.get(i).getRearcamera() %>
                                    </li>
                                  </ul>
                                  <% } %>
                            </div>
                            <div class="col-md-6">
                                <ul class="list-group list-group-flush">
                                <%
                                List<ProductDetail> listD1 = (List<ProductDetail>)request.getAttribute("listD");
                    			for(int i = 0; i< listD.size(); i++){
                                %>
                                    <li class="list-group-item px-0">
                                        Chip: <%= listD.get(i).getChip() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Ram: <%= listD.get(i).getRam() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Sim: <%= listD.get(i).getSim() %>
                                    </li>
                                    <li class="list-group-item px-0">
                                        Pin: <%= listD.get(i).getBattery() %>
                                    </li>
                                  </ul> 
                                  <% } %>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="tab-pane-3">
                        <div class="row">
                            <div class="col-md-6">
                                <h4 class="mb-4">1 review for "Colorful Stylish Shirt"</h4>
                                <div class="media mb-4">
                                    <img src="img/user.jpg" alt="Image" class="img-fluid mr-3 mt-1" style="width: 45px;">
                                    <div class="media-body">
                                        <h6>John Doe<small> - <i>01 Jan 2045</i></small></h6>
                                        <div class="text-primary mb-2">
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star"></i>
                                            <i class="fas fa-star-half-alt"></i>
                                            <i class="far fa-star"></i>
                                        </div>
                                        <p>Diam amet duo labore stet elitr ea clita ipsum, tempor labore accusam ipsum et no at. Kasd diam tempor rebum magna dolores sed sed eirmod ipsum.</p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <h4 class="mb-4">Leave a review</h4>
                                <small>Your email address will not be published. Required fields are marked *</small>
                                <div class="d-flex my-3">
                                    <p class="mb-0 mr-2">Your Rating * :</p>
                                    <div class="text-primary">
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                        <i class="far fa-star"></i>
                                    </div>
                                </div>
                                <form>
                                    <div class="form-group">
                                        <label for="message">Your Review *</label>
                                        <textarea id="message" cols="30" rows="5" class="form-control"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Your Name *</label>
                                        <input type="text" class="form-control" id="name">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Your Email *</label>
                                        <input type="email" class="form-control" id="email">
                                    </div>
                                    <div class="form-group mb-0">
                                        <input type="submit" value="Leave Your Review" class="btn btn-primary px-3">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Shop Detail End -->


    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">You May Also Like</span></h2>
        </div>
        <div class="row px-xl-5">
            <div class="col">
                <div class="owl-carousel related-carousel">
            <%
			List<Product> listall = (List<Product>)request.getAttribute("listAll");
			for(int i = 0; i< listall.size(); i++){
        	%>
                    <div class="card product-item border-0">
                        <div class="card-header product-img position-relative overflow-hidden bg-transparent border p-0">
                            <img class="img-fluid w-100" src="<%= listall.get(i).getImage() %>" alt="">
                        </div>
                        <div class="card-body border-left border-right text-center p-0 pt-4 pb-3">
                            <h6 class="text-truncate mb-3"><%= listall.get(i).getName() %></h6>
                            <div class="d-flex justify-content-center">
                                <h6><%= listall.get(i).getPrice() %></h6><h6 class="text-muted ml-2"><del><%= listall.get(i).getPrice() %></del></h6>
                            </div>
                        </div>
                        <div class="card-footer d-flex justify-content-between bg-light border">
                            <a href="DetailController?idP=<%= listall.get(i).getId() %>" class="btn btn-sm text-dark p-0"><i class="fas fa-eye text-primary mr-1"></i>View Detail</a>
                            <a href="" class="btn btn-sm text-dark p-0"><i class="fas fa-shopping-cart text-primary mr-1"></i>Add To Cart</a>
                        </div>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>
    <!-- Products End -->


    <!-- Footer Start -->
     <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <h1 class="mb-4 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Shopper</h1>
                </a>
                <p>TranDucTan Cooperation</p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street, New York, USA</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>tranductan66vn@gmail.com</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="HomeController"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="ShopController"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="CartController"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="CheckOutController"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Quick Links</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="HomeController"><i class="fa fa-angle-right mr-2"></i>Home</a>
                            <a class="text-dark mb-2" href="ShopController"><i class="fa fa-angle-right mr-2"></i>Our Shop</a>
                            <a class="text-dark mb-2" href="CartController"><i class="fa fa-angle-right mr-2"></i>Shopping Cart</a>
                            <a class="text-dark mb-2" href="CheckOutController"><i class="fa fa-angle-right mr-2"></i>Checkout</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row border-top border-light mx-xl-5 py-4">
            <div class="col-md-6 px-xl-0">
                <p class="mb-md-0 text-center text-md-left text-dark">
                    &copy; <a class="text-dark font-weight-semi-bold" href="HomeController">EShopper</a>. All Rights Reserved. Designed
                    by
                    <label class="text-dark font-weight-semi-bold">Tran Duc Tan</label>
                    <br>
                    Distributed By <label class="text-dark font-weight-semi-bold">Tran Duc Tan</label>
                </p>
            </div>
            <div class="col-md-6 px-xl-0 text-center text-md-right">
                <img class="img-fluid" src="img/payments.png" alt="">
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>