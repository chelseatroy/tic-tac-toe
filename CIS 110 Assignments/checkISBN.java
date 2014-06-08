//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 4
//checks ISBN-10 and ISBN-13 numbers for books

import java.util.Scanner;

public class checkISBN{

	public static void main(String[] args){
		Scanner user = new Scanner(System.in);
		//determines whether the user will enter an ISBN-10 or ISBN-13 code
		promptKind();ISBN-10
		//directs the program to run the appropriate check for that type of code
		String U = user.nextLine();
		if (U.equals("ISBN-10")){
			promptCode(U);
			String T = user.nextLine();
			checkISBN10(T);
		}
		else if (U.equals("ISBN-13")){
			promptCode(U);
			String T = user.nextLine();
			checkISBN13(T);
		}
		//provides a response for invalid code types
		else {
			System.out.println(U + " is an invalid ISBN type.");
		}
	}
	public static void promptKind(){
		System.out.println("What kind of ISBN do you want to check?");
	}
	public static String promptCode(String U){
		System.out.println("Enter the "+ U +" code to check.");
		return U;
	}
	//performs calculation on ISBN-10 codes using entered string
	public static String checkISBN10(String T){
		int tot = 0;
		for (int j=0; j<=8; j++){
			int val = Character.getNumericValue(T.charAt(j));
			tot += val*(j+1);
		}
		int mod = tot%11;
		char check = T.charAt(9);
		if (mod == Character.getNumericValue(T.charAt(9))){
			printValid10(T);
		}
		else if (mod==10 && Character.isLetter(check)){
			printValid10(T);
		}
		else{
			printInvalid(mod, check);
		}
		return T;
	}
	//prints statement that ISBN-10 code is valid
	public static void printValid10(String T){
		System.out.println(T + " is a valid ISBN-10 code.");

	}
	//prints statement that ISBN-13 code is valid
	public static void printValid13(String T){
		System.out.println(T + " is a valid ISBN-13 code.");
	}
	//prints statement that code is not valid
	public static void printInvalid(int mod, int check){
		System.out.println("Expected " + mod + ", but found " + check + ".");
	}
	//performs calculation on ISBN-10 codes using entered string
	public static String checkISBN13(String T){
		int tot = 0;
		for (int j=0; j<=11; j+=2){
			int val = Character.getNumericValue(T.charAt(j));
			tot += val;
		}
		for (int i=1; i<=11; i+=2){
			int val = Character.getNumericValue(T.charAt(i));
			tot += val*3;
		}
		int mod = 10-(tot%10);
		char check = T.charAt(12);
		if (mod == Character.getNumericValue(T.charAt(12))){
			printValid13(T);
		}
		else if (mod==10 && check==0){
			printValid13(T);
		}
		else{
			printInvalid(mod, check);
		}
		return T;
	}
}
	