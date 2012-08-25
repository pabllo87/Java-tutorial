package CheckingAccount;

public class WeatherData {
	String country = "United States";
	String[] cities = {"Chicago", "New York", "Los Angeles"};
	double[][] temperatures = new double[3][];
	
	for(int row = 0; row < temperatures.length; row++){
		temperatures[row] = new double[2];
	}
}
