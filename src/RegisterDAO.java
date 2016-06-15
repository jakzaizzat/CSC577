
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;



public class RegisterDAO extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	private static String INSERT = "/create.jsp";
	
	private UserDAO dao;
	
	
	public RegisterDAO(){
		super();
		dao = new UserDAO();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
		int staff = Integer.parseInt(request.getParameter("staff"));
		
		
		String update = request.getParameter("update");
		
		
		//md5
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 20) {
                hashtext = "0" + hashtext;
            }
            password = hashtext;
            System.out.println("New encryp password " + password);
			
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
		
		
		
		
		
		try{
			//connect to DB
			currentCon = ConnectionManager.getConnection();
			
			
			if(update == null){
			
				ps=currentCon.prepareStatement("insert into customer (email, username, password, staff)values(?,?,?,?)");
				
				ps.setString(1, email);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setInt(4, staff);
				
				int i = ps.executeUpdate();
				
				if(i>0){
					RequestDispatcher view = request.getRequestDispatcher("login.jsp");
					view.forward(request, response);
				}
			}else{
				String searchQuery ="UPDATE customer SET email='" + email + "', password='" + password+ "' WHERE username= '" + username + "'  ";
				stmt = currentCon.createStatement();
				stmt.executeUpdate(searchQuery);
				
				request.setAttribute("errorMessage", "Done update profile. You're good to go");
				
				String message = "Done update profile. You're good to go";
				
				response.sendRedirect("/CSC577/TicketServlet?action=insert&message=" + URLEncoder.encode(message, "UTF-8"));
				
			}
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String forward ="";
		String action = request.getParameter("action");
		String username = request.getParameter("username");
		
		
		if(action.equalsIgnoreCase("editprofile")){
			forward = "profile.jsp";
			RequestDispatcher view = request.getRequestDispatcher(forward);
			UserInfo user = dao.editProfile(username);
			request.setAttribute("user", user);
			view.forward(request, response);
			
		}
		
		
	}
	
	
}
