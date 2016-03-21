package uniquesAndDupes;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class UniquesDupes{
	public static Set<String> getUniques(String input){
		return new TreeSet<String>(Arrays.asList(input.split(" ")));
	}

	public static Set<String> getDupes(String input){
		Set<String> dupes = new TreeSet<String>(), uniques = new TreeSet<String>();
		for(String x : input.split(" "))
			if(!uniques.add(x))
				dupes.add(x);
		
		return dupes;		
	}
}