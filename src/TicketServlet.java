

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TicketServlet
 */
public class TicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT = "/create.jsp";
	private static String EDIT = "/update.jsp";
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
		
		String forward="";
		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("delete")){
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			dao.deleteTicket(ticketid);
			forward = LIST_TICKET;
			request.setAttribute("tickets", dao.getAllTicket());
		}else if(action.equalsIgnoreCase("edit")){
			forward = EDIT;
			int ticketid = Integer.parseInt(request.getParameter("ticketid"));
			TicketInfo ticket = dao.getTicketById(ticketid);
			request.setAttribute("tickets", ticket);
		}else if(action.equalsIgnoreCase("listTicket")){
			forward = LIST_TICKET;
			request.setAttribute("tickets", dao.getAllTicket());
		}else{
			forward = INSERT;
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
		
		String ticketid = request.getParameter("ticketid");
		
		if(ticketid == null || ticketid.isEmpty()){
			dao.add(ticket);
		}else{
			ticket.setTicketId(Integer.parseInt(ticketid));
			dao.updateTicket(ticket);
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(LIST_TICKET);
		request.setAttribute("tickets", dao.getAllTicket());
		view.forward(request, response);
		
		
		
		
		
		
	}

}
