// Template for
// Illustrating Central Limit Theorem using unfair coin experiments

import java.util.SplittableRandom; 

public class Tests2 {
	
	
	static void Assert (boolean res) // We use this to test our results - don't delete or modify!
	{
	 if(!res)	{
		 System.out.print("Something went wrong.");
	 	 System.exit(0);
	 }
	}
	
	static double Average(double [] X) { // Returns average value on the the sample X - copy from a prior task
        double sum = 0;
        for(int i=0;i<X.length;i++){
            sum += X[i];
        }
        return sum/X.length;
	}
	static double Stddev(double [] X) { // Returns average value on the the sample X - copy from a prior task
        double sum = 0;
        for(int i=0;i<X.length;i++){
            // square
            sum += (X[i] - Average(X)) * (X[i] - Average(X));
        }
        return sum/X.length;
	}
	
		
	public static void main(String[] args) throws Exception  {
		
		SplittableRandom random = new SplittableRandom();
	

		// For vizualising a histogram of the estimates:
		int number_of_bins = 10; // 11 is good for 10 tosses, since only 11 possible outcomes: {0,1,2,...10}. Experiments with larger number of tosses will benefit from more bins. 
		int [] histogram = new int [number_of_bins] ;
		for (int i=0;i<number_of_bins;i++)
			histogram[i] = 0;
		
		int sample_size = 100; // Can increase this to obtain more accurate estimates 
		int number_of_tosses = 10; // Number of coin tosses in each trial.
		double [] sample = new double [sample_size]; // Sample of fairness estimates
		
		for (int s = 0; s < sample_size; s++) {  
		
			double heads = 0; // Number of tosses where heads occurs.
			for (int toss = 0 ; toss < number_of_tosses; toss++) {  
				
				// Simulating unfair coin with chances of head 70%. We pretend that we don't know that it is 70% and trying to estimate it. 
				int d = random.nextInt(1, 11); // returns equally probable numbers {1...10}  
				// Our unfair head condition:
                if (d <= 7)
					heads ++;				
			}
						
			double fairness_estimate  = heads/number_of_tosses;
			histogram[(int)(fairness_estimate*(number_of_bins-1)) ]++; // To draw a histogram,  we map each fairness estimate to a bin, and increment bin's count 			
			sample[s] = fairness_estimate; 
		}
		
		for (int i=0;i<number_of_bins;i++) { // Printing the histogram, so we can plot it in Excel. 
			System.out.println(histogram[i]);
		}
		

		// Computing the standard deviation of fairness as the square root of average squared deviations: 
		double mean = Average(sample);
		double [] deviations = new double [sample_size]; // Sample of fairness estimates				
		for (int s=0;s<sample_size;s++)
			deviations[s]=(sample[s] - mean)*(sample[s] - mean);			
		double stddev = Math.sqrt(Average(deviations));
		

		
		// Print the parameters of the experiment:
		System.out.println("Number of tosses: "); System.out.println(number_of_tosses);
		System.out.println("Sample size: "); System.out.println(sample_size);
		System.out.println("Estimated fairness: "); System.out.println(mean);
		System.out.println("standard deviation: "); System.out.println(stddev);

		// Confirming CLT: normal shape of our sample distribution for sufficiently large number of tosses.
		// We count the proportion of the estimates that are within a standard deviation from the mean 
		// and compare that with the theoretical value based on the shape of a normal distribution.
		
		int within_sigma = 0;
        int within_sigma3 = 0;
		for (int i=0;i<sample_size; i++) {
            if(Math.abs(sample[i]-.7) < stddev)
                within_sigma ++;
            if(Math.abs(sample[i]-.7) < 3*stddev)
                within_sigma3 ++;
        }
										
		double proportion_within_sigma = (double)within_sigma/sample.length; 
		System.out.println("Proportion of estimates within stddev: "); System.out.println(proportion_within_sigma);
		System.out.println("Theoretical value: "); System.out.println(.6827);
		Assert(Math.abs(proportion_within_sigma  - .6827) < 0.01);

        double proportion_within_sigma3 = (double)within_sigma3/sample.length;
        System.out.println("Proportion of estimates within stddev: "); System.out.println(proportion_within_sigma3);
        System.out.println("Theoretical value: "); System.out.println(.9973);
        Assert(Math.abs(proportion_within_sigma  - .9973) < 0.01);

		System.out.print("All tests fine.");

	}
}
