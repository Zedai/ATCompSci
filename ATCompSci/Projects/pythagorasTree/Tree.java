package pythagorasTree;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings({ "serial" })
public class Tree extends JPanel{
	
	private ArrayList<ColouredPolygon> draw = new ArrayList<ColouredPolygon>();
	private int target = 0, greenThreshold = 0;
	private Color bark = new Color(98, 40, 19), leaf = new Color(0, 132, 13);
	private double leftScalar, rightScalar, alpha, beta, horizMove;
	
	public Tree() {
		this.setBackground(Color.cyan);
		String input = JOptionPane.showInputDialog(null, "Number of Iterations (0, 20)");	

		try {
			target = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("Enter a Valid Input");
			System.exit(0);
		}
		
		if(target > 20 || target < 0){
			System.err.println("Enter a Valid Input");
			System.exit(0);
		}
		
		String angle = JOptionPane.showInputDialog(null, "Alpha (10, 80)");	
		
		int a = 0;
		try {
			a = Integer.parseInt(angle);
		} catch (NumberFormatException e) {
			System.err.println("Enter a Valid Input");
			System.exit(0);
		}
		
		if(a > 80 || a < 10){
			System.err.println("Enter a Valid Input");
			System.exit(0);
		}
		

		alpha = Math.toRadians(a);
		beta = Math.PI/2 - alpha;
		
		if(alpha < Math.PI/4)
			horizMove = 300;
		else if (alpha == Math.PI/4)
			horizMove = 150;
		else
			horizMove = 0;
			
		leftScalar = Math.cos(alpha);
		rightScalar = Math.sin(alpha);
		
		greenThreshold = (int) (.8 * target);
    }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;	
		g2.setColor(Color.green);
		g2.fillRect(0, 800, 10000, 100000);
		makeFractal(g2, 0, target, (int) (450 + horizMove), 800, 0, 100);
		this.finalPaint(g2);
	}
	
	public void makeFractal(Graphics2D g, int iterations, int targetIterations, int leftX, int leftY, double angle, double sideLength){
		if(iterations > targetIterations)
			return;
		
		int x1 = leftX, x2 = (int) (x1 + (Math.cos(angle + Math.PI/2) * sideLength)), x3 = (int) (x2 + (Math.cos(angle) * sideLength)), x4 = (int) (x3 + (Math.cos(angle - Math.PI/2) * sideLength)), y1 = leftY, y2 = (int) (y1 - (Math.sin(angle + Math.PI/2) * sideLength)), y3 = (int) (y2 - (Math.sin(angle) * sideLength)), y4 = (int) (y3 - (Math.sin(angle - Math.PI/2) * sideLength));
		int squareTwoX = (int) (x3 - (Math.cos(angle - beta) * sideLength * rightScalar)), squareTwoY =  (int) (y3 + (Math.sin(angle - beta) * sideLength * rightScalar));
		
		Polygon p = new Polygon();
		p.addPoint(x1, y1);
		p.addPoint(x2, y2);
		p.addPoint(x3, y3);
		p.addPoint(x4, y4);
//		System.out.println("(" + x1 + " , " + y1 + ")\n" + "(" + x2 + " , " + y2 + ")\n" + "(" + x3 + " , " + y3 + ")\n" + "(" + x4 + " , " + y4 + ")\n Side Length: " + sideLength + "\n\n");
		if(iterations < greenThreshold)
			draw.add(new ColouredPolygon(p, bark));
		else
			draw.add(new ColouredPolygon(p, leaf));
		
		makeFractal(g, iterations + 1, targetIterations, x2, y2, angle + alpha, sideLength * leftScalar);
		makeFractal(g, iterations + 1, targetIterations, squareTwoX, squareTwoY, angle - beta, sideLength * rightScalar);
	}

	
	private void finalPaint(Graphics2D g) {
		for(ColouredPolygon p : draw){
			g.setColor(p.getColour());
			g.fillPolygon(p.getPolygon());
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
	
	public static void main(String[] args){
      Tree panel = new Tree();                            
      JFrame application = new JFrame();    
      application.setSize(1080, 1024);         
      application.setTitle("Pythagoras Tree");
      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                               
      application.add(panel);           
      application.setUndecorated(true);
      application.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      application.setVisible(true);
      
      Scanner keyboard = new Scanner(System.in);
      if(keyboard.nextLine().equalsIgnoreCase("stop")){
    	  keyboard.close();
    	  System.exit(ABORT);
      }
	}

}