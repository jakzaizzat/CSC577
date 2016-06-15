<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    

<jsp:include page="/WEB-INF/template/header.jsp"/>


<section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                	
                	<c:if test="${param.message != null}" >
                        <div class="alert alert-dismissible alert-success">
                             <button type="button" class="close" data-dismiss="alert">×</button>
                             <strong>${param.message}</strong> 
                        </div>
                      </c:if>
                	
                    <h3>Edit <%= session.getAttribute("username") %> Profile</h3>
                    <form class="signup-form" action="registerDAO" method="POST" role="form">
                        
                            <input type="hidden" class="" placeholder="Enter your username" name="username" value="<c:out value="${user.username}" />" required>
                        
                        <div class="form-input-group">
                            <i class="fa fa-lock"></i><input type="email" class="" placeholder="Enter your email" name="email" value="<c:out value="${user.email}" />" required>
                        </div>
                        <div class="form-input-group">
                            <i class="fa fa-lock"></i><input type="password" class="" placeholder="Enter your password" name="password"  required>
                        </div>
                        
                        <input type="hidden" name="staff" value="0"/>
                        
                        <input type="hidden" name="update" value="yes" />
                        
                        <button type="submit" name="update" class="btn-fill sign-up-btn">Update Now</button>
                    </form>
                </div>
            </div>
        </div>
    </section>







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


<jsp:include page="/WEB-INF/template/footer.jsp"/>
