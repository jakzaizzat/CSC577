<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/template/header.jsp"/>


<section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Get started with eTicketing, absolutely free</h3>
                    <p>No need to line up</p>
                    <form class="signup-form" action="registerDAO" method="POST" role="form">
                        <div class="form-input-group">
                            <i class="fa fa-user"></i><input type="text" class="" placeholder="Enter your username" name="username" required>
                        </div>
                        <div class="form-input-group">
                            <i class="fa fa-envelope"></i><input type="email" class="" placeholder="Enter your email" name="email" required>
                        </div>
                        <div class="form-input-group">
                            <i class="fa fa-lock"></i><input type="password" class="" placeholder="Enter your password" name="password" required>
                        </div>

                        <input type="hidden" name="staff" value="0"/>

                        <button type="submit" class="btn-fill sign-up-btn">Sign up for free</button>
                    </form>
                </div>
            </div>
        </div>
    </section>


<jsp:include page="/WEB-INF/template/footer.jsp"/>