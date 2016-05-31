
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class RegisterDAO extends HttpServlet{

	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	private static String INSERT = "/create.jsp";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
		int staff = Integer.parseInt(request.getParameter("staff"));
		
		try{
			//connect to DB
			currentCon = ConnectionManager.getConnection();
			
			ps=currentCon.prepareStatement("insert into customer (email, username, password, staff)values(?,?,?,?)");
			
			ps.setString(1, email);
			ps.setString(2, username);
			ps.setString(3, password);
			ps.setInt(4, staff);
			
			int i = ps.executeUpdate();
			
			if(i>0){
				RequestDispatcher view = request.getRequestDispatcher(INSERT);
				view.forward(request, response);
			}
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	
}
