import java.util.ArrayList;

public class taxi {
	static private int taxicount=0;
	private int id;
	private char startingPoint;
	private int freeTime;
	private int bookingId;
	private int customerId;
	private int earning;
	private char pickupPoint;
	//private char dropPoint;
	private int pickupTime;
	ArrayList<taxi> booking_details;
	taxi(){
		this.id=id;
		this.startingPoint='a';
		this.freeTime=6;
		this.bookingId=0;
		this.customerId=0;
		this.earning=0;
		this.pickupPoint='0';
		//this.dropPoint='0';
		this.pickupTime=0;
		taxicount=taxicount+1;
		id=taxicount;
	}
	public void setdetails(int id,int bookingId, int customerId, int earning, char pickupPoint,
			int pickupTime) {
		//this.startingPoint=startingPoint;
		this.id=id;
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.earning = earning;
		this.pickupPoint = pickupPoint;
		//this.dropPoint = dropPoint;
		this.pickupTime = pickupTime;
		
		//this.freeTime=freeTime;
	}
	public void booking_details(taxi booking) {
		this.booking_details.add(booking);
	}
	public void printDetails() {
		for(int i=0;i<booking_details.size();i++) {
			System.out.println("TaxiId= "+booking_details.get(i).getId()+"\t"+"Bookingid= "+booking_details.get(i).getBookingId()+"\t"+"Customerid= "+booking_details.get(i).getCustomerId()+"\t"+"PickupPoint= "+booking_details.get(i).getPickupPoint()+"\t"+"DropPoint= "+booking_details.get(i).getStartingPoint()
					+"\t"+"PickupTime= "+booking_details.get(i).getPickupTime()+"\t"+"DropTime= "+booking_details.get(i).getFreeTime()+"\t"+
					"Earning= "+booking_details.get(i).getEarning());
		}
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getEarning() {
		return earning;
	}
	public void setEarning(int earning) {
		this.earning = earning;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(char startingPoint) {
		this.startingPoint = startingPoint;
	}
	public int getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(int freeTime) {
		this.freeTime = freeTime;
	}
	public char getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(char pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	/*public char getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}*/
	public int getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}
	

}
