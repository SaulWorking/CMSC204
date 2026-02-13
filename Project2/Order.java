
public class Order {
	 private String Order_ID;
	 private int deadline;
	 private int arrivalMinute;

	 
	 public Order(String Order_ID, int deadline) {
		 this.Order_ID = Order_ID;
		 this.deadline = deadline;
		 this.arrivalMinute = 0;
	 }
	 
	 public String getId() {return Order_ID;}
 	 public int getDeadlineMinute() {return deadline;}

	 
	 public void setArrivalMinute(int arrivalMinute) {}
	 public int getArrivalMinute() {return arrivalMinute;}
}
