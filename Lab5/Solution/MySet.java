
/* my array list: an array that behaves like a list 
 * E/17/219
 */

public class MySet<T> { 

    int nextItem; 
    int currentCapacity; 
    T[] data; // DO NOT CHANGE

    private static int defaultSizeToCreate = 10; // how many elements to create 

    public MySet(int elements) { 
		try{
			this.nextItem = 0; 
			this.defaultSizeToCreate = elements; 
			this.currentCapacity = elements; 
			this.data = (T[]) new Object[this.defaultSizeToCreate];
	
		}catch(NegativeArraySizeException e){
		
			System.out.println("Number of elements is negative!");	
		}
	
    }

    public MySet() { 
		this(defaultSizeToCreate); 
    }

    public boolean isEmpty() { return this.nextItem == 0; } 
    public boolean isFull() { return false; /* never get filled */} 

    public boolean add(T item) { 
		data[nextItem] = null; // DO NOT CHANGE 
	
		/* if there is any element delete it 
		* then add the new element. 
		* How do you handle when the array is full: 
		* crate a new array with currentCapacity+defaultSizeToCreate, 
		* copy the old conents into that
		* Accessing array when full might be a problem
		*/
	
		int i;
	
		for(i=0;i<nextItem;i++){
		
			if(item.equals(data[i])){
				return false;
			} 
		}
	
		data[nextItem]=item;
	
		nextItem++;
	
		if(nextItem==currentCapacity){
			currentCapacity+=defaultSizeToCreate;
			T[] newData = (T[]) new Object[currentCapacity];
		
			for(i=0; i<nextItem; i++){
				newData[i] = this.data[i];
			}
			data=newData;
		}
	
		/* Add the item to the array if the item is not there */
		return true; // CHANGE ME

    }

    public T remove() { 
		/* remove the first element in the array 
		* and copy the rest front. 
		* FIFO structure. 
		* If the ArrayList is empty return null
		*/
		/* Option 1: */
		if(isEmpty()) return null; 
		// IMPLEMENT THE REST
		T output=this.data[0];
	
		int i;
		for(i=0;i<this.nextItem-1;i++){
			data[i]=data[i+1];
		}
	
		nextItem--;
	
		return output;
		/* Option 2: */
		/* if(!isEmpty()) { 
	    // IMPLEMENT THE REST
		
		}
		return null; */
		// which option is better? why? 
    }
	
}
	 

	