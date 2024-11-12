public class Tests {

	// Use we use 'static' for all methods to keep things simple, so we can call those methods main

	static void Assert (boolean res) // We use this to test our results - don't delete or modify!
	{
	 if(!res)	{
		 System.out.print("Something went wrong.");
	 	 System.exit(0);
	 }
	}
	
	// Finish implementations of vector operations: 
	
    static double [] mult(double a, double [] V) { // multiplying scalar and vector
    	// add your code
    	double [] result = new double [V.length];
        for(int i = 0; i < V.length; i++)
        	result[i] = a*V[i];
        return result;
    }
    static double [] add(double a, double [] V) { // adding scalar and vector
    	// add your code
    	double [] result = new double [V.length];
     
        for(int i = 0; i < V.length; i++)
        	result[i] = a + V[i];
        return result;
    	
    }
    static double [] sub(double a, double [] V) {  // subtracting a scalar from vector        	    
    	// add your code
    	double [] result = new double [V.length];
        
        for(int i = 0; i < V.length; i++)
        	result[i] = V[i] - a;
    	    	
        return result;    	    
    	
    }
    
    static double [] add(double [] U, double [] V) { // adding two vectors
    	// add your code
    	Assert(U.length == V.length);
    	double [] result = new double [U.length];
    
        for(int i = 0; i < U.length; i++)
        	result[i] = U[i] + V[i];
    	    	
        return result;    	    
    	
    }
    static double [] sub(double [] U, double [] V) { // subtracting vector from vector 
    	// add your code
    	return add(U, mult(-1, V));
    	
    }
    static double dot(double [] U, double [] V) { // dot product of two vectors 
    	// add your code
    	Assert(U.length == V.length);
    	double result = 0;     
        for(int i = 0; i < U.length; i++)
        	result += U[i]*V[i];
    	    	   	
    	return result;    
    	
    }
    
	// Finish implementations of matrix operations: 
    
    static double [] dot(double [][] U, double [] V) { // finish this function 
    	
    	Assert(U[0].length == V.length);   	
    	double[] ans = new double[U.length];    	
    	// add some code here
        for (int i = 0; i < U.length; i++) {
        	ans[i] = dot(U[i], V);
        }
        return ans;
    }
    
    static double [][] add(double [][] a, double [][] b) {
    	
    	Assert(a.length == b.length);
    	for (int i = 0;i < a.length; i++)
    		Assert(a[i].length == b[i].length);
        double[][] ans = new double[a.length][a[0].length];
        for (int i = 0; i <a.length; i++)
            ans[i] = add(a[i], b[i]);
       
        return ans;
    	
       
    }
	
	public static void main(String[] args) {

    	
    	double [] U = {1, 2, 3, 4}; 
    	double [] V = {5, 6, 7, 8};

    	// Fill in the proper values for tests:
    	Assert(mult(1, U)[0] == 1); 
    	Assert(mult(1, U)[1] == 2); 
    	Assert(mult(1, U)[2] == 3); 
    	Assert(mult(1, U)[3] == 4);
    	
    	Assert(mult(2, U)[0] == 2); 
    	Assert(mult(2, U)[1] == 4); 
    	Assert(mult(2, U)[2] == 6); 
    	Assert(mult(2, U)[3] == 8);
    	
    	Assert(add(1, U)[0] == 2); 
    	Assert(add(1, U)[1] == 3); 
    	Assert(add(1, U)[2] == 4); 
    	Assert(add(1, U)[3] == 5); 

    	Assert(sub(1, U)[0] == 0); 
    	Assert(sub(1, U)[1] == 1); 
    	Assert(sub(1, U)[2] == 2); 
    	Assert(sub(1, U)[3] == 3); 
    	
    	// double [] x = add(U, V);
    	Assert(add(U, V)[0] == 6); // comparing double and int OK 
    	Assert(add(U, V)[1] == 8); 
    	Assert(add(U, V)[2] == 10); 
    	Assert(add(U, V)[3] == 12); 

    	Assert(sub(V, U)[0] == 4);  
    	Assert(sub(V, U)[0] == 4);  
    	Assert(sub(V, U)[0] == 4);  
    	Assert(sub(V, U)[0] == 4);  

    	Assert(dot(V, U) == 1*5+2*6+3*7+4*8);  

		double [][] M = {{1, 2, 3, 4}, {5, 6, 7, 8}};
		double [][] W = {{5, 6, 7, 8}, {1, 2, 3, 4}};
    	
    	Assert(add(M, W)[0][0] ==  6); 	    			    
    	Assert(add(M, W)[1][1] ==  8); 	    			    
    	Assert(add(M, W)[0][2] ==  10); 	    			    
    	
    	Assert(dot(M, new double [] {1, 10, 100, 1000})[0] == 4321);
    	Assert(dot(M, new double [] {1, 10, 100, 1000})[1] == 8765);
    	       	
		System.out.print("Finished ok.");
    	
	}

} 
