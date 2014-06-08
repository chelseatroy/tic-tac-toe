/**
 * CIS 110 (11fa) - Homework 8
 * The CritterFrame class.
 *
 * NOTE: YOU SHOULD NOT MODIFY THIS CLASS FOR THE HOMEWORK.
 *
 * The CritterFrame is the top level GUI for the program.  It contains
 * the CritterPanel that renders the world along with buttons and other widgits
 * that allow the user to control stepping as well as get additional
 * info abou tthe current simulation.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

// A CritterFrame is the GUI over the critter zoo simulation.
public class CritterFrame extends JFrame {
	private CritterModel model;
	private CritterPanel critterPanel;
	
	// Constructs a new CritterFrame with the given model.
	public CritterFrame(int width, int height, final CritterModel model) {
		setTitle("CIS 110 critter zoo!");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.model = model;
		this.critterPanel = new CritterPanel(model);
		JPanel panel = new JPanel();
		JButton button = new JButton("Step!");
		button.setMnemonic('S');
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				synchronized(model) {
					model.step();
				}
				critterPanel.repaint();
			}
		});
		button.requestFocus();
		panel.add(button);
		add(critterPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
	}
}