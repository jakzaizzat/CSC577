import java.sql.*;

public class Validate {
	
	public static boolean checkUser(String username,String password){
		
		Connection currentCon = null;
		ResultSet rs = null; 
		PreparedStatement ps=null;
		Statement stmt=null;
		
		
		
		
		boolean st = false;
		
		try{
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select * from customer where username=? and password=?");
			
			ps.setString(1,username);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			st = rs.next();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return st;
	}
	
}
