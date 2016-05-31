<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="/WEB-INF/template/header.jsp"/>


<div class="row">
  <div class="col-md-6 col-md-offset-3">
    
  <h1 class="text-center">Edit Ticket ID: <c:out value="${ticket.ticketId}" /></h1>
  

  <form class="form-horizontal" method="POST" action="TicketServlet" name="formAddTicket">
  
  <input type="hidden" type="text" name="ticketId" value="<c:out value="${ticket.ticketId}" />" />
  <fieldset>  
    <div class="form-group">
      <label for="inputEmail" class="col-md-2 control-label">Date</label>
      <div class="col-md-10">
        <input type="date" class="form-control" id="inputEmail" placeholder="Date" name="date" value="<c:out value="${ticket.ticketdate}" />">
      </div>
    </div>
    <div class="form-group">
      <label for="adultTicket" class="col-md-2 control-label">Adult</label>
      <div class="col-md-10">
        <input type="number" class="form-control" id="adultTicket" placeholder="number" name="adult" value="<c:out value="${ticket.adultTicket}" />">
      </div>
    </div>
    <div class="form-group">
      <label for="childTicket" class="col-md-2 control-label">Child</label>
      <div class="col-md-10">
        <input type="number" class="form-control" id="childTicket" placeholder="number" name="child" value="<c:out value="${ticket.childticket}" />">
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-md-10 col-md-offset-2">
        <button type="button" class="btn btn-default">Cancel</button>
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </fieldset>
</form>

  </div>

</div>


<jsp:include page="/WEB-INF/template/footer.jsp"/>
