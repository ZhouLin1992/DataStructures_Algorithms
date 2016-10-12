public class Solution {
	public void insertSort(int[] nums) {
		// array is sorted sequentially and unsorted elements are moved and inserted into sorted sublist
		// process goes until unsorted values are covered in sorted sublist
		for (int i = 1; i < nums.length; i++) {
			// pick next element
			int valueToInsert = nums[i];
			int indexToInsert = i;
			// Compare with all the elements in the sorted sublist, shift all the elements
			while (indexToInsert > 0 && nums[indexToInsert - 1] > valueToInsert) {
			  nums[indexToInsert] = nums[indexToInsert - 1];
			  indexToInsert--;
			}
			// insert the value
			if (indexToInsert != i)
			    nums[indexToInsert] = valueToInsert;
	      }
	}
}