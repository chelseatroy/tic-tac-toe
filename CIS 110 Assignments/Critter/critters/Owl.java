import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Owl extends Bird {
	private boolean haseaten;
	private int longwinter;
	
	//constructor (non-automatic)
	public Owl(){
		haseaten = false;
		longwinter = 0;
	}
	
	// Returns the color for this owl: gray in normal life, white upon migration north.
	public Color getColor() {
		if (haseaten == true){
			return Color.WHITE;
		}
		else{
			return Color.GRAY;
		}
	}
	
	// Returns the speed of this owl: slow.
	public Speed getSpeed() {
		return Speed.SLOW;
	}
	
	//once these owls have eaten to prepare for winter, they migrate north.
	//the reason  they turn white is to blend in better with the snow up north.
	//(See, evolution will take some time to catch up to climate change,
	//which has made it too warm all over the earth for snow to fall).
	public void onEat(){
		haseaten = true;
		getMove();
	}
	
	public Direction getMove(){
		if (haseaten==true && longwinter<20){
			longwinter++;
			justnow = "north";
			return Direction.NORTH;
		}
		else{
			return super.getMove();
		}
	}
	
}