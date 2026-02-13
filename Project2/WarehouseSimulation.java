
public class WarehouseSimulation implements SimulationInterface{

	private Order[] orders;
	private int currentMinute;
	private int totalArrived;
	private int totalShipped;
	private int totalLate;
	
	public WarehouseSimulation() {
		this(null);
	}
	

	public WarehouseSimulation(Order[] orders) {
			this.orders = orders;
			this.currentMinute = 0;
			this.totalArrived = 0;
			this.totalShipped = 0;
			this.totalLate = 0;
	}
	
    /**
     * Advance the simulation by exactly one minute.
     * This may involve:
     *  - Adding new orders to the queue
     *  - Shipping one order
     *  - Moving late orders to the returns stack
     */
    public void tick() {
    	currentMinute++;
    	
    }

    /**
     * Returns true if:
     *  - All orders have been released into the queue, AND
     *  - The queue is empty (all orders shipped).
     */
    public boolean isFinished() {

    	
    	return true;
    }

    /** Returns the current simulation time in minutes. */
    public int getCurrentMinute(){return currentMinute;}

    /** Returns the total number of orders that have arrived. */
    public int getTotalArrived() {return totalArrived;}

    /** Returns the total number of orders that have been shipped. */
    public int getTotalShipped() {return totalShipped;}

    /** Returns the total number of orders that shipped late. */
    public int getTotalLate() {return totalLate;}
}
