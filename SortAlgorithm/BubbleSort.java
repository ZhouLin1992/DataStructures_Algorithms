public class Solution {
	public static void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			// use flag to mark if array needs no more swapping
			boolean flag = false;
			// next iteration needs not to include already sorted elements
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] < nums[j + 1]) {
					swap(nums, j, j + 1);
					flag = true;					
				}
			}
			if (!flag)
				break;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		if (i == j) return;
		// swap element without using extra space
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}