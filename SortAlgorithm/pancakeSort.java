public class Solution {
	public static void pancakeSort(int[] nums) {
		// start from the complete array
		// one by one reduce current size by one
		for (int i = nums.length; i > 1; i--) {
			// find the maximum element index
			int max = findMax(nums, i);

			if (max != i - 1) {
				// flip subarray[0, max]
				// after flip, max element is at the first index
				flip(nums, max);

				// flip subarray[0, nums.length - 1]
				flip(nums, i - 1);				
			}	
		}
	}

	// flip array [0, index]
	private static void flip(int[] nums, int index) {
		int temp, start = 0;

		while (start < index) {
			temp = nums[start];
			nums[start] = nums[index];
			nums[index] = temp;
			start++;
			index--;
		}
	}

	// find maximum element in the array [0, size - 1]
	private static int findMax(int[] nums, int size) {
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (nums[i] > nums[max]) {
				max = i;
			}
		}

		return max;
	}
}