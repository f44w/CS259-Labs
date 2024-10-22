/*
// We need this to read images:


//A template for Naive Bayes binary model: If John has a flu based on possibly having cough, fever or sneezing.
//

import java.lang.Math; 


public class Tests2 {
	
	static  int pos_count = 0, neg_count = 0; // Counts of positive (flu) and negative (~flu) datapoints. 

	static int NumberOfFeatures =  ; 
	
	// Feature counts to estimate conditional probabilities:
	static double [] FeatureCountsPos = new double [NumberOfFeatures];  // to count #{x AND pos}, where x can be cough, fever or sneezing. pos = having a flu 
	static double [] FeatureCountsNeg = new double [NumberOfFeatures]; // to count #{x AND ~pos}
			
	
	static void Assert (boolean res) 
	{
	 if(!res)	{
		 System.out.print("Something went wrong.");
	 	 System.exit(0);
	 }	
	}
	
	// Copy Image class code from Task 1 here:
	
	static class NaiveBayesModel {    
		
	   public NaiveBayesModel(){ }  

	   double estimate(double [] X){  // Returns the probability of the datapoint with the features X to belong to the positive class C, here C = having a flu 
		   							// Implements the Naive Bayes prediction model as the slides 23-26 explain.
			      	
		// Initialize the score to the log of prior odds: log O(C) = log ( #{flu}/#{~flu} ) :
		double s = Math.log((double)pos_count/neg_count); 
		Assert(neg_count > 0);
		Assert(pos_count > 0);

		Assert(NumberOfFeatures == X.length);
		for (int x = 0; x < NumberOfFeatures; x++) { // Update the score s according to the Naive Bayes formula for the odds: log O(C|x1,x2,x3,...) = log O(C) + log s1 + log s2 + log s3,
			// where s1 = P(x1|C)/P(x1|~C), s2 = P(x2|C)/P(x2|~C), s3 = P(x3|C)/P(x3|~C) are "feature strengths".    
			
	   		if(X[x] > 0) { // To simplify the model and to apply it later to MNIST, we only consider feature presence, not absences   
	   			
	   			 	   			
	   			double p_feature_cond_pos = FeatureCountsPos[x]/pos_count; // P(x|C) = #{x AND pos} / #{pos} 
	   			if (p_feature_cond_pos == 0)
	   				p_feature_cond_pos = .01; // We make each estimated probability to be at least 0.01 to avoid division by 0 later.
	   										  // This is called "smoothing."
	   			double p_feature_cond_neg =  FeatureCountsNeg[x]/neg_count   ; 	 	   			
	   			if (p_feature_cond_neg == 0)
	   				p_feature_cond_neg = .01; 
	   			
	   			double feature_strength =   p_feature_cond_pos  /   p_feature_cond_neg; //  
	   			
	   			s = s + Math.log(feature_strength);
	   		}	   			   		
	   	}
		return 1/(1 + Math.exp(-s)); // Convert back from log O(C|X) to P(C|X)   
	   }
	   public void Update(double X[], int label) { 

		   // Update the tables with occurrence counts for the features:
		   Assert(NumberOfFeatures == X.length);
		   for (int x = 0; x < NumberOfFeatures; x++) { 
			   
			   if(label > 0) { 
				   if(X[x] > 0)
					   FeatureCountsPos[x] ++;
			   }
			   else  
				   if(X[x] > 0)
					   // add a line of code here!			   
					   FeatureCountsNeg[x] ++;
		   }		   
		   // Update the counts of #{pos} and #{~pos}:
		   if(label > 0)  
			   pos_count++;
		   else  
			   neg_count++;
	   }
	   
		public void ReportAccuracy(Image data[]) { // Added to Lab 2 Task 4 code to test the accuracy of the model   
		      double number_correct_predictions = 0;
		      for(int j = 0;j<data.length; j++) {
		    	  
		    	  
		    	   int prediction;
			       if (estimate(data[j].pixels)  >= .5) // We apply .5 probability threshold to predict the class
			    	   prediction = 1;     
			       else
			    	   prediction = 0;
		    	  
		          if (prediction == data[j].label)
		          	  ?? ; // Replace '??' with the line of code that changes 'number_correct_predictions' accordingly 
		      }
		      System.out.print((int)(100*number_correct_predictions/data.length)); 
			}
	   
	   
	} 
	 


	
	public static void main(String[] args) throws Exception  {  
		
		Image[] data_train = Read("C:\\H\\strath\\259\\labs\\train.txt"); // the paths may need to be updated  
		Image[] data_test = Read("C:\\H\\strath\\259\\labs\\test.txt");     
		

		NaiveBayesModel M = new NaiveBayesModel();   
				
		// Initialising feature counts to 0s:
		for (int x = 0; x < NumberOfFeatures; x++) {
					   FeatureCountsPos[x]=0;
					   FeatureCountsNeg[x]=0;
		}
		
		// Update our feature count tables:
		 for(int j = 0;j<data_train.length; j++) {
			 M.Update(data_train[j].pixels, data_train[j].label);
		 }
		 System.out.print(" accuracy on training data:");
		 M.ReportAccuracy(data_train);
		 System.out.println("");
		 System.out.print(" accuracy on testing data:");
		 M.ReportAccuracy(data_test); 
		 System.out.println("");
		
} 
}




 */