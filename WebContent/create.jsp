<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>


<section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">

                    <c:if test="${errorMessage != null}" >
                        <div class="alert alert-dismissible alert-success">
                             <button type="button" class="close" data-dismiss="alert">×</button>
                             <strong>${errorMessage}</strong> 
                        </div>
                      </c:if>
                      
                      <c:if test="${param.message != null}" >
                      <div class="alert alert-dismissible alert-success">
                             <button type="button" class="close" data-dismiss="alert">×</button>
                             <strong>${param.message}</strong>
                       </div>
                      </c:if>

                    <h3>Hi, <strong><%= session.getAttribute("username") %></strong>. Get ticket online now</h3>
                    <p>Grab your copy today</p>
                    
                    <form class="signup-form" action="OrderServlet" method="POST" role="form" name="formAddTicket">

                        <input type="hidden" value="<%= session.getAttribute("username") %>"  name="username"/>
                        <input type="hidden" value="0"  name="payment"/>


                        <div class="form-input-group">
                            <i class="fa fa-calendar"></i><input type="date" class="" placeholder="Enter your date" name="date" required>
                        </div>

                        <p>RM<span class="price1"><c:out value='${price.adultPrice}' />0</span> for Adult</p>
                        
                        <div class="form-input-group">
                            <i class="fa fa-male"></i><input type="number" class="" placeholder="Adult Ticket" name="adult" value="0" id="adult" min="0" required>
                        </div>

                        <p>RM<span class="price2"><c:out value='${price.childPrice}' />0</span> for Child</p>

                        <div class="form-input-group">
                            <i class="fa fa-child"></i><input type="number" class="" placeholder="Child Ticket" name="child" id="child" value="0" min="0" required>
                        </div>

                        <p class="total-price" >Total:RM<span class="total-add"></span></p>
                        <input type="hidden" class="total-price" name="total" id ="total" value=""/>

                        <button type="submit" class="btn-fill sign-up-btn">Buy Now</button>
                        
                    </form>
                </div>
            </div>
        </div>
    </section>


<jsp:include page="/WEB-INF/template/footer.jsp"/>



