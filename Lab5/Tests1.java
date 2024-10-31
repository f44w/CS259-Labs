public class Tests1 {

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
    	double [] Res = new double[V.length]; // Create a vector of the size, that we will return
		for(int i=0; i<V.length; i++){
			Res[i] = a*V[i];
		}
		return Res;
    }

	static double [] add(double a, double [] V) { // adding scalar and vector
    	// add your code
		double [] Res =  new double[V.length];
		for(int i=0; i<V.length; i++){
			Res[i] = a+V[i];
		}
		return Res;
    }

    static double [] sub(double a, double [] V) {  // subtracting a scalar from vector
    	// add your code
		double [] Res =  new double[V.length];
		for(int i=0; i<V.length; i++){
			Res[i] = V[i]-a;
		}
		return Res;
    }

	static double [] add(double [] U, double [] V) { // adding two vectors
    	// add your code
		double [] Res =  new double[U.length];
		for(int i=0; i<U.length; i++){
			Res[i] = U[i]+V[i];
		}
		return Res;
    }
	static double [] sub(double [] U, double [] V) { // subtracting vector from vector
    	// add your code
		double [] Res =  new double[V.length];
		for(int i=0; i<V.length; i++){
			Res[i] = U[i] - V[i];
		}
		return Res;
    }

    static double dot(double [] U, double [] V) { // dotProduct product of two vectors
    	// add your code
		double [] Res =  new double[U.length];
		double dotProduct = 0;
		for(int i=0; i<U.length; i++){
			Res[i] = U[i]*V[i];
		}
		for(int j = 0; j< Res.length; j++){
			dotProduct += Res[j];
		}
		return dotProduct;
    }

	// Finish implementations of matrix operations:

    static double [] dot(double [][] U, double [] V) { // finish this function
		Assert(U[0].length == V.length);
    	double[] ans = new double[U.length];
		// add some code here
		// U length is the number of rows
		for(int i=0; i<U.length; i++) {
			for(int j=0;j<V.length;j++) {
				ans[i] += U[i][j] * V[j];
			}
		}
		return ans;
    }

    static double [][] add(double [][] a, double [][] b) {
    	Assert(a.length == b.length);
    	for (int i = 0;i < a.length; i++)
    		Assert(a[i].length == b[i].length);
      double[][] ans = new double[a.length][a[0].length];
    	// add some code here
		for(int i=0; i<a.length; i++){
			for(int j=0;j<a[0].length;j++){
				ans[i][j] = a[i][j] + b[i][j];
			}
		}
		return ans;
    }


	public static void main(String[] args) {

    	
    	double [] U = {1, 2, 3, 4}; 
    	double [] V = {5, 6, 7, 8};

    	// Fill in the proper values for tests:
    	Assert(mult(1, U)[0] == 1.0);
    	Assert(mult(1, U)[1] == 2.0);
    	Assert(mult(1, U)[2] == 3.0);
    	Assert(mult(1, U)[3] == 4.0);

    	
    	Assert(mult(2, U)[0] == 2.0);
    	Assert(mult(2, U)[1] == 4.0);
    	Assert(mult(2, U)[2] == 6.0);
    	Assert(mult(2, U)[3] == 8.0);

    	
    	Assert(add(1, U)[0] == 2.0);
    	Assert(add(1, U)[1] == 3.0);
    	Assert(add(1, U)[2] == 4.0);
    	Assert(add(1, U)[3] == 5.0);

    	Assert(sub(1, U)[0] == 0.0);
    	Assert(sub(1, U)[1] == 1.0);
    	Assert(sub(1, U)[2] == 2.0);
    	Assert(sub(1, U)[3] == 3.0);

    	Assert(add(U, V)[0] == 6.0);
    	Assert(add(U, V)[1] == 8.0);
    	Assert(add(U, V)[2] == 10.0);
    	Assert(add(U, V)[3] == 12.0);

    	Assert(sub(V, U)[0] == 4.0);
    	Assert(sub(V, U)[1] == 4.0);
    	Assert(sub(V, U)[2] == 4.0);
    	Assert(sub(V, U)[3] == 4.0);

    	Assert(dot(V, U) == 70.0);


		double [][] M = {{1, 2, 3, 4}, {5, 6, 7, 8}};
		double [][] W = {{5, 6, 7, 8}, {1, 2, 3, 4}};

    	Assert(add(M, W)[0][0] == 6.0 );
    	Assert(add(M, W)[1][1] == 8.0 );
    	Assert(add(M, W)[0][2] == 10.0 );

    	
    	Assert(dot(M, new double [] {1, 10, 100, 1000})[0] == 4321.0);
    	Assert(dot(M, new double [] {1, 10, 100, 1000})[1] == 8765.0);

		System.out.print("Finished ok.");
    	
	}

} 
