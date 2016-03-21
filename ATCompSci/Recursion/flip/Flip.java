package flip;

public class Flip {
	public static String flip(String s){
		if(s.length() == 1)
			return s;
		
		return s.substring(s.length()-1) + flip(s.substring(0, s.length()-1));
	}
}