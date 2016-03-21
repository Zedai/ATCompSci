package maxValue;

public class MaxValue {
	public static void main(String[] args){
		int[][] nums = new int[10][10];
		fill(nums.length, nums);
		printArray(nums);
		System.out.println("Maximum Value: " + findMax(nums));
	}
	
	public static void fill(int rows, int[][] a){
		if(rows == 0)
			return;

		for(int i = 0; i < a[0].length; i++)
			a[rows - 1][i] = (int)(Math.random()*101);
		
		fill(rows - 1, a);
	}
	
	public static int findMax(int[][] nums){
		int max = nums[0][0];
		for(int[] r : nums)
			for(int c : r)
				if(c > max)
					max = c;
		
		return max;
	}
	
	public static void printArray(int[][] a){
		for(int[] r : a){
			for(int c : r)
				System.out.print(c + " ");
			System.out.println();
		}
	}
}