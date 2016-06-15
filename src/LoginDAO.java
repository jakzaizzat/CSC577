
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.io.*;
import java.math.BigInteger;

import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginDAO extends HttpServlet {
	
	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/create.jsp";
	private static String LOGIN = "/login.jsp";
	
	Connection currentCon = null;
	ResultSet rs = null; 
	PreparedStatement ps=null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        
        //MD5
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
	        BigInteger number = new BigInteger(1, messageDigest);
	        String hashtext = number.toString(16);
	        // Now we need to zero pad it if you actually want the full 32 chars.
	        while (hashtext.length() < 20) {
	            hashtext = "0" + hashtext;
	        }
	        password = hashtext;
	        System.out.println("New encryp password " + password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        
        if(Validate.checkUser(username,password)){
        	
        	System.out.println("Done validates");
        	
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("username", username);
        	
        	//setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            
            Cookie CookieUserName = new Cookie("username", username);
            CookieUserName.setMaxAge(30*60);
            response.addCookie(CookieUserName);
            
            
            //Check wether the user is staff or not
            if(Staffornot.checkUserStaff(username)){
            	System.out.println("This user is staff");
            	response.sendRedirect("/CSC577/TicketServlet?action=price&priceid=1");
            }else{
            	System.out.println("This user is not staff");
            	response.sendRedirect("/CSC577/TicketServlet?action=insert");
                
            }
        	
            
        	//RequestDispatcher view = request.getRequestDispatcher(INSERT);
        	//view.forward(request, response);
        }
        else{
        	System.out.println("Username and Pass incorrect");
        	 request.setAttribute("errorMessage", "Your Username and Password didn't match");
        	RequestDispatcher view = request.getRequestDispatcher(LOGIN);
        	view.include(request, response);
        }
		
	}

}
