/**
 * CIS 110 (11fa) - Homework 8
 * The CritterModel class.
 *
 * NOTE: YOU SHOULD NOT MODIFY THIS CLASS FOR THE HOMEWORK.
 *
 * The CritterModel is the object that represents the entire simulation.
 * it is responsible for maintaining the location of critters and grass in
 * the world and stepping them through time.
 */

import java.awt.Color;
import java.awt.Point;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;

// The CritterModel is the simulation world.
public class CritterModel {
	///// IMPORTANT CONSTANTS /////
	
	// The symbol used for grass.
	public static final String GRASS_SYMBOL = "\"";
	
	// The symbol used for an empty space in the world.
	public static final String EMPTY_SYMBOL = " ";
	
	// Our random object for the simulation.
	private static final Random RAND = new Random();

	private List<ConcreteCritter> critters;
	private ConcreteCritter[][] board;
	private int[][] grass;
	private int width;
	private int height;
	private int numSteps;
	private int randomGrassProb;
	private int hungerLimit;

	///// PUBLIC METHODS /////

	// Constructs a new model with the given parameters:
	// width - the width of the world
	// height - the height of the world
	// randomGrassProb - the factor by which grass randomly spawns; larger
	//                   numbers means it is less likely for more grass to spawn.
	// hungerLimit - the hunger count at which a Critter dies
	// critterTypes - the types of critters to spawn in this simulation
	// numInitial - the number of critters to spawn of each type
	// initialGrassRatio - the initial ratio of grass to not-grass in the world.
	public CritterModel(int width, int height, int randomGrassProb, int hungerLimit,
	                    List<Class<?>> critterTypes, int numInitial, double initialGrassRatio) {
		this.width = width;
		this.height = height;
		this.critters = new LinkedList<ConcreteCritter>();
		this.board = new ConcreteCritter[width][height];
		this.grass = new int[width][height];
		this.numSteps = 0;
		this.randomGrassProb = randomGrassProb;
		this.hungerLimit = hungerLimit;
		initializeWorld(critterTypes, numInitial, initialGrassRatio);
	}

	// Returns the number of steps so far taken in this simulation.
	public int getNumSteps() { return numSteps; }
	
	// Returns the width of the simulation world.
	public int getWidth() { return width; }
	
	// Returns the height of the simulation world.
	public int getHeight() { return height; }
	
	// Returns the String/glyph for position (x, y) in the world.
	public String getGlyphAt(int x, int y) {
		ConcreteCritter critter = board[x][y];
		if (critter != null) {
			return critter.toString();
		} else if (grass[x][y] > 0) {
			return GRASS_SYMBOL;
		} else {
			return EMPTY_SYMBOL;
		}
	}

	// Returns the color of the String/glyph at position (x, y) in the world.
	public Color getColorAt(int x, int y) {
		ConcreteCritter critter = board[x][y];
		if (critter != null) {
			return critter.strategy.getColor();
		} else if (grass[x][y] > 0) {
			return Color.GREEN;
		} else {
			return null;
		}
	}

	// Steps the world forward one time step.
	public void step() {
		stepCritters();
		propogateGrass();
		numSteps++;
	}

