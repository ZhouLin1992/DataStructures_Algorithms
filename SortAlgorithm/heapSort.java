public class Solution {
	public static void heapSort(int[] nums) {
		int n = nums.length;

		// build a heap

		// i is the root index
		// the index of the root's right child is r = 2 * i + 2 (index starts from 0)
		// so the root is i =  (r - 2) / 2
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(nums, n, i);
		}

		// one by one extract an element from the heap
		// i: the size of the max heap
		for (int i = n - 1; i >= 0; i--) {
			// exchange the max
			int tmp = nums[i];
			nums[i] = nums[0];
			nums[0] = tmp;

			// after exchange, needs to heapify the whole max heap from the root
			// because after deleting the maximum element, the struture of the max heap changes
			heapify(nums, i, 0);
		}

	}

	// n: the current size of the max heap;
	// i: array index of root
	public static void heapify(int[] nums, int n, int i) {
		// initialize largest as root
		int largest = i;
		// left child = 2 * root + 1 (index starts from 0)
		int l = 2 * i + 1;
		// right child = 2 * root + 2 (index starts from 0)
		int r = 2 * i + 2;

		// left child is larger than root
		if (l < n && nums[largest] < nums[l]) {
			largest = l;
		}

		// right child is larger than root
		if (r < n && nums[largest] < nums[r]) {
			largest = r;
		}

		// if max is not root
		if (largest != i) {
			int swap = nums[i];
			nums[i] = nums[largest];
			nums[largest] = swap;

			// recursively heapify the affected sub-tree
			heapify(nums, n, largest);
		}
	}
}