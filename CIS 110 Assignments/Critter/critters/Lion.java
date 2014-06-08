import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Lion extends Cat {
	private int slept;
	private int sleepneeded;
	private String justnow;
	
	//constructor (non-automatic)
	public Lion(){
		totaldistance = 0;
		slept = 0;
		sleepneeded = 0;
		justnow = "initialize";
	}
	
	public int getSleepNeeded(){
		Random s = new Random();
		sleepneeded = s.nextInt(5);
		return sleepneeded;
	}
	
	//decides where and whether the lion moves
	public Direction getMove(){
		if (totaldistance%8==0){
			sleepneeded = getSleepNeeded();
			if (slept < sleepneeded){
				slept ++;
				justnow = "sleeping";
				return Direction.CENTER;
			}
			else {
				totaldistance++;
				justnow = "sleeping";
				return Direction.CENTER;
			}
		}
		else{
			justnow = "moving";
			return super.getMove();
		}
	}
	
	// Returns the food type for this lion: meat.
	public FoodType getFoodType(){
		return FoodType.MEAT;
	}
	
	// Returns the color for this lion: yellow.
	public Color getColor(){
		return Color.YELLOW;
	}
	
	// Returns the speed of this lion: slow.
	public Speed getSpeed(){
		return Speed.SLOW;
	}
	
	// Returns the String representation of this lion.
	public String toString() {
		if (justnow.equals("sleeping")){
			return "Z";
		}
		else{
			return "L";
		}
	}
}