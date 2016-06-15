

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * Servlet implementation class TicketServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT = "/create.jsp";
	private static String EDIT = "/edit.jsp";
	private static String LIST_TICKET = "/listTickets.jsp";
	private static String HISTORY = "/history.jsp";
	private static String PAYMENT = "/pay.jsp";
	private static String SINGLE = "/single-ticket.jsp";
	private OrderDAO dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao = new OrderDAO();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		Cookie[] cookies = request.getCookies();
		
		String username = null;
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("username")) username = cookie.getValue();
		}
		System.out.println("Username by cookie " + username);
		
	
		
		
		String forward="";
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("delete")){
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
			dao.deleteTicket(ticketid);
			forward = LIST_TICKET;
			request.setAttribute("tickets", dao.getAllTicketByUsernameCart(username));
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("edit")){
			forward = EDIT;
			
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			
			RequestDispatcher view = request.getRequestDispatcher("edit-ticket.jsp");
			System.out.println("In Edit " + ticketid);
			
			OrderInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("ticket", ticket);
			view.forward(request, response);
			
		}else if(action.equalsIgnoreCase("listTicket")){
			forward = LIST_TICKET;
			RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
			request.setAttribute("tickets", dao.getAllTicket());
			view.forward(request, response);
			System.out.println("In listTicket");
		}else if(action.equalsIgnoreCase("listTicketByUsername")){
			forward = LIST_TICKET;
			RequestDispatcher view = request.getRequestDispatcher(HISTORY);
			request.setAttribute("tickets", dao.getAllTicketByUsernamePayment(username));
			view.forward(request, response);
			System.out.println("In listTicket By Username");
		}else if(action.equalsIgnoreCase("listTicketInCart")){
			forward = LIST_TICKET;
			RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
			request.setAttribute("tickets", dao.getAllTicketByUsernameCart(username));
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("pay")){
			forward = PAYMENT;
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			RequestDispatcher view = request.getRequestDispatcher(PAYMENT);
			
			OrderInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("ticket", ticket);
			view.forward(request, response);
			
		}else if(action.equalsIgnoreCase("cartToPayment")){
			forward = LIST_TICKET;
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			RequestDispatcher view = request.getRequestDispatcher(SINGLE);
			
			dao.changeStatusPayment(ticketid);
			request.setAttribute("errorMessage", "Thanks for the payment");
			OrderInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("ticket", ticket);
			view.forward(request, response);
	
			
		}else if(action.equalsIgnoreCase("viewTicket")){
			forward = "VIEW";
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			RequestDispatcher view = request.getRequestDispatcher(SINGLE);
			OrderInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("ticket", ticket);
			view.forward(request, response);
		}else{
			forward = INSERT;
			
			System.out.println("In INSERT");
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OrderInfo ticket = new OrderInfo();
		ticket.setTicketdate(request.getParameter("date"));
		ticket.setAdultTicket(Integer.parseInt(request.getParameter("adult")));
		ticket.setChildticket(Integer.parseInt(request.getParameter("child")));
		ticket.setUsername(request.getParameter("username"));
		ticket.setPayment(Integer.parseInt(request.getParameter("payment")));
		ticket.setTotal(Double.parseDouble(request.getParameter("total")));
		
		System.out.println("Request for username " + request.getParameter("username"));
		
		
		String ticketid = request.getParameter("ticketId");
		
		System.out.println("Ticket ID is "+ticketid);
		
		if(ticketid == null || ticketid.isEmpty()){
			System.out.println("Entering ADD");
			dao.add(ticket);
			request.setAttribute("errorMessage", "Done Added. You're good to go");
		}else{
			ticket.setTicketId(Integer.parseInt(ticketid));
			System.out.println("Entering UPDATE");
			dao.updateTicket(ticket);
			request.setAttribute("errorMessage", "Done edit. You're good to go");
		}
		
		
		
		String username = request.getParameter("username");
		 
		System.out.println("Username in parameter is " + username);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
		request.setAttribute("tickets", dao.getAllTicketByUsernameCart(username));
		view.forward(request, response);
		
		
		
		
	}

}
