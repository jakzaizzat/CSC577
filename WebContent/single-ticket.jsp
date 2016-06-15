<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>


  <section>
        <div class="container">
            <div class="row">
                


                      <% String txt = (String) session.getAttribute("username"); %>

                <div class="col-md-6 col-md-offset-3">
                	<c:if test="${errorMessage != null}" >
                        <div class="alert alert-dismissible alert-success">
                             <button type="button" class="close" data-dismiss="alert">×</button>
                             <strong>${errorMessage}</strong> 
                        </div>
                      </c:if>
                    <div class="ticket">
                        
                        <div class="ticket-id">
                            <h3>#<c:out value="${ticket.ticketId}" /></h3>
                        </div>

                         <div class="qrcode">
                            <img src="/CSC577/qrservlet?qrtext&ticketid=<c:out value='${ticket.ticketId}' />&username=<%= txt %>" class="center-block" alt="Sketch Logo" class="img-responsive center-block">
                        </div>

                        <div class="ticket-date">
                            <p><i class="fa fa-calendar"></i> <c:out value="${ticket.ticketdate}" /></p>
                        </div>
                        
                        <hr>

                        <div class="ticket-summary">
                            <h4>ITEMS</h4>
                            </hr>
                            <p><c:out value="${ticket.adultTicket}" /> Adult </p>
                            <p><c:out value="${ticket.childticket}" /> Child </p>
                        </div>
                            
                        <hr>

                        <div class="ticket-total">
                            <h3>RM <c:out value="${ticket.total}" />0</h3>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>

<jsp:include page="/WEB-INF/template/footer.jsp"/>