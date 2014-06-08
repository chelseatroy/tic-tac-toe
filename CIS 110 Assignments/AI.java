public class AI{
	public static void main (String[]args){
		getStrategy(rand, currentYear, lastStrat);
		getName();
	}
	// Returns the strategy the computer should do this turn, either "war" or
   // "peace".  
	//My strategy is "tit for tat." 
   public static String getStrategy(Random rand, int currentYear, String lastStrat) {
        return lastStrat;
   }
    // Returns your AI's name that will be used during the tournament.  This
    // can be your name or any nickname as long as it is not offensive or
    // otherwise inappropriate.
   public static String getName() {
        System.out.println ("AI name: Talibanistan");
   }
}