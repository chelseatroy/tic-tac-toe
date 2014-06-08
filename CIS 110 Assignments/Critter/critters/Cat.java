import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Cat extends Critter {
	private int dist;
	private int pickykitty;
	protected int totaldistance;
	
	//constructor (non-automatic)
	public Cat(){
		dist = 0;
		pickykitty = 0;
		totaldistance = 0;
	}
	
	public int getTotalDistance(){
		return totaldistance;
	}
	
	public int catchDirection(){
		if (dist == 5){
			dist = 0;
			Random r = new Random();
			pickykitty = r.nextInt(4);
		}
		return pickykitty;
	}
	
	//determines the direction of the cat
	public Direction getMove(){
		totaldistance++;
		pickykitty = catchDirection();
		if (dist < 5 && pickykitty == 1){
			dist++;
			return Direction.EAST;
		}
		if (dist < 5 && pickykitty == 2){
			dist++;
			return Direction.WEST;
		}
		if (dist < 5 && pickykitty == 3){
			dist++;
			return Direction.NORTH;
		}
		else {
			dist++;
			return Direction.SOUTH;
		}
	}
	
		// Returns the food type for this cat: meat.
	public FoodType getFoodType(){
		return FoodType.MEAT;
	}
	
	// Returns the color for this cat: magenta.
	public Color getColor(){
		return Color.MAGENTA;
	}
	
	// Returns the speed of this cat: medium.
	public Speed getSpeed(){
		return Speed.MEDIUM;
	}
	
	// Returns the String representation of this cat.
	public String toString() {
		return "c";
	}
}