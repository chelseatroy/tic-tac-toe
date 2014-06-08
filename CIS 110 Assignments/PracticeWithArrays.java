import java.util.Arrays;

public class PracticeWithArrays{

	public static void main(String[] args){
		int[] test = {1,2,3,4,5,6,7,8,9};
		String[] tes2 = {"mom","dad","brother","sister","cousin"};
		Random r = new Random();
		int k = 3;
		concatenate(tes2);
	}
	
	public static void mysteryArray(){
		String[] msgs= {"a","b","c","d","e"};
		for(int i=0; i<msgs.length; i++){
			msgs[i] = msgs[msgs.length-i-1]+msgs[i];
			System.out.print(msgs[i]+" ");
		}
	}
	
	public static void shiftRight(int[] test){
		for (int i=test.length; i>1; i--){
			test[i-1] = test[i-2];
		}
		test[0] = 0;
		for(int j=0; j<test.length; j++){
			System.out.print(test[j]+" ");
		}
	}
	
	public static void printMultiplesOfThree(int[] test){
		for(int j=2; j<test.length; j+=3){
			System.out.print(test[j]+" ");
		}
	}
	
	public static void getLengths (String[] tes2){
		for(int j=0; j<tes2.length; j++){
			double k = tes2[j].length();
			System.out.println(k);
		}
	}
	
	public static void medianOfThree(int[]test){
		for (int i=0; i<=test.length; i+=3){
			int[]mediansub = {test[i],test[i+1],test[i+2]};
			Arrays.sort(mediansub);
			System.out.println(test[mediansub.length/2]);
		}
	}
	
	public static void concatenate(String[]tes2){
		String arraystring = Arrays.toString(tes2);
		System.out.print(arraystring);
	}
	
	public static void randomFill(int[]test,int k,Random r){
		for(int i = 0; i<=test.length; i+=3){
			int q = r;
			test[0]=q;
			test[i+1]=q;
			test[i+2]=q;
		}
		System.out.println(Arrays.toString(test));
	}
	
}