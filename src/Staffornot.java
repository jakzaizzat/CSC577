import java.sql.*;


public class Staffornot {
	
	public static boolean checkUserStaff(String username){
		

		Connection currentCon = null;
		ResultSet rs = null; 
		PreparedStatement ps=null;
		//Statement stmt=null;
		
		boolean st = false;
		
		
		try{
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("select email from customer where username=? and staff=1");
			
			ps.setString(1,username);
			
			rs = ps.executeQuery();
			st = rs.next();
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return st;
		
		
	}
	
	
}
