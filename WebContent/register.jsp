<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="/WEB-INF/template/header.jsp"/>


<div class="row">
  <div class="col-md-6 col-md-offset-3">
  
  <div class="well bs-component">
  <form class="form-horizontal" action="registerDAO" method="post">
  <fieldset>
    <legend>Register</legend>
    <div class="form-group">
      <label for="inputusernmae" class="col-md-2 control-label">Username</label>

      <div class="col-md-10">
        <input type="text" class="form-control" id="inputusername" placeholder="Usernmae" name="username">
      </div>
    </div>
    <div class="form-group">
      <label for="inputEmail" class="col-md-2 control-label">Email</label>

      <div class="col-md-10">
        <input type="email" class="form-control" id="inputEmail" placeholder="Email" name="email">
      </div>
    </div>
    <div class="form-group">
      <label for="inputPassword" class="col-md-2 control-label">Password</label>

      <div class="col-md-10">
        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
      </div>
    </div>
    
    <input type="hidden" name="staff" value="0"/>
    
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

</div>


<jsp:include page="/WEB-INF/template/footer.jsp"/>