package acronyms;

import java.io.File;
import java.io.IOException;

public class AcroRunner
{
	public static void main( String args[] ) throws IOException
	{
		Acronyms a = new Acronyms(new File("H:\\workspace\\ATCompSci\\somemaps\\acronyms\\acro.dat"));
		System.out.println(a.convert("I drove my PU to TSO to get a HD.  My CPU has a virus."));
		System.out.println(a.convert("I sometimes SO when trying to kick a FG.  I had 2 RBI."));
		System.out.println(a.convert("At the game, I saw 2 PDA infractions in the hall."));
	}
}