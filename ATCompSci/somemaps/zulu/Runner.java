package zulu;

import java.io.File;
import java.io.IOException;

public class Runner {
	public static void main(String[] args) throws IOException{
		Translator t = new Translator(new File("H:\\workspace\\ATCompSci\\somemaps\\zulu\\engtozulu.dat"));
		System.out.println(t.translate("i want a computer virus"));
		System.out.println(t.translate("all of the boys have internal memory"));
		System.out.println(t.translate("my hair is brown"));
		System.out.println(t.translate("you want ink with your paper"));
		System.out.println(t.translate("reboot the computer to empty the screen"));
	}
}