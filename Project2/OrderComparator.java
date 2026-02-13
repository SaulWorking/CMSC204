import java.util.Comparator;
public class OrderComparator implements Comparator<Order> {
	private final int FIRST_IS_GREATER = 1;
	private final int SECOND_IS_GREATER = -1;
	private final int FAIL = 0;
	
	
	

	@Override
	public int compare(Order o1, Order o2) {
		if(o1.getDeadlineMinute() == o2.getDeadlineMinute()) {
			if(o1.getArrivalMinute() > o2.getArrivalMinute()) 
				return FIRST_IS_GREATER;
		}
		
		if(o1.getDeadlineMinute() > o2.getArrivalMinute()) 
			return FIRST_IS_GREATER;
		
		return FAIL;
	}

}
