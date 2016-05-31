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
		//String username = (String) session.getAttribute("username");
		String username = bean.getUsername();
		
		
		System.out.println("ticketid:" + ticketId);
		try{
			//connect to DB
			
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into ticketorder (orderdate, adultticket, childticket,username)values(?,?,?,?)");
			//ps.setInt(1,ticketId);
			ps.setString(1,ticketDate);
			ps.setInt(2,ticketAdult);
			ps.setInt(3,ticketChild);
			ps.setString(4,username);

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
		
		System.out.println("Done add ticket");
		//return bean
	}
	
	
	//delete ticker
	public void deleteTicket(int ticketId){
		try{
			currentCon = ConnectionManager.getConnection();
			ps = currentCon.prepareStatement("delete from ticketorder where ticketid=?");
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
		System.out.println("In Update Ticket - TicketDAO");
		System.out.println(ticketId + ticketDate + ticketAdult + ticketChild);
		
		String searchQuery = "UPDATE ticketorder SET ticketid='" + ticketId + "', orderdate='" + ticketDate+ "', adultticket= '" + ticketAdult + "', childticket='" + ticketChild + "' WHERE ticketid= '" + ticketId + "'  ";
		
	
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
			
			ResultSet rs = stmt.executeQuery("select * from ticketorder");
			
			while(rs.next()){
				TicketInfo ticket = new TicketInfo();
				ticket.setTicketId(rs.getInt("ticketid"));
				ticket.setTicketdate(rs.getString("orderdate"));
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
			ps = currentCon.prepareStatement("select * from ticketorder where ticketid=?");
			
			ps.setInt(1, ticketid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				ticket.setTicketId(rs.getInt("ticketid"));
				ticket.setTicketdate(rs.getString("orderdate"));
				ticket.setAdultTicket(rs.getInt("adultticket"));
				ticket.setChildticket(rs.getInt("childticket"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ticket;
		
	}
	
	//list ticket by Username
		public List<TicketInfo> getAllTicketByUsername(String username){
			
			List<TicketInfo> tickets = new ArrayList<TicketInfo>();
			
			try{
				
				
				currentCon = ConnectionManager.getConnection();
				
				ps = currentCon.prepareStatement("select * from ticketorder where username=?");
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					TicketInfo ticket = new TicketInfo();
					ticket.setTicketId(rs.getInt("ticketid"));
					ticket.setTicketdate(rs.getString("orderdate"));
					ticket.setAdultTicket(rs.getInt("adultticket"));
					ticket.setChildticket(rs.getInt("childticket"));
					ticket.setUsername(rs.getString("username"));
					
					tickets.add(ticket);
					
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return tickets;
			
		}
	


}
