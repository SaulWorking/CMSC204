
public class MyPriorityQueue<T> implements PriorityQueueADT<T>{
    
	public MyPriorityQueue() {
		
	}
	
	/**
     * Inserts an item into the queue according to the priority order.
     * @param item the element to insert (cannot be null)
     * @throws IllegalArgumentException if item is null
     */
    public void enqueue(T item) {}

    /**
     * Removes and returns the highest-priority item.
     * @return the dequeued element
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
    	T obj = null;
    	return obj;
    }

    /**
     * Returns (without removing) the highest-priority item.
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {    
    	T obj = null;
    	return obj;
    }

    /**
     * Checks whether the queue has no elements.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
    	return false;
    }

    /**
     * Returns the current number of elements in the queue.
     * @return number of elements
     */
    public int size() {
    	return -1;
    }
    
    /**
     * Returns an array containing all elements in this priority queue,
     * in the current internal order (not necessarily sorted by priority).
     */
    public Object[] toArray() {
    	T [] objs = null;
    	return objs;
    }
}
