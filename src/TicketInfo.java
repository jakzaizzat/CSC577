
public class TicketInfo {
	
	
	private int ticketId;
	private String ticketDate;
	private int adultTicket;
	private int childticket;
	
	
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
	
	@Override
	public String toString() {
		return "TicketInfo [ticketId=" + ticketId + ", Ticketdate="
				+ ticketDate + ", adultTicket=" + adultTicket
				+ ", childticket=" + childticket + "]";
	}
	
	
	
}
