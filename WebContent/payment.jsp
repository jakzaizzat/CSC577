<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="paypalForm" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
<input type="hidden" name="cmd" value="_xclick" />
<input type="text" name="business" value="jakzaizzat@gmail.com" />
<input type="text" name="password" value="jakzshinigami09" />
<input type="text" name="custom" value="1123" />
<input type="text" name="item_name" value="Tshirt " />
<input type="text" name="amount" value="60.00"/>
<input type="text" name="rm" value="1" />
<INPUT TYPE="hidden" NAME="currency_code" value="MYR">
<input type="text" name="return" value="http://localhost:8080/PaypalGS/paypalResponse.jsp" />
<input type="text" name="cancel_return" value="http://localhost:8080/PaypalGS/paypalResponseCancel.jsp" />
<input type="text" name="cert_id" value="API Singature" /><input type="Submit" value="Pay with Paypal"/>
</form>
</body>
</html>