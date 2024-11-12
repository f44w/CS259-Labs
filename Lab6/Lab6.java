import java.io.*;

public class Lab6 {

    static void Assert (boolean res) // We use this to test our results - don't delete or modify!
    {
        if(!res)	{
            System.out.print("Something went wrong.");
            System.exit(0);
        }
    }

    // Copy your implementation of vector operations here:
    // ...

    static double [] mult(double a, double [] V) { // multiplying scalar and vector
        // add your code
        double [] res = new double[V.length];   // create a vector of same size, that we will return
        for (int i = 0; i < V.length; i++){
            res[i] = a*V[i];
        }
        return res;
    }
    static double [] add(double a, double [] V) { // adding scalar and vector
        // add your code
        double [] res = new double[V.length];
        for (int i = 0; i < V.length; i++){
            res[i] = a+V[i];
        }
        return res;
    }
    static double [] sub(double a, double [] V) {  // subtracting a scalar from vector
        // add your code
        double [] res = new double[V.length];
        for (int i = 0; i < V.length; i++){
            res[i] = V[i]-a;
        }
        return res;
    }

    static double [] add(double [] U, double [] V) { // adding two vectors
        // add your code
        double [] res = new double[U.length];
        for (int i = 0; i < U.length; i++){
            res[i] = U[i]+V[i];
        }
        return res;
    }
    static double [] sub(double [] U, double [] V) { // subtracting vector from vector
        // add your code
        double [] res = new double[V.length];
        for (int i = 0; i < V.length; i++){
            res[i] = U[i]-V[i];
        }
        return res;
    }

    static double dot(double [] U, double [] V) { // dot product of two vectors
        // add your code
        double [] res = new double[U.length];
        double dot = 0;
        for (int i = 0; i < U.length; i++){
            res[i] = U[i]*V[i];

        }
        for(int j = 0; j < V.length; j++){
            dot += res[j];
        }
        return dot;
    }


    static int NumberOfFeatures = 20;

    static double[] toFeatureVector(String day, double temperature, String condition, double wind, double humidity, int model) {
        double[] feature = new double[NumberOfFeatures];

        // Creates our feature vector allowing us to compute distance between days:

        switch (day) {
            case "Monday":    feature[0] = 1; break;
            case "Tuesday":   feature[1] = 1; break;
            case "Wednesday": feature[2] = 1; break;
            case "Thursday":  feature[3] = 1; break;
            case "Friday":    feature[4] = 1; break;
            case "Saturday":  feature[5] = 1; break;
            case "Sunday":    feature[6] = 1; break;
            default: Assert(false);
        }

        // Add your code to similarly handle 'condition' attribute:
        // ...
        switch (condition) {
            case "Sunny":
                feature[7] = 1;
                break;
            case "Cloudy":
                feature[8] = 1;
                break;
            case "Rainy":
                feature[9] = 1;
                break;
            default:
                Assert(false);
        }

        if (model == 2) { // Finish those lines to create Model 2 from our slides
            // Model 2 includes temperature in its feature vector:

            feature[10] = temperature;
            // ...
        }
        if (model == 3) { // Finish those lines to create Model 2 from our slides
            // To correct the temperature from being too extreme
            feature[10] = temperature - 18;
            // ...
        }

        return feature;
    }

    static double similarity(double[] u, double[] v) {
        // Calculate how alinged the vectors are (how algined the two cases are)
        // If dot product is high, indicates high similarity
        return dot(u, v);
    }

    static int knnClassify(double[][] trainingData, int[] trainingLabels, double[] testFeature) {
        int bestMatch = -1;
        double bestSimilarity = -1000;

        for (int i = 0; i < trainingData.length; i++) {
            double currentSimilarity = similarity(testFeature, trainingData[i]);
            System.out.printf("i: %d currentSimilarity: %.2f bestSimilarity: %.2f \n", i+1, currentSimilarity, bestSimilarity);

            if (currentSimilarity > bestSimilarity) { // Update the nearest-neighbour if closer (more similar) training example found.
                // Add some actions here ... OR finish the lines
                bestSimilarity = currentSimilarity;
                bestMatch = i;
            }
        }
        System.out.printf("bestSimilarity: %.2f bestMatch: %d \n", bestSimilarity, bestMatch+1);
        return trainingLabels[bestMatch];
    }

    static void loadData(String filePath, double[][] dataFeatures, int[] dataLabels, int model) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int idx = 0;
            br.readLine(); // skip first line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String day = values[0];
                double temperature = Double.parseDouble(values[1]);
                String condition = values[2];
                double wind = Double.parseDouble(values[3]);
                double humidity = Double.parseDouble(values[4]);

                dataFeatures[idx] = toFeatureVector(day, temperature, condition, wind, humidity, model);
                dataLabels[idx] = "Yes".equals(values[5]) ? 1 : 0;
                idx++;
            }
        }
    }

    public static void main(String[] args) {


        double[][] trainingData = new double[5][];
        int[] trainingLabels = new int[5];
        double[][] testingData = new double[5][];
        int[] testingLabels = new int[5];

        System.out.printf("Testing Model 1 ... \n");
        try { // Change your path accordingly:
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-train-shift.csv", trainingData, trainingLabels, 1);
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-test-shift.csv", testingData, testingLabels, 1);
        }
        catch (IOException e) {
            System.out.println("Error reading data files: " + e.getMessage());
            return;
        }

        Assert(knnClassify(trainingData, trainingLabels, testingData[0]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[1]) == 0);
        Assert(knnClassify(trainingData, trainingLabels, testingData[2]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[3]) == 0);
        System.out.println("");
        System.out.printf("Testing Model 2 ... \n");
        try { // Change your path accordingly:
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-train-shift.csv", trainingData, trainingLabels, 2);
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-test-shift.csv", testingData, testingLabels, 2);
        }
        catch (IOException e) {
            System.out.println("Error reading data files: " + e.getMessage());
            return;
        }
        Assert(knnClassify(trainingData, trainingLabels, testingData[0]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[1]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[2]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[3]) == 1);

        System.out.println("");
        System.out.printf("Testing Model 3 ... \n");
        try { // Change your path accordingly:
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-train-shift.csv", trainingData, trainingLabels, 3);
            loadData("C:\\Users\\frase\\OneDrive - University of Strathclyde\\CS-Y2\\CS259\\Labs\\Lab6\\jogging-test-shift.csv", testingData, testingLabels, 3);
        }
        catch (IOException e) {
            System.out.println("Error reading data files: " + e.getMessage());
            return;
        }

        Assert(knnClassify(trainingData, trainingLabels, testingData[0]) == 0);
        Assert(knnClassify(trainingData, trainingLabels, testingData[1]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[2]) == 1);
        Assert(knnClassify(trainingData, trainingLabels, testingData[3]) == 0);

        System.out.printf("All tests are fine! \n");    }
}