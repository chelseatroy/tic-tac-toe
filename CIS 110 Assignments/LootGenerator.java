//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 6
//generates loot for a computer game
import java.util.*;
import java.io.*;

public class LootGenerator{
	public static void main (String[]args)throws FileNotFoundException{
		runTheGame();
	}
	
	//initalizes the running of the game
	public static void runTheGame()throws FileNotFoundException{
		String treasureclass = "t";
		treasureclass = chooseMonsterAndIDTreasureclass(treasureclass);
		findObjectsForTreasureclass(treasureclass);
	}
	
	//randomly selects a monster and finds treasureclass options
	public static String chooseMonsterAndIDTreasureclass(String treasureclass)throws FileNotFoundException{
		Scanner monsterfinder = new Scanner(new File("large_data/monstats.txt"));
		int num = monsterfinder.nextInt();
		monsterfinder.nextLine();
		int j = 1 + (int)(Math.random() * ((num - 1) + 1));
		for (int i = 1; i<=j; i++){
			monsterfinder.nextLine();
		}
		String monster = monsterfinder.next();
		monster = monster.replace('_',' ');
		System.out.println("Fighting " + monster + "...");
		System.out.println("You have slain " + monster + "!");
		System.out.println(monster + " dropped: ");
		System.out.println("=====");
		treasureclass = monsterfinder.next();
		treasureclass = monsterfinder.next();
		treasureclass = monsterfinder.next();
		return treasureclass;
	}
	
	//finds the objects in the treasureclass
	public static String findObjectsForTreasureclass(String treasureclass) throws FileNotFoundException{
		Scanner typefinder = new Scanner(new File("large_data/TreasureClassEx.txt"));
		String theobject = "o";
		while (typefinder.hasNextLine()){
			Scanner line = new Scanner(typefinder.nextLine());
			if (line.next().equals(treasureclass)){
				getObject(treasureclass,typefinder,line,theobject);
			}
		}
		return theobject;
	}
	
	//randomly chooses among the objects
	public static String getObject(String treasureclass, Scanner typefinder, Scanner line, String theobject)throws FileNotFoundException{
			String firstobject = line.next();
			String secondobject = line.next();
			String thirdobject = line.next();
			Random r = new Random();
			int objectpicker = r.nextInt(3);
			if (objectpicker == 1){
				theobject = firstobject;
			}
			else if (objectpicker == 2){
				theobject = secondobject;
			}
			else{
				theobject = thirdobject;
			}
		theobject = makeSureObjectNotAnotherTreasureclass(theobject,treasureclass);
		return theobject;
	}
	
	//checks that the chosen object is not, itself, a treasureclass
	public static String makeSureObjectNotAnotherTreasureclass(String theobject, String treasureclass)throws FileNotFoundException{
		if (theobject.startsWith("tc:")){
				treasureclass = theobject;
				findObjectsForTreasureclass(treasureclass);
		}
		else{
			decideToAddPrefixAndSuffix(theobject);
			determineObjectStats(theobject);
		}
		return theobject;
	}
	
	//randomly chooses whether to add prefixes and suffixes and prints message body
	public static void decideToAddPrefixAndSuffix (String theobject)throws FileNotFoundException{
		Random r = new Random();
		String prefixstatscomplete = ("Whoops!");
		String suffixstatscomplete = ("Whoops!");
		int storeprefixtoprint = r.nextInt(2);
		int storesuffixtoprint = r.nextInt(2);
		if (storeprefixtoprint == 1){
			prefixstatscomplete = addAPrefix();
		}
		theobject = theobject.replace('_',' ');
		
		
		System.out.print(theobject);
		
		
		if (storesuffixtoprint == 1){
			suffixstatscomplete = addASuffix();
		}
		System.out.println();
		if (storeprefixtoprint == 1){
			System.out.println(prefixstatscomplete);
		}
		if (storesuffixtoprint == 1){
			System.out.println(suffixstatscomplete);
		}
	}
	
	//chooses a prefix and identifies its stats
	public static String addAPrefix() throws FileNotFoundException{
		Scanner prefixpicker = new Scanner(new File("large_data/MagicPrefix.txt"));
		int num = prefixpicker.nextInt();
		prefixpicker.nextLine();
		Random r = new Random();
		int j = 1 + (int)(Math.random() * ((num - 1) + 1));
		for (int i = 1; i<=num; i++){
			prefixpicker.nextLine();
		}
		String prefix = prefixpicker.next();
		System.out.print(prefix +" ");
		String prefixstat = prefixpicker.next().replace('_',' ');
		int minval = prefixpicker.nextInt();
		int maxval = prefixpicker.nextInt();
		int numa = minval + (int)(Math.random() * ((maxval - minval) + 1));
		String prefixstatscomplete = prefixstat+": "+numa;
		return prefixstatscomplete;
	}
	
	//chooses a suffix and identifies its stats	
	public static String addASuffix()throws FileNotFoundException{
		Scanner suffixpicker = new Scanner(new File("large_data/MagicSuffix.txt"));
		int num = suffixpicker.nextInt();
		suffixpicker.nextLine();
		Random r = new Random();
		int j = 1 + (int)(Math.random() * ((num - 1) + 1));
		for (int i = 1; i<=num; i++){
			suffixpicker.nextLine();
		}
		String suffix = suffixpicker.next().replace('_',' ');
		System.out.print(" " + suffix);
		String suffixstat = suffixpicker.next().replace('_',' ');
		int minsuf = suffixpicker.nextInt();
		int maxsuf = suffixpicker.nextInt();
		int numb = minsuf + (int)(Math.random() * ((maxsuf - minsuf) + 1));
		String suffixstatscomplete = suffixstat+": "+numb;
		return suffixstatscomplete;
	}
	
	//generates general stats
	public static void determineObjectStats(String theobject)throws FileNotFoundException{
		Scanner statsreader = new Scanner(new File("large_data/armor.txt"));
		while (statsreader.hasNextLine()){
			Scanner line = new Scanner(statsreader.nextLine());
			int minstrength = 1000;
			int maxstrength = 1002;
				if (line.next().equals(theobject)){
					minstrength = line.nextInt();
					maxstrength = line.nextInt();
					int strength = minstrength + (int)(Math.random() * ((maxstrength - minstrength) + 1));
					System.out.println(strength + " Strength");
					System.out.println("=====");
					promptUserPlayAgain();
				}
			}
		}
		
		//prompts replay
		public static void promptUserPlayAgain()throws FileNotFoundException{
			System.out.println("Fight again [y/n]?");
			Scanner in = new Scanner(System.in);
			String gotcha = in.next();
			if (gotcha.equalsIgnoreCase("y")){
				runTheGame();
			}
			else if (gotcha.equalsIgnoreCase("n")){
				System.out.println();
			}
			else {
				promptUserPlayAgain();
			}
		}
}