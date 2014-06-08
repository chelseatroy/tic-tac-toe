//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 2
//prints ASCII rendering of PMA stairs
class RockySteps{
	public static void main (String [] args){
		printsTop();
		printsMiddle();
		printsSteps();
		printsFountain();
	}
	//draws top of PMA
	public static void printsTop(){
		for (int i=0; i<5; i++){
			for (int j=0; j<13-i; j++){
				System.out.print(" ");
			}
		System.out.print("/");
		for (int j=0; j<i; j++){
			System.out.print("/\\");
		}
		System.out.println("\\");
		}
	}
		//draws middle of PMA
		public static void printsMiddle(){
			System.out.println("---------| %    % |---------");
			System.out.println(" o o o o | %    % | o o o o ");
			System.out.println("---------| %    % |---------");
	}
	//draws the Rocky steps
		public static final int STEPS = 3;
			public static void printsSteps(){
				for (int i=0; i<STEPS; i++){
					for (int j=0; j<4-i; j++){
						System.out.print("~^");
						}
						System.out.print("~/");
					for (int j=0; j<8+2*i; j++){
						System.out.print("-");
						}
						System.out.print("\\");
					for (int j=0; j<4-i; j++){
						System.out.print("^~");
					}
					System.out.println();
				for (int j=0; j<4-i; j++){
						System.out.print(" ");
					}
					System.out.print("|");
					for (int j=0; j<8+2*i; j++){
						System.out.print("=");
					}
					System.out.println("|");
				}
	}
		//draws the fountain
		public static void printsFountain(){
			System.out.println("   /                    \\");
			for (int i=0; i<2; i++){
				for (int j=0; j<2-i;){
				System.out.print(" ");
				}
				System.out.print("/ ");
				for (int j=0; j<18; j++){
				System.out.print("=");
				}
				System.out.println(" \\");
			}
			System.out.println("|  | ");
			for (int j=0; j<18; j++){
				System.out.print ("\"");
			}
			System.out.println("|  |\"");
			System.out.println(" \\  \\ \"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\" /  /");
  			System.out.println("  \\  ==================  /");
   		System.out.println("   \\____________________/");
		}
}


