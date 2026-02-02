public class ProductSalesTracker {
	private double[] sales;
	private int saleSize;
	
	public ProductSalesTracker(int capacity) {
		sales = new double[capacity];
		saleSize = 0;
	}

	/**
	 * Adds a new sale to the sales array.
	 * 
	 * @param sale 
	 * @return True if sale can be added to sales array.
	 */
	
	public boolean addSale(double sale) {
		if(saleSize >=sales.length) 
			return false;
		
		if(sale <= 0) 
			return false;
		
			sales[saleSize] = sale;
			saleSize++;
		return true;
	}
	
	/**
	 * Calculates the total sales made by current store
	 * 
	 * @return Summation of all sales
	 */
	public double totalSales() {
		double totalSale = 0.0;
		
		for(int i =0; i <saleSize;i++) 
			totalSale += sales[i];
		
		return totalSale;
	}
	/**
	 * Finds the lowest sale
	 * 
	 * @return The lowest sale
	 */
	public double lowestSale() {
		double lowestSale = sales[0];
		
		for(int i =1; i <saleSize;i++) {
			if(sales[i] < lowestSale) 
				lowestSale = sales[i];
		}
		return lowestSale;
	}
	/**
	 * Sums all the total sales, except for the lowest sale.
	 * We can subtract directly, because addSale() checks for negative numbers.
	 * 
	 * @return The summation of all sales minus the lowest sale
	 * 
	 */
	public double finalSalesTotal() {
		if(saleSize < 2) 
			return 0.0;
		
		return totalSales() - lowestSale();
	}
	/**
	 * Concatenates all sale values into one String
	 * 
	 * @return String with the form "sale1 sale2 sale3 sale4"
	 * 
	 */
	public String toString() {
		String saleData = "";
		
		for(int i =0; i<saleSize;i++)
			saleData += (Double.toString(sales[i]) + " ");
			
		return saleData;
	}
}