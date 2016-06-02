import java.util.*;
import java.sql.*;



public class TicketDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	//update ticket price
		public void updateTicket(TicketInfo bean){
			
			int priceId = bean.getPriceId();
			float ticketAdult = bean.getAdultPrice();
			float ticketChild = bean.getChildPrice();
			System.out.println("In Update Ticket Price - TicketDAO");
			
			String searchQuery = "UPDATE ticket SET adult_price='" + ticketAdult + "', child_price='" + ticketChild +  "' WHERE priceId= '" + priceId + "'  ";
			
		
			try{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			stmt.executeUpdate(searchQuery);
			
			
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
		//get price by id
		public TicketInfo getPriceById(int priceid){
			
			TicketInfo price = new TicketInfo();
			
			try{
				currentCon = ConnectionManager.getConnection();
				ps = currentCon.prepareStatement("select * from ticket where priceid=?");
				
				ps.setInt(1, priceid);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					price.setPriceId(rs.getInt("priceid"));
					price.setAdultPrice(rs.getFloat("adult_price"));
					price.setChildPrice(rs.getFloat("child_price"));
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return price;
			
		}

}
