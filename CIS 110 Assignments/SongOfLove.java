// Chelsea Dommert, cdommert@sas.upenn.edu
// CIS 110 (section 207) - Homework 1
//prints all the lyrics to Song of Love
public class SongOfLove {
	public static void main(String[] args){
		printsFirstVerse();
		printsSecondPart();	
		printsThirdPart();	
		printsFourthPart();
		printsFifthPart();
		printsSixthPart();
		printsSeventhPart();
		printsEighthPart();		
		printsConclusion();
	}
	//prints Second Part
	public static void printsSecondPart(){
		printsFirstRepeat();
		printsSecondVerse();
		printsSecondRepeat();
	}
	//prints Third Part
	public static void printsThirdPart(){
		printsFirstRepeat();
		printsThirdVerse();
		printsThirdRepeat ();
	}
	//prints Fourth Part
	public static void printsFourthPart(){
		printsFirstRepeat();
		printsFourthVerse();
		printsFourthRepeat();
	}
	//prints Fifth Part
	public static void printsFifthPart(){
		printsFirstRepeat();
		printsFifthVerse();
		printsFifthRepeat();
	}
	//prints Sixth Part
	public static void printsSixthPart(){
		printsFirstRepeat();
		printsSixthVerse();
		printsSixthRepeat();
	}
	//prints Seventh Part
	public static void printsSeventhPart(){
		printsFirstRepeat();
		printsSeventhVerse();
		printsSeventhRepeat();
	}
	//prints Eighth Part
	public static void printsEighthPart(){
		printsFirstRepeat();
		printsEighthVerse();
		printsEighthRepeat();
	}
	//prints First Repeat
	public static void printsFirstRepeat(){
		System.out.println();
		System.out.println("I\'m in love with a girl named Fred.");
	}
	//prints Second Repeat
	public static void printsSecondRepeat(){
		System.out.println("With a \"F\" and a \"R\" and an \"E\" and a \"D\"\nAnd a \"F-R-E-D\" Fred! Yeah!");
	}
	//prints Third Repeat
	public static void printsThirdRepeat(){
		System.out.println("Fill the bowl to overflowing. Raise the goblet high!");
		printsSecondRepeat();
	}
	//prints Fourth Repeat
	public static void printsFourthRepeat(){
		System.out.println("La la la la, la la la la, la la la la la!");
		printsThirdRepeat();
	}
	//prints Fifth Repeat
	public static void printsFifthRepeat(){
		System.out.println("Clap clap, clap clap, clap clap clap clap, clap, clap clap!");
		printsFourthRepeat();
	}
	//prints Sixth Repeat
	public static void printsSixthRepeat(){
		System.out.println("Bravo!  Bravo!  Bravissimo bravo!  Bravissimo!");
		printsFifthRepeat();
	}
	//prints Seventh Repeat
	public static void printsSeventhRepeat(){
		System.out.println("Strum strum, strum strum, strum strum strum strum strum, strum.");
		printsSixthRepeat();
	}
	//prints Eighth Repeat
	public static void printsEighthRepeat(){
		System.out.println("Ha ha ha ha, ho ho ho ho, ha ha ha ha ho!");
		printsSeventhRepeat();

	}
	//prints First Verse
	public static void printsFirstVerse (){
		System.out.println("I like you, Fred, I like you!");
		System.out.println("You\'re just saying those words to be kind.");
		System.out.println("No, I mean it.  I like... I mean I love you, Fred!");				
		System.out.println("He is out of his medieval mind!");
		System.out.println("I\'m perfectly sane and sound! I never felt better in my life!");		
		System.out.println("Everybody... everybody, everybody! Come on! And meet my incipient wife!");
	}
	//prints Second Verse
	public static void printsSecondVerse (){
		System.out.println("My reasons must be clear.");
		System.out.println("When she shows you all how strong she is you\'ll stand right up and cheer!");
	}
	//prints Third Verse
	public static void printsThirdVerse (){
		System.out.println("She drinks just like a lord!");
		System.out.println("So sing a merry drinking song and let the wine be poured!");
	}
	//prints Fourth Verse
	public static void printsFourthVerse (){
		System.out.println("She sings just like a bird!");
		System.out.println("You'll be left completely speechless when her gentle voice is heard!");
	}
	//prints Fifth Verse
	public static void printsFifthVerse (){
		System.out.println("She wrestles like a Greek!");
		System.out.println("You will clap your hands in wonder at her fabulous technique!");
	}
	//prints Sixth Verse
	public static void printsSixthVerse (){
		System.out.println("She dances with such grace!");
		System.out.println("You are bound to sing her praises \'til you're purple in the face!");
	}
	//prints Seventh Verse
	public static void printsSeventhVerse (){
		System.out.println("She\'s musical to boot!");
		System.out.println("She will set your feet a-tapping when she plays upon her lute!");
	}
	//prints Eighth Verse
	public static void printsEighthVerse (){
		System.out.println("A clever, clownish wit!");
		System.out.println("When she does her funny pantomime your sides are sure to split!");
	}
	//prints Conclusion
	public static void printsConclusion(){
		System.out.println();
		System.out.println("I\'m in love with a girl.");
		System.out.println("He\'s in love with a girl named \"F-R-E-D\" Fred!");
	}
}
		