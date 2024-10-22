//Playing with Basic Probability Concepts
//This code illustrates the examples in the slides. It also serves as a template for Lab 7.

import java.util.SplittableRandom; // We need this to simulate random experiments

public class Tests {
	
	// Use we use 'static' for all methods to keep things simple, so we can call those methods main
	
	static void Assert (boolean res) // We use this to test our results - don't delete or modify!
	{
	 if(!res)	{
		 System.out.print("Something went wrong.");
	 	 System.exit(0);
	 }
	}
		
	public static void main(String[] args) throws Exception  {
		
		Assert(2*2 == 4);
		
		SplittableRandom random = new SplittableRandom();

		// Single Die Roll:  P(6) - probability of an odd number
		{
			int pos = 0; // Number of positive outcomes: those when the event occurs
			int trial = 0; // Total number of trials 
			for (; trial < 10000; trial++) { // C  
				
				int d = random.nextInt(1, 7); // Returns equally likely integer number from {1,2,3,4,5,6} set.  This simulates a single die roll.
 				if(d == 1 || d == 3 || d == 5) // C
					pos ++;				
			}
			
			double p  = (double)pos/trial;   // We need a cast to double to avoid integer division
			System.out.print(" Single die roll, P(odd):");
			System.out.print(" positive outcomes = ");
			System.out.print(pos);
			System.out.print(" number of trials = ");
			System.out.print(trial);
			System.out.print(" probability of event = ");
			System.out.println(p);
			
			// Check that the probability obtained by our experiments is as it should be according to the theory:  
			Assert(Math.abs(p - 1/2.) < 0.01); // abs() calculates absolute value: abs(x) = x if x > 0, -x otherwise. // C   
			
		}
		
		// 2 Die Rolls: P(sum=4), possibilities: 1+3,2+2,3+1 so should be 3/36
		{
			int pos = 0; 
			int trial = 0;
			
			for (; trial < 1000000; trial++) { // C  
				
				int d1 = random.nextInt(1, 7); 
				int d2 = random.nextInt(1, 7); 			
				if(d1+d2 == 4)  // C
				// if(d1 == 6 && d2 == 6) 
					pos ++;
			}
	
			double p  = (double)pos/trial;  
			System.out.print(" Two die rolls, P(sum=4):");
			System.out.print(" positive outcomes = ");
			System.out.print(pos);
			System.out.print(" number of trials = ");
			System.out.print(trial);
			System.out.print(" probability of event = ");
			System.out.println(p);
			// Check that the probability obtained by our experiments is as it should be according to the theory:  
			Assert(Math.abs(p - 3/36.) < 0.001); // C  
		}
		// 3 Die Rolls: P(sum=5), possibilities: 1+1+3,1+2+2,1+3+1,2+1+2,2+2+1,3+1+1  so should be 6/(6*6*6)= 1/36
		{
			int pos = 0; 
			int trial = 0;
			
			for (; trial < 100000; trial++) { // C  
				
				int d1 = random.nextInt(1, 7); 
				int d2 = random.nextInt(1, 7); 			
				int d3 = random.nextInt(1, 7); 			
				if(d1+d2+d3 == 5)  // C
					pos ++;
			}
	
			double p  = (double)pos/trial;  
			System.out.print(" Three die rolls, P(sum=5):");
			System.out.print(" positive outcomes = ");
			System.out.print(pos);
			System.out.print(" number of trials = ");
			System.out.print(trial);
			System.out.print(" probability of event = ");
			System.out.println(p);
			// Check that the probability obtained by our experiments is as it should be according to the theory:  
			Assert(Math.abs(p - 1/36.) < 0.001); // C  
		}
		
		// Conditional Probability
		// Single Die Roll: Probability of 1 or 2 if we know that the number is less than 4
		{
			int pos = 0; 
			int trial = 0;
			int cond = 0; 
			
			for (; trial < 10000; trial++) {  
				
				int d = random.nextInt(1, 7); 
				if(d < 4) {
					cond ++;
					if(d == 1 || d == 2)
						pos ++;		
				}
			}

			double p  = (double)pos/cond; 
			System.out.print(" Single Die Roll, P(1,2|<4):");
			System.out.print(" positive outcomes = ");
			System.out.print(pos);
			System.out.print(" number of trials when condition satisfied = ");
			System.out.print(cond);
			System.out.print(" conditional probability = ");
			System.out.println(p);
			
			// Check that the probability obtained by our experiments is as it should be according to the theory:  
			Assert(Math.abs(p - 2/3.) < 0.01);  
			
		}
		
		// Two Die Rolls: Probability that the sum is 4 when the sum is even.
		// Possibilities: 1+3,2+2,3+1, so 3/18
		
		int pos = 0; 
		int trial = 0;
		int cond = 0; 
		
		for (; trial < 10000; trial++) { // C  
			
			int d1 = random.nextInt(1, 7); 
			int d2 = random.nextInt(1, 7); 			
			if(d1+d2 == 2 || d1+d2 == 4 || d1+d2 == 6 || d1+d2 == 8 || d1+d2 == 10 || d1+d2 == 12) { // C
				cond ++;
				if(d1+d2 == 4) // C
					pos ++;		
			}
		}

		double p  = (double)pos/cond; 
		System.out.print(" Two die rolls, P(A+B == 4 | A+B even):");
		System.out.print(" positive outcomes = ");
		System.out.print(pos);
		System.out.print(" number of trials when condition satisfied = ");
		System.out.print(cond);
		System.out.print(" conditional probability = ");
		System.out.println(p);
		
		// Check that the probability obtained by our experiments is as it should be according to the theory:  
		Assert(Math.abs(p - 3/18.) < 0.01); // C  
									
		System.out.print("All tests fine.");

	}
}