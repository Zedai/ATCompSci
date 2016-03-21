package pipes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Seizure extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @author Saikiran Nakka
	 */
	Timer timer;
	
	public Seizure(){
	    timer = new Timer(1, this);
	    timer.setInitialDelay(190);
	    timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
		g2.fillRect(0, 0, 10000, 10000);
	}
		
	public static void main(String[] args){
	      Seizure panel = new Seizure();                            
	      JFrame application = new JFrame();    
	      application.setSize(520, 520);         
	      application.setUndecorated(true);
	      application.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      application.add(panel);           
	      application.setVisible(true);   
	    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}

}