

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketServlet
 */
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT = "/create.jsp";
	private static String EDIT = "/edit.jsp";
	private static String LIST_TICKET = "/listTickets.jsp";
	private TicketDAO dao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketServlet() {
        super();
        // TODO Auto-generated constructor stub
        dao = new TicketDAO();
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
			request.setAttribute("tickets", dao.getAllTicketByUsername(username));
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("edit")){
			forward = EDIT;
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			RequestDispatcher view = request.getRequestDispatcher(EDIT);
			System.out.println("In Edit" + ticketid);
			TicketInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("tickets", ticket);
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("listTicket")){
			forward = LIST_TICKET;
			RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
			request.setAttribute("tickets", dao.getAllTicket());
			view.forward(request, response);
			System.out.println("In listTicket");
		}else if(action.equalsIgnoreCase("listTicketByUsername")){
			forward = LIST_TICKET;
					
			RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
			request.setAttribute("tickets", dao.getAllTicketByUsername(username));
			view.forward(request, response);
			System.out.println("In listTicket By Username");
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
		
		TicketInfo ticket = new TicketInfo();
		ticket.setTicketdate(request.getParameter("date"));
		ticket.setAdultTicket(Integer.parseInt(request.getParameter("adult")));
		ticket.setChildticket(Integer.parseInt(request.getParameter("child")));
		ticket.setUsername(request.getParameter("username"));
		
		System.out.println("Request for username " + request.getParameter("username"));
		
		
		String ticketid = request.getParameter("ticketId");
		
		System.out.println("Ticket ID is "+ticketid);
		
		if(ticketid == null || ticketid.isEmpty()){
			System.out.println("Entering ADD");
			dao.add(ticket);
		}else{
			ticket.setTicketId(Integer.parseInt(ticketid));
			System.out.println("Entering UPDATE");
			dao.updateTicket(ticket);
		}
		
		
		
		String username = request.getParameter("username");
		 
		System.out.println("Username in parameter is " + username);
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
		request.setAttribute("tickets", dao.getAllTicketByUsername(username));
		view.forward(request, response);
		
		
		
		
	}

}
