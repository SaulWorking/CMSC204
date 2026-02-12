import java.util.Arrays;
import java.util.NoSuchElementException;
public class MyStack<T> implements StackADT<T>{
	
	T[] stack;
	int numOfEntries;
	
	static final int DEFAULT_CAPACITY = 10;
	
	public MyStack(int capacity) {		
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		stack = temp;	
		numOfEntries = 0;
	}
	
    /**
     * Pushes an item onto the top of the stack.
     * @param item the element to push 
     * @throws IllegalArgumentException if item is null 
     * @throws IllegalStateException if stack has reached max capacity
     */
    public void push(T item) {
    	if(item == null)
    		throw new IllegalArgumentException();
    	
    	if(numOfEntries >= stack.length)
    		throw new IllegalStateException();
    	
    	//provided that i do not need to expand size.
    	stack[numOfEntries] = item;
    	numOfEntries++;
    }

    /**
     * Removes and returns the top item from the stack.
     * @return the popped element
     * @throws NoSuchElementException if the stack is empty
     */
    public T pop() {
    	if(isEmpty())
    		throw new NoSuchElementException();
    	
    	int topIndex = numOfEntries - 1;
    	
    	T temp = stack[topIndex];
    	stack[topIndex] = null;
    	
		return temp;
    }

    /**
     * Returns the top item of the stack without removing.
     * @return the top element
     * @throws NoSuchElementException if the stack is empty
     */
    public T peek() {
    	 if(isEmpty())
    		throw new NoSuchElementException();
    	 
     	int topIndex = numOfEntries - 1;

    	//no idea if i need to create a new copy.
		return stack[topIndex];
    }

    /**
     * Checks whether the stack is empty.
     * @return true if the stack has no elements, false otherwise
     */
    public boolean isEmpty() {
        
    	//i'm sure we can check the first element
    	//but not now.
    	for(T element : stack) {
    		if(element != null) {
    			return false;
    		}
    	}
 
    	return true; 
    }

    /**
     * Returns the current number of elements in the stack.
     * @return number of elements
     */
    public int size() {
    	return numOfEntries;
    }
    
    /**
     * Returns an array containing all elements in this stack.
     * The element at index 0 is the bottom of the stack, and the
     * element at index size()-1 is the top.
     */
    public Object[] toArray() {
		return Arrays.copyOf(stack, stack.length);
    }
}
