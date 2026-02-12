
public class Order {
	 private String Order_ID;
	 private int deadline;

	 
	 public Order(String Order_ID, int deadline) {
		 this.Order_ID = Order_ID;
		 this.deadline = deadline;
	 }
	 
	 public void setArrivalMinute() {}
	 public void getArrivalMinute() {}
	 public int getDeadlineMinute() {return -1;}
}
