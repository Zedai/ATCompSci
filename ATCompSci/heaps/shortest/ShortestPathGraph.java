package shortest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

public class ShortestPathGraph {
	private TreeMap<String, HashSet<String>> map;
	boolean match = false;
	int shortest = 0;

	public ShortestPathGraph(String line) {
		map = new TreeMap<String, HashSet<String>>();
		String[] a = line.split(" ");
		for (int i = 1; i < a.length; i++) {
			if (map.containsKey(a[i].substring(0, 1))) {
				HashSet<String> t = map.get(a[i].substring(0, 1));
				t.add(a[i].substring(1));
				map.put(a[i].substring(0, 1), t);
			} else {
				HashSet<String> t = new HashSet<String>();
				t.add(a[i].substring(1));
				map.put(a[i].substring(0, 1), t);
			}

			if (map.containsKey(a[i].substring(1))) {
				HashSet<String> t = map.get(a[i].substring(1));
				t.add(a[i].substring(0, 1));
				map.put(a[i].substring(1), t);
			} else {
				HashSet<String> t = new HashSet<String>();
				t.add(a[i].substring(0, 1));
				map.put(a[i].substring(1), t);
			}
		}
	}

	public boolean contains(String letter) {
		return map.containsKey(letter);
	}

WRUFHDSKHGKSDHFGKSHFGDHFDSHFISHDILF
	public String toString() {
		return "";
	}
}