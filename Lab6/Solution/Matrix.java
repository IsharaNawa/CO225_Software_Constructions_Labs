//E/17/219

public class Matrix extends Thread { 

    private static int [][] a; 
    private static int [][] b; 
    private static int [][] c; 

    /* You might need other variables as well */

	private static int matrixSize;			//size of the matrix
	private int xCordinate,yCordinate;		//x,y cordintes

    public Matrix(int x,int y) { // need to change this, might need some information 
		
		//this constructor assisgns the appropriate values for the private variables
		this.xCordinate = x;
		this.yCordinate = y;
		
	}
	
	public void run(){ //from the Thread class 
		
		//making the corresponding element to 0
		c[xCordinate][yCordinate] = 0; 
		
		try{
			for (int i = 0; i < matrixSize; i++)
				//performing the matrix multipication process
				c[xCordinate][yCordinate] += a[xCordinate][i] * b[i][yCordinate];
		}
		catch (ArithmeticException e){//handling the arithmatic error situation
			System.out.println("An arithmatic error has occured.Please check the values.");
		}catch(Exception e1){//handling the exceptions
			System.out.println("An exception is occured!");
		}
		
		
	}

    public static int [][] multiply(int [][] a, int [][] b) {

	/* check if multipication can be done, if not 
	 * return null 
	 * allocate required memory 
	 * return a * b
	 */

		int x = a.length; 
		int y = b[0].length; 

		int z1 = a[0].length; 
		int z2 = b.length; 

		if(z1 != z2) { 
			System.out.println("Cannnot multiply");
			return null;
		}

		c = new int [x][y]; 
		int i, j, k, s; 

		//this matrix temporily holds the matrix
		Matrix temp;
	
		Matrix.a=a;
		Matrix.b=b;
		matrixSize = z1;
	
		try{
			for (i = 0; i < x; i++) 
				for (j = 0; j < y; j++) {

					// instatiating new elements
					temp = new Matrix(i, j);

					// Starting the tread
					temp.start();
				}
		}
		catch (ArithmeticException ae){//handling the arithmatic error situation
			System.out.println("An arithmatic error has occured.Please check the values.");
		}catch (Exception e1){//handling the exceptions
			System.out.println("An exception is occured!");
		}
		
		return c; 
    }

}