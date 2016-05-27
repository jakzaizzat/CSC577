<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>

<html>

<head>
  <title>Material Design for Bootstrap</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">

  <!-- Mobile support -->
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Material Design fonts -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <!-- Bootstrap -->
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

  <!-- Bootstrap Material Design -->
  <link href="css/bootstrap-material-design.css" rel="stylesheet">
  <link href="css/ripples.min.css" rel="stylesheet">

  <!-- Dropdown.js -->
  <link href="http://cdn.rawgit.com/FezVrasta/dropdown.js/master/jquery.dropdown.css" rel="stylesheet">

  <!-- Page style -->
  <link href="style.css" rel="stylesheet">

  <!-- jQuery -->
  <script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

</head>
<body>

<div class="navbar navbar-material-light-blue-300">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-material-light-blue-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="javascript:void(0)">Logo</a>
    </div>
    <div class="navbar-collapse collapse navbar-material-light-blue-collapse">
      <ul class="nav navbar-nav">
        <li><a href="create.html">Create</a></li>
        <li><a href="javascript:void(0)">Read</a></li>
        <li><a href="javascript:void(0)">Update</a></li>
        <li><a href="javascript:void(0)">Delete</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="index.html" data-target="#" class="dropdown-toggle" data-toggle="dropdown">Hi, Aizzat <i class="material-icons">face</i>
            <b class="caret"></b></a>
          <ul class="dropdown-menu">
            <li><a href="javascript:void(0)">Settings</a></li>
            <li><a href="javascript:void(0)">Logout</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>


<div class="row">
  <div class="col-md-8 col-md-offset-2">
    
  <h1 class="text-center">Home</h1>
  <table class="table table-striped table-hover ">
            <thead>
            <tr>
              <th># Order ID</th>
              <th>Date</th>
              <th>Adult</th>
              <th>Child</th>
              <th>Total</th>
              <th>Options</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tickets}" var="ticket">
	            <tr>
	              <td><c:out value="${ticket.ticketId}" /></td>
	              <td><c:out value="${ticket.ticketdate}" /></td>
	              <td><c:out value="${ticket.adultTicket}" /></td>
	              <td><c:out value="${ticket.childticket}" /></td>
	              <td>RM200</td>
	              <td><a href="#" class="btn btn-raised btn-info btn-xs">Edit</a><a href="#" class="btn btn-raised btn-danger btn-xs">Delete</a></td>
	            </tr>
            </c:forEach>
            </tbody>
          </table>

  </div>

</div>


<!-- Open source code -->
<script>
  window.page = window.location.hash || "#about";

  $(document).ready(function () {
    if (window.page != "#about") {
      $(".menu").find("li[data-target=" + window.page + "]").trigger("click");
    }
  });

  $(window).on("resize", function () {
    $("html, body").height($(window).height());
    $(".main, .menu").height($(window).height() - $(".header-panel").outerHeight());
    $(".pages").height($(window).height());
  }).trigger("resize");

  $(".menu li").click(function () {
    // Menu
    if (!$(this).data("target")) return;
    if ($(this).is(".active")) return;
    $(".menu li").not($(this)).removeClass("active");
    $(".page").not(page).removeClass("active").hide();
    window.page = $(this).data("target");
    var page = $(window.page);
    window.location.hash = window.page;
    $(this).addClass("active");


    page.show();

    var totop = setInterval(function () {
      $(".pages").animate({scrollTop: 0}, 0);
    }, 1);

    setTimeout(function () {
      page.addClass("active");
      setTimeout(function () {
        clearInterval(totop);
      }, 1000);
    }, 100);
  });

  function cleanSource(html) {
    var lines = html.split(/\n/);

    lines.shift();
    lines.splice(-1, 1);

    var indentSize = lines[0].length - lines[0].trim().length,
        re = new RegExp(" {" + indentSize + "}");

    lines = lines.map(function (line) {
      if (line.match(re)) {
        line = line.substring(indentSize);
      }

      return line;
    });

    lines = lines.join("\n");

    return lines;
  }

  $("#opensource").click(function () {
    $.get(window.location.href, function (data) {
      var html = $(data).find(window.page).html();
      html = cleanSource(html);
      $("#source-modal pre").text(html);
      $("#source-modal").modal();
    });
  });
</script>

<!-- Twitter Bootstrap -->
<script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- Material Design for Bootstrap -->
<script src="js/material.js"></script>
<script src="js/ripples.min.js"></script>
<script>
  $.material.init();
</script>


<!-- Dropdown.js -->
<script src="https://cdn.rawgit.com/FezVrasta/dropdown.js/master/jquery.dropdown.js"></script>
<script>
  $("#dropdown-menu select").dropdown();
</script>

</body>
</html>
