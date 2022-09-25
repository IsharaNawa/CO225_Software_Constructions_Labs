class Lab1 { 

    public static void showMaxima(int [] array) { 
	// implement 
		int counter;
		for(counter=1;counter<array.length-1;counter++){
			
			if(array[counter-1]<array[counter] && array[counter]>array[counter+1]){
			System.out.println("array["+ counter + "] = "+ array[counter]+" is a local maxima.");
			}
			
		}
		
    }

    public static void main(String [] args) { 
	int [] array = {0, 1, 2, 1, 0, -1, 2, 3, 5, 6, 7, 4, 3, 4, 6, 5, 4};
	showMaxima(array);
    }
}
