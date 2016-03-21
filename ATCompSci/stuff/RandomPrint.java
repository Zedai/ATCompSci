public class RandomPrint {
	public static void main(String[] args) throws InterruptedException{
		for(int i = 0; i < 100; i++){
			if(Math.random() < .5)
				System.out.print((char)(int)(Math.random() * 100));
			else
				System.err.print((char)(int)(Math.random() * 100));
			
			if(i == 99){
				i = 0;
				System.out.println();
				System.err.println();
			}
			
			Thread.sleep((int)(Math.random() * 45));
		}
	}
}