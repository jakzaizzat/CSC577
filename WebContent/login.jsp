<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="/WEB-INF/template/header.jsp"/>


<section class="sign-up section-padding text-center" id="download">
        <div class="container">

            <c:if test="${errorMessage != null}" >
              <div class="alert alert-dismissible alert-danger">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <strong>${errorMessage}</strong>
                If you didn't have account yet. 
                <a href="register.jsp" class="alert-link">Register here</a>
              </div>
          </c:if>

            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Get started with Zoo eTicketing, absolutely free</h3>
                    <p>No need to line up</p>
                    <form class="signup-form" action="LoginDAO" method="POST" role="form">
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input type="text" class="" placeholder="Enter your username" id="username" name="username" required>
                        </div>
                        <div class="form-input-group">
                            <i class="fa fa-lock"></i><input type="password" class="" placeholder="Enter your password" id="password" name="password" required>
                        </div>

                        <input type="hidden" name="staff" value="0"/>

                        <button type="submit" class="btn-fill sign-up-btn">Sign In</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="/WEB-INF/template/footer.jsp"/>
