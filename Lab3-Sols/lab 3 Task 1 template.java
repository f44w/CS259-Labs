



//We need this to read images:
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tests {
	
	static  int  image_size =  ;  // This should be the total number of pixels  

	static class Image { // Class for MNIST images 
		
	    double [] pixels; // We will store the pixel values as 1D array of doubles. This will make it convenient to feed to the model  
	    int label;

	    Image() {
	    	pixels = new double[image_size];
	    }
	    double get(int row, int column) {
	    	 
			// Finish this function: Replace 'X' with a specific number
	    	 return pixels[row*X+column];   
	    }
	    void set(int row, int column, int value) {
	    	
	    	// Finish the code here to store the pixel value in a "flat" 1D array:
	    	// Replace 'X' with a specific number 
	    	pixels[row*X + column] = value;  
	    	
	    }
	    void set_label(int value) {
	    	
	    	// Finish the code that does binarization:
	    	if (value >= 5)   
	    		label =  ;
	    	else
	    		label =  ;
	    	
	    		    	
	    }

	}

	static Image[] Read(String fileName) throws Exception { 

	  File file = new File(fileName); 
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  
	  int number_of_lines = 0; 
	  String st;
	  while ((st = br.readLine()) != null) // Reading through the entire file to see how many images we have
		number_of_lines++; // 
	  
	  int number_of_images =   number_of_lines / X; // Replace 'X' with the specific number
	  br.close();


	  Image[] images =  new Image[number_of_images];

	  br = new BufferedReader(new FileReader(file));
	  for(int i = 0; i < number_of_images; i++) { // Now reading each image:
		  		  
		  images[i] = 	new Image();
	 	  
		  for(int row = 0; row < 28; row ++) { // Read all rows:  

			st = br.readLine();

			String[] line_parts = st.split("[\t ]+"); 
		  	int label =  Integer.parseInt(line_parts[0]); // Read the label 
	 	  	images[i].set_label(label); 
			  
		 	for(int column  = 0; column < 28; column ++) { // Read all columns:
		 			int value =  Integer.parseInt(line_parts[column+1]); // Read the pixel value 
			 		images[i].set(row, column, value);
		 	}
		  }
	  }
	  return images;
	}

public static void main(String[] args) throws Exception  {  

	Image[] data_train = Read("C:\\H\\strath\\259\\labs\\test-10.txt"); 

		for(int i = 0; i < data_train.length; i++) {

			 System.out.println(data_train[i].label);

			 for(int row = 0; row < 28 ; row++) {
				 for(int pixel = 0; pixel < 28  ; pixel++)
				 {
					 // Finish the code here:
					 if (  data_train[i].get(row, pixel) > 0  )
						 System.out.print(   );
					 else
						 System.out.print(   ); 
				 }
			 	 System.out.println(" ");
			 }
		}
}
}