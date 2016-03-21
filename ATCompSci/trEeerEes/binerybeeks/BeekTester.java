package binerybeeks;

import java.io.File;
import java.io.FileNotFoundException;

public class BeekTester {
	public static void main(String[] args) throws FileNotFoundException{
			PhoneBook pb = new PhoneBook(new File("H:/workspace/ATCompSci/trEeerEes/binerybeeks/phone.txt"));
			pb.display();
			System.out.println("\n\nlookup Banas:: " + pb.lookupNumber("Banas"));
			System.out.println("\n\nlookup NotFound:: " + pb.lookupNumber("NotFound"));
			System.out.println("\n\nlookup 9810421:: " + pb.reverseLookup("9810421"));
			System.out.println("\n\nlookup 123542315:: " + pb.reverseLookup("123542315"));
			System.out.println("\n\nDelete Banas");
			pb.delete("Banas");
			System.out.println("\n\nlookup Banas:: " + pb.lookupNumber("Banas"));
			System.out.println("\n\nlookup 9810421:: " + pb.reverseLookup("9810421"));
			pb.display();
	}
}