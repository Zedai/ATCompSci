package rassling;

import java.util.HashSet;

public class TeamSet {
	private HashSet<Wrestler> team = new HashSet<Wrestler>();

	public boolean add(Wrestler w){
		return team.add(w);
	}
	
	public double getAvgWeight(){
		double sum = 0;
		for(Wrestler w : team)
			sum += w.getWeight();
		
		return sum/team.size();
	}
	
	public HashSet<Wrestler> getLightweights(){
		HashSet<Wrestler> light = new HashSet<Wrestler>();
		
		for(Wrestler w : team)
			if(w.getWeight() < 120)
				light.add(w);
		
		return light;
	}
	
	public String toString(){
		return team.toString();
	}
}