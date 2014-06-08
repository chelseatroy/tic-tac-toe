/**
 * CIS 110 (11fa) - Homework 8
 * The CritterMain class.
 *
 * NOTE: YOU SHOULD NOT MODIFY THIS CLASS FOR THE HOMEWORK.
 *
 * CritterMain is the main method of the critter zoo program.
 */

import java.io.*;
import java.util.*;

// CritterMain is the driver for the critter program.
public class CritterMain {
	// Returns true if the given Class object is a valid Critter subclass.
	// A valid Critter subclass has Critter as a superclass and a single constructor.
	public static boolean isValidCritterClass(Class<?> cls) {
		if (!cls.equals(Critter.class) && Critter.class.isAssignableFrom(cls)) {
			return cls.getConstructors().length == 1;
		} else {
			return false;
		}
	}

	// Returns an array of Class objects that correspond to subclasses of the
	// Critter class found in the given directory.
	public static List<Class<?>> discoverCritters(File dir) {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		String[] names = dir.list(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});
		for (String name : names) {
			name = name.substring(0, name.lastIndexOf(".class"));
			// NOTE: we make the assumption that the fully-qualified class name
			// coincides directly with the name of the file.  This is only true
			// when the class is in the default package (i.e., has no qualifications).
			Class<?> cls = null;
			try {
				cls = Class.forName(name);
			} catch (ClassNotFoundException e) {
				System.out.println("WARNING: class with non-trivial qualified name: " + name);
			}
			if (cls != null && isValidCritterClass(cls)) {
				classes.add(cls);
			}
		}
		return classes;
	}
	
	// Returns an array of Class objects that correspond to the subclasses of
	// Critter specified within the method.
	public static List<Class<?>> loadKnownCritters() {
		return Arrays.asList(
			new Class<?>[] {
				Lemming.class, Rock.class, Ant.class, Bird.class, Cat.class, Lion.class, Owl.class /* additional classes go here */
			});
	}

	public static void main(String[] args) {
		// Parameters to the simulation.  Feel free to experiment with these for fun!
		// See the comment on the constructor of CritterModel for a description of
		// what each of these parameters control.
		int width = 50;
		int height = 50;
		int randomGrassProb = 512;
		int hungerLimit = 50;
		List<Class<?>> critterTypes = discoverCritters(new File(System.getProperty("user.dir")));
		int numCritters = 25;
		double initialGrassRatio = .15;
		CritterModel model = new CritterModel(width, height, randomGrassProb, hungerLimit,
		                                      critterTypes, numCritters, initialGrassRatio);
		CritterFrame frame = new CritterFrame(height, height, model);
		frame.pack();
		frame.setVisible(true);
		frame.repaint();
	}
}