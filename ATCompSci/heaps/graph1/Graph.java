package graph1;

import java.util.HashSet;
import java.util.TreeMap;

public class Graph {
	private TreeMap<String, HashSet<String>> map;
	boolean match = false;
	
	public Graph(String line) {
		map = new TreeMap<String, HashSet<String>>();
		String[] a = line.split(" ");
		for (int i = 1; i < a.length; i++) {
			if (map.containsKey(a[i].substring(0, 1))) {
				HashSet<String> t = map.get(a[i].substring(0, 1));
				t.add(a[i].substring(1));
				map.put(a[i].substring(0, 1), t);
			} else{
				HashSet<String> t = new HashSet<String>();
				t.add(a[i].substring(1));
				map.put(a[i].substring(0, 1), t);
			}
			
			if(map.containsKey(a[i].substring(1))){
				HashSet<String> t = map.get(a[i].substring(1));
				t.add(a[i].substring(0, 1));
				map.put(a[i].substring(1), t);
			}else {
				HashSet<String> t = new HashSet<String>();
				t.add(a[i].substring(0, 1));
				map.put(a[i].substring(1), t);
			}
		}
	}
	
	public boolean contains(String letter) {
		return map.containsKey(letter);
	}

//	public boolean check(String first, String second) {
//		if(!map.containsKey(first))
//			return false;
//		if(map.get(first).contains(second))
//			return true;
//		
//		HashSet<String> set = map.get(first);
//		HashSet<String> solutions = map.get(first);
//		for(String s : set){
//			solutions.addAll(map.get(s));
//		}
//		for(String s : set){
//			solutions.addAll(map.get(s));
//		}
//
//		return solutions.contains(second);
//	}
	
	public void check(String one, String two, String been){
		if(!match){
			if(map.get(been).contains(two))
				match = true;
			else{
				HashSet<String> set = map.get(been);
				for(String x : set)
					check(one, two, x);
			}
		}
	}

	public String toString() {
		return "";
	}
}