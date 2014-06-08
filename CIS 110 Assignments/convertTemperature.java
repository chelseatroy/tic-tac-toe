import java.util.Scanner;

public class convertTemperature{	

	public static void main(String[] args){
		Scanner user = new Scanner(System.in);
		promptCOrF();
		String U = user.nextLine();
		promptValue();
		int T = user.nextInt();
		if (U.equals("C")){
			calculateCelsiusToFarenheit(T);
		}
		else if (U.equals("F")){
			calculateFarenheitToCelsius(T);
		}
		else {
			System.out.println("Error: not C or F!");
		}
		//submitAnswer(A);
	}
	public static void promptCOrF(){
		System.out.println("Are you providing a Celsius or Farenheit Value?");
	}
	public static void promptValue(){
		System.out.println("Provide the degree value to convert.");
	}
	public static void submitAnswer(double A){
		System.out.println ("The converted amount is "+A);
	}
	public static double calculateCelsiusToFarenheit(double T){
		double A = (T*9/5)+32;
		submitAnswer(A);
		return A;
	}
	public static double calculateFarenheitToCelsius(double T){
		double A = (T-32)*5/9;
		submitAnswer(A);
		return A;
	}
}