
public class TicketInfo {
	
	
	private int ticketId;
	private String ticketDate;
	private int adultTicket;
	private int childticket;
	private String username;
	private int payment;
	
	
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketdate() {
		return ticketDate;
	}
	public void setTicketdate(String ticketdate) {
		ticketDate = ticketdate;
	}
	public int getAdultTicket() {
		return adultTicket;
	}
	public void setAdultTicket(int adultTicket) {
		this.adultTicket = adultTicket;
	}
	public int getChildticket() {
		return childticket;
	}
	public void setChildticket(int childticket) {
		this.childticket = childticket;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public int getPayment(){
		return payment;
	}
	public void setPayment(int payment){
		this.payment = payment;
	}
	
	@Override
	public String toString() {
		return "TicketInfo [ticketId=" + ticketId + ", Ticketdate="
				+ ticketDate + ", adultTicket=" + adultTicket
				+ ", childticket=" + childticket + "]";
	}
	
	
	
}
