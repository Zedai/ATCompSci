package pheme;


public class TesterPhone {
	public static void main(String[] args){
		PhoneBook pb = new PhoneBook();
		pb.displayLexicographical();
		pb.load();
		pb.displayLexicographical();
		System.out.println("\n\n\n\n" + pb.lookup("Alaev"));
		System.out.println(pb.changeNumber("Alaev", "911"));
		System.out.println(pb.lookup("Alaev") + "\n\n\n\n");
		pb.displayLexicographical();
	}
}