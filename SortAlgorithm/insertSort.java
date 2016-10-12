public class Solution {
	public void insertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
	          int valueToInsert = nums[i];
	          int indexToInsert = i;
	          while (indexToInsert > 0 && nums[indexToInsert - 1] > valueToInsert) {
	              nums[indexToInsert] = nums[indexToInsert - 1];
	              indexToInsert--;
	          }
	          if (indexToInsert != i)
	                nums[indexToInsert] = valueToInsert;
	      }
	}
}