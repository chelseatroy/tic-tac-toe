//Cryptogram Encoder for PPP 2012 Upperclassmen//
import java.util.*;
public class PPPCryptogramEncoder{

	public static String encodeTheAlphabet (String s){
		if (s.equals("a")||s.equals("A")){return"O";}
		if (s.equals("b")||s.equals("B")){return"M";}
		if (s.equals("c")||s.equals("C")){return"P";}
		if (s.equals("d")||s.equals("D")){return"J";}
		if (s.equals("e")||s.equals("E")){return"I";}
		if (s.equals("f")||s.equals("F")){return"W";}
		if (s.equals("g")||s.equals("G")){return"Z";}
		if (s.equals("h")||s.equals("H")){return"V";}
		if (s.equals("i")||s.equals("I")){return"A";}
		if (s.equals("j")||s.equals("J")){return"S";}
		if (s.equals("k")||s.equals("K")){return"T";}
		if (s.equals("l")||s.equals("L")){return"R";}
		if (s.equals("m")||s.equals("M")){return"Q";}
		if (s.equals("n")||s.equals("N")){return"B";}
		if (s.equals("o")||s.equals("O")){return"U";}
		if (s.equals("p")||s.equals("P")){return"X";}
		if (s.equals("q")||s.equals("Q")){return"C";}
		if (s.equals("r")||s.equals("R")){return"K";}
		if (s.equals("s")||s.equals("S")){return"D";}
		if (s.equals("t")||s.equals("T")){return"L";}
		if (s.equals("u")||s.equals("U")){return"E";}
		if (s.equals("v")||s.equals("V")){return"F";}
		if (s.equals("w")||s.equals("W")){return"H";}
		if (s.equals("x")||s.equals("X")){return"N";}
		if (s.equals("y")||s.equals("Y")){return"Y";}
		if (s.equals("z")||s.equals("Z")){return"G";}
		else{return s;}
	}
	
   public static void main (String[]args){
		System.out.println("Please type or paste your message here.");
		System.out.println("Then hit enter and I will encrypt!");
		Scanner in = new Scanner(System.in);
		int wordsum = 0;
		while (in.hasNext()){
			String textline = in.next();
			for (int i=0; i<textline.length(); i++){
				System.out.print(encodeTheAlphabet(textline.substring(i,i+1)));
			}
			System.out.print (" ");
			if (wordsum % 10==0){System.out.println();}
			if (textline.equals("%")){return;}
			wordsum +=1;
		}
	}
	
}	