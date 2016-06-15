<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true" %>

<jsp:include page="/WEB-INF/template/header.jsp"/>




<section>
        <div class="container">

            

            <div class="row">

                <div class="text-center">
                <h3>Hi, ,<strong><%= session.getAttribute("username") %></strong>. Pay your ticket now?</h3>
            </div>

                <div class="col-md-6 col-md-offset-3">


                    <form class="form-horizontal"  name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
                        
                        <input type="hidden" value="<%= session.getAttribute("username") %>"  name="username"/>
                        <input type="hidden" value="0"  name="payment"/>

                        <input type="hidden" name="cmd" value="_xclick" />
                        <input type="hidden" name="business" value="jakzaizzat@gmail.com" />
                        <input type="hidden" name="password" value="jakzshinigami09" />
                        <input type="hidden" name="item_name" value="Ticket Zoo " />
                        <input type="hidden" name="rm" value="1" />
                        <input type="hidden" name="amount" value="<c:out value="${ticket.total}" />"/>
                        <input TYPE="hidden" NAME="currency_code" value="MYR">
                        <input type="hidden" name="return" value="http://localhost:8081/CSC577/OrderServlet?action=cartToPayment&ticketid=<c:out value="${ticket.ticketId}" />" />
                        <input type="hidden" name="cancel_return" value="http://localhost:8081/CSC577/OrderServlet?action=listTicketInCart" />
                        <input type="hidden" name="cert_id" value="API Singature" />

                    <div class="ticket">
                        
                        <div class="ticket-id cart">
                            <h3>#<c:out value="${ticket.ticketId}" /></h3>
                        </div>

                        <div class="ticket-date">
                            <p><i class="fa fa-calendar"></i> <c:out value="${ticket.ticketdate}" /></p>
                        </div>
                        
                        <hr>

                        <div class="ticket-summary">
                            <h4>ITEMS</h4>
                            <p><c:out value="${ticket.adultTicket}" /> Adult</p>
                            <p><c:out value="${ticket.childticket}" /> Child</p>
                        </div>
                            
                        <hr>

                        <div class="ticket-total cart">
                            <h3><a href="#">RM <c:out value="${ticket.total}" /></a></h3>
                            
                        </div>

                    </div>
						
						<input type="submit" class="btn btn-lg btn-raised btn-primary btn-paypal" value="Pay via Paypal"/>
						
                    </form>
                </div>
            </div>
        </div>
    </section>



<jsp:include page="/WEB-INF/template/footer.jsp"/>