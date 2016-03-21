package towersOfHanoi;

public class DiskMover {

	public static void move(int disks, int source, int target) {
		if (disks < 1)
			return;
		
		int notUsed;
		
		if(target == 2 && source == 1 || source == 2 && target == 1)
			notUsed = 3;
		else if(target == 1 && source == 3 || target == 3 && source == 1)
			notUsed = 2;
		else
			notUsed = 1;
		
		move(disks - 1, source, notUsed);
		System.out.println("Move a disk from " + source + " to " + target);
		move(disks - 1, notUsed, target);
	}
}