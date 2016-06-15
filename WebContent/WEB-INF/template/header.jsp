<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="Staff.Staffornot" %>


    <!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Zoo eTicketing System</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">
    <link rel="icon" type="image/png" href="favicon-32x32.png" sizes="32x32" />
    <link rel="icon" type="image/png" href="favicon-16x16.png" sizes="16x16" />
    <link rel="stylesheet" href="css/normalize.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery.fancybox.css">
    <link rel="stylesheet" href="css/flexslider.css">
    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="css/queries.css">
    <link rel="stylesheet" href="css/etline-font.css">
    <link rel="stylesheet" href="bower_components/animate.css/animate.min.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <% String user = (String) session.getAttribute("username"); %>
    <section >
        <section class="dashboard">
            <header>
                <div class="header-content">
                    <div><a href="http://localhost:8081/CSC577/OrderServlet?action=listTicketByUsername"  class="logo-text">Zoo</a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="member-actions">
                                
                                <% if (session.getAttribute("username") != null){ %>
                                	
                                		<% if  (Staffornot.checkUserStaff(user) ) {  %>
	                                		<li><a href="TicketServlet?action=price&priceid=1">Ticket Price</a></li>
	                               		<% } %>
	                               		
	                                <li><a href="OrderServlet?action=listTicketByUsername">Dashboard</a></li>
	                            	<li><a href="OrderServlet?action=listTicketInCart"><i class="fa fa-shopping-cart"/></i> Cart</a></li>
	                                <li><!-- Single button -->
	                                    <div class="btn-group user-nav">
	                                      <button type="button" class="btn btn-user btn-fill dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	                                        Hi, <%= session.getAttribute("username") %> <span class="caret"></span>
	                                      </button>
	                                      <ul class="dropdown-menu">
	                                        <li><a class="text-center" href="/CSC577/registerDAO?action=editprofile&username=<%= session.getAttribute("username") %>">View Profile</a></li>
	                                        <li>
	                                        	<form action="LogoutServlet" method="post">
													<input class="btn btn-small btn-fill" type="submit" value="Sign Out" >
												</form>
	                                        </li>
	                                      </ul>
	                                    </div>
	                                </li>
	                                <li><a href="/CSC577/TicketServlet?action=insert" class="btn btn-small btn-fill">Buy Ticket</a></li>
                                <% } else{ %>
                                	<li><a href="http://localhost:8081/CSC577/register.jsp">Register</a></li>
                                	<li><a href="http://localhost:8081/CSC577/login.jsp">Login</a></li>
                                <% }  %>
                                
                                
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>
    </section>