import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Flower extends Critter {
	
	//constructor (non-automatic)
	public Flower(){
	}
	
	//Flowers do not move
	public Direction getMove(){
		propogate();
		return Direction.CENTER;
	}
	
	
	// Returns the food type for this ant: grass.
	public FoodType getFoodType() {
		return FoodType.GRASS;
	}
	
	// Returns the color for this ant: black.
	public Color getColor() {
		return Color.WHITE;
	}
	
	// Returns the speed of this bird: fast.
	public Speed getSpeed() {
		return Speed.FAST;
	}
	
	// Returns the String representation of this ant.
	public String toString() {
		return "*";
	}
	
}