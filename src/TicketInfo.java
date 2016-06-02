
public class TicketInfo {
	
	
	private int priceId;
	private float adultPrice;
	private float childPrice;
	
	
	public int getPriceId(){
		return priceId;
	}
	
	public void setPriceId(int priceId){
		this.priceId = priceId;
	}
	
	public float getAdultPrice() {
		return adultPrice;
	}
	public void setAdultPrice(float adultPrice) {
		this.adultPrice = adultPrice;
	}
	public float getChildPrice() {
		return childPrice;
	}
	public void setChildPrice(float childPrice) {
		this.childPrice = childPrice;
	}
	
	
	@Override
	public String toString() {
		return "TicketInfo [adultPrice=" + adultPrice + ", childPrice="
				+ childPrice + "]";
	}
	

}
