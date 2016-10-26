public class Solution {
	// divide and conquer
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			// p is the partition point in the array, and arr[p]
			// right now is in the right position
			int p = partition(arr, start, end);

			// recursively use quick sort before partition and 
			// after partition
			quickSort(arr, start, p - 1);
			quickSort(arr, p + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		// take the last element as pivot
		// try to find the correct position where the left part is smaller than pivot
		// and the right part is larger than pivot
		int pivot = arr[end];
		
		// index of smaller element
		int i = start - 1;

		// if current element is smaller than pivot
		// swap arr[i], arr[j]
		for (int j = start; j <= end - 1; j++) {
			if (arr[j] <= pivot) {
				i++;
				arr[i] ^= arr[j];
				arr[j] ^= arr[i];
				arr[i] ^= arr[j];
			}
		}

		// index (i + 1) is the position for pivot
		arr[i + 1] ^= arr[end];
		arr[end] ^= arr[i + 1];
		arr[i + 1] ^= arr[end];

		return i + 1;
	}
}