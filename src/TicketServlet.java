

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
	private static String PRICE = "/TicketPrice.jsp";
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
		String action = request.getParameter("action");
		
		
		String forward="";
		
		if(action.equalsIgnoreCase("price")){
			
			int priceid = Integer.parseInt(request.getParameter("priceid"));
			
			RequestDispatcher view = request.getRequestDispatcher(PRICE);
			System.out.println("In Edit Price " + priceid);
			
			TicketInfo price = dao.getPriceById(priceid);
			request.setAttribute("price", price);
			view.forward(request, response);
		}else if(action.equalsIgnoreCase("insert")){
			forward = "INSERT";
			RequestDispatcher view = request.getRequestDispatcher(INSERT);
			TicketInfo price = dao.getPriceById(1);
			request.setAttribute("price", price);
			view.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TicketInfo price = new TicketInfo();
		
		price.setPriceId(Integer.parseInt(request.getParameter("priceid")));
		price.setAdultPrice(Float.parseFloat(request.getParameter("adultPrice")));
		price.setChildPrice(Float.parseFloat(request.getParameter("childPrice")));
		
		dao.updateTicket(price);
		request.setAttribute("errorMessage", "Done update Ticket Price");
		RequestDispatcher view = request.getRequestDispatcher(INSERT);
		view.forward(request, response);
		
		
		
	}

}
