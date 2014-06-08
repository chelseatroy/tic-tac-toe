import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Ant extends Critter {
	private boolean b;
	private String justnow;
	
	//constructor (non-automatic)
	public Ant(boolean stepsNorth){
		b = stepsNorth;
		justnow = "initial";
	}
	
	//determines which of 4 ways the ant will move based on a)the boolean abd b) what the ant just did
	public Direction getMove(){
		if (justnow.equals("north")){
			justnow = "east";
			return Direction.EAST;
		}
		else if (justnow.equals("south")){
			justnow = "west";
			return Direction.WEST;
		}
		else if (b==true){
			justnow = "north";
			return Direction.NORTH;
		}
		else {
			justnow = "south";
			return Direction.SOUTH;
		}
		
	}
	
	
	// Returns the food type for this ant: grass.
	public FoodType getFoodType() {
		return FoodType.GRASS;
	}
	
	// Returns the color for this ant: black.
	public Color getColor() {
		return Color.BLACK;
	}
	
	// Returns the speed of this bird: fast.
	public Speed getSpeed() {
		return Speed.FAST;
	}
	
	// Returns the String representation of this ant.
	public String toString() {
		return "%";
	}
}