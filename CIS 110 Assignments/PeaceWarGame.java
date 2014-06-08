//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 4
//Plays Peace and War
import java.util.*;
//import.java.AI.*;

public class PeaceWarGame{
	public static void main (String[]args){
		//This is where the programmer decides how many rounds (years) s/he would like the game to last. 
		int numberofyears = 10;
		//This information is placed here for the purpose of creating a cumulative sum and will be used later. 
		int gamesplayed = 1;
		int gameswon = 0;
		int ourscore = 0;
		int theirscore = 0;
		int currentyear = 0;
		playASingleGameOfPeaceAndWar(numberofyears, gamesplayed, gameswon, ourscore, theirscore, currentyear);
	} 
	//implements one full game (not round, full game) of Peace and War
	public static void playASingleGameOfPeaceAndWar(int numberofyears, int gamesplayed, int gameswon, int ourscore, int theirscore, int currentyear){
		Scanner user = new Scanner(System.in);
		String laststrat = "";
		String compstrat = "";
		printYearAndScore (currentyear, ourscore, theirscore);
		for (currentyear = 1; currentyear<=numberofyears; currentyear++){
			getUserStrategy (user, laststrat, compstrat, ourscore, theirscore, currentyear);
		}
		printFinalScore(ourscore, theirscore, gamesplayed, gameswon);
		askPlayAgain(user, numberofyears, gamesplayed, gameswon, ourscore, theirscore, currentyear);
	}
	//prints the year and score so far at the beginning of each round
	public static void printYearAndScore(int currentyear, int ourscore, int theirscore){
		System.out.println("");
		System.out.println("Year: " + currentyear);
		System.out.println("Our score: " + ourscore);
		System.out.println("Their Score: " + theirscore);
	}
	//obtains the user strategy
	public static String getUserStrategy(Scanner user, String laststrat, String compstrat, int ourscore, int theirscore, int currentyear){
		System.out.println ("What is your strategy this year?");
		laststrat = user.nextLine();
		checkCorrectUserStrategy(user, laststrat, ourscore, theirscore, currentyear);
		return laststrat;
	}
	//checks to make sure that the user's input of type of strategy is correct
	//re-prompts if that strategy is not, in fact, correct. 
	public static void checkCorrectUserStrategy(Scanner user, String laststrat, int ourscore, int theirscore, int currentyear){
		if (laststrat.equalsIgnoreCase("peace") || laststrat.equalsIgnoreCase("war")){
			laststrat = laststrat.toLowerCase();
			System.out.println ("You chose " + laststrat +".");
			implementComputerStrategy(ourscore, theirscore, laststrat, currentyear);
		}
		else {
			System.out.println("Invalid strategy. Enter \"peace\" or \"war\".");
			laststrat = user.nextLine();
			checkCorrectUserStrategy (user, laststrat, ourscore, theirscore, currentyear);
		}
	}
	//obtains a strategy from the opponent (computer). In this version of the game, it's random.
	public static String implementComputerStrategy(int ourscore, int theirscore, String laststrat, int currentyear){
		String compstrat = "";
		Random r = new Random();
		int decider;
		decider = r.nextInt(2);
		if (decider == 1){
			compstrat = "peace";
		}
		else {
			compstrat = "war";
		}
		System.out.println("They chose "+ compstrat + ".");
		findScore(ourscore, theirscore, laststrat, compstrat, currentyear);
		return compstrat;
	}
	//determines the score at the end of each round and prints a message about the outcome
	public static void findScore(int ourscore, int theirscore, String laststrat, String compstrat, int currentyear){
		if (laststrat.equals("peace") && compstrat.equals ("peace")){
			System.out.println(">>> Peace for everyone!");
			ourscore = changeOurScore(ourscore, 3);
			theirscore = changeTheirScore(theirscore, 3);
		}
		else if (laststrat.equals("peace") && compstrat.equals ("war")){
			System.out.println(">>> They crushed us!");
			theirscore = changeTheirScore(theirscore, 5);
		}
		else if (laststrat.equals("war") && compstrat.equals ("peace")){
			System.out.println(">>> We crushed them!");
			ourscore = changeOurScore(ourscore, 5);
		}
		else if (laststrat.equals("war") && compstrat.equals ("war")){
			System.out.println(">>> Everyone to arms!");
			ourscore = changeOurScore(ourscore, 1);
			theirscore = changeTheirScore(theirscore, 1);
		}
		printYearAndScore (currentyear, ourscore, theirscore);
	}
	public static int changeOurScore(int ourscore, int pointsfor){
		ourscore += pointsfor;
		return ourscore;
	}
	public static int changeTheirScore(int theirscore, int pointsagainst){
		theirscore += pointsagainst;
		return theirscore;
	}
	//prints the final score at the end of each full Peace War Game along with the outcome
	public static int printFinalScore (int ourscore, int theirscore, int gamesplayed, int gameswon){
		System.out.println ("Final");
		System.out.println ("Our score: " + ourscore);
		System.out.println ("Their score: " + theirscore);
		System.out.println ("");
		if (ourscore > theirscore){
			System.out.println(">>> We win! <<<");
			gameswon += 1;
		}
		else if (ourscore < theirscore){
			System.out.println(">>> They win! <<<");
		}
		else if (ourscore == theirscore){
			System.out.println(">>> It's a tie! <<<");
		}
		return gameswon;
	}
	//asks if the user would like to play again
	public static void askPlayAgain(Scanner user, int numberofyears, int gamesplayed, int gameswon, int ourscore, int theirscore, int currentyear){
		System.out.println("Play again?");
		String useranswer = user.nextLine();
		checkUserAnswerPlayAgain(user, useranswer, numberofyears, gamesplayed, gameswon, ourscore, theirscore, currentyear);
	}
	//checks that the user input something valid for play again, and tells program what to do with user response
	public static int logGameplay(int gamesplayed){
		gamesplayed += 1;
		return gamesplayed;
	}
	public static void checkUserAnswerPlayAgain(Scanner user, String useranswer, int numberofyears, int gamesplayed, int gameswon, int ourscore, int theirscore, int currentyear){
		if (useranswer.equalsIgnoreCase("y")){
			logGameplay(gamesplayed);
			playASingleGameOfPeaceAndWar(numberofyears, gamesplayed, gameswon, ourscore, theirscore, currentyear);
		}
		else if (useranswer.equalsIgnoreCase("n")){
			reportFinalStatisticsAndExit(gamesplayed, gameswon);
		}
		else{
			System.out.println("Invalid response. Please enter \"y\" or \"n\".");
			useranswer = user.nextLine();
			checkUserAnswerPlayAgain(user, useranswer, numberofyears, gamesplayed, gameswon, ourscore, theirscore, currentyear);
		}
	}
	//submits statistics when player no longer wishes to play
	public static void reportFinalStatisticsAndExit(int gamesplayed, int gameswon){
		System.out.println("Total games played: " + gamesplayed);
		System.out.println("Total games won " + gameswon);
		System.out.printf("Win percentage: %.2f", (double)gameswon/gamesplayed);
	}
}