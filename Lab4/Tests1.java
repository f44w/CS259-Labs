//A template for calculating simple sample and distribution statistics: averages, standard deviation, expected values 

public class Tests1 {
	

	
	static void Assert (boolean res) // We use this to test our results - don't delete or modify!
	{
	 if(!res)	{
		 System.out.print("Something went wrong.");
	 	 System.exit(0);
	 }
	}
	
	// Finish the functions computing basic sample or distribution statistics:
	
	static double Average(double [] X) {// Returns average (mean) value on the the sample X
		double sum = 0;
		for(int i=0;i<X.length;i++){
			sum += X[i];
		}
		return sum/X.length;
	}

	static double Stddev(double [] X) { // Returns the standard deviation of the sample X
		double sum = 0;
		for(int i=0;i<X.length;i++){
			// square
			sum += (X[i] - Average(X)) * (X[i] - Average(X));
		}
		// Sqaure root:
		return Math.sqrt(sum/X.length);
	}

	static double ExpectedValue(double [] X, double [] P) { // Returns expected value of the distribution (X, P(X)) 
		double sum = 0;
		for(int i=0;i<X.length;i++){
			sum += X[i]*P[i];
		}
		return sum;
	}
		
	public static void main(String[] args) throws Exception  {


		{
		System.out.print(" sample:  {7,7,7,7} ");  
		double [] X = new double [] {7,7,7,7};
		System.out.print(" average: "); System.out.print(Average(X));
		System.out.print(" standard deviation: "); System.out.println(Stddev(X));
		Assert(Math.abs(Average(X) - 7) < 0.001);
		Assert(Math.abs(Stddev(X) - 0) < 0.001);
		}
		{
		System.out.print(" sample:  {6,6,8,8} ");  
		double [] X = new double [] {6,6,8,8};
		System.out.print(" average: "); System.out.print(Average(X));
		System.out.print(" standard deviation: "); System.out.println(Stddev(X)); 
		Assert(Math.abs(Average(X) - 7) < 0.001);
		Assert(Math.abs(Stddev(X) - 1) < 0.001);
		}
		{
		System.out.print(" sample:  {0,1,13,14} ");  
		double [] X = new double [] {0,1,13,14};
		System.out.print(" average: "); System.out.print(Average(X));
		System.out.print(" standard deviation: "); System.out.println(Stddev(X)); 
		Assert(Math.abs(Average(X) - 7) < 0.001);
		Assert(Math.abs(Stddev(X) - 6.519202405202649) < 0.001);
		}
		{
			System.out.println(" sample:  {5,5,9,9}");
			double [] X = new double [] {5,5,9,9};
			System.out.println(" average: "); System.out.print(Average(X));
			System.out.print(" standard deviation: "); System.out.println(Stddev(X));
			Assert(Math.abs(Average(X) - 7) < 0.001);
			Assert(Math.abs(Stddev(X) - 2) < 0.001);
		}
		{
			System.out.println(" distribution: X = {-2,-1,0,2,4}, P(X) = {.2,.4,.1,.2,.1}");
			double [] X = new double [] {-2,-1,0,2,4};
			double [] P = new double [] {.2,.4,.1,.2,.1};

		double sum_prob = 0;
		for(int i =0;i<X.length;i++)
			sum_prob += P[i];
		Assert(Math.abs(sum_prob - 1) < 0.000001);

		double expected_value = ExpectedValue(X, P);
		System.out.print(" expected value: "); System.out.println(expected_value);
		Assert(Math.abs(expected_value - 0) < 0.001);

		double [] X_sqr = new double [X.length];
		for (int i=0;i<X.length;i++)
			X_sqr[i] = X[i]*X[i];
		System.out.print(" expected value of squares: "); System.out.println(ExpectedValue(X_sqr, P));
		//Assert(Math.abs(ExpectedValue(X_sqr, P) - .60) < 0.001);
		Assert(Math.abs(ExpectedValue(X_sqr, P) - 3.6) < 0.001);
	}


		{
			System.out.println(" distribution: X  = {-1,0,2}, P(X) = {.20,.70,.10}");
			double [] X = new double [] {-1,0,2};
			double [] P = new double [] {.20,.70,.10};


			// Verifying all probabilities in the distribution add up to 1:
			double sum_prob = 0;
			for(int i =0;i<X.length;i++)
				sum_prob += P[i];
			Assert(Math.abs(sum_prob - 1) < 0.000001);

			double expected_value = ExpectedValue(X, P);
			System.out.print(" expected value: "); System.out.println(expected_value);
			Assert(Math.abs(expected_value - 0) < 0.001);

			double [] X_sqr = new double [X.length];
			for (int i=0;i<X.length;i++)
				X_sqr[i] = X[i]*X[i];
			System.out.print(" expected value of squares: "); System.out.println(ExpectedValue(X_sqr, P));
			Assert(Math.abs(ExpectedValue(X_sqr, P) - .60) < 0.001);

		}

		System.out.print("All tests fine.");

	}
}