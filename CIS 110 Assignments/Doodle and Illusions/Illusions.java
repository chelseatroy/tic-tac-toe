//Chelsea Dommert, cdommert@sas.upenn.edu
//CIS 110 (section 207) - Homework 3
//prints patterns of Ehrenstein Circles
import java.awt.*;

public class Illusions{
	public static void main(String[] args){
		drawDrawingPanel();	
	}
	//draws the initial panel, sets its background, then calls the methods for the boxes and circles.
	//different parameters are used to make the same "makeBox" method applicable to all grids of boxes.
	//A satellite TA explained that this was the appropriate way to call the methods.
	//Should I be finding a way to call "makeBoxes" in the main method instead?
	//I mean, this way does appear to work :) 
	public static void drawDrawingPanel(){
		DrawingPanel p = new DrawingPanel(500, 500);
		p.setBackground(Color.GREEN);
		Graphics g = p.getGraphics();
		makeBox(g,0,0,75,6,1,1);
		makeBox(g,105,15,50,10,7,1);
		makeBox(g,10,100,70,3,2,5);
		makeBox(g,175,115,100,8,3,3);
		makeCircles(g,200,430,25,4,10,2);
	}
	public static void makeBox(Graphics g,int startx, int starty, int diam, int circles, int columnsboxes, int rowsboxes){
			//draw a boxgrid of Ehrenstein Circles
			for (int j = starty; j <= starty+(diam*(rowsboxes-1)); j+=diam){
				for (int k = startx; k<= startx+(diam*(columnsboxes-1)); k+=diam){
					g.setColor(Color.CYAN);
					g.fillRect(k,j,diam,diam);
					g.setColor(Color.BLACK);
					g.drawRect(k,j,diam,diam);
					//draw the circles
					g.setColor(Color.YELLOW);
					g.fillOval(k,j,diam,diam);
					g.setColor(Color.BLACK);
						for (int i = 0; i<circles; i++){
							g.drawOval(i*diam/(2*circles)+k,i*diam/(2*circles)+j,(diam-(2*i*diam/(2*circles))),(diam-(2*i*diam/(2*circles))));
						}
					//draw the lines
					g.setColor(Color.BLACK);
					g.drawLine(diam/2+1+k,j,k,diam/2+1+j);
					g.drawLine(diam/2+1+k,j,diam+k,diam/2+1+j);
					g.drawLine(k,diam/2+1+j,diam/2+1+k,diam+j);
					g.drawLine(diam/2+1+k,diam+j,diam+k,diam/2+1+j);
				}
			}
	}
		//make the grid of circles without any boxes around them
		public static void makeCircles(Graphics g,int startx, int starty, int diam, int circles, int columnsboxes, int rowsboxes){
			for (int j = starty; j <= starty+(diam*(rowsboxes-1)); j+=diam){
				for (int k = startx; k<= startx+(diam*(columnsboxes-1)); k+=diam){
					g.setColor(Color.YELLOW);
					g.fillOval(k,j,diam,diam);
					g.setColor(Color.BLACK);
						for (int i = 0; i<circles; i++){
							g.drawOval(i*diam/(2*circles)+k,i*diam/(2*circles)+j,(diam-(2*i*diam/(2*circles))),(diam-(2*i*diam/(2*circles))));
						}
				}
			}
		}

}

