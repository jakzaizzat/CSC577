import java.util.*;
import java.sql.*;

public class OrderDAO {
	
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	
	//add ticket
	public void add(OrderInfo bean){
		int ticketId = bean.getTicketId();
		String ticketDate = bean.getTicketdate();
		int ticketAdult = bean.getAdultTicket();
		int ticketChild = bean.getChildticket();
		//String username = (String) session.getAttribute("username");
		String username = bean.getUsername();
		int payment = bean.getPayment();
		double total = bean.getTotal();
		
		
		System.out.println("ticketid:" + ticketId);
		try{
			//connect to DB
			
			currentCon = ConnectionManager.getConnection();
			ps=currentCon.prepareStatement("insert into ticketorder (orderdate, adultticket, childticket,username,payment,total)values(?,?,?,?,?,?)");
			//ps.setInt(1,ticketId);
			ps.setString(1,ticketDate);
			ps.setInt(2,ticketAdult);
			ps.setInt(3,ticketChild);
			ps.setString(4,username);
			ps.setInt(5,payment);
			ps.setDouble(6,total);
			
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
	public void updateTicket(OrderInfo bean){
		
		float ticketId = bean.getTicketId();
		String ticketDate = bean.getTicketdate();
		int ticketAdult = bean.getAdultTicket();
		int ticketChild = bean.getChildticket();
		double total = bean.getTotal();
		System.out.println("In Update Ticket - TicketDAO");
		System.out.println(ticketId + ticketDate + ticketAdult + ticketChild);
		
		String searchQuery = "UPDATE ticketorder SET ticketid='" + ticketId + "', orderdate='" + ticketDate+ "', adultticket= '" + ticketAdult + "', childticket='" + ticketChild + "',total='" + total + "' WHERE ticketid= '" + ticketId + "' ";
		
	
		try{
		currentCon = ConnectionManager.getConnection();
		stmt = currentCon.createStatement();
		stmt.executeUpdate(searchQuery);
		
		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	//list ticket
	public List<OrderInfo> getAllTicket(){
		
		List<OrderInfo> tickets = new ArrayList<OrderInfo>();
		
		try{
			currentCon = ConnectionManager.getConnection();
			stmt = currentCon.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from ticketorder");
			
			while(rs.next()){
				OrderInfo ticket = new OrderInfo();
				ticket.setTicketId(rs.getInt("ticketid"));
				ticket.setTicketdate(rs.getString("orderdate"));
				ticket.setAdultTicket(rs.getInt("adultticket"));
				ticket.setChildticket(rs.getInt("childticket"));
				ticket.setTotal(rs.getDouble("total"));
				
				tickets.add(ticket);
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return tickets;
		
	}
	
	
	//get ticket by id
	public OrderInfo getTicketById(int ticketid){
		
		OrderInfo ticket = new OrderInfo();
		
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
				ticket.setUsername(rs.getString("username"));
				ticket.setTotal(rs.getDouble("total"));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return ticket;
		
	}
	
	//list ticket by Username for cart
		public List<OrderInfo> getAllTicketByUsernameCart(String username){
			
			List<OrderInfo> tickets = new ArrayList<OrderInfo>();
			
			try{
				
				
				currentCon = ConnectionManager.getConnection();
				
				ps = currentCon.prepareStatement("select * from ticketorder where username=? and payment=0");
				ps.setString(1, username);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					OrderInfo ticket = new OrderInfo();
					ticket.setTicketId(rs.getInt("ticketid"));
					ticket.setTicketdate(rs.getString("orderdate"));
					ticket.setAdultTicket(rs.getInt("adultticket"));
					ticket.setChildticket(rs.getInt("childticket"));
					ticket.setUsername(rs.getString("username"));
					ticket.setTotal(rs.getDouble("total"));
					
					tickets.add(ticket);
					
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			return tickets;
			
		}
		
		//list ticket by Username after payment
				public List<OrderInfo> getAllTicketByUsernamePayment(String username){
					
					List<OrderInfo> tickets = new ArrayList<OrderInfo>();
					
					try{
						
						
						currentCon = ConnectionManager.getConnection();
						
						ps = currentCon.prepareStatement("select * from ticketorder where username=? and payment=1");
						ps.setString(1, username);
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()){
							OrderInfo ticket = new OrderInfo();
							ticket.setTicketId(rs.getInt("ticketid"));
							ticket.setTicketdate(rs.getString("orderdate"));
							ticket.setAdultTicket(rs.getInt("adultticket"));
							ticket.setChildticket(rs.getInt("childticket"));
							ticket.setUsername(rs.getString("username"));
							ticket.setTotal(rs.getDouble("total"));
							tickets.add(ticket);
							
						}
						
					}catch(SQLException e){
						e.printStackTrace();
					}
					
					return tickets;
					
				}
				
				// ChangeStatusPayment
				public OrderInfo changeStatusPayment(int ticketid){
					
					OrderInfo ticket = new OrderInfo();
					
					try{
						currentCon = ConnectionManager.getConnection();
						ps = currentCon.prepareStatement("update ticketorder set payment=1 where ticketid=?");
						
						ps.setInt(1, ticketid);
						ResultSet rs = ps.executeQuery();
						
						if(rs.next()){
							ticket.setTicketId(rs.getInt("ticketid"));
							ticket.setTicketdate(rs.getString("orderdate"));
							ticket.setAdultTicket(rs.getInt("adultticket"));
							ticket.setChildticket(rs.getInt("childticket"));
							ticket.setUsername(rs.getString("username"));
						}
						
					}catch(SQLException e){
						e.printStackTrace();
					}
					
					return ticket;
					
				}
				
	


}
