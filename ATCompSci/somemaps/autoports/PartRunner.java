package autoports;

import static java.lang.System.*;

import java.io.FileNotFoundException;

//Files needed
 	//Part.java
 	//PartList.java

public class PartRunner
{
	public static void main(String[] args) throws FileNotFoundException
	{
		PartList prog = new PartList("H:\\workspace\\ATCompSci\\somemaps\\autoports\\partinfo.dat");
		out.println(prog);
	}
}
