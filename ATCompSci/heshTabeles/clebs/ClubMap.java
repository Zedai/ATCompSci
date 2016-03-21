package clebs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class ClubMap {
	private HashMap<String, ArrayList<Student>> clubList = new HashMap<String, ArrayList<Student>>();

	public ClubMap(File f) throws FileNotFoundException{
		Scanner in = new Scanner(f);
		while(in.hasNextLine()){
			join(in.nextLine());
		}
		in.close();
	}

	public void join(String x){
		Scanner deep = new Scanner(x);
		String pass = deep.next() + " " + deep.next() + " " + deep.next();
		String club = deep.next().trim();
		deep.close();

		ArrayList<Student> ne = new ArrayList<Student>();
		ne.add(new Student(pass));

		if(clubList.containsKey(club))
			clubList.get(club).add(new Student(pass));
		else
			clubList.put(club, ne);

		Collections.sort(clubList.get(club));
	}

	public void displayByClub(){
		Object[] keys = clubList.keySet().toArray();
		Arrays.sort(keys);
		for(Object club : keys)
			System.out.println(club + " :: " + clubList.get(club));
	}

	public void displayByClub(String club){
		System.out.println(club + " :: " + clubList.get(club));
	}
}