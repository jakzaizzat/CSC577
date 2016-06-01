<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>


   <div class="row">
	<div class="col-md-6 col-md-offset-3">
		<div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Ticket ID: #<c:out value="${ticket.ticketId}" /></h3>
            </div>
            <div class="panel-body">
            <c:out value="${ticket.adultTicket}" /> Adult Ticket
			</div>
			<div class="panel-body">
              <c:out value="${ticket.childticket}" /> Child Ticket
            </div>
            <div class="panel-body">
            	<a class="btn-lg btn-block btn-raised text-center btn-primary" href="#">Total RM<c:out value="${ticket.adultTicket * 20 + ticket.childticket * 10}" /></a>
            </div>
        </div>
            
        </div>
	</div>

<jsp:include page="/WEB-INF/template/footer.jsp"/>