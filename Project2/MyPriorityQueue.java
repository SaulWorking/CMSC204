
import java.util.Comparator;
import java.util.NoSuchElementException;

public class MyPriorityQueue<T> implements PriorityQueueADT<T> {
	
	private final static int DEFAULT_CAPACITY = 10;
	
	private T[] priorityQueue;
    private Comparator<T> comparator;
    private int numOfEntries;
	
	
   
	
	public MyPriorityQueue(int capacity, Comparator<T> comparator) {
	
		this.comparator = comparator;
		

		//The cast is safe because the array contains null entries
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		
		priorityQueue = temp;
		numOfEntries = 0;
		
	}
	
	public MyPriorityQueue(Comparator<T> comparator) {
		
		this.comparator = comparator;

		//The cast is safe because the array contains null entries
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[DEFAULT_CAPACITY];
		
		priorityQueue = temp;
		
		numOfEntries = 0;
		
	}
	
	/**
     * Inserts an item into the queue according to the priority order.
     * @param item the element to insert (cannot be null)
     * @throws IllegalArgumentException if item is null
     */
    public void enqueue(T item) {
    	if(item == null)
    		throw new IllegalArgumentException();
    	
    	if(numOfEntries <=0) {
    		priorityQueue[0] = item;
    	    numOfEntries++;
    	}

    	for(int i =0; i<numOfEntries; i++) {
    		T queueElement = priorityQueue[i];
    		if(comparator.compare(item, queueElement) > 0) {
    			priorityQueue[numOfEntries] = item;
    		}
    	}
    	
    	numOfEntries++;
    	return;
    }

    /**
     * Removes and returns the highest-priority item.
     * @return the dequeued element
     * @throws NoSuchElementException if the queue is empty
     */
    public T dequeue() {
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	T tempItem = priorityQueue[0];
    	
    	 for(int i =0; i<numOfEntries; i++) {
    		 
    		T queueElement = priorityQueue[i];
    		if(comparator.compare(tempItem, queueElement) > 0) {
    			tempItem = queueElement;
    		}
    	}
    	
    	priorityQueue[0] = null;
    	numOfEntries--;
    	return tempItem;	
    }

    /**
     * Returns (without removing) the highest-priority item.
     * @return the front element
     * @throws NoSuchElementException if the queue is empty
     */
    public T peek() {
    	if(isEmpty())
    		throw new NoSuchElementException();
    	return priorityQueue[0];
    }

    /**
     * Checks whether the queue has no elements.
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
    
    	//i'm sure we can check the first element
    	//but not now.
    	for(T element : priorityQueue) {
    		if(element != null) {
    			return false;
    		}
    	}
 
    	return true; 
    }

    /**
     * Returns the current number of elements in the queue.
     * @return number of elements
     */
    public int size() {
    	return numOfEntries;
    }
    
    /**
     * Returns an array containing all elements in this priority queue,
     * in the current internal order (not necessarily sorted by priority).
     */
    public Object[] toArray() {
    	Object[] temp = new Object[priorityQueue.length];
    	
    	for(int i =0; i<priorityQueue.length;i++){
    		temp[i] = priorityQueue[i];
    	}
    	
    	return temp;
    }

}
