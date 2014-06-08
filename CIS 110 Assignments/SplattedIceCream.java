//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 2
//prints the ice cream splat from the movie Despicable Me
class SplattedIceCream{
	public static void main (String [] args){
		printsCone();
		printsRim();
		printsSplat();
	}
	//draws top of PMA
	public static void printsCone(){
		for (int i=0; i<7; i++){
			for (int j=0; j<13-i; j++){
				System.out.print(" ");
			}
		System.out.print("(");
		for (int j=0; j<i; j++){
			System.out.print("()");
		}
		System.out.println(")");
		}
	}
		//draws rim of cone
		public static void printsRim(){
		System.out.println("  \'\'   (............)   \'\'");
	}
		//draws splattered ice cream
		public static void printsSplat(){
		System.out.println(" _^___^              ^___^__");
		System.out.println("__                         __");
		System.out.println(" _                           _");
		System.out.println("  _                        _");
		System.out.println("   v-------v-------v---vv--");
	}
}