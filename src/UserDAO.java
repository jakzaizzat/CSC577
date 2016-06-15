import java.util.*;
import java.sql.*;

public class UserDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;

	//Get Information Profile of current session
	public UserInfo editProfile(String username){
		
		UserInfo user = new UserInfo();
		
		try{
			currentCon = ConnectionManager.getConnection();
			
			ps = currentCon.prepareStatement("select * from customer where username=?");
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
				if(rs.next()){
					
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setStaff(rs.getInt("staff"));
				}
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		
		
		return user;
	}


}