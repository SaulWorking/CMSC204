
public class WarehouseSimulation implements SimulationInterface{
	

	public WarehouseSimulation() {
		
	}
	
    /**
     * Advance the simulation by exactly one minute.
     * This may involve:
     *  - Adding new orders to the queue
     *  - Shipping one order
     *  - Moving late orders to the returns stack
     */
    public void tick() {return;}

    /**
     * Returns true if:
     *  - All orders have been released into the queue, AND
     *  - The queue is empty (all orders shipped).
     */
    public boolean isFinished() {return false;}

    /** Returns the current simulation time in minutes. */
    public int getCurrentMinute(){return -1;}

    /** Returns the total number of orders that have arrived. */
    public int getTotalArrived() {return -1;}

    /** Returns the total number of orders that have been shipped. */
    public int getTotalShipped() {return -1;}

    /** Returns the total number of orders that shipped late. */
    public int getTotalLate() {return -1;}
}
