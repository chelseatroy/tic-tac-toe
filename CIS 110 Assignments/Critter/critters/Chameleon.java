import java.awt.Color;
import java.util.*;
import java.io.*;
import java.awt.Color;

public class Chameleon extends Cat {
	
	//constructor (non-automatic)
	public Chameleon(){
	}
	
	// Returns the color for this chameleon.
	public Color getColor() {
			return Color.CYAN;
	}
	
	// Returns the speed of this owl: fast.
	public Speed getSpeed() {
		return Speed.FAST;
	}
	
	public String toString(){
		if (getNeighbor(Direction.NORTH)!=="\""){
			return (getNeighbor(Direction.NORTH));
		}	
		else{
			return "$";
		}
	}
}