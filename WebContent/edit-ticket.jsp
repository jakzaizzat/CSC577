<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>


<section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">

                    
                      
                      <div class="alert alert-dismissible alert-success">
                             <button type="button" class="close" data-dismiss="alert">×</button>
                             <strong>${param.message}</strong>
                       </div>
                      

                    <h3>Hi, <strong><%= session.getAttribute("username") %></strong>. Edit Ticket <c:out value="${ticket.ticketId}" /></h3>
                    <p>Grab your copy today</p>
                    
                    <form class="signup-form" action="OrderServlet" method="POST" role="form" name="formAddTicket">
                    
                    	<input type="hidden" name="ticketId" value="<c:out value="${ticket.ticketId}" />" />
						<input type="hidden" name="username" value="<c:out value="${ticket.username}" />" />
						<input type="hidden" name="payment" value="0"/>

                        <input type="hidden" value="<%= session.getAttribute("username") %>"  name="username"/>
                        <input type="hidden" value="0"  name="payment"/>


                        <div class="form-input-group">
                            <i class="fa fa-calendar"></i><input type="date" class="" placeholder="Enter your date" name="date" value="<c:out value="${ticket.ticketdate}" />" required>
                        </div>

                        <p>RM<span class="price1">20.00</span> for Adult</p>
                        
                        <div class="form-input-group">
                            <i class="fa fa-male"></i><input type="number" class="" placeholder="Adult Ticket" name="adult" id="adult" min="0" value="<c:out value="${ticket.adultTicket}" />" required>
                        </div>

                        <p>RM<span class="price2">10.00</span> for Child</p>

                        <div class="form-input-group">
                            <i class="fa fa-child"></i><input type="number" class="" placeholder="Child Ticket" name="child" id="child" min="0" value="<c:out value="${ticket.childticket}" />" required>
                        </div>

                        <p class="total-price" >Total:RM<span class="total-add"></span></p>
                        <input type="hidden" class="total-price" name="total" id ="total" value=""/>

                        <button type="submit" class="btn-fill sign-up-btn">Update Now</button>
                        
                    </form>
                </div>
            </div>
        </div>
    </section>


<jsp:include page="/WEB-INF/template/footer.jsp"/>



