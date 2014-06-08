/**
 * CIS 110 (11fa) - Homework 8
 * The CritterInfo interface.
 *
 * An interface that describes the info that a particular critter object
 * knows about during the simulation.  Subclasses of Critter may use
 * the CritterInfo field of their critter (defined in the Critter class)
 * to make more informed decisions.  This field is updated by the
 * simulation at the beginning of each time step.
 */

// Implementors of CritterInfo provide information about a particular critter.
public interface CritterInfo {
	// Returns the current x-coordinate of the critter in the world.
	public int getX();
	
	// Returns the current y-coordinate of the critter in the world.
	public int getY();
	
	// Returns the String representation of the space adjacent to the
	// critter in the given direction.  This is what your critter "sees".
	public String getNeighbor(Critter.Direction direction);
	
	// Returns the hunger level of the critter where 0 means that the
	// critter is not hungry at all.
	public int getHungerLevel();
	
	// Returns true if the critter has mated.  Remember that a critter
	// can only mate once in its lifetime.
	public boolean hasMated();
}