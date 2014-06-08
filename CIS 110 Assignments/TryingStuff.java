import java.util.Scanner;
public class TryingStuff{

	public static void main(String[]args){
		promptUserPlayAgain();
	}
		
	public static void promptUserPlayAgain(){
			System.out.println("Fight again [y/n]?");
			Scanner in = new Scanner(System.in);
			if (in.next().equalsIgnoreCase("y")){
				System.out.println("yay!");
			}
			if (in.next().equalsIgnoreCase("n")){
				System.out.println("you suck.");
			}
			else {
				promptUserPlayAgain();
			}
		}

}