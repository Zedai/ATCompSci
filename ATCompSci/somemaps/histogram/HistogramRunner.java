package histogram;

public class HistogramRunner
{
	public static void main(String args[]) {
		Histogram histo =  new Histogram("a b c d e f g h i a c d e g h i h k");
		System.out.println(histo + "\n");
		histo =  new Histogram("1 2 3 4 5 6 1 2 3 4 5 1 3 1 2 3 4");
		System.out.println(histo + "\n");
		histo =  new Histogram("Y U I O Q W E R T Y");
		System.out.println(histo + "\n");
		histo =  new Histogram("4 T # @ ^ # # #");
		System.out.println(histo + "\n");
	
	}
}