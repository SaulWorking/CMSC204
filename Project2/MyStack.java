
public class MyStack<T> implements StackADT<T>{
	
	
	
	
	public MyStack() {
		
	}
	
    /**
     * Pushes an item onto the top of the stack.
     * @param item the element to push 
     * @throws IllegalArgumentException if item is null 
     * @throws IllegalStateException if stack has reached max capacity
     */
    public void push(T item) {
    	
    }

    /**
     * Removes and returns the top item from the stack.
     * @return the popped element
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
    	T obj = null;
		return obj;
    }

    /**
     * Returns the top item of the stack without removing.
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
    	T obj = null;
		return obj;
    }

    /**
     * Checks whether the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty() {
		return false;
    	
    }

    /**
     * Returns the current number of elements in the stack.
     * @return number of elements
     */
    public int size() {
    	return -1;
    }
    
    /**
     * Returns an array containing all elements in this stack.
     * The element at index 0 is the bottom of the stack, and the
     * element at index size()-1 is the top.
     */
    public Object[] toArray() {
    	 T []obj = null;
		return obj;
    }
}
