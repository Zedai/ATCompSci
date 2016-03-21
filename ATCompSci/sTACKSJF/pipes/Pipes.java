package pipes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Pipes extends JPanel implements ActionListener{
	Timer timer;
	boolean phase1 = false, phase2 = false;
	private Queue<Line2D> lines = new LinkedList<Line2D>(), newlines = new LinkedList<Line2D>();
	private ArrayList<Line2D> onScreen = new ArrayList<Line2D>();
	private int nlines;
	
	public Pipes(){
		nlines = (int)(Math.random() * 16) + 15;
		this.setBackground(Color.black);
		
		int prevX = (int)(Math.random() * 480), prevY = (int)(Math.random() * 480);
		for(int i = 0; i < nlines; i++){
			int x = (int)(Math.random() * 480), y = (int)(Math.random() * 480);
			lines.add(new Line2D.Double(prevX, prevY, x, y));
			prevX = x;
			prevY = y;
		}
		
	    timer = new Timer(500, this);
	    timer.setInitialDelay(190);
	    timer.start();
	}
	
	public void step(Graphics2D g2){
		if(onScreen.size() <= nlines){
			g2.setColor(Color.green);
			for(Line2D l : onScreen)
				g2.draw(l);
		}
		else if(onScreen.size() >= nlines){
			g2.setColor(Color.green);
			for(int i = 0; i < nlines; i++)
				g2.draw(onScreen.get(i));
			g2.setPaint(Color.black);
			for(int i = nlines; i < onScreen.size(); i++)
				g2.draw(onScreen.get(i));
		}
		if(!lines.isEmpty()){
			g2.setColor(Color.green);
			g2.setStroke(new BasicStroke(6));
			Line2D l = lines.poll();
			newlines.add(l);
			g2.draw(l);
			onScreen.add(l);
		}
		else if(!newlines.isEmpty()){
			g2.setColor(Color.black);
			Line2D l = newlines.poll();
			g2.draw(l);
			onScreen.add(l);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;	
		step(g2);
	}
		
	public static void main(String[] args){
	      Pipes panel = new Pipes();                            
	      JFrame application = new JFrame();    
	      application.setSize(520, 520);         
	      application.setTitle("Pipes");
	      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                               
	      application.add(panel);           
	      application.setVisible(true);   
	    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

}