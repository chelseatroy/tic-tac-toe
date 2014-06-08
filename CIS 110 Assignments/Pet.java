import java.util.*;

public class Pet extends PetGame{
		private int age;
		private String name;
		private int foodLevel;
		
		//this is called a CONSTRUCTOR. This is how you initialize your objects.
		public Pet(){
			age=1;
			name="Buffy the Vampire Slayer";
			foodLevel=10;
		}
		
		//You can have multiple ways to initialize an object in the same class.
		public Pet(String newName){
			age=1;
			name=newName;
			foodLevel=10;
		}
		
		//You don't have to return the new age because objects live in "dynamic memory"
		//and they remember changes about themselves. 
		public void birthday(){
			age++;
			System.out.println("Happy Birthday "+name);
		}
		
		public void feed(){
			foodLevel=10;
		}
		
		public String toString(){
			String print = "Name: "+name+"\nAge: "+age+"\n";
			System.out.println(print);
			live();
			return print;
		}
		
		public void live(){
			if (foodLevel>0){
				foodLevel--;
			}
			if (foodLevel==0){
				System.out.println("Feed me! I'm hungry!");
			}
		}
}