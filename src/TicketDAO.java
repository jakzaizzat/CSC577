import java.util.*;
import java.sql.*;

public class TicketDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	//add ticket
	public void add(TicketInfo bean){
		int ticketId = bean.getTicketId();
		String ticketDate = bean.getTicketdate();
		int ticketAdult = bean.getAdultTicket();
		int ticketChild = bean.getChildticket();
		
		
		try{
			//connect to DB
			
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into ticket (ticketid, orderdate, adultticket, childticket)values(?,?,?,?)");
			ps.setInt(1,ticketId);
			ps.setString(2,ticketDate);
			ps.setInt(3,ticketAdult);
			ps.setInt(4,ticketChild);

			ps.executeUpdate();
		} catch(Exception ex){
			System.out.println("Failed: An exception has occured! " + ex);
		}
		
		
		//some exception handling
		finally{
			if(ps != null){
				try{
					ps.close();
				}catch(Exception e){
				}
				ps = null;
			}
			
			if(currentCon != null){
				try{
					currentCon.close();
				}catch(Exception e){
				}
				currentCon = null;
			}
		}
		//return bean
	}
	
	
	//delete ticker
	public void deleteTicket(int ticketId){
		try{
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("delete from ticket where ticketid=?");
			//parameter start with 1
			ps.setInt(1,ticketId);
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//update ticket
	public void updateTicket(TicketInfo bean){
		
		int ticketId = bean.getTicketId();
		String ticketDate = bean.getTicketdate();
		int ticketAdult = bean.getAdultTicket();
		int ticketChild = bean.getChildticket();
		
		String searchQuery = "UPDATE ticket SET ticketid='" + ticketId + "', ticketdate='" + ticketDate+ "', ticketAdult= '" + ticketAdult + "', ticketChild='" + ticketChild + "'";
		
		try{
		currentCon = ConnectionManager.getConnection();
		stmt = currentCon.createStatement();
		stmt.executeUpdate(searchQuery);
		
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	//list ticket
	public List<TicketInfo> getAllTicket(){
		
		List<TicketInfo> tickets = new ArrayList<TicketInfo>();
		
		try{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from ticket");
			
			while(rs.next()){
				TicketInfo ticket = new TicketInfo();
				ticket.setTicketId(rs.getInt("ticketid"));
				ticket.setTicketdate(rs.getString("ticketdate"));
				ticket.setAdultTicket(rs.getInt("adultticket"));
				ticket.setChildticket(rs.getInt("childticket"));
				
				tickets.add(ticket);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tickets;
		
	}
	
	
	//get ticket by id
	public TicketInfo getTicketById(int ticketid){
		
		TicketInfo ticket = new TicketInfo();
		
		try{
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("select * from ticket where ticketid=?");
			
			ps.setInt(1, ticketid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				ticket.setTicketId(rs.getInt("ticketid"));
				ticket.setTicketdate(rs.getString("ticketdate"));
				ticket.setAdultTicket(rs.getInt("adultticket"));
				ticket.setChildticket(rs.getInt("childticket"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	


}
