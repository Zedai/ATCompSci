//import org.fusesource.jansi.AnsiConsole;

public class ColorTester {
	public static void main(String[] args){
		System.out.println((char)27 + "[31mThis text would show up red" + (char)27 + "[0m");
	}
}
