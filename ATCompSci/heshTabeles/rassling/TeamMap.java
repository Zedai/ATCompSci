package rassling;

import java.util.HashMap;

public class TeamMap {
	private HashMap<Wrestler, Integer> team = new HashMap<Wrestler, Integer>();
	
	public Integer add(Wrestler w){
		if(w.getWeight() < 110)
			return team.put(w, 0);
		if(w.getWeight() < 120)
			return team.put(w, 1);
		 if(w.getWeight() < 130)
			return team.put(w, 2);
		if(w.getWeight() < 140)
			return team.put(w, 3);
		if(w.getWeight() < 150)
			return team.put(w, 4);
		if(w.getWeight() < 160)
			return team.put(w, 5);
		if(w.getWeight() < 170)
			return team.put(w, 6);
		if(w.getWeight() < 180)
			return team.put(w, 7);
		if(w.getWeight() < 190)
			return team.put(w, 8);
		
		return team.put(w, 9);
	}
	
	public int get(Wrestler w){
		return team.get(w);
	}
	
	public void changeWeightGroup(Wrestler w, int t){
		team.put(w, t);
	}
	
	public String toString(){
		return team.toString();
	}
}