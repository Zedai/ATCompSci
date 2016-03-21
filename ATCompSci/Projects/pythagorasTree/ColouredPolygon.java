package pythagorasTree;

import java.awt.Color;
import java.awt.Polygon;

public class ColouredPolygon{
	private Polygon poly;
	private Color col;
	
	public ColouredPolygon(Polygon p, Color c){
		col = c;
		poly = p;
	}
	
	public Polygon getPolygon(){
		return poly;
	}
	
	public Color getColour(){
		return col;
	}
}