<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<jsp:include page="/WEB-INF/template/header.jsp"/>

<section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
  
				  <h3 class="text-center">Current Price For Tickets</h3>
				  
				  
				  <form class="form-horizontal" method="POST" action="TicketServlet" name="formAddTicket">
				  	
				  		
				  		<input type="hidden" value="<c:out value="${price.priceId}" />" name="priceid"/>
				  		  		
					  	<div class="form-group">
					      <label for="inputEmail" class="col-md-2 control-label">Adult</label>
					      <div class="col-md-10">
					        <input type="text" class="form-control" id="adultPrice" placeholder="Adult Price" name="adultPrice" value="<c:out value="${price.adultPrice}" />">
					      </div>
					    </div>
					    <div class="form-group">
				      	  <label for="inputEmail" class="col-md-2 control-label">Child</label>
					      <div class="col-md-10">
					        <input type="text" class="form-control" id="childPrice" placeholder="Child price" name="childPrice" value="<c:out value="${price.childPrice}" />">
					      </div>
					    </div>
					    <div class="form-group">
					      <div class="col-md-10 col-md-offset-2">
					        <button type="submit" class="btn-fill btn-lg sign-up-btn">Submit</button>
					      </div>
					    </div>
					    
					    
				  	
				  </form>
  
  
  				</div>
            </div>
        </div>
    </section>


<jsp:include page="/WEB-INF/template/footer.jsp"/>