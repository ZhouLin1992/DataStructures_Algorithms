public class Solution {
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int p = partition(arr, start, end);

			quickSort(arr, start, p - 1);
			quickSort(arr, p + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int s = start, e = end;
		// arr[start] is arr[s], namely it is the first number
		int pivot = arr[start];

		// from right to left, find the number smaller than pivot
		while (s < e) {
			while (s < e && arr[e] >= pivot)
				e--;
			if (s < e)
				// s[e] now is a new position
				arr[s++] = arr[e];

			// from left to right, find the number larger than/equal to the pivot
			while (s < e && arr[s] < pivot)
				s++;
			if (s < e)
				// make s[e] = this number, s is a new position
				arr[e--] = arr[s]; 
		}
		// when quitting from the loop, "s = e", right now s is the position for pivot
		arr[s] = pivot;
		// return the position of pivot
		return s;
	}
}



// Link: http://blog.csdn.net/morewindows/article/details/6684558