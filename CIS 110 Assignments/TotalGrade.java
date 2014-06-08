import java.util.*;

public class TotalGrade{

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		totalHomework(in);
		totalLab(in);
		totalExams(in);
		totalFinal(in);
		totalCalculate();
	}

	public static int totalHomework(Scanner in){
		int totalHomework=0;
		for (int i=0; i<8; i++){
			System.out.print("Please enter homework grade #"+i);
			totalHomework+=in.nextint();
		}
		return totalHomework;
	}

	public static int totalLab(Scanner in){
		int totalLab=0;
		for (int i=0; i<10; i++){
			System.out.print("Please enter lab grade #"+i);
			totalLab+=in.nextint();
		}
		return totalLab;
	}

	public static int totalExams(Scanner in){
		int totalExams=0;
		for (int i=0; i<2; i++){
			System.out.print("Please enter exam grade #"+i);
			totalExams+=in.nextint();
		}
		return totalExams;
	}

	public static int totalFinal(Scanner in){
		int totalFinal=0;
		System.out.print("Please enter final exam grade");
		totalFinal+=in.nextint();
		return totalFinal;
	}
	public static double totalCalculate(){
		System.out.println((totalHomework/160*.50)+(totalLab/10*.10)+(totalExams/200*.24)+(totalFinal/100*.16));
	}
}