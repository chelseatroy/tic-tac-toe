//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 3
//prints my doodle. At first glance it just looks like pacman eating a ghost 
//with some weird lines.
//But look closer. The pacman is a "c" and the lines make an "is" in the ghost
//so you get "CIS!"
import java.awt.*;

public class Doodle{
	public static void main(String[] args){
		drawPacman();
	}
	public static Graphics drawPacman(){
		DrawingPanel p = new DrawingPanel(500, 500);
		p.setBackground(Color.BLACK);
		Graphics g = p.getGraphics();
		//draws yellow circle
		g.setColor(Color.YELLOW);
		g.fillOval(20,40,200,200);
		//draws mouth
		g.setColor(Color.BLACK);
		g.fillRect(110,140,110,100);
		//draws bow on head
		g.setColor(Color.RED);
		g.fillRect(162,50,30,30);
		g.fillRect(132,20,30,30);
		//draws pacman eye
		g.setColor(Color.BLACK);
		g.fillOval(132,80,20,20);
		//draws blue rectangles
		g.setColor(Color.BLUE);
		g.fillRect(120,150,20,70);
		g.fillRect(143,150,40,70);
		//draws rounded ghost edges
		g.setColor(Color.BLACK);
		g.fillRect(120,150,10,10);
		g.fillRect(175,150,10,10);
		//draws the curves in the "s"
		g.setColor(Color.BLACK);
		g.fillRect(165,170,20,3);
		g.fillRect(143,195,20,3);
		//draws ghost eyes
		g.setColor(Color.WHITE);
		g.fillRect(127,165,8,8);
		g.fillRect(152,165,8,8);
		//draws squiggly bottom of ghost
		g.setColor(Color.BLACK);
		g.fillRect(125,215,5,5);
		g.fillRect(135,215,5,5);
		g.fillRect(150,215,5,5);
		g.fillRect(160,215,5,5);
		g.fillRect(170,215,5,5);
		//draws text
		g.setColor(Color.RED);
		g.drawString("CIS at Penn",120,240);
		return g;
	}
}
