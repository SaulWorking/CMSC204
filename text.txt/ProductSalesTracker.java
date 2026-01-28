public class ProductSalesTracker {
	private double[] sales;
	private int saleSize;
	
	public ProductSalesTracker(int capacity) {
		sales = new double[capacity];
		saleSize = 0;
	}

	/**
	 * addSale adds sale to sales array.
	 * 
	 * @param sale 
	 * @return true if sale can be added to sales array.
	 */
	
	public boolean addSale(double sale) {
		if(saleSize >=sales.length) {
			return false;
		}

			sales[saleSize] = sale;
			saleSize++;
		return true;
	}
	
	/**
	 * calculate the total sales made by current store
	 * 
	 * @return summation of all sales
	 */
	public double totalSales() {
		double totalSale = 0.0;
		
		for(int i =0; i <saleSize;i++) {
			totalSale += sales[i];
		}
		
		return totalSale;
		
	}
	public double lowestSale() {
		double lowestSale = sales[0];
		
		for(int i =1; i <saleSize;i++) {
			if(sales[i] < lowestSale) {
				
				lowestSale = sales[i];
			}
		}
		return lowestSale;
	}
	public double finalSalesTotal() {
		if(saleSize < 2) {
			return 0.0;
		}
	
		return totalSales() - lowestSale();
		
		
	}
	public String toString() {
		String saleData = "";
		
		for(int i =0; i<saleSize;i++) {
			
			saleData += (Double.toString(sales[i]) + " ");
			
		}
		
		return saleData;
	}
	
	
	
	
}