	// Returns a String representation of the simulation world suitable for printing.
	public String toString() {
		StringBuffer ret = new StringBuffer();
		ret.append("Steps = ");
		ret.append(numSteps);
		ret.append("\n");
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < width; i++) {
				if (board[i][j] != null) {
					ret.append(board[i][j].toString());
				} else if (grass[i][j] > 0) {
					ret.append(GRASS_SYMBOL);
				} else {
					ret.append(".");
				}
			}
			ret.append("\n");
		}
		return ret.toString();
	}

	///// PRIVATE HELPER METHODS /////

	// Returns a list randomized list of each of the points in the world.
	private List<Point> getRandomizedPositions() {
		List<Point> positions = new LinkedList<Point>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				positions.add(new Point(i, j));
			}
		}
		Collections.shuffle(positions);
		return positions;
	}
	
	// Given a constructor, creates a set of random arguments for that
	// constructor.  In particular, primitive types receive a random value
	// in their range and object types receive null.
	private Object[] createRandomArguments(Constructor<?> ctor) {
		Class<?>[] types = ctor.getParameterTypes();
		Object[] ret = new Object[types.length];
		for (int i = 0; i < types.length; i++) {
			Class<?> type = types[i];
			if (!type.isPrimitive()) {
				ret[i] = null;
			} else if (type.equals(int.class)) {
				ret[i] = RAND.nextInt();
			} else if (type.equals(long.class)) {
				ret[i] = RAND.nextLong();
			} else if (type.equals(char.class)) {
				int max = 65536;
				ret[i] = (char) RAND.nextInt(max);
			} else if (type.equals(short.class)) {
				int max = 65536;
				ret[i] = (short) (RAND.nextInt(max) - max/2);
			} else if (type.equals(byte.class)) {
				int max = 128;
				ret[i] = (byte) (RAND.nextInt(max) - max/2);
			} else if (type.equals(double.class)) {
				ret[i] = RAND.nextDouble();
			} else if (type.equals(float.class)) {
				ret[i] = RAND.nextFloat();
			} else if (type.equals(boolean.class)) {
				ret[i] = RAND.nextBoolean();
			}
		}
		return ret;
	}

	// Returns a new instance of the given Critter class at (x, y).
	private ConcreteCritter createCritter(Class<?> type, int x, int y) {
		// NOTE: We assume that the Class objects we receieve are subclasses of
		// Critter with a single constructor so this will always succeed.
		Constructor<?> ctor = type.getConstructors()[0];
		ConcreteCritter critter = null;
		try {
			critter = new ConcreteCritter((Critter) ctor.newInstance(createRandomArguments(ctor)), x, y);
		} catch (InstantiationException ex) {
			throw new IllegalArgumentException(type + " is abstract!");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException(type + " is not accessible!");
		} catch (InvocationTargetException ex) {
			throw new IllegalArgumentException("Instantiating " + type + " gave an exception!\n" + ex.toString());
		}
		return critter;
	}
	
	// Adds the given critter to the world including both the critter list and the board.
	private void addToWorld(ConcreteCritter critter) {
		critters.add(critter);
		board[critter.getX()][critter.getY()] = critter;
	}
	
	// Adds the given critter to the world including both the critter list and the board.
	// This overload should be used when the addition needs to happen while traversing the
	// critter list.  The second argument is the ListIterator currently being used to
	// traverse the critter list and will be how we add the critter to the list.
	private void addToWorld(ConcreteCritter critter, ListIterator<ConcreteCritter> crittersIter) {
		crittersIter.add(critter);
		board[critter.getX()][critter.getY()] = critter;
	}

	// Initializes the simulation world adding in n random critters of each of
	// the given critter types along with grass.
	private void initializeWorld(List<Class<?>> critterTypes, int n, double initialGrassRatio) {
		// 1. Add random critters
		List<Point> positions = getRandomizedPositions();
		if (positions.size() < critterTypes.size() * n) {
			throw new IllegalArgumentException("World is not big enough for desired	number of critters!");
		}
		for (Class<?> type : critterTypes) {
			for (int i = 0; i < n; i++) {
				Point pos = positions.remove(0);
				ConcreteCritter critter = createCritter(type, pos.x, pos.y);
				addToWorld(critter);
			}
		}
	
		// 2. Add some grass
		positions = getRandomizedPositions();
		int numGrass = (int) (width * height * initialGrassRatio);
		for (int i = 0; i < numGrass; i++) {
			Point pos = positions.remove(0);
			grass[pos.x][pos.y] = 1;
		}
	}

	// Returns (n+1) mod k
	private static int incWrap(int n, int k) {
		return (n + 1) % k;
	}

	// Returns (n-1) mod k (note: different from %)
	private static int decWrap(int n, int k) {
		int ret = (n - 1) % k;
		if (ret < 0) {
			return k + ret;
		} else {
			return ret;
		}
	}

	// Returns the Point adjacent to (x, y) in the given direction.
	private Point calculateRelativePosition(int x, int y, Critter.Direction move) {
		switch (move) {
			case NORTH: return new Point(x, decWrap(y, height));
			case EAST: return new Point(incWrap(x, width), y);
			case SOUTH: return new Point(x, incWrap(y, height));
			case WEST: return new Point(decWrap(x, width), y);
			default:  return new Point(x, y);
		}
	}

	// Returns a random Point that is an empty adjacent spot to (x, y) or null if
	// no such spot exists.
	private Point findRandomEmptyAdjacentPosition(int x, int y) {
		List<Point> candidates = new ArrayList<Point>();
		for (Critter.Direction direction : Critter.Directions) {
			Point pos = calculateRelativePosition(x, y, direction);
			if (board[pos.x][pos.y] == null) { candidates.add(pos); }
		}
		if (candidates.size() == 0) {
			return null;
		}
		else {
			Collections.shuffle(candidates);
			return candidates.get(0);
		}
	}
	
	// Goes through both the critter list and grid and removes dead critters.
	private void clearTheDead() {
		// Clear the dead from the Critter list
		ListIterator<ConcreteCritter> iter = critters.listIterator();
		while (iter.hasNext()) {
			ConcreteCritter critter = iter.next();
			if (critter.isDead()) {
				iter.remove();
			}
		}
		// Clear the dead from the Critter board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				ConcreteCritter critter = board[i][j];
				if (critter != null && critter.isDead()) {
					board[i][j] = null;
				}
			}
		}
	}

	// Steps the critters forward one time step.
	private void stepCritters() {
		// 1. Calculate the potential moves for all critters (without actually doing them)
		Map<ConcreteCritter, Point> moves = new HashMap<ConcreteCritter, Point>();
		for (ConcreteCritter critter : critters) {
			moves.put(critter, calculateRelativePosition(critter.getX(), critter.getY(), critter.strategy.getMove()));
		}
		// 2. Execute those potential moves in order of speed.
		for (Critter.Speed speed : Critter.Speeds) {
			stepCritterKind(speed, moves);
		}
		// 3. Prune out the dead critters.
		clearTheDead();
	}

	// Executes the potential moves of the critters of a particular speed.
	private void stepCritterKind(Critter.Speed speed, Map<ConcreteCritter, Point>	moves) {
		List<ConcreteCritter> babies = new ArrayList<ConcreteCritter>();
		ListIterator<ConcreteCritter> iter = critters.listIterator();
		while (iter.hasNext()) {
			ConcreteCritter critter = iter.next();
			if (critter.strategy.getSpeed() == speed) {
				Point dest = moves.get(critter);
				// There are two cases when we try to execute a move.
				// 1. The destination is empty: move there.
				if (board[dest.x][dest.y] == null) {
					critter.moveTo(dest.x, dest.y);
					// Note: if there's grass and the critter eats grass, then eat it as well.
					if (critter.strategy.getFoodType() == Critter.FoodType.GRASS && grass[dest.x][dest.y] != 0) {
						critter.eat();
						grass[dest.x][dest.y] = 0;
					} else {
						critter.starve();
					}
				//	2. The destination is not empty: mate or fight.
				} else {
					ConcreteCritter other = board[dest.x][dest.y];
					if (!critter.equals(other)) {
						// Case: if the critters can mate, then mate.
						if (critter.canMate(other)) {
							if (!critter.hasMated() && !other.hasMated()) {
								// Try to find a place to drop off the baby
								Point birthLoc = findRandomEmptyAdjacentPosition(critter.getX(), critter.getY());
								if (birthLoc == null) {
									birthLoc = findRandomEmptyAdjacentPosition(dest.x, dest.y);
								}
								// If there is an available, then mate!  Otherwise, don't bother.
								if (birthLoc != null) {
									ConcreteCritter baby = createCritter(critter.strategy.getClass(), birthLoc.x, birthLoc.y);
									addToWorld(baby, iter);
									critter.mate(other);
									other.mate(critter);
								}
							}
							critter.starve();
						// Case: otherwise, the critters must fight; there is a winner and a loser.
						} else if (critter.fight(other)) {
							other.dead();
							critter.moveTo(dest.x, dest.y);
							critter.strategy.onWin();
							if (critter.strategy.getFoodType() == Critter.FoodType.MEAT) {
								critter.eat();
							}
						} else {
							critter.dead();
							other.strategy.onWin();
							if (other.strategy.getFoodType() == Critter.FoodType.MEAT) {
								other.eat();
							}
						}
					} else {
						// Here other == critter, so do nothing but starve.
						other.starve();
					}
				}
				// After executing the critter's move, check to see if it starved to death.
				if (critter.hasStarvedToDeath()) {
					critter.dead();
				}
			}
		}
	}

	// Randomly spawns grass adjacent to (x, y).
	private void spawnAdjacentGrass(int x, int y) {
		int grassValue = grass[x][y];
		List<Point> candidates = new ArrayList<Point>();
		if (grassValue != 0 && RAND.nextInt(grassValue) == 0) {
			for (Critter.Direction direction : Critter.Directions) {
				Point pos = calculateRelativePosition(x, y, direction);
				if (grass[pos.x][pos.y] != 0) {
					candidates.add(pos);
				}
			}
		}
		if (candidates.size() > 0) {
			Collections.shuffle(candidates);
			Point pos = candidates.get(0);
			grass[pos.x][pos.y] = grass[x][y] * 2;
		}
	}

	// Propogate grass in one time step by spawning adjacent grass and new grass.
	private void propogateGrass() {
		for (int i = 0; i < grass.length; i++) {
			for (int j = 0; j < grass[0].length; j++) {
				if (grass[i][j] != 0) {
					spawnAdjacentGrass(i, j);
				} else {
					grass[i][j] = RAND.nextInt(randomGrassProb) == 0 ? 1 : 0;
				}
			}
		}
	}

	///// HELPER INNER CLASSES /////

	/**
	 * The state of a particular critter.  Note that this is separated from
	 * the Critter class so that implementors of Critter have no way to modify
	 * their values.
	 */
	private class CritterState {
		public int hunger;
		public boolean hasMated;
		public boolean died;
		public int x;
		public int y;
	
		public CritterState(int x, int y) {
			this.x = x;
			this.y = y;
			this.hunger = 0;
			hasMated = false;
			died = false;
		}
	}

	/**
	 * A concrete critter which combines a CritterState object with a Critter object.
	 * The Critter object (provided by the user) encodes the behavior of the critter.
	 * This is an example of the Strategy design pattern where we allow the behavior
	 * of an object to be determined at runtime by separating it into its own class.
	 */
	private class ConcreteCritter {
		private CritterState state;
		private Critter strategy;
	
		// Initializes the CritterInfo for this ConcreteCritter's Critter object.
		// This effectively "ties the knot" between CritterState and Critter.
		private void initializeInfo() {
			// NOTE: this is an example of an anonymous inner class, a one-off class
			// that implements the CritterInfo interface.
			strategy.setCritterInfo(new CritterInfo() {
				public int getX() { return state.x; }
				public int getY() { return state.y; }
				public String getNeighbor(Critter.Direction direction) {
					Point loc = calculateRelativePosition(state.x, state.y, direction);
					if (board[loc.x][loc.y] != null) {
						return board[loc.x][loc.y].toString();
					} else if (grass[loc.x][loc.y] != 0) {
						return GRASS_SYMBOL;
					} else {
						return EMPTY_SYMBOL;
					}
				}
				public int getHungerLevel() { return state.hunger; }
				public boolean hasMated() { return state.hasMated; }
			});
		}
	
		// Constructs a new ConcreteCritter from the given strategy at (x, y).
		public ConcreteCritter(Critter strategy, int x, int y) {
			state = new CritterState(x, y);
			this.strategy = strategy;
			initializeInfo();
		}
	
		// Returns the x-coordinate of this critter.
		public int getX() { return state.x; }
		
		// Returns the y-coordinate of this critter.
		public int getY() { return state.y; }
	
		// Returns true if this critter can mate with the other critter, i.e., they
		// have the same type.
		public boolean canMate(ConcreteCritter other) {
		// NOTE: really Critter should define canMate, but because we don't want
		// to expose that functionality to implementors, we place the logic here.
			return strategy.getClass().equals(other.strategy.getClass());
		}
	
		// Returns true if this critter has mated already.
		public boolean hasMated() { return state.hasMated; }
		
		// Returns true if this critter has starved to death.
		public boolean hasStarvedToDeath() { return state.hunger >= hungerLimit; }
		
		// Returns true if this critter has died.
		public boolean isDead() { return state.died; }
	
		// Moves this critter to (x, y), updating the simulation board in the process.
		public void moveTo(int x, int y) {
			board[state.x][state.y] = null;
			board[x][y] = this;
			state.x = x;
			state.y = y;
		}
	
		// Causes this critter to eat.
		public void eat() {
			state.hunger = 0;
			strategy.onEat();
		}
	
		// Causes this critter to starve for one round.
		public void starve() {
			state.hunger++;
		}
	
		// Marks this critter for death.
		public void dead() {
			strategy.onDeath();
			state.died = true;
		}
	
		// Causes this critter to mate.
		public void mate(ConcreteCritter other) {
			strategy.onMate(other.strategy);
			state.hasMated = true;
		}
	
		// Returns true if this critter beats the other critter in a fight.
		public boolean fight(ConcreteCritter other) {
			int comp = strategy.getSpeed().compareTo(other.strategy.getSpeed());
			if (comp < 0) {
				return false;
			} else if (comp > 0) {
				return true;
			} else {
				return RAND.nextBoolean();
			}
		}
	
		// Returns the String representation of this critter (which is just
		// the String representation of the underlying Critter object).
		public String toString() { return strategy.toString(); }
	}
}
