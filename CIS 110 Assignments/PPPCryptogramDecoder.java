//Cryptogram Decoder for PPP 2012 Agents//

//How to use this decoder program://
//Below you see a list of lines that start with "if" and end with a curly bracket.//
//That is your cipher interface. When you think you know which letter in the cipher//
//stands for A, you go to the first line and change the "_ "//
//so that instead of the underscore and space between the parentheses, the code letter//
//for letter a is between the parentheses.//
//As an example, "X" is already decoded for you.//

//When you want to try out your substitutions, copy the encoded message and paste it//
//in the "run" box. Then hit enter. The program will use the substitutions you gave it//
//to decipher the message for you.//
import java.util.Scanner;
public class PPPCryptogramDecoder{

	public static String decodeTheAlphabet (String s){
		if (s.equals("a")||s.equals("A")){return"_ ";}
		if (s.equals("b")||s.equals("B")){return"_ ";}
		if (s.equals("c")||s.equals("C")){return"_ ";}
		if (s.equals("d")||s.equals("D")){return"_ ";}
		if (s.equals("e")||s.equals("E")){return"_ ";}
		if (s.equals("f")||s.equals("F")){return"_ ";}
		if (s.equals("g")||s.equals("G")){return"_ ";}
		if (s.equals("h")||s.equals("H")){return"_ ";}
		if (s.equals("i")||s.equals("I")){return"_ ";}
		if (s.equals("j")||s.equals("J")){return"_ ";}
		if (s.equals("k")||s.equals("K")){return"_ ";}
		if (s.equals("l")||s.equals("L")){return"_ ";}
		if (s.equals("m")||s.equals("M")){return"_ ";}
		if (s.equals("n")||s.equals("N")){return"_ ";}
		if (s.equals("o")||s.equals("O")){return"_ ";}
		if (s.equals("p")||s.equals("P")){return"_ ";}
		if (s.equals("q")||s.equals("Q")){return"_ ";}
		if (s.equals("r")||s.equals("R")){return"_ ";}
		if (s.equals("s")||s.equals("S")){return"_ ";}
		if (s.equals("t")||s.equals("T")){return"_ ";}
		if (s.equals("u")||s.equals("U")){return"_ ";}
		if (s.equals("v")||s.equals("V")){return"_ ";}
		if (s.equals("w")||s.equals("W")){return"_ ";}
		if (s.equals("x")||s.equals("X")){return"N";}
		if (s.equals("y")||s.equals("Y")){return"_ ";}
		if (s.equals("z")||s.equals("Z")){return"_ ";}
		else{return s;}
	}
	
//If you change anything below this,//
//the decoder will not work.// 
//So please do not do that.//
	public static void main (String[]args){
		System.out.println("Please paste your encrypted message here.");
		System.out.println("Then hit enter and I will try to decrypt!");
		Scanner in = new Scanner(System.in);
		int wordsum = 0;
		while (in.hasNext()){
			String codeline = in.next();
			for (int i=0; i<codeline.length(); i++){
				System.out.print(decodeTheAlphabet(codeline.substring(i,i+1)));
			}
			System.out.print (" ");
			if (wordsum == 10){
				System.out.println();
				wordsum = 0;
			}
			wordsum +=1;
		}
		System.exit(0);
	}
	
}	