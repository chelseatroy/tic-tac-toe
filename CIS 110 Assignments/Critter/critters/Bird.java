import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Bird extends Critter {
	private int diam;
	protected String justnow;
	
	//constructor (non-automatic)
	public Bird(){
		diam=0;
		justnow = "initial";
	}
	
	//determines the direction of the bird's flight
	public Direction getMove(){
		if (diam < 3){
			diam++;
			justnow = "east";
			return Direction.EAST;
		}
		else if (diam < 6){
			diam++;
			justnow = "south";
			return Direction.SOUTH;
		}
		else if (diam < 9){
			diam++;
			justnow = "west";
			return Direction.WEST;
		}
		else if (diam < 12){
			diam++;
			justnow = "north";
			return Direction.NORTH;
		}
		else {
			diam = 0;
			diam++;
			justnow = "east";
			return Direction.EAST;
		}	
	}
	
		// Returns the food type for this bird: grass.
	public FoodType getFoodType() {
		return FoodType.GRASS;
	}
	
	// Returns the color for this bird: red.
	public Color getColor() {
		return Color.RED;
	}
	
	// Returns the speed of this bird: fast.
	public Speed getSpeed() {
		return Speed.FAST;
	}
	
	// Returns the String representation of this bird.
	public String toString() {
		if (justnow.equals("east")){
			return ">";
		}
		if (justnow.equals("south")){
			return "v";
		}
		if (justnow.equals("west")){
			return "<";
		}
		if (justnow.equals("north")){
			return "^";
		}
		else{
			return ">";
		}
	}
}