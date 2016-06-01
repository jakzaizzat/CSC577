<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>




<div class="row">
  <div class="col-md-6 col-md-offset-3">
    
  
  <h3 class="text-center">Hi,<strong><%= session.getAttribute("username") %></strong>. Want to pay your ticket now? </h3>
  
  
	
  <form class="form-horizontal"  name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
  
  <input type="hidden" value="<%= session.getAttribute("username") %>"  name="username"/>
  <input type="hidden" value="0"  name="payment"/>
  
  <p class="text-center">Adult : <c:out value="${ticket.adultTicket * 20}" /></p>
  <p class="text-center">Child : <c:out value="${ticket.childticket * 10}" /></p>
   
  <h3 class="text-center">Total <c:out value="${ticket.adultTicket * 20 + ticket.childticket * 10}" /> </h3> 
    
  <input type="hidden" name="cmd" value="_xclick" />
  <input type="text" name="business" value="jakzaizzat@gmail.com" />
  <input type="text" name="password" value="jakzshinigami09" />
  <input type="text" name="ticketid" value="<c:out value="${ticket.ticketId}" />" />
  <input type="text" name="item_name" value="Ticket Zoo " />
  <input type="text" name="rm" value="1" />
  <input type="text" name="amount" value="<c:out value="${ticket.adultTicket * 20 + ticket.childticket * 10}" />"/>
  <input TYPE="hidden" NAME="currency_code" value="MYR">
  <input type="text" name="return" value="http://localhost:8081/CSC577/TicketServlet?action=cartToPayment&ticketid=<c:out value="${ticket.ticketId}" />" />
  <input type="text" name="cancel_return" value="http://localhost:8081/CSC577/TicketServlet?action=listTicketInCart" />
  <input type="text" name="cert_id" value="API Singature" />
  <input type="submit" class="btn btn-lg btn-block btn-raised btn-success" value="Pay via Paypal"/>
  
  </form>

  </div>

</div>



<jsp:include page="/WEB-INF/template/footer.jsp"/